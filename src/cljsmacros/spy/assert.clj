(ns spy.assert
  (:require [spy.core :as spy]))

(defmacro quick-test []
  `(cljs.test/is (= 3 3)))
