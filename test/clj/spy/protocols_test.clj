(ns spy.protocols-test
  (:require [clojure.test :refer [deftest is testing]]
            [spy.core :as spy]
            [spy.protocol :as protocol]))

(defprotocol Hello
  (hello [this]))

(protocol/defspy HelloSpy Hello)

(deftest basic-test
  (let [pspy (map->HelloSpy {:hello (spy/stub :helloworld)})]
    (is (satisfies? Hello pspy))
    (hello pspy)
    (spy/called-with? (:hello pspy) pspy)))

(defprotocol HelloTwo
  (hello-one [this a])
  (hello-two [this b]))

(protocol/defspy HelloTwoSpy HelloTwo)

(deftest hello-two-test
  (let [pspy (map->HelloTwoSpy {:hello-one (spy/stub :h1)
                                :hello-two (spy/stub :h2)})]
    (is (satisfies? HelloTwo pspy))

    (hello-one pspy :foo)
    (is (spy/called-once-with? (:hello-one pspy) pspy :foo))

    (hello-two pspy :bar)
    (is (spy/called-once-with? (:hello-two pspy) pspy :bar))))

(defprotocol HelloMulti
  (hello-multi [this] [this a]))

(protocol/defspy HelloMultiSpy HelloMulti)

(deftest hello-multi-test
  (let [pspy (->HelloMultiSpy (spy/stub :hello-world))]
    (is (satisfies? HelloMulti pspy))
    (hello-multi pspy)
    (hello-multi pspy :foo)
    (spy/called-with? (:hello-multi pspy) pspy)
    (spy/called-with? (:hello-multi pspy) pspy :foo)))

(defprotocol HelloMulti2
  (hello-multi2 [this] [this a])
  (something-else [this x]))

(protocol/defspy HelloMulti2Spy HelloMulti2)

(deftest hello-multi2-test
  (let [pspy (->HelloMulti2Spy (spy/stub :helloworld) (spy/stub :something-else))]
    (is (satisfies? HelloMulti2 pspy))
    (hello-multi2 pspy)
    (hello-multi2 pspy :foo)
    (something-else pspy :bingo)
    (spy/called-with? (:hello-multi2 pspy) pspy)
    (spy/called-with? (:hello-multi2 pspy) pspy :foo)
    (spy/called-with? (:something-else pspy) pspy :bingo)))

(defprotocol BasicProtocol
  (basic-protocol [this]))

(deftest basic-protocol-test
  (let [pspy (protocol/spy BasicProtocol)]
    (is (satisfies? BasicProtocol pspy))
    (is (false? (spy/called-once? (:basic-protocol pspy))))

    (testing "defaults to an empty spy (that returns nil when called)"
      (is (nil? (basic-protocol pspy))))

    (is (spy/called-once? (:basic-protocol pspy)))))

(deftest protocol-with-custom-spy-test
  (let [pspy (protocol/spy BasicProtocol {:basic-protocol (spy/stub 99)})]
    (is (satisfies? BasicProtocol pspy))
    (is (= 99 (basic-protocol pspy)))
    (is (spy/called-once? (:basic-protocol pspy)))))
