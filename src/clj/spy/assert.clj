(ns ^{:author "Alexander James King",
      :doc "Assertion functions wrapping spy.core functions,
      providing assertions using clojure.test/is and messages
      to aid debugging when test expectations are not met.

      Macros are used to ensure the clojure.test/is macro
      appears in the calling code, otherwise line numbers
      reported on failure will show as failures in the
      library and not the calling code."}
  spy.assert
  (:require [spy.core :as spy]
            [spy.assert-messages :as assert-messages]
            [clojure.test :refer [is]]))

(defmacro called-n-times?
  [f n]
  `(is (spy/called-n-times? ~f ~n)
       (assert-messages/expected-calls ~f ~n)))

(defmacro not-called?
  [f]
  `(is (spy/not-called? ~f)
       (assert-messages/expected-calls ~f 0)))

(defmacro called-once?
  [f]
  `(is (spy/called-once? ~f)
       (assert-messages/expected-calls ~f 1)))

(defmacro called-with?
  [f & args]
  `(is (spy/called-with? ~f ~@args)
       (assert-messages/called-with ~f ~@args)))

(defmacro not-called-with?
  [f & args]
  `(is (spy/not-called-with? ~f ~@args)
       (assert-messages/not-called-with ~f ~@args)))

(defmacro called-once-with?
  [f & args]
  `(is (spy/called-once-with? ~f ~@args)
       (assert-messages/called-once-with ~f ~@args)))

(defmacro called-at-least-n-times?
  [f n]
  `(is (spy/called-at-least-n-times? ~f ~n)
       (assert-messages/called-at-least-n-times ~f ~n)))

(defmacro called?
  [f]
  `(called-at-least-n-times? ~f 1))

(defmacro called-at-least-once?
  [f]
  `(called-at-least-n-times? ~f 1))

(defmacro called-no-more-than-n-times?
  [f n]
  `(is (spy/called-no-more-than-n-times? ~f ~n)
       (assert-messages/called-no-more-than-n-times ~f ~n)))

(defmacro called-no-more-than-once?
  [f]
  `(called-no-more-than-n-times? ~f 1))
