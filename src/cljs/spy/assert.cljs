(ns ^{:author "Alexander James King",
      :doc "Assertion functions wrapping spy.core functions,
      providing assertions using cljs.test/is and messages
      to aid debugging when test expectations are not met.

      Differs from the Clojure version as macros are not used
      due to added complexity and the fact that cljs does not
      provide the line number on failure at present."}
    spy.assert
  (:require [spy.core :as spy]
            [spy.assert-messages :as assert-messages]
            [cljs.test :refer [do-report] :refer-macros [is]]))

(defn called-n-times?
  [f n]
  (is (spy/called-n-times? f n)
      (assert-messages/expected-calls f n)))

(defn not-called?
  [f]
  (is (spy/not-called? f)
      (assert-messages/expected-calls f 0)))

(defn called-once?
  [f]
  (is (spy/called-once? f)
      (assert-messages/expected-calls f 1)))

(defn called-with?
  [f & args]
  (is (apply spy/called-with? f args)
      (apply assert-messages/called-with f args)))

(defn not-called-with?
  [f & args]
  (is (apply spy/not-called-with? f args)
      (apply assert-messages/not-called-with f args)))

(defn called-once-with?
  [f & args]
  (is (apply spy/called-once-with? f args)
      (apply assert-messages/called-once-with f args)))

(defn called-at-least-n-times?
  [f n]
  (is (spy/called-at-least-n-times? f n)
      (assert-messages/called-at-least-n-times f n)))

(defn called?
  [f]
  (called-at-least-n-times? f 1))

(defn called-at-least-once?
  [f]
  (called-at-least-n-times? f 1))

(defn called-no-more-than-n-times?
  [f n]
  (is (spy/called-no-more-than-n-times? f n)
      (assert-messages/called-no-more-than-n-times f n)))

(defn called-no-more-than-once?
  [f]
  (called-no-more-than-n-times? f 1))
