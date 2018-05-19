(ns spy.assert-test
  (:require [spy.assert :as assert]
            [spy.core :as spy]
            #?(:cljs
               [cljs.test :as test :refer [report] :refer-macros [deftest testing is]])
            #?(:clj
               [clojure.test :refer [deftest testing is report]])))

(deftest not-called-test
  (testing "assert reports the expected and actual call counts"
    (let [f (spy/spy)]
      (f)

      (let [reporter (spy/spy)]
        (binding [report reporter]
          (assert/not-called? f))

        (let [report (first (spy/first-call reporter))]
          (is (= :fail (:type report)))
          (is (= "Expected 0 calls, received 1 call." (:message report))))))))

(deftest called-once-test
  (testing "assert reports the expected and actual call counts"
    (let [f (spy/spy)]
      (f)
      (f)

      (let [reporter (spy/spy)]
        (binding [report reporter]
          (assert/called-once? f))

        (let [report (first (spy/first-call reporter))]
          (is (= :fail (:type report)))
          (is (= "Expected 1 call, received 2 calls." (:message report))))))))
