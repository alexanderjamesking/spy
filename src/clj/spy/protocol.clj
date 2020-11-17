(ns spy.protocol
  (:require [spy.core :as spy]))

(defn protocol-methods
  "Generate a list of methods that need to be implemented for
  the protocol signatures"
  [protocol]
  (let [method-builders (:method-builders protocol)]
    (loop [signatures (:sigs protocol)
           processing nil
           mthds {}]
      (if processing
        (if (empty? (:arglists processing))
          (recur signatures nil mthds)
          (let [k (keyword (:name processing))
                v {:name (:name processing)
                   :arglists (:arglists processing)
                   :var (->> method-builders
                             keys
                             (filter (fn [x]
                                       (= (:name (meta x))
                                          (:name processing))))
                             first)}]
            (recur signatures
                   nil
                   (assoc mthds k v))))
        (if (empty? signatures)
          mthds
          (let [[_ to-process] (first signatures)]
            (recur (rest signatures) to-process mthds)))))))

(defn ->spy-fns [methods instance]
  (reduce (fn [acc method]
            (assoc acc (keyword (:name method))
                   `(spy.core/spy
                     (fn
                       ~@(map (fn [arglist]
                                (list arglist
                                      (concat (list (:var method)
                                                    instance)
                                              (rest arglist))))
                              (:arglists method))))))
          {}
          methods))

(defmacro spy
  "Reify the protocol, spies attached to the reified object via metadata"
  [protocol instance]
  (let [methods (vals (protocol-methods @(resolve protocol)))
        spy-fns-sym (gensym "spy-fns-")]
    `(let [~spy-fns-sym ~(->spy-fns methods instance)]
       (with-meta
         (reify ~protocol
           ~@(mapcat (fn [{:keys [name arglists]}]
                       (map (fn [arglist]
                              (list name
                                    arglist
                                    (concat (list (list (keyword name)
                                                        spy-fns-sym))
                                            arglist)))
                            arglists))
               methods))
         ~spy-fns-sym))))

(defn spies [instance]
  (meta instance))
