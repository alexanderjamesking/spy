(ns spy.assert-messages
  (:require [spy.core :as spy]))

(defn- calls
  "Returns call if n is one, otherwise returns calls."
  [n]
  (if (= 1 n)
    "call"
    "calls"))

(defn expected-calls
  "Returns message with expected and actual call counts.'"
  [f expected-count]
  (str "Expected " expected-count " " (calls expected-count) ", "
       "actual: " (spy/call-count f) " " (calls (spy/call-count f)) "."))

(defn called-with [f & args]
  (str "Expected a call with " args ".\nActual calls: " (spy/calls f)))

(defn not-called-with [f & args]
  (str "Expected no calls with " args ".\nActual calls: " (spy/calls f)))

(defn called-once-with [f & args]
  (str "Expected one call with " args ".\nActual calls: " (spy/calls f)))

(defn called-at-least-n-times [f n]
  (str "Expected at least " n " " (calls n) ", "
       "actual: " (spy/call-count f) " " (calls (spy/call-count f)) "."))

(defn called-no-more-than-n-times [f n]
  (str "Expected no more than " n " " (calls n) ", "
       "actual: " (spy/call-count f) " " (calls (spy/call-count f)) "."))
