(ns spy.alpha
  (:require [spy.core :as spy]))

#_(defn signature->method [spies [k v]]
  (for [args (:arglists v)]
    `(~(:name v) ~args
      (apply (get ~spies ~k) ~args))))

#_(defn protocol-methods [signatures spies]
  (mapcat (partial signature->method spies) signatures))

#_(defn method-spies [signatures]
  (reduce (fn [m [k v]]
            (assoc m k `(spy/spy)))
          {}
          signatures))

(defn pmethods [signatures]
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


;; TODO - generate default empty spies if no spy passed in
;; TODO - sugar to generate stubs/spies?
#_(defmacro protocol-spy [protocol & spies]
  (let [signatures (:sigs @(resolve protocol))
        spies (merge (method-spies signatures) (first spies))
        methods (protocol-methods signatures spies)]
    `(let [spies# ~spies]
       (with-meta
         (reify ~protocol
           ~@(mapcat (fn [[k v]]
                       (for [args (:arglists v)]
                         `(~(:name v) ~args
                           (apply (get ~spies ~k) ~args)))) signatures))
         'spies#))))

(defmacro defspy [record-name protocol]
  (let [protocol-sigs (:sigs @(resolve protocol))
        signatures (pmethods protocol-sigs)
        fields (->> protocol-sigs keys (map (comp symbol name)))]
    `(defrecord ~record-name [~@fields]
       ~protocol
       ~@(map (fn [{:keys [name args]}]
                `(~name ~args
                  ((~(keyword name) ~(first args)) ~@args))) signatures))))

#_(defn createspy [protocol record-name & [spies]]
  (let [protocol-sigs (:sigs protocol)
        spy-fns (into {} (map (fn [[k v]]
                                {k (get spies k (spy/spy))}) protocol-sigs))
        fields (->> protocol-sigs keys (map (comp symbol name)))]
    ((symbol (str "map->" (name record-name))) spy-fns)))
