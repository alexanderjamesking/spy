(ns spy.assert
  (:require [spy.core :as spy]
            [clojure.test :refer [is]]))

(defn calls [n]
  (if (= 1 n)
    "call"
    "calls"))

(defn calls-message [f expected-count]
  (str "Expected " expected-count " " (calls expected-count) ", "
       "received " (spy/call-count f) " " (calls (spy/call-count f)) "."))

(defmacro called-n-times?
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
       (str "Expected a call with " '~args ".\n\nCalls:\n" (spy/calls ~f))))

(defmacro not-called-with?
  [f & args]
  `(is (spy/not-called-with? ~f ~@args)
       (str "Expected no calls with " '~args ".\n\nCalls:\n" (spy/calls ~f))))

(defmacro called-once-with?
  [f & args]
  `(is (spy/called-once-with? ~f ~@args)
      (str "Expected one call with " '~args ".\n\nCalls:\n" (spy/calls ~f))))

(defmacro called-at-least-n-times?
  [f n]
  `(is (spy/called-at-least-n-times? ~f ~n)
       (str "Expected at least " ~n " " (calls ~n) ", "
            "received " (spy/call-count ~f) " " (calls (spy/call-count ~f)) ".")))

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
            "received " (spy/call-count ~f) " " (calls (spy/call-count ~f)) ".")))

(defmacro called-no-more-than-once?
  [f]
  `(called-no-more-than-n-times? ~f 1))
