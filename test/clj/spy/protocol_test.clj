(ns spy.protocol-test
  (:require [clojure.test :refer [deftest is testing]]
            [spy.core :as spy]
            [spy.protocol :as protocol]
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

(deftest protocol-methods-test
  (let [p @(resolve 'spy.protocol-test/Greeter)
        methods (protocol/protocol-methods p)]
    (is (= {:hey {:name 'hey
                  :arglists [['this 'x]]
                  :var #'spy.protocol-test/hey}}
           methods)))

  (let [p @(resolve 'spy.protocol-test/OverloadedMethods)
        methods (protocol/protocol-methods p)]

    (is (= {:hello
           {:name 'hello
            :arglists [['this 'a] ['this 'a 'b 'c]]
            :var #'spy.protocol-test/hello}}
           methods)))

  (let [p @(resolve 'spy.protocol-test/AllSorts)
        methods (protocol/protocol-methods p)]
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
