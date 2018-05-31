(ns spy.protocols-test
  (:require [clojure.test :refer [deftest is testing]]
            [spy.core :as spy]
            [spy.protocol :as protocol]
            [spy.my-protocol :as my-protocol]))

(defprotocol Hello
  (hello [this]))

(defprotocol HelloTwo
  (hello-one [this a])
  (hello-two [this b]))

(deftest hello-two-test
  (let [pspy (protocol/spy HelloTwo
                           {:hello-one (spy/stub :h1)
                            :hello-two (spy/stub :h2)})]
    (is (satisfies? HelloTwo pspy))

    (hello-one pspy :foo)
    (is (spy/called-once-with? (:hello-one (protocol/spies pspy)) pspy :foo))

    (hello-two pspy :bar)
    (is (spy/called-once-with? (:hello-two (protocol/spies pspy)) pspy :bar))))

(defprotocol HelloMulti
  (hello-multi [this] [this a]))

(deftest hello-multi-test
  (let [pspy (protocol/spy HelloMulti (spy/stub :hello-world))]
    (is (satisfies? HelloMulti pspy))
    (hello-multi pspy)
    (hello-multi pspy :foo)
    (spy/called-with? (:hello-multi (protocol/spies pspy)) pspy)
    (spy/called-with? (:hello-multi (protocol/spies pspy)) pspy :foo)))

(defprotocol HelloMulti2
  (hello-multi2 [this] [this a])
  (something-else [this x]))

(deftest hello-multi2-test
  (let [pspy (protocol/spy HelloMulti2
                           {:hello-multi2 (spy/stub :helloworld)
                            :something-else (spy/stub :something-else)})]
    (is (satisfies? HelloMulti2 pspy))
    (hello-multi2 pspy)
    (hello-multi2 pspy :foo)
    (something-else pspy :bingo)
    (spy/called-with? (:hello-multi2 (protocol/spies pspy)) pspy)
    (spy/called-with? (:hello-multi2 (protocol/spies pspy)) pspy :foo)
    (spy/called-with? (:something-else (protocol/spies pspy)) pspy :bingo)))

(defprotocol BasicProtocol
  (basic-protocol [this]))

(deftest basic-protocol-test
  (let [pspy (protocol/spy BasicProtocol)]
    (is (satisfies? BasicProtocol pspy))
    (is (false? (spy/called-once? (:basic-protocol pspy))))

    (testing "defaults to an empty spy (that returns nil when called)"
      (is (nil? (basic-protocol pspy))))

    (is (spy/called-once? (:basic-protocol (protocol/spies pspy))))))

(deftest protocol-with-custom-spy-test2
  (let [pspy (protocol/spy BasicProtocol {:basic-protocol (spy/stub 99)})]
    (is (satisfies? BasicProtocol pspy))
    (is (= 99 (basic-protocol pspy)))
    (is (spy/called-once? (:basic-protocol (protocol/spies pspy))))))

(deftest protocol-with-custom-spy-test2-different-ns
  (let [pspy (protocol/spy my-protocol/MyProtocolInADifferentNs
                            {:hello-from-different-ns (spy/stub 42)})]
    (is (satisfies? my-protocol/MyProtocolInADifferentNs pspy))
    (is (= 42 (my-protocol/hello-from-different-ns pspy)))
    (is (spy/called-once? (:hello-from-different-ns (protocol/spies pspy))))))
