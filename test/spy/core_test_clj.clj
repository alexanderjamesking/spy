(ns spy.core-test-clj
  (:require [clojure.test :refer [deftest is testing]]
            [spy.core :as spy]))

(deftest spy-throws-exception
  (testing "the spy catches and rethrows exceptions"
    (let [f (spy/stub-throws (Exception. "Goodbye World!"))]
      (is (thrown? Exception (f)))
      (is (= 1 (count (spy/responses f))))
      (is (contains? (spy/first-response f) :thrown))
      (is (= "Goodbye World!" (-> (spy/first-response f) :thrown :cause))))))
