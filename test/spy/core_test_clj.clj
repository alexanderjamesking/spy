(ns spy.core-test-clj
  (:require [clojure.test :refer [deftest is testing]]
            [spy.core :as s]))

(deftest spy-throws-exception
  (testing "the spy catches and rethrows exceptions"
    (let [f (s/stub-throws (Exception. "Goodbye World!"))]
      (is (thrown? Exception (f)))
      (is (= 1 (count (s/responses f))))
      (is (contains? (s/first-response f) :thrown))
      (is (= "Goodbye World!" (-> (s/first-response f) :thrown :cause))))))
