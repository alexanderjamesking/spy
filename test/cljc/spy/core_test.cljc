(ns spy.core-test
  (:require #?(:cljs [cljs.test :as t :refer-macros [deftest testing is]])
            #?(:clj  [clojure.test :as t :refer [deftest testing is]])
            [spy.core :as spy]
            [clojure.set :refer [subset?]]))

(deftest spy-that-returns-nil
  (testing "calling spy with no arguments gives a spy that returns nil"
    (let [f (spy/spy)]
      (is (nil? (f)))
      (is (spy/called? f))))
  (testing "calling stub with no arguments gives a spy that returns nil"
    (let [f (spy/stub)]
      (is (nil? (f)))
      (is (spy/called? f)))))

(deftest stub-call-counts
  (testing "call counts"
    (let [f (spy/stub 42)]
      (is (spy/not-called? f))
      (f)
      (is (spy/called? f))
      (is (spy/called-once? f))
      (f)
      (f)
      (is (spy/called-n-times? f 3)))))

(deftest called-at-least
  (testing "called at least once"
    (let [f (spy/stub 42)]
      (is (false? (spy/called-at-least-n-times? f 1)))
      (f)
      (is (spy/called-at-least-n-times? f 1))
      (is (spy/called-at-least-once? f))

      (doall (repeatedly 42 f))

      (is (spy/called-at-least-n-times? f 42)))))

(deftest called-at-most
  (testing "called at most once"
    (let [f (spy/stub 42)]
      (is (spy/called-no-more-than-n-times? f 1))
      (is (spy/called-no-more-than-once? f))
      (f)
      (f)

      (is (false? (spy/called-no-more-than-n-times? f 1)))
      (f)

      (is (false? (spy/called-no-more-than-once? f)))

      (doall (repeatedly 42 f))

      (is  (spy/called-no-more-than-n-times? f 50)))))

(deftest reset-spy
  (testing "resetting the call count for a spy"
    (let [f (spy/stub 1863)]
      (doall (repeatedly 3 f))
      (is (spy/called-n-times? f 3))
      (spy/reset-spy! f)
      (is (spy/not-called? f))
      (is (nil? (spy/first-response f))))))

(deftest spy-call-counts
  (testing "call counts"
    (let [f (spy/spy (fn [x y] (+ x y)))]
      (is (spy/not-called? f))
      (is (= 3 (f 1 2)))
      (is (spy/called-once? f))))

  (testing "call counts when the spy is wrapped with partial"
    (let [spy (spy/spy (fn [x y] (+ x y)))
          pf (partial spy 5)]
      (is (spy/not-called? spy))
      (is (= 8 (pf 3)))
      (is (spy/called-once? spy)))))

(deftest call-matching-test
  (testing "call matching"
    (let [f (spy/spy (fn [x y] (+ x y)))]
      (is (false? (spy/call-matching? f (fn [call-args]
                                          (= 42 (first call-args))))))
      (f 42 88)
      (is (true? (spy/call-matching? f (fn [call-args]
                                         (= 42 (first call-args))))))


      (is (true? (spy/call-matching? f (fn [args]
                                         (subset? (set [42])
                                                  (set args))))))

      (let [f2 (spy/spy)]
        (f2 {:command "hello"
             :some-val 42})
        (is (true? (spy/call-matching? f2 (fn [args]
                                            (subset? (set {:command "hello"})
                                                     (set (first args)))))))
        (is (true? (spy/call-matching? f2 (fn [args]
                                            (subset? (set {:some-val 42})
                                                     (set (first args)))))))))))

(deftest called-with-test
  (testing "called with"
    (let [f (spy/spy +)]
      (f 1 2)
      (is (spy/called-with? f 1 2))
      (f 1 2 3)
      (is (spy/called-with? f 1 2 3))
      (is (false? (spy/called-with? f 4 5 6)))
      (is (spy/not-called-with? f 7 8)))))

