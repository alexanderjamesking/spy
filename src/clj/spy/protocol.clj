(ns spy.protocol)

(defn protocol-methods
  "Generate a list of method that need to be implemented for
  the protocol signatures"
  [signatures]
  (loop [signatures signatures
         processing nil
         mthds []]
    (if processing
      (if (empty? (:arglists processing))
        (recur signatures nil mthds)
        (recur signatures
               (update processing :arglists rest)
               (conj mthds {:name (:name processing)
                            :args (-> processing :arglists first)})))
      (if (empty? signatures)
        mthds
        (let [[_ to-process] (first signatures)]
          (recur (rest signatures) to-process mthds))))))

(defmacro spy
  "Reify the protocol, spies attached to the reified object via metadata"
  [protocol & [spies]]
  (let [signatures (protocol-methods (:sigs @(resolve protocol)))
        spy-fns (->> signatures
                     (map (fn [signature]
                                (let [n (keyword (:name signature))]
                                  {n (get spies n '(spy.core/spy))})))
                     (into {}))
        spy-fns-sym (gensym "spy-fns-")]
    `(let [~spy-fns-sym ~spy-fns]
       (with-meta
         (reify ~protocol
           ~@(map (fn [{:keys [name args]}]
                    `(~name ~args
                      ((~(keyword name) ~spy-fns-sym) ~@args)))
               signatures))
         ~spy-fns-sym))))

(defn spies [instance]
  (meta instance))
