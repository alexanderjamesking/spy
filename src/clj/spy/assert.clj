(ns ^{:author "Alexander James King",
      :doc "clojure.test assertion functions wrapping spy.core

      Macros are used to ensure the clojure.test/is macro
      appears in the calling code, otherwise line numbers
      reported on failure will show as failures in the
      library and not the calling code."}
  spy.assert
  (:require [spy.core :as spy]
            [clojure.test :refer [is]]))

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

(defmacro called-n-times?
  "Throws "
  [f n]
  `(is (spy/called-n-times? ~f ~n)
       (calls-message ~f ~n)))

(defmacro not-called?
  [f]
  `(is (spy/not-called? ~f)
       (calls-message ~f 0)))

(defmacro called-once?
  [f]
  `(is (spy/called-once? ~f)
       (calls-message ~f 1)))

(defmacro called-with?
  [f & args]
  `(is (spy/called-with? ~f ~@args)
       (str "Expected a call with " '~args ".\nActual: " (spy/calls ~f))))

(defmacro not-called-with?
  [f & args]
  `(is (spy/not-called-with? ~f ~@args)
       (str "Expected no calls with " '~args ".\nActual: " (spy/calls ~f))))

(defmacro called-once-with?
  [f & args]
  `(is (spy/called-once-with? ~f ~@args)
      (str "Expected one call with " '~args ".\nActual: " (spy/calls ~f))))

(defmacro called-at-least-n-times?
  [f n]
  `(is (spy/called-at-least-n-times? ~f ~n)
       (str "Expected at least " ~n " " (calls ~n) ", "
            "actual: " (spy/call-count ~f) " " (calls (spy/call-count ~f)) ".")))

(defmacro called?
  [f]
  `(called-at-least-n-times? ~f 1))

(defmacro called-at-least-once?
  [f]
  `(called-at-least-n-times? ~f 1))

(defmacro called-no-more-than-n-times?
  [f n]
  `(is (spy/called-no-more-than-n-times? ~f ~n)
       (str "Expected no more than " ~n " " (calls ~n) ", "
            "actual: " (spy/call-count ~f) " " (calls (spy/call-count ~f)) ".")))

(defmacro called-no-more-than-once?
  [f]
  `(called-no-more-than-n-times? ~f 1))
