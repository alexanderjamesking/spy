(ns spy.core)

(def no-calls [])

(defn spy
  ([] (spy (constantly nil)))
  ([f] (let [calls (atom no-calls)
             responses (atom [])
             record-call! (fn [args] (swap! calls conj args))
             record-response! (fn [response] (swap! responses conj response))
             record-exception! (fn [e]
                                 (swap! responses
                                        conj
                                        {:thrown #?(:clj (Throwable->map e)
                                                    :cljs e)}))]
         (with-meta (fn [& args]
                      (record-call! args)
                      (try
                        (let [response (apply f args)]
                          (record-response! response)
                          response)
                        (catch #?(:clj Exception :cljs js/Object) e
                            (record-exception! e)
                          (throw e))))
           {:calls calls
            :responses responses}))))

(defn reset-calls! [f]
  (reset! (-> f meta :calls) no-calls))

(defn stub
  ([] (spy))
  ([value] (spy (constantly value))))

(defn mock [f]
  (spy f))

(defn stub-throws [exception]
  (spy (fn [] (throw exception))))

(defn calls [f]
  (some-> f meta :calls deref))

(defn responses [f]
  (some-> f meta :responses deref))

(defn nth-response [n f]
  (nth (responses f) n nil))

(def first-response (partial nth-response 0))
(def second-response (partial nth-response 1))
(def third-response (partial nth-response 2))

(defn last-response [f]
  (last (responses f)))

(defn call-count [f]
  (count (calls f)))

(defn called-n? [n f]
  (= n (call-count f)))

(def not-called? (partial called-n? 0))
(def called-once? (partial called-n? 1))
(def called-twice? (partial called-n? 2))
(def called-thrice? (partial called-n? 3))

(defn called-with? [f & args]
  (some #(= args %) (calls f)))

(def not-called-with? (complement called-with?))

(defn called-with-exactly? [f & args]
  (= [args] (calls f)))

(defn called-at-least-n? [n f]
  (>= (call-count f) n))

(defn called-at-least? [n f]
  (called-at-least-n? n f))

(def called? (partial called-at-least? 1))
(def called-at-least-once? (partial called-at-least? 1))
(def called-at-least-twice? (partial called-at-least? 2))
(def called-at-least-thrice? (partial called-at-least? 3))

(defn called-at-most-n? [n f]
  (<= (call-count f) n))

(def called-no-more-than-once? (partial called-at-most-n? 1))
(def called-no-more-than-twice? (partial called-at-most-n? 2))
(def called-no-more-than-thrice? (partial called-at-most-n? 3))
(defn called-no-more-than-n? [n f] (called-at-most-n? n f))

(defn nth-call [n f]
  (let [f-calls (calls f)]
    (when (< n (count f-calls))
      (nth f-calls n nil))))

(def first-call (partial nth-call 0))
(def second-call (partial nth-call 1))
(def third-call (partial nth-call 2))

(defn last-call [f]
  (last (calls f)))

;; called with types / called with matching...
