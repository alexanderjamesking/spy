(ns spy.core-test
  (:require [clojure.test :refer [deftest testing is]]
            [spy.core :refer [stub spy not-called? called-once? called-n?]]))

(deftest stub-call-counts
  (testing "call counts"
    (let [stubbed-fn (stub 42)]
      (is (not-called? stubbed-fn))
      (stubbed-fn)
      (is (called-once? stubbed-fn))
      (stubbed-fn)
      (stubbed-fn)
      (is (called-n? stubbed-fn 3)))))

(deftest spy-call-counts
  (testing "call counts"
    (let [my-adder (fn [x y] (+ x y))
          my-adder-spy (spy my-adder)]
      (is (not-called? my-adder-spy))
      (is (= 3 (my-adder-spy 1 2)))
      (is (called-once? my-adder-spy))))

  (testing "call counts when the spy is wrapped with partial"
    (let [my-adder-spy (spy (fn [x y] (+ x y)))
          my-partial (partial my-adder-spy 5)]
      (is (not-called? my-adder-spy))
      (is (= 8 (my-partial 3)))
      (is (called-once? my-adder-spy)))))
