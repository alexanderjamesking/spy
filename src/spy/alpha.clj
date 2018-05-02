(ns spy.alpha)

(defn signature->method [spies [k {:keys [arglists name]}]]
  (for [args arglists]
    `(~name ~args
      (apply (get ~spies ~k) ~args))))

(defn protocol-methods [signatures spies]
  (mapcat (partial signature->method spies) signatures))

(defmacro protocol-spy [protocol spies]
  (let [signatures (:sigs @(resolve protocol))
        methods (protocol-methods signatures spies)]
    `(reify ~protocol
       ~@methods)))
