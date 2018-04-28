(ns spy.core-test-cljs
  (:require [clojure.test :refer [deftest is testing]]
            [spy.core :as spy]))

(deftest spy-throws-exception
  (testing "the spy catches and rethrows exceptions"
    (let [f (spy/stub-throws (js/Error "Goodbye World!"))]
      (is (thrown? js/Object (f)))
      (is (= 1 (count (spy/responses f))))
      (is (contains? (spy/first-response f) :thrown)))))
