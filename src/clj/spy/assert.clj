(ns spy.assert
  (:require [spy.core :as spy]
            [clojure.test :refer [is]]))

(defn- calls [n]
  (if (= 1 n)
    "call"
    "calls"))

(defn calls-message [f expected-count]
  (str "Expected " expected-count " " (calls expected-count) ", "
       "received " (spy/call-count f) " " (calls (spy/call-count f)) "."))

(defn called-n-times?
  [f n]
  (is (spy/called-n-times? f n)
      (calls-message f n)))

(defn not-called?
  [f]
  (is (spy/not-called? f)
      (calls-message f 0)))

(defn called-once?
  [f]
  (is (spy/called-once? f)
      (calls-message f 1)))

(defn called-with?
  [f & args]
  (is (apply spy/called-with? f args)
      (str "Spy was not called with " args ".\n\nCalls:\n" (spy/calls f))))

(defn not-called-with?
  [f & args]
  (is (apply spy/not-called-with? f args)
      (str "Spy was called with " args ".\n\nCalls:\n" (spy/calls f))))

(defn called-once-with?
  [f & args]
  (is (apply spy/called-once-with? f args)
      (str "Spy was called once with " args)))

(defn called-at-least-n-times?
  [f n]
  (is (spy/called-at-least-n-times? f n)
      (str "Expected at least " n " " (calls n) ", "
           "received " (spy/call-count f) " " (calls (spy/call-count f)) ".")))

(defn called?
  [f])

(defn called-at-least-once?
  [f])

(defn called-no-more-than-n-times?
  [f n])

(defn called-no-more-than-once?
  [f])
