(ns spy.assert-test
  (:require [spy.core :as spy]
            [clojure.test :refer [deftest testing is testing-contexts-str report]]
            [spy.assert :as assert]))

(defn- assert-failure [assert-fn expected-message]
  (let [reporter (spy/spy)]
    (binding [report reporter]
      (assert-fn))

    (let [report (first (spy/first-call reporter))]
      (is (= :fail (:type report)) (str "Expected assertion" (testing-contexts-str) " to fail"))
      (is (= expected-message (:message report))))))

(deftest not-called-test
  (let [f (spy/spy)]
    (f)
    (assert-failure #(assert/not-called? f)
                    "Expected 0 calls, received 1 call.")))

(deftest called-once-test
  (let [f (spy/spy)]
    (f)
    (f)
    (assert-failure #(assert/called-once? f)
                    "Expected 1 call, received 2 calls.")))

(deftest called-n-times-test
  (assert-failure #(assert/called-n-times? (spy/spy) 5)
                  "Expected 5 calls, received 0 calls."))

(deftest called-with-test
  (let [f (spy/spy +)]
    (f 1 2)
    (assert-failure #(assert/called-with? f 1 2 3)
                    "Expected a call with (1 2 3).\n\nCalls:\n[(1 2)]")))

(deftest not-called-with-test
  (let [f (spy/spy +)]
    (f 1 2)
    (assert-failure #(assert/not-called-with? f 1 2)
                    "Expected no calls with (1 2).\n\nCalls:\n[(1 2)]")))

(deftest called-once-with-test
  (let [f (spy/spy str)]
    (f "hello world!")
    (is (assert/called-once-with? f "hello world!"))

    (f "foo bar")
    (assert-failure #(assert/called-once-with? f "foo bar")
                    "Expected one call with (\"foo bar\").\n\nCalls:\n[(\"hello world!\") (\"foo bar\")]")))

(deftest called-at-least-n-times-test
  (let [f (spy/stub 42)]
    (assert-failure #(assert/called-at-least-n-times? f 1)
                    "Expected at least 1 call, received 0 calls.")
    (f)
    (is (assert/called-at-least-n-times? f 1))
    (assert-failure #(assert/called-at-least-n-times? f 33)
                    "Expected at least 33 calls, received 1 call.")

    (doall (repeatedly 42 f))

    (is (assert/called-at-least-n-times? f 42))))

(deftest called-test
  (let [f (spy/stub 42)]
    (assert-failure #(assert/called? f)
                    "Expected at least 1 call, received 0 calls.")
    (f)
    (is (assert/called? f))))

(deftest called-at-least-once-test
  (let [f (spy/stub 42)]
    (assert-failure #(assert/called-at-least-once? f)
                    "Expected at least 1 call, received 0 calls.")
    (f)
    (is (assert/called-at-least-once? f))))

(deftest called-no-more-than-n-times-test
  (let [f (spy/spy)]
    (is (assert/called-no-more-than-n-times? f 3))
    (f)
    (f)
    (f)
    (assert-failure #(assert/called-no-more-than-n-times? f 2)
                    "Expected no more than 2 calls, received 3 calls.")))

(deftest called-no-more-than-once-test
  (let [f (spy/spy)]
    (is (assert/called-no-more-than-once? f))
    (f)
    (is (assert/called-no-more-than-once? f))
    (f)
    (assert-failure #(assert/called-no-more-than-once? f)
                    "Expected no more than 1 call, received 2 calls.")))
