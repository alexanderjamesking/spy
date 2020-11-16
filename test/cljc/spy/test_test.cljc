(ns spy.test-test
  (:require #?(:cljs [cljs.test :as t :refer [is deftest]]
               :clj  [clojure.test :as t :refer [is deftest]])
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

(deftest called-n-times?-test
  (let [f (spy/spy)]
    (passes #(is (spy/called-n-times? f 0)) 0 0)

    (fails #(is (spy/called-n-times? f 5)) 5 0)))

(deftest not-called?-test
  (let [f (spy/spy)]
    (passes #(is (spy/not-called? f)) 0 0)

    (f)
    (fails #(is (spy/not-called? f)) 0 1)))

(deftest called-once?-test
  (let [f (spy/spy)]
    (fails #(is (spy/called-once? f)) 1 0)

    (f)
    (passes #(is (spy/called-once? f)) 1 1)))

(deftest called-with?-test
  (let [f (spy/spy)]
    (fails #(is (spy/called-with? f "foo" "bar")) ["foo" "bar"] [])

    (f "foo" "bar")
    (passes
     #(is (spy/called-with? f "foo" "bar")) ["foo" "bar"] [["foo" "bar"]])))

(deftest not-called-with?-test
  (let [f (spy/spy)]
    (passes #(is (spy/not-called-with? f "foo" "bar")) ["foo" "bar"] [])

    (f "foo" "bar")
    (fails #(is (spy/not-called-with? f "foo" "bar"))
           ["foo" "bar"]
           [["foo" "bar"]])))

(deftest called-once-with?-test
  (let [f (spy/spy)]
    (fails #(is (spy/called-once-with? f "foo" "bar")) ["foo" "bar"] [])

    (f "foo" "bar")
    (passes
     #(is (spy/called-once-with? f "foo" "bar")) ["foo" "bar"] [["foo" "bar"]])

    (f "foo" "bar")
    (fails #(is (spy/called-once-with? f "foo" "bar"))
           ["foo" "bar"]
           [["foo" "bar"] ["foo" "bar"]])))

(deftest called-at-least-n-times?-test
  (let [f (spy/spy)]
    (fails #(is (spy/called-at-least-n-times? f 2)) 2 0)

    (f)
    (fails #(is (spy/called-at-least-n-times? f 2)) 2 1)

    (f)
    (passes #(is (spy/called-at-least-n-times? f 2)) 2 2)))

(deftest called?-test
  (let [f (spy/spy)]
    (fails #(is (spy/called? f)) 1 0)

    (f)
    (passes #(is (spy/called? f)) 1 1)

    (f)
    (passes #(is (spy/called? f)) 1 2)))

(deftest called-at-least-once?-test
  (let [f (spy/spy)]
    (fails #(is (spy/called-at-least-once? f)) 1 0)

    (f)
    (passes #(is (spy/called-at-least-once? f)) 1 1)

    (f)
    (passes #(is (spy/called-at-least-once? f)) 1 2)))

(deftest called-no-more-than-n-times?-test
  (let [f (spy/spy)]
    (passes #(is (spy/called-no-more-than-n-times? f 1)) 1 0)

    (f)
    (passes #(is (spy/called-no-more-than-n-times? f 1)) 1 1)

    (f)
    (fails #(is (spy/called-no-more-than-n-times? f 1)) 1 2)))

(deftest called-no-more-than-once?-test
  (let [f (spy/spy)]
    (passes #(is (spy/called-no-more-than-once? f)) 1 0)

    (f)
    (passes #(is (spy/called-no-more-than-once? f)) 1 1)

    (f)
    (fails #(is (spy/called-no-more-than-once? f)) 1 2)))

(deftest error-test
  (let [error (ex-info "Uh-oh!" {:some "data"})]
    (check :error
           #(is (spy/called-n-times? (throw error)))
           (fn [report]
             (is (= error (:actual report)))))))
