(ns spy.assert-test
  (:require [spy.assert :as assert]
            [spy.core :as spy]
            #?(:cljs
               [cljs.test :as test :refer [report] :refer-macros [deftest testing is]])
            #?(:clj
               [clojure.test :refer [deftest testing is report]])))

(defn- assert-failure [assert-fn expected-message]
  (let [reporter (spy/spy)]
    (binding [report reporter]
      (assert-fn))

    (let [report (first (spy/first-call reporter))]
      (is (= :fail (:type report)))
      (is (= expected-message (:message report))))))

(deftest not-called-test
  (let [f (spy/spy)]
    (f)
    (assert-failure (partial assert/not-called? f)
                    "Expected 0 calls, received 1 call.")))

(deftest called-once-test
  (let [f (spy/spy)]
    (f)
    (f)
    (assert-failure (partial assert/called-once? f)
                    "Expected 1 call, received 2 calls.")))

(deftest called-n-times-test
  (assert-failure (partial assert/called-n-times? (spy/spy) 5)
                  "Expected 5 calls, received 0 calls."))

(deftest called-with-test
  (let [f (spy/spy +)]
    (f 1 2)
    (assert-failure (partial assert/called-with? f 1 2 3)
                    "Spy was not called with (1 2 3).\n\nCalls:\n[(1 2)]")))
