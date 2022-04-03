(ns spy.protocol-test
  (:require [clojure.test :refer [deftest is testing]]
            [spy.core :as spy]
            [spy.protocol :as protocol]
            [spy.assert :as assert]
            [spy.my-protocol :as my-protocol]))

(defprotocol Greeter
  (hey [this x]))

(defrecord KeywordGreeter []
  Greeter
  (hey [this x]
    (keyword (str "hello-" (name x)))))

(deftest spy-fns-test
  (let [protocol-to-spy-on (reify Greeter
                             (hey [this x]
                               (str "Bonjour " x "!")))
        my-spy (protocol/spy Greeter protocol-to-spy-on)
        hey-spy (:hey (protocol/spies my-spy))]

    (is (spy/not-called? hey-spy))
    (is (= "Bonjour Alex!" (hey my-spy "Alex")))
    (is (spy/called-once-with? hey-spy my-spy "Alex")))


  (let [my-spy (protocol/spy Greeter
                                (reify Greeter
                                  (hey [this x]
                                    (str "Hola " x "!"))))
        hey-spy (:hey (protocol/spies my-spy))]
    (is (spy/not-called? hey-spy))
    (is (= "Hola Juan!" (hey my-spy "Juan")))
    (is (spy/called-once-with? hey-spy my-spy "Juan")))

  (let [kwg (->KeywordGreeter)
        kwg-spy (protocol/spy Greeter kwg)
        hey-spy (:hey (protocol/spies kwg-spy))]
    (is (= :hello-ajk (hey kwg-spy :ajk)))
    (is (= [[kwg-spy :ajk]] (spy/calls hey-spy)))
    (is (= [:hello-ajk] (spy/responses hey-spy)))))

(deftest mock-test
  (let [my-spy (protocol/mock Greeter
                 (hey [this x]
                   (str "Bonjour " x "!")))]
    (is (= "Bonjour Pierre!" (hey my-spy "Pierre")))
    (assert/called-once-with? (:hey (protocol/spies my-spy))
                                  my-spy
                                  "Pierre")))

(deftest protocol-in-different-ns-test
  (let [target-instance (reify my-protocol/MyProtocolInADifferentNs
                          (hello-from-different-ns [this]
                            :working!))
        spy-instance (protocol/spy my-protocol/MyProtocolInADifferentNs
                                   target-instance)
        f (-> spy-instance protocol/spies :hello-from-different-ns)]
    (is (spy/not-called? f))
    (is (= :working! (my-protocol/hello-from-different-ns spy-instance)))
    (is (= [[spy-instance]] (spy/calls f)))
    (is (= [:working!] (spy/responses f)))))

(defprotocol OverloadedMethods
  (hello
    [this a]
    [this a b c]))

(defprotocol AllSorts
  (foo
    [this a]
    [this a b c])
  (bar [this])
  (baz [this one two]))

(deftest proto-with-overloaded-methods-test
  (let [target-instance (reify OverloadedMethods
                          (hello [this a]
                            :hello-a)
                          (hello [this a b c]
                            :hello-a-b-c))
        spy-instance (protocol/spy OverloadedMethods
                                   target-instance)
        f (-> spy-instance protocol/spies :hello)]
    (is (spy/not-called? f))
    (is (= :hello-a (hello spy-instance :a)))
    (is (= :hello-a-b-c (hello spy-instance :a :b :c)))))

(def protocol-methods #'protocol/protocol-methods)
(deftest protocol-methods-test
  (let [p @(resolve 'spy.protocol-test/Greeter)
        methods (protocol-methods p)]
    (is (= {:hey {:name 'hey
                  :arglists [['this 'x]]
                  :var #'spy.protocol-test/hey}}
           methods)))

  (let [p @(resolve 'spy.protocol-test/OverloadedMethods)
        methods (protocol-methods p)]

    (is (= {:hello
           {:name 'hello
            :arglists [['this 'a] ['this 'a 'b 'c]]
            :var #'spy.protocol-test/hello}}
           methods)))

  (let [p @(resolve 'spy.protocol-test/AllSorts)
        methods (protocol-methods p)]
    (is (= {:foo {:name 'foo
                  :arglists [['this 'a] ['this 'a 'b 'c]]
                  :var #'spy.protocol-test/foo}
            :bar {:name 'bar
                  :arglists [['this]]
                  :var #'spy.protocol-test/bar}
            :baz {:name 'baz
                  :arglists [['this 'one 'two]]
                  :var #'spy.protocol-test/baz}}
           methods))))


(defprotocol DestructuringArgs
  (destructuring-within-definition [this {:keys [my destructured args] :as my-args}]))

(deftest destructuring-within-definition-test
  (let [to-spy-on (reify DestructuringArgs
                    (destructuring-within-definition [_ {:keys [my destructured args] :as some-args}]
                      [[my destructured args]
                       some-args]))
        spied-upon (protocol/spy DestructuringArgs to-spy-on)
        args-map {:my "my"
                  :destructured {:a 1 :b 2}
                  :args [4 5 6]}
        expected [["my" {:a 1 :b 2} [4 5 6]]
                  args-map]]

    (is (= expected (destructuring-within-definition to-spy-on args-map)))
    (is (= expected (destructuring-within-definition spied-upon args-map)))))

(deftest destructuring-within-definition-not-in-implementation-test
  (let [to-spy-on (reify DestructuringArgs
                    (destructuring-within-definition [_ some-args]
                      some-args))
        spied-upon (protocol/spy DestructuringArgs to-spy-on)
        args-map {:my "my"
                  :destructured {:a 1 :b 2}
                  :args [4 5 6]}]

    (is (= args-map (destructuring-within-definition to-spy-on args-map)))
    (is (= args-map (destructuring-within-definition spied-upon args-map)))))

(defprotocol ProtocolA
  (method-a [this x])
  (a-not-mocked [this y z]))

(defprotocol ProtocolB
  (method-b [this x]))

(deftest multi-protocols-test
  (let [mock (protocol/mock
              ProtocolA
              (method-a [this x]
                        :a)

              ProtocolB
              (method-b [this x]
                        :b))]
    (is (= :a (method-a mock :testing)))
    (is (= :b (method-b mock :test)))
    (is (spy/called-once-with? (:method-a (protocol/spies mock))
                               mock
                               :testing))

    (is (spy/called-once-with? (:method-b (protocol/spies mock))
                               mock
                               :test))))
