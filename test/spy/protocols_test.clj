(ns spy.protocols-test
  (:require [clojure.test :refer [deftest is testing]]
            [spy.core :as spy]
            [spy.alpha :as spy-alpha]))

(defprotocol Hello
  (hello [this]))


(defprotocol HelloTwo
  (hello-one [this a])
  (hello-two [this b]))

(defprotocol HelloMulti
  (hello-multi [this] [this a]))

(defprotocol HelloMulti2
  (hello-multi2 [this] [this a])
  (something-else [this x]))

(deftest basic-test
  (let [hello-spy (spy/stub :helloworld)
        x (spy-alpha/protocol-spy Hello {:hello hello-spy})]
    (is (satisfies? Hello x))
    (hello x)
    (spy/called-with? hello-spy x)))

(deftest hello-two-test
  (let [first-spy (spy/stub :h1)
        second-spy (spy/stub :h2)
        x (spy-alpha/protocol-spy HelloTwo {:hello-one first-spy
                                            :hello-two second-spy})]
    (is (satisfies? HelloTwo x))

    (hello-one x :foo)
    (is (spy/called-once-with? first-spy x :foo))

    (hello-two x :bar)
    (is (spy/called-once-with? second-spy x :bar))))

(deftest hello-multi-test
  (let [hello-spy (spy/stub :helloworld)
        x (spy-alpha/protocol-spy HelloMulti {:hello-multi hello-spy})]
    (is (satisfies? HelloMulti x))
    (hello-multi x)
    (hello-multi x :foo)
    (spy/called-with? hello-spy x)
    (spy/called-with? hello-spy x :foo)))

(deftest hello-multi2-test
  (let [hello-spy (spy/stub :helloworld)
        se-spy (spy/stub :something-else)
        x (spy-alpha/protocol-spy HelloMulti2 {:hello-multi2 hello-spy
                                               :something-else se-spy})]
    (is (satisfies? HelloMulti2 x))
    (hello-multi2 x)
    (hello-multi2 x :foo)
    (something-else x :bingo)
    (spy/called-with? hello-spy x)
    (spy/called-with? hello-spy x :foo)
    (spy/called-with? se-spy x :bingo)))
