(ns spy.core-test
  (:require [clojure.test :refer [deftest testing is]]
            [spy.core :as s]))

(deftest stub-call-counts
  (testing "call counts"
    (let [f (s/stub 42)]
      (is (s/not-called? f))
      (f)
      (is (s/called? f))
      (is (s/called-once? f))
      (f)
      (is (s/called? f))
      (is (s/called-twice? f))
      (f)
      (is (s/called-thrice? f))
      (is (s/called-n? 3 f)))))

(deftest called-at-least
  (testing "called at least once"
    (let [f (s/stub 42)]
      (is (false? (s/called-at-least? 1 f)))
      (f)
      (is (s/called-at-least? 1 f))
      (is (s/called-at-least-once? f))

      (f)
      (is (s/called-at-least-twice? f))

      (f)
      (is (s/called-at-least-thrice? f))

      (doall (repeatedly 42 f))

      (is  (s/called-at-least? 42 f)))))

(deftest reset-spy
  (testing "resetting the call count for a spy"
    (let [f (s/stub 1863)]
      (doall (repeatedly 3 f))
      (is (s/called-thrice? f))
      (s/reset-calls! f)
      (is (s/not-called? f)))))

(deftest spy-call-counts
  (testing "call counts"
    (let [f (s/spy (fn [x y] (+ x y)))]
      (is (s/not-called? f))
      (is (= 3 (f 1 2)))
      (is (s/called-once? f))))

  (testing "call counts when the spy is wrapped with partial"
    (let [spy (s/spy (fn [x y] (+ x y)))
          pf (partial spy 5)]
      (is (s/not-called? spy))
      (is (= 8 (pf 3)))
      (is (s/called-once? spy)))))

(deftest called-with-test
  (testing "called with"
    (let [f (s/spy +)]
      (f 1 2)
      (is (s/called-with? f 1 2))
      (f 1 2 3)
      (is (s/called-with? f 1 2 3))
      (is (s/not-called-with? f 7 8)))))

(deftest called-with-exactly
  (let [f (s/spy str)]
    (testing "called with exactly"
      (f "hello world!")
      (is (s/called-with-exactly? f "hello world!")))

    (testing "returns false if there were other calls"
      (f "foo bar")
      (is (false? (s/called-with-exactly? f "foo bar")))
      (is (false? (s/called-with-exactly? f "hello" "world" "!"))))))
