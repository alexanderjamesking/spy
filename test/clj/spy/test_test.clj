(ns spy.test-test
  (:require [clojure.test :as t :refer [is deftest]]
            [spy.core :as spy]
            [spy.test]))

(defn check
  [status assert-fn check-fn]
  (let [reporter (spy/spy)]
     (binding [t/report reporter]
       (assert-fn))
     (let [report (first (spy/first-call reporter))]
       (is (= status (:type report)))
       (check-fn report))))

(defn check-simple
  [status assert-fn expected actual]
  (check status assert-fn (fn [report]
                            (is (= expected (:expected report)))
                            (is (= actual (:actual report))))))

(defn passes
  [assert-fn expected actual]
  (check-simple :pass assert-fn expected actual))

(defn fails
  [assert-fn expected actual]
  (check-simple :fail assert-fn expected actual))

(defn errors
  [assert-fn message]
  (check :error
         assert-fn
         (fn [report]
           (is (= message (-> report :actual .getMessage))))))

(deftest called-n-times?-test
  (let [f (spy/spy)]
    (passes #(is (spy/called-n-times? f 0)) 0 0)

    (fails #(is (spy/called-n-times? f 5)) 5 0))

  (errors
   #(is (spy/called-n-times?))
   "Wrong number of args (0) passed to: core/called-n-times?"))

(deftest not-called?-test
  (let [f (spy/spy)]
    (passes #(is (spy/not-called? f)) 0 0)

    (f)
    (fails #(is (spy/not-called? f)) 0 1))

  (errors
   #(is (spy/not-called?))
   "Wrong number of args (0) passed to: core/not-called?"))

(deftest called-once?-test
  (let [f (spy/spy)]
    (fails #(is (spy/called-once? f)) 1 0)

    (f)
    (passes #(is (spy/called-once? f)) 1 1))

  (errors
   #(is (spy/called-once?))
   "Wrong number of args (0) passed to: core/called-once?"))

(deftest called-with?-test
  (let [f (spy/spy)]
    (fails #(is (spy/called-with? f "foo" "bar")) ["foo" "bar"] [])

    (f "foo" "bar")
    (passes
     #(is (spy/called-with? f "foo" "bar")) ["foo" "bar"] [["foo" "bar"]]))

  (errors #(is (spy/called-with?))
          "Wrong number of args (0) passed to: core/called-with?"))

(deftest not-called-with?-test
  (let [f (spy/spy)]
    (passes #(is (spy/not-called-with? f "foo" "bar")) ["foo" "bar"] [])

    (f "foo" "bar")
    (fails #(is (spy/not-called-with? f "foo" "bar"))
           ["foo" "bar"]
           [["foo" "bar"]]))

  (errors #(is (spy/not-called-with?))
          "Wrong number of args (0) passed to: core/not-called-with?"))

(deftest called-once-with?-test
  (let [f (spy/spy)]
    (fails #(is (spy/called-once-with? f "foo" "bar")) ["foo" "bar"] [])

    (f "foo" "bar")
    (passes
     #(is (spy/called-once-with? f "foo" "bar")) ["foo" "bar"] [["foo" "bar"]])

    (f "foo" "bar")
    (fails #(is (spy/called-once-with? f "foo" "bar"))
           ["foo" "bar"]
           [["foo" "bar"] ["foo" "bar"]]))

  (errors #(is (spy/called-once-with?))
          "Wrong number of args (0) passed to: core/called-once-with?"))

(deftest called-at-least-n-times?-test
  (let [f (spy/spy)]
    (fails #(is (spy/called-at-least-n-times? f 2)) 2 0)

    (f)
    (fails #(is (spy/called-at-least-n-times? f 2)) 2 1)

    (f)
    (passes #(is (spy/called-at-least-n-times? f 2)) 2 2))

  (errors
   #(is (spy/called-at-least-n-times?))
   "Wrong number of args (0) passed to: core/called-at-least-n-times?"))

(deftest called?-test
  (let [f (spy/spy)]
    (fails #(is (spy/called? f)) 1 0)

    (f)
    (passes #(is (spy/called? f)) 1 1)

    (f)
    (passes #(is (spy/called? f)) 1 2))

  (errors #(is (spy/called?))
          "Wrong number of args (0) passed to: core/called?"))

(deftest called-at-least-once?-test
  (let [f (spy/spy)]
    (fails #(is (spy/called-at-least-once? f)) 1 0)

    (f)
    (passes #(is (spy/called-at-least-once? f)) 1 1)

    (f)
    (passes #(is (spy/called-at-least-once? f)) 1 2))

  (errors #(is (spy/called-at-least-once?))
          "Wrong number of args (0) passed to: core/called-at-least-once?"))

(deftest called-no-more-than-n-times?-test
  (let [f (spy/spy)]
    (passes #(is (spy/called-no-more-than-n-times? f 1)) 1 0)

    (f)
    (passes #(is (spy/called-no-more-than-n-times? f 1)) 1 1)

    (f)
    (fails #(is (spy/called-no-more-than-n-times? f 1)) 1 2))

  (errors
   #(is (spy/called-no-more-than-n-times?))
   "Wrong number of args (0) passed to: core/called-no-more-than-n-times?"))

(deftest called-no-more-than-once?-test
  (let [f (spy/spy)]
    (passes #(is (spy/called-no-more-than-once? f)) 1 0)

    (f)
    (passes #(is (spy/called-no-more-than-once? f)) 1 1)

    (f)
    (fails #(is (spy/called-no-more-than-once? f)) 1 2))

  (errors
   #(is (spy/called-no-more-than-once?))
   "Wrong number of args (0) passed to: core/called-no-more-than-once?"))
