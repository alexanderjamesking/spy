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

(defn call-count [f]
  (-> f meta :calls deref count))

(defn called-n? [f n]
  (= n (call-count f)))

(defn not-called? [f]
  (called-n? f 0))

(defn called-once? [f]
  (called-n? f 1))
