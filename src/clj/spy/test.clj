(ns spy.test
  "Implements the `clojure.test/assert-expr` multimethod for all spy predicates,
  allowing for rich error reporting without having to wrap `clojure.test/is`.

  Example usage:

  (def f (spy/spy))

  (f \"foo\" \"bar\")

  ;; succeeds!
  (is (spy/called-with? f \"foo\" \"bar\")

  ;; fails with:
  ;; FAIL in () (form-init541289308750557841.clj:234)
  ;; expected: (\"baz\")
  ;;   actual: [(\"foo\" \"bar\")]
  (is (spy/called-with? f \"baz\"))"
  (:require [clojure.test :as t]
            [spy.core :as spy]))

(defn assert-called*
  [msg expected-fn actual-fn spy-fn args]
  (let [result (apply spy-fn args)]
    (t/do-report {:type     (if result :pass :fail)
                  :message  msg
                  :expected (apply expected-fn (rest args))
                  :actual   (actual-fn (first args))})
    result))

(defn resolve-spy-fn
  [expr]
  (let [ns-sym 'spy.core]
    (require ns-sym)
    (ns-resolve (the-ns ns-sym) (symbol (name expr)))))

(defmacro assert-called
  [msg form expected-fn actual-fn]
  (let [spy-fn (resolve-spy-fn (first form))
        args   (rest form)]
    `(assert-called* ~msg ~expected-fn ~actual-fn ~spy-fn (list ~@args))))

(defmacro assert-called-n
  [msg form]
  `(assert-called ~msg ~form ~identity ~spy/call-count))

(defmacro assert-called-1
  [msg form]
  `(assert-called ~msg ~form ~(fn [] 1) ~spy/call-count))

(defmacro assert-called-args
  [msg form]
  `(assert-called ~msg ~form ~(fn [& args] args) ~spy/calls))

(defmethod t/assert-expr 'spy/called-n-times?
  [msg form]
  `(assert-called-n ~msg ~form))

(defmethod t/assert-expr 'spy/not-called?
  [msg form]
  `(assert-called ~msg ~form ~(fn [] 0) ~spy/call-count))

(defmethod t/assert-expr 'spy/called-once?
  [msg form]
  `(assert-called-1 ~msg ~form))

(defmethod t/assert-expr 'spy/called-with?
  [msg form]
  `(assert-called-args ~msg ~form))

(defmethod t/assert-expr 'spy/not-called-with?
  [msg form]
  `(assert-called-args ~msg ~form))

(defmethod t/assert-expr 'spy/called-once-with?
  [msg form]
  `(assert-called-args ~msg ~form))

(defmethod t/assert-expr 'spy/called-at-least-n-times?
  [msg form]
  `(assert-called-n ~msg ~form))

(defmethod t/assert-expr 'spy/called?
  [msg form]
  `(assert-called-1 ~msg ~form))

(defmethod t/assert-expr 'spy/called-at-least-once?
  [msg form]
  `(assert-called-1 ~msg ~form))

(defmethod t/assert-expr 'spy/called-no-more-than-n-times?
  [msg form]
  `(assert-called-n ~msg ~form))

(defmethod t/assert-expr 'spy/called-no-more-than-once?
  [msg form]
  `(assert-called-1 ~msg ~form))
