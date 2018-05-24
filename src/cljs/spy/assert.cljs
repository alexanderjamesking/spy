(ns ^{:author "Alexander James King",
      :doc "Assertion functions wrapping spy.core functions,
      providing assertions using cljs.test/is and messages
      to aid debugging when test expectations are not met.

      Differs from the Clojure version as macros are not used
      due to added complexity and the fact that cljs does not
      provide the line number on failure at present."}
    spy.assert
  (:require [spy.core :as spy]
            [spy.assert-messages :refer [calls calls-message]]
            [cljs.test :refer [do-report] :refer-macros [is]]))

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
      (str "Expected a call with " args ".\nActual: " (spy/calls f))))

(defn not-called-with?
  [f & args]
  (is (apply spy/not-called-with? f args)
      (str "Expected no calls with " args ".\nActual: " (spy/calls f))))

(defn called-once-with?
  [f & args]
  (is (apply spy/called-once-with? f args)
      (str "Expected one call with " args ".\nActual: " (spy/calls f))))

(defn called-at-least-n-times?
  [f n]
  (is (spy/called-at-least-n-times? f n)
      (str "Expected at least " n " " (calls n) ", "
           "actual: " (spy/call-count f) " " (calls (spy/call-count f)) ".")))

(defn called?
  [f]
  (called-at-least-n-times? f 1))

(defn called-at-least-once?
  [f]
  (called-at-least-n-times? f 1))

(defn called-no-more-than-n-times?
  [f n]
  (is (spy/called-no-more-than-n-times? f n)
      (str "Expected no more than " n " " (calls n) ", "
           "actual: " (spy/call-count f) " " (calls (spy/call-count f)) ".")))

(defn called-no-more-than-once?
  [f]
  (called-no-more-than-n-times? f 1))
