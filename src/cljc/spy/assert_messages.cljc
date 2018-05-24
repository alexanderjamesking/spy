(ns spy.assert-messages
  (:require [spy.core :as spy]))

(defn calls
  "Returns call if n is one, otherwise returns calls."
  [n]
  (if (= 1 n)
    "call"
    "calls"))

(defn calls-message
  "Returns message with expected and actual call counts.'"
  [f expected-count]
  (str "Expected " expected-count " " (calls expected-count) ", "
       "actual: " (spy/call-count f) " " (calls (spy/call-count f)) "."))
