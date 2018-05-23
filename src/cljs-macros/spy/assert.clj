(ns spy.assert
  (:require [spy.core :as spy]
            [cljs.test :refer :all :include-macros true]))

(defmacro quick-test []

   `(is (= 3 3)))

(defn- calls [n]
  (if (= 1 n)
    "call"
    "calls"))

(defn calls-message [f expected-count]
  (str "Expected " expected-count " " (calls expected-count) ", "
       "received " (spy/call-count f) " " (calls (spy/call-count f)) "."))

(defn called-n-times?
  [f n]
  (spy/called-n-times? f n)
  #_
  (is (spy/called-n-times? f n)
      (calls-message f n)))
