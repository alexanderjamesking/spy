(ns spy.core-test
  (:require [clojure.test :refer [deftest is testing]]
            [spy.core :as s]))

(deftest spy-that-returns-nil
  (testing "calling spy with no arguments gives a spy that returns nil"
    (let [f (s/spy)]
      (is (nil? (f)))
      (is (s/called? f))))
  (testing "calling stub with no arguments gives a spy that returns nil"
    (let [f (s/stub)]
      (is (nil? (f)))
      (is (s/called? f)))))

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

(deftest called-at-most
  (testing "called at most once"
    (let [f (s/stub 42)]
      (is (s/called-at-most-n? 1 f))
      (is (s/called-no-more-than-once? f))
      (f)
      (f)
      (is (s/called-no-more-than-twice? f))

      (is (false? (s/called-at-most-n? 1 f)))
      (f)

      (is (false? (s/called-no-more-than-once? f)))
      (is (false? (s/called-no-more-than-twice? f)))
      (is (s/called-no-more-than-thrice? f))

      (doall (repeatedly 42 f))

      (is  (s/called-at-most-n? 50 f)))))

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

(deftest nth-call
  (testing "nth call"
    (let [f (s/spy keyword)]
      (f "bingo")
      (is (= ["bingo"] (s/nth-call 0 f)))
      (is (= ["bingo"] (s/first-call f)))

      (f "foo")
      (f "bar")

      (is (= ["foo"] (s/second-call f)))
      (is (= ["bar"] (s/third-call f)))
      (is (= ["bar"] (s/last-call f)))))

  (testing "error cases"
    (testing "returns nil when there are no calls"
      (is (nil? (s/nth-call 5 (s/spy str)))))
    (testing "returns nil when the function passed is not a spy"
      (is (nil? (s/nth-call 5 str))))))

(deftest function-with-no-args
  (let [f (s/spy (fn [] "I have no arguments"))]
    (f)
    (is (s/called-once? f))))

(deftest spy-throws-exception
  (testing "the spy catches and rethrows exceptions"
    (let [f (s/stub-throws (#?(:clj Exception. :cljs js/Error) "Goodbye World!"))]
      (is (thrown? #?(:clj Exception :cljs js/Object) (f)))
      (is (= 1 (count (s/responses f))))
      (is (contains? (first (s/responses f)) :thrown))
      #_(println (-> (meta f) :responses deref first))

      #_(is (= "Goodbye World!" (-> (meta f) :responses deref first :cause))))))
