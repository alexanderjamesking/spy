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
        proto-spy (spy-alpha/protocol-spy Hello {:hello hello-spy})]
    (is (satisfies? Hello proto-spy))
    (is (= [:hello] (keys (meta proto-spy))))
    (hello proto-spy)
    (spy/called-with? hello-spy proto-spy)))

(deftest hello-two-test
  (let [first-spy (spy/stub :h1)
        second-spy (spy/stub :h2)
        proto-spy (spy-alpha/protocol-spy HelloTwo {:hello-one first-spy
                                                    :hello-two second-spy})]
    (is (satisfies? HelloTwo proto-spy))
    (is (= [:hello-one :hello-two] (keys (meta proto-spy))))

    (hello-one proto-spy :foo)
    (is (spy/called-once-with? first-spy proto-spy :foo))

    (hello-two proto-spy :bar)
    (is (spy/called-once-with? second-spy proto-spy :bar))))

(deftest hello-multi-test
  (let [hello-spy (spy/stub :helloworld)
        proto-spy (spy-alpha/protocol-spy HelloMulti {:hello-multi hello-spy})]
    (is (satisfies? HelloMulti proto-spy))
    (is (= [:hello-multi] (keys (meta proto-spy))))
    (hello-multi proto-spy)
    (hello-multi proto-spy :foo)
    (spy/called-with? hello-spy proto-spy)
    (spy/called-with? hello-spy proto-spy :foo)))

(deftest hello-multi2-test
  (let [hello-spy (spy/stub :helloworld)
        se-spy (spy/stub :something-else)
        proto-spy (spy-alpha/protocol-spy HelloMulti2 {:hello-multi2 hello-spy
                                                       :something-else se-spy})]
    (is (satisfies? HelloMulti2 proto-spy))
    (is (= [:hello-multi2 :something-else] (keys (meta proto-spy))))
    (hello-multi2 proto-spy)
    (hello-multi2 proto-spy :foo)
    (something-else proto-spy :bingo)
    (spy/called-with? hello-spy proto-spy)
    (spy/called-with? hello-spy proto-spy :foo)
    (spy/called-with? se-spy proto-spy :bingo)))
