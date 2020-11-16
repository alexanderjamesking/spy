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
  #?(:cljs (:require-macros [spy.test.cljs])
     :clj  (:require [clojure.test :as t]))
  (:require [spy.core]))

(defn called-n [n] n)
(defn called-once [] 1)
(defn called-args [& args] args)
(defn not-called [] 0)

#?(:clj
   (do
     (defmacro assert-called
       [msg form report-fn expected-fn actual-fn]
       (let [spy-fn (symbol (str "spy.core/" (name (first form))))
             args   (rest form)]
         `(let [args#   (list ~@args)
                result# (apply ~spy-fn args#)]
            (~report-fn {:type     (if result# :pass :fail)
                         :message  ~msg
                         :expected (apply ~expected-fn (rest args#))
                         :actual   (~actual-fn (first args#))})
            result#)))

     (defmacro assert-called-n
       [msg form report-fn]
       `(assert-called ~msg ~form ~report-fn called-n spy/call-count))

     (defmacro assert-called-once
       [msg form report-fn]
       `(assert-called ~msg ~form ~report-fn called-once spy/call-count))

     (defmacro assert-called-args
       [msg form report-fn]
       `(assert-called ~msg ~form ~report-fn called-args spy/calls))

     (defmacro assert-not-called
       [msg form report-fn]
       `(assert-called ~msg ~form ~report-fn not-called spy/call-count))

     (defmethod t/assert-expr 'spy/called-n-times?
       [msg form]
       `(assert-called-n ~msg ~form t/do-report))

     (defmethod t/assert-expr 'spy/not-called?
       [msg form]
       `(assert-not-called ~msg ~form t/do-report))

     (defmethod t/assert-expr 'spy/called-once?
       [msg form]
       `(assert-called-once ~msg ~form t/do-report))

     (defmethod t/assert-expr 'spy/called-with?
       [msg form]
       `(assert-called-args ~msg ~form t/do-report))

     (defmethod t/assert-expr 'spy/not-called-with?
       [msg form]
       `(assert-called-args ~msg ~form t/do-report))

     (defmethod t/assert-expr 'spy/called-once-with?
       [msg form]
       `(assert-called-args ~msg ~form t/do-report))

     (defmethod t/assert-expr 'spy/called-at-least-n-times?
       [msg form]
       `(assert-called-n ~msg ~form t/do-report))

     (defmethod t/assert-expr 'spy/called?
       [msg form]
       `(assert-called-once ~msg ~form t/do-report))

     (defmethod t/assert-expr 'spy/called-at-least-once?
       [msg form]
       `(assert-called-once ~msg ~form t/do-report))

     (defmethod t/assert-expr 'spy/called-no-more-than-n-times?
       [msg form]
       `(assert-called-n ~msg ~form t/do-report))

     (defmethod t/assert-expr 'spy/called-no-more-than-once?
       [msg form]
       `(assert-called-once ~msg ~form t/do-report))))
