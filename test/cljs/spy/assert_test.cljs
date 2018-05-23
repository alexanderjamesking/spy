(ns spy.assert-test
  (:require [spy.core :as spy]
            [spy.assert :as assert]
            [cljs.test :refer-macros [deftest testing is]])
  (:require-macros [spy.assert :refer [quick-test]]))


(deftest bingo-test
  (is (= 123 (assert/hello))))
