(ns spy.assert-test
  (:require [spy.core :as spy]
            [cljs.test :refer-macros [deftest testing is]])
  (:require-macros [spy.assert :refer [quick-test]]))

(deftest quick-test-that-fails
  (quick-test))

(deftest quick-test-that-fails-2
  (quick-test))

(deftest quick-test-that-fails-3
  (quick-test))

#_(defn- assert-failure [assert-fn expected-message]
  (let [reporter (spy/spy)]
    (binding [report reporter]
      (assert-fn))

    (let [report (first (spy/first-call reporter))]
      (is (= :fail (:type report)) (str "Expected assertion" (testing-contexts-str) " to fail"))
      (is (= expected-message (:message report))))))
#_
(deftest not-called-test
  (let [f (spy/spy)]
    (f)
    (assert-failure (partial assert/not-called? f)
                    "Expected 0 calls, received 1 call.")))
#_
(deftest called-once-test
  (let [f (spy/spy)]
    (f)
    (f)
    (assert-failure (partial assert/called-once? f)
                    "Expected 1 call, received 2 calls.")))
#_
(deftest called-n-times-test
  (assert-failure (partial assert/called-n-times? (spy/spy) 5)
                  "Expected 5 calls, received 0 calls."))
#_
(deftest called-with-test
  (let [f (spy/spy +)]
    (f 1 2)
    (assert-failure (partial assert/called-with? f 1 2 3)
                    "Spy was not called with (1 2 3).\n\nCalls:\n[(1 2)]")))
#_
(deftest not-called-with-test
  (let [f (spy/spy +)]
    (f 1 2)
    (assert-failure (partial assert/not-called-with? f 1 2)
                    "Spy was called with (1 2).\n\nCalls:\n[(1 2)]")))
#_
(deftest called-once-with-test
  (let [f (spy/spy str)]
    (f "hello world!")
    (is (assert/called-once-with? f "hello world!"))

    (f "foo bar")
    (assert-failure (partial assert/called-once-with? f "foo bar")
                    "Spy was called once with (\"foo bar\")")))
#_
(deftest called-at-least-n-times-test
  (let [f (spy/stub 42)]
    (assert-failure (partial assert/called-at-least-n-times? f 1)
                    "Expected at least 1 call, received 0 calls.")
    (f)
    (is (assert/called-at-least-n-times? f 1))
    (assert-failure (partial assert/called-at-least-n-times? f 33)
                    "Expected at least 33 calls, received 1 call.")

    (doall (repeatedly 42 f))

    (is (assert/called-at-least-n-times? f 42))))
