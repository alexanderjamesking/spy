(ns spy.assert-test
  (:require [spy.core :as spy]
            #?(:cljs [cljs.test :as t :refer-macros [deftest is]]
               :clj  [clojure.test :as t :refer [deftest is]])
            [spy.assert :as assert]
            [spy.assert-messages :as assert-messages]))

(defn assert-failure [assert-fn expected-message]
  (let [reporter (spy/spy)]
    (binding [t/report reporter]
      (assert-fn))
    (let [report (first (spy/first-call reporter))]
      (is (= :fail (:type report)))
      (is (= expected-message (:message report))))))

(deftest not-called-test
  (let [f (spy/spy)]
    (f)
    (assert-failure #(assert/not-called? f)
                    (assert-messages/expected-calls f 0))))

(deftest called-once-test
  (let [f (spy/spy)]
    (f)
    (f)
    (assert-failure #(assert/called-once? f)
                    (assert-messages/expected-calls f 1))))

(deftest called-n-times-test
  (let [f (spy/spy)]
    (assert-failure #(assert/called-n-times? f 5)
                    (assert-messages/expected-calls f 5))))

(deftest called-with-test
  (let [f (spy/spy +)]
    (f 1 2)
    (assert-failure #(assert/called-with? f 1 2 3)
                    (assert-messages/called-with f 1 2 3))))


(deftest not-called-with-test
  (let [f (spy/spy +)]
    (f 1 2)
    (assert-failure #(assert/not-called-with? f 1 2)
                    (assert-messages/not-called-with f 1 2))))

(deftest called-once-with-test
  (let [f (spy/spy str)]
    (f "hello world!")
    (is (assert/called-once-with? f "hello world!"))

    (f "foo bar")
    (assert-failure #(assert/called-once-with? f "foo bar")
                    (assert-messages/called-once-with f "foo bar"))))

(deftest called-at-least-n-times-test
  (let [f (spy/stub 42)]
    (assert-failure #(assert/called-at-least-n-times? f 1)
                    (assert-messages/called-at-least-n-times f 1))
    (f)
    (is (assert/called-at-least-n-times? f 1))
    (assert-failure #(assert/called-at-least-n-times? f 33)
                    (assert-messages/called-at-least-n-times f 33))

    (doall (repeatedly 42 f))

    (is (assert/called-at-least-n-times? f 42))))

(deftest called-test
  (let [f (spy/stub 42)]
    (assert-failure #(assert/called? f)
                    (assert-messages/called-at-least-n-times f 1))
    (f)
    (is (assert/called? f))))

(deftest called-at-least-once-test
  (let [f (spy/stub 42)]
    (assert-failure #(assert/called-at-least-once? f)
                    (assert-messages/called-at-least-n-times f 1))
    (f)
    (is (assert/called-at-least-once? f))))

(deftest called-no-more-than-n-times-test
  (let [f (spy/spy)]
    (is (assert/called-no-more-than-n-times? f 3))
    (f)
    (f)
    (f)
    (assert-failure #(assert/called-no-more-than-n-times? f 2)
                    (assert-messages/called-no-more-than-n-times f 2))))

(deftest called-no-more-than-once-test
  (let [f (spy/spy)]
    (is (assert/called-no-more-than-once? f))
    (f)
    (is (assert/called-no-more-than-once? f))
    (f)
    (assert-failure #(assert/called-no-more-than-once? f)
                    (assert-messages/called-no-more-than-n-times f 1))))