(deftest called-n-times-with-test
  (testing "called n times with predicate"
    (let [f (spy/spy +)]
      (is (= 2 (f 1 1)))
      (is (spy/called-n-times-with? f 1 #(= 1 (first %))))
      (is (= 3 (f 1 2)))
      (is (spy/called-n-times-with? f 2 #(= 1 (first %))))
      (is (false? (spy/called-n-times-with? f 5 #(= 1 (first %))))))))

(deftest called-once-with-test
  (let [f (spy/spy str)]
    (testing "called with exactly"
      (f "hello world!")
      (is (spy/called-once-with? f "hello world!")))

    (testing "returns false if there were other calls"
      (f "foo bar")
      (is (false? (spy/called-once-with? f "foo bar")))
      (is (false? (spy/called-once-with? f "hello" "world" "!"))))))

(deftest nth-call
  (testing "nth call"
    (let [f (spy/spy keyword)]
      (f "bingo")
      (is (= ["bingo"] (spy/nth-call f 0)))
      (is (= ["bingo"] (spy/first-call f)))

      (f "foo")
      (f "bar")

      (is (= ["bar"] (spy/last-call f)))

      (is (nil? (spy/nth-call f 42)))))

  (testing "error cases"
    (testing "returns nil when there are no calls"
      (is (nil? (spy/nth-call (spy/spy str) 5))))
    (testing "returns nil when the function passed is not a spy"
      (is (nil? (spy/nth-call str 5))))))

(deftest function-with-no-args
  (let [f (spy/spy (fn [] "I have no arguments"))]
    (f)
    (is (spy/called-once? f))))

(deftest response-values
  (testing "first response"
    (let [f (spy/stub 42)]
      (f)
      (is (= 42 (spy/first-response f)))))

  (testing "nth response"
    (let [f (spy/spy (fn [x] (+ x 42)))]
      (f 1)
      (f 2)
      (f 3)
      (f 4)
      (is (= 43 (spy/first-response f)))
      (is (= 43 (spy/nth-response f 0)))
      (is (= 44 (spy/nth-response f 1)))
      (is (= 45 (spy/nth-response f 2)))
      (is (= 46 (spy/nth-response f 3)))
      (is (= 46 (spy/last-response f)))
      (is (nil? (spy/nth-response f 99))))))

(deftest mock-test
  (testing "a mock is just a spy of a function with some behaviour"
    (let [f (spy/mock (fn [x] (if (= 1 x)
                                :one
                                :something-else)))]
      (is (= :one (f 1)))
      (is (spy/called-once? f))
      (is (= :something-else (f 42))))))

(deftest spy-throws-exception
  (testing "the spy catches and rethrows exceptions"
    (let [ex (ex-info "Goodbye World!" {:goodbye "world"})
          f  (spy/stub-throws ex)]
      (is (thrown? #?(:cljs ExceptionInfo
                      :clj  clojure.lang.ExceptionInfo) (f "foo" "bar")))
      (is (= 1 (count (spy/responses f))))
      (let [thrown (:thrown (spy/first-response f))]
        (is (= (ex-message ex) #?(:cljs (ex-message thrown)
                                  :clj  (:cause thrown))))))))

(defn check-expr
  [status assert-fn check-expr-fn]
  (let [reporter (spy/spy)]
    (binding [t/report reporter]
      (assert-fn))
    (let [report (first (spy/first-call reporter))]
      (is (= status (:type report)))
      (check-expr-fn report))))

(defn check-expr-simple
  [status assert-fn expected actual]
  (check-expr status assert-fn (fn [report]
                                 (is (= expected (:expected report)))
                                 (is (= actual (:actual report))))))

(defn passes-expr
  [assert-fn expected actual]
  (check-expr-simple :pass assert-fn expected actual))

(defn fails-expr
  [assert-fn expected actual]
  (check-expr-simple :fail assert-fn expected actual))

(deftest called-n-times?-expr-test
  (let [f (spy/spy)]
    (passes-expr #(is (spy/called-n-times? f 0)) 0 0)

    (fails-expr #(is (spy/called-n-times? f 5)) 5 0)))

(deftest not-called?-expr-test
  (let [f (spy/spy)]
    (passes-expr #(is (spy/not-called? f)) 0 0)

    (f)
    (fails-expr #(is (spy/not-called? f)) 0 1)))

(deftest called-once?-expr-test
  (let [f (spy/spy)]
    (fails-expr #(is (spy/called-once? f)) 1 0)

    (f)
    (passes-expr #(is (spy/called-once? f)) 1 1)))

(deftest called-with?-expr-test
  (let [f (spy/spy)]
    (fails-expr #(is (spy/called-with? f "foo" "bar")) ["foo" "bar"] [])

    (f "foo" "bar")
    (passes-expr
     #(is (spy/called-with? f "foo" "bar")) ["foo" "bar"] [["foo" "bar"]])))

(deftest not-called-with?-expr-test
  (let [f (spy/spy)]
    (passes-expr #(is (spy/not-called-with? f "foo" "bar")) ["foo" "bar"] [])

    (f "foo" "bar")
    (fails-expr #(is (spy/not-called-with? f "foo" "bar"))
                ["foo" "bar"]
                [["foo" "bar"]])))

(deftest called-once-with?-expr-test
  (let [f (spy/spy)]
    (fails-expr #(is (spy/called-once-with? f "foo" "bar")) ["foo" "bar"] [])

    (f "foo" "bar")
    (passes-expr
     #(is (spy/called-once-with? f "foo" "bar")) ["foo" "bar"] [["foo" "bar"]])

    (f "foo" "bar")
    (fails-expr #(is (spy/called-once-with? f "foo" "bar"))
                ["foo" "bar"]
                [["foo" "bar"] ["foo" "bar"]])))

(deftest called-at-least-n-times?-expr-test
  (let [f (spy/spy)]
    (fails-expr #(is (spy/called-at-least-n-times? f 2)) 2 0)

    (f)
    (fails-expr #(is (spy/called-at-least-n-times? f 2)) 2 1)

    (f)
    (passes-expr #(is (spy/called-at-least-n-times? f 2)) 2 2)))

(deftest called?-expr-test
  (let [f (spy/spy)]
    (fails-expr #(is (spy/called? f)) 1 0)

    (f)
    (passes-expr #(is (spy/called? f)) 1 1)

    (f)
    (passes-expr #(is (spy/called? f)) 1 2)))

(deftest called-at-least-once?-expr-test
  (let [f (spy/spy)]
    (fails-expr #(is (spy/called-at-least-once? f)) 1 0)

    (f)
    (passes-expr #(is (spy/called-at-least-once? f)) 1 1)

    (f)
    (passes-expr #(is (spy/called-at-least-once? f)) 1 2)))

(deftest called-no-more-than-n-times?-expr-test
  (let [f (spy/spy)]
    (passes-expr #(is (spy/called-no-more-than-n-times? f 1)) 1 0)

    (f)
    (passes-expr #(is (spy/called-no-more-than-n-times? f 1)) 1 1)

    (f)
    (fails-expr #(is (spy/called-no-more-than-n-times? f 1)) 1 2)))

(deftest called-no-more-than-once?-expr-test
  (let [f (spy/spy)]
    (passes-expr #(is (spy/called-no-more-than-once? f)) 1 0)

    (f)
    (passes-expr #(is (spy/called-no-more-than-once? f)) 1 1)

    (f)
    (fails-expr #(is (spy/called-no-more-than-once? f)) 1 2)))

(deftest call-matching?-expr-test
  (let [f (spy/spy)]
    (fails-expr #(is (spy/call-matching? f (fn [call] (= call ["foo"]))))
                '(fn [call] (= call ["foo"]))
                [])

    (f "foo")
    (passes-expr #(is (spy/call-matching? f (fn [call] (= call ["foo"]))))
                 '(fn [call] (= call ["foo"]))
                 [["foo"]])

    (f "bar")
    (fails-expr #(is (spy/call-matching? f (fn [call] (= call ["baz"]))))
                '(fn [call] (= call ["baz"]))
                [["foo"] ["bar"]])))

(deftest error-expr-test
  (let [error (ex-info "Uh-oh!" {:some "data"})]
    (check-expr :error
                #(is (spy/called-n-times? (throw error)))
                (fn [report]
                  (is (= error (:actual report)))))))
