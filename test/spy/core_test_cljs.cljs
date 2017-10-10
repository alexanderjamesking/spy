(ns spy.core-test-cljs
  (:require [clojure.test :refer [deftest is testing]]
            [spy.core :as s]))

(deftest spy-throws-exception
  (testing "the spy catches and rethrows exceptions"
    (let [f (s/stub-throws (js/Error "Goodbye World!"))]
      (is (thrown? js/Object (f)))
      (is (= 1 (count (s/responses f))))
      (is (contains? (s/first-response f) :thrown)))))
