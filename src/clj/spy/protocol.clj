(ns spy.protocol
  (:require [spy.core :as spy]))

(defn- protocol-methods
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

(defn- ->args [arglist]
  (vec (map (fn [_] (gensym)) arglist)))

(defn- ->spy-fns [methods instance]
  (reduce (fn [acc method]
            (assoc acc (keyword (:name method))
                   `(spy.core/spy
                     (fn
                       ~@(map (fn [arglist]
                                (let [args (->args arglist)]
                                  (list args (concat (list (:var method) instance) (rest args)))))
                              (:arglists method))))))
          {}
          methods))

(defmacro spy
  "Reify the protocols, spies attached to the reified object via metadata.
  Can accept multiple protocols at once: (spy.protocol/spy Proto1...ProtoN impl)"
  {:style/indent [:defn [1]]}
  [& args]
  (let [protocols (butlast args)
        instance  (last args)
        proto-methods (reduce (fn [acc protocol]
                                (assoc acc protocol (vals (protocol-methods @(resolve protocol)))))
                              {}
                              protocols)
        all-methods (->> proto-methods vals (apply concat))
        spy-fns-sym (gensym "spy-fns-")]

    `(let [~spy-fns-sym ~(->spy-fns all-methods instance)]
       (with-meta
         ~@(let [protos+impls
                  (for [[protocol methods] proto-methods]
                     (concat
                       (list (symbol protocol))
                       (mapcat (fn [{:keys [name arglists]}]
                                 (map (fn [arglist]
                                        (let [args (->args arglist)]
                                          (list name args (concat (list (list (keyword name) spy-fns-sym)) args))))
                                      arglists))
                               methods)))]
             (list (concat '(reify)
                           (apply concat protos+impls))))
         ~spy-fns-sym))))

(defn spies [instance]
  (meta instance))

(defmacro mock
  "Creates an implementation via `clojure.core/reify` and
  a wrapper to spy on the implementation, forwards all calls
  to the implementation and records calls in spies. Matches the
  signature and can be used directly instead of `clojure.core/reify`"
  {:style/indent [:defn [1]]}
  [& opts+specs]
  (let [[_ specs] (#'clojure.core/parse-opts opts+specs)
        impls (#'clojure.core/parse-impls specs)
        protocols (map (comp :on deref resolve) (keys impls))
        methods (apply concat (map (comp vals
                                         protocol-methods
                                         deref
                                         resolve)
                                   (keys impls)))
        spy-fns-sym (gensym "spy-fns-")
        instance (gensym "instance-")]
    `(let [~instance (reify ~@opts+specs)
           ~spy-fns-sym ~(->spy-fns methods instance)]
       (with-meta
         (reify
           ~@protocols
           ~@(mapcat (fn [{:keys [name arglists]}]
                       (map (fn [arglist]
                              (let [args (->args arglist)]
                                (list name args (concat (list (list (keyword name) spy-fns-sym)) args))))
                            arglists))
               methods))
         ~spy-fns-sym))))
