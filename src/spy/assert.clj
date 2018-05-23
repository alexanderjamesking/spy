(ns spy.assert
  (:require [spy.core :as spy]))

(def ^:private ^:no-doc cljs? (boolean (find-ns 'cljs.analyzer)))

(defmacro quick-test []
  (if cljs?
    `(cljs.test/is (= 2 2))
    `(clojure.test/is (= 3 3))))

#_(defn- calls [n]
  (if (= 1 n)
    "call"
    "calls"))

#_(defn calls-message [f expected-count]
  (str "Expected " expected-count " " (calls expected-count) ", "
       "received " (spy/call-count f) " " (calls (spy/call-count f)) "."))

#_(defn called-n-times?
  [f n]
  (is (spy/called-n-times? f n)
      (calls-message f n)))

#_(defn not-called?
  [f]
  (is (spy/not-called? f)
      (calls-message f 0)))

#_(defn called-once?
  [f]
  (is (spy/called-once? f)
      (calls-message f 1)))
#_
(defn called-with?
  [f & args]
  (is (apply spy/called-with? f args)
      (str "Spy was not called with " args ".\n\nCalls:\n" (spy/calls f))))
#_
(defn not-called-with?
  [f & args]
  (is (apply spy/not-called-with? f args)
      (str "Spy was called with " args ".\n\nCalls:\n" (spy/calls f))))
#_
(defn called-once-with?
  [f & args]
  (is (apply spy/called-once-with? f args)
      (str "Spy was called once with " args)))
#_
(defn called-at-least-n-times?
  [f n]
  (is (spy/called-at-least-n-times? f n)
      (str "Expected at least " n " " (calls n) ", "
           "received " (spy/call-count f) " " (calls (spy/call-count f)) ".")))
#_
(defn called?
  [f])
#_
(defn called-at-least-once?
  [f])
#_
(defn called-no-more-than-n-times?
  [f n])
#_
(defn called-no-more-than-once?
  [f])
