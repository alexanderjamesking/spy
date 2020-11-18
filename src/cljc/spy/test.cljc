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
  #?(:clj (:require [clojure.test :as t])))

(defn expected-called-n-times
  [n]
  n)

(defn actual-called-n-times
  [calls]
  (count calls))

(defn expected-called-once
  []
  1)

(defn actual-called-once
  [calls]
  (actual-called-n-times calls))

(defn expected-called-with-args
  [& args]
  args)

(defn actual-called-with-args
  [calls]
  calls)

(defn expected-not-called
  []
  0)

(defn actual-not-called
  [calls]
  (actual-called-n-times calls))

(defn expected-call-matching
  [form]
  form)

(defn actual-call-matching
  [calls]
  (actual-called-with-args calls))

#?(:clj
   (do
     (defmacro assert-called
       [msg form report-fn expected-fn actual-fn]
       (let [spy-fn (symbol (str (name 'spy.core) "/" (name (first form))))
             args   (rest form)]
         `(let [args#   (list ~@args)
                result# (apply ~spy-fn args#)]
            (~report-fn {:type     (if result# :pass :fail)
                         :message  ~msg
                         :expected (apply ~expected-fn (rest args#))
                         :actual   (~actual-fn (spy.core/calls (first args#)))})
            result#)))

     (defmacro assert-called-n-times
       [msg form report-fn]
       `(assert-called ~msg
                        ~form
                        ~report-fn
                        ~`expected-called-n-times
                        ~`actual-called-n-times))

     (defmacro assert-called-once
       [msg form report-fn]
       `(assert-called ~msg
                        ~form
                        ~report-fn
                        ~`expected-called-once
                        ~`actual-called-once))

     (defmacro assert-called-with-args
       [msg form report-fn]
       `(assert-called ~msg
                        ~form
                        ~report-fn
                        ~`expected-called-with-args
                        ~`actual-called-with-args))

     (defmacro assert-not-called
       [msg form report-fn]
       `(assert-called ~msg
                        ~form
                        ~report-fn
                        ~`expected-not-called
                        ~`actual-not-called))

     (defmacro assert-call-matching
       [msg form report-fn]
       `(assert-called ~msg
                       ~form
                       ~report-fn
                       (fn [~'& ~'args]
                         (expected-call-matching '~(last form)))
                       ~`actual-call-matching))

     (defmethod t/assert-expr 'spy/called-n-times?
       [msg form]
       `(assert-called-n-times ~msg ~form ~`t/do-report))

     (defmethod t/assert-expr 'spy/not-called?
       [msg form]
       `(assert-not-called ~msg ~form ~`t/do-report))

     (defmethod t/assert-expr 'spy/called-once?
       [msg form]
       `(assert-called-once ~msg ~form ~`t/do-report))

     (defmethod t/assert-expr 'spy/called-with?
       [msg form]
       `(assert-called-with-args ~msg ~form ~`t/do-report))

     (defmethod t/assert-expr 'spy/not-called-with?
       [msg form]
       `(assert-called-with-args ~msg ~form ~`t/do-report))

     (defmethod t/assert-expr 'spy/called-once-with?
       [msg form]
       `(assert-called-with-args ~msg ~form ~`t/do-report))

     (defmethod t/assert-expr 'spy/called-at-least-n-times?
       [msg form]
       `(assert-called-n-times ~msg ~form ~`t/do-report))

     (defmethod t/assert-expr 'spy/called?
       [msg form]
       `(assert-called-once ~msg ~form ~`t/do-report))

     (defmethod t/assert-expr 'spy/called-at-least-once?
       [msg form]
       `(assert-called-once ~msg ~form ~`t/do-report))

     (defmethod t/assert-expr 'spy/called-no-more-than-n-times?
       [msg form]
       `(assert-called-n-times ~msg ~form ~`t/do-report))

     (defmethod t/assert-expr 'spy/called-no-more-than-once?
       [msg form]
       `(assert-called-once ~msg ~form ~`t/do-report))

     (defmethod t/assert-expr 'spy/call-matching?
       [msg form]
       `(assert-call-matching ~msg ~form ~`t/do-report))))
