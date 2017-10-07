(ns spy.core)

(def no-calls [])

(defn spy [f]
  (let [calls (atom no-calls)]
    (with-meta (fn [& args]
                 (swap! calls conj args)
                 (apply f args))
      {:calls calls})))

(defn reset-calls! [f]
  (reset! (-> f meta :calls) no-calls))

(defn stub [value]
  (spy (constantly value)))

(defn calls [f]
  (-> f meta :calls deref))

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

(defn called-at-least? [f n]
  (called-at-least-n? f n))

(def called? (partial called-at-least? 1))
(def called-at-least-once? (partial called-at-least? 1))
(def called-at-least-twice? (partial called-at-least? 2))
(def called-at-least-thrice? (partial called-at-least? 3))

;; at most

;; first-call
;; second-call
;; third-call
;; last-call
;; nth-call

;; we don't keep this state - perhaps store a timestamp for each call?
;; called-before (another spy)
;; called-after

;; called with types / called with matching...

;; threw - check if spy threw an exception
;; always threw

;; returned

;; return values
;; first return value
;; nth-return-value
;; last return value
