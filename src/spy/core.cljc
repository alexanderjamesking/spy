(ns spy.core)

;; TODO
;; called with
;; reset

(defn spy [f]
  (let [calls (atom [])]
    (with-meta (fn [& args]
                 (swap! calls conj args)
                 (apply f args))
      {:calls calls})))

(defn stub [value]
  (spy (constantly value)))

(defn calls [f]
  (-> f meta :calls deref))

(defn call-count [f]
  (count (calls f)))

(defn called-n? [f n]
  (= n (call-count f)))

(defn not-called? [f]
  (called-n? f 0))

(defn called-once? [f]
  (called-n? f 1))

(defn called-twice? [f]
  (called-n? f 2))

(defn called-thrice? [f]
  (called-n? f 3))

(defn called-with? [f & args]
  (some #(= args %) (calls f)))

(def not-called-with? (complement called-with?))

(defn called-with-exactly? [f & args]
  (= [args] (calls f)))

(defn called-at-least-n? [f n]
  (>= (call-count f) n))

(defn called-at-least? [f n]
  (called-at-least-n? f n))

(defn called? [f]
  (called-at-least-n? f 1))

(defn called-at-least-once? [f]
  (called-at-least-n? f 1))

(defn called-at-least-twice? [f]
  (called-at-least-n? f 2))

(defn called-at-least-thrice? [f]
  (called-at-least-n? f 3))

;; never
;; at least
;; at most
;; once
;; twice
;; thrice
;; exactly

;; first-call
;; second-call
;; third-call
;; last-call
;; nth-call

;; we don't keep this state - perhaps store a timestamp for each call?
;; called-before (another spy)
;; called-after

;; called with
;; called with exactly
;; called with types / called with matching...
;; not called with match

;; threw - check if spy threw an exception
;; always threw

;; returned

;; return values
;; first return value
;; nth-return-value
;; last return value
