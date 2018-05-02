(ns spy.alpha)

(defn signature->method [spies [k v]]
  (for [args (:arglists v)]
    `(~(:name v) ~args
      (apply (get ~spies ~k) ~args))))

(defn protocol-methods [signatures spies]
  (mapcat (partial signature->method spies) signatures))

(defmacro protocol-spy [protocol spies]
  (let [signatures (:sigs @(resolve protocol))
        methods (protocol-methods signatures spies)]
    (with-meta
      `(reify ~protocol
         ~@methods)
      spies)))
