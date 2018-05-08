(ns spy.alpha
  (:require [spy.core :as spy]))

(defn pmethods
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

(defmacro defspy
  "Generates a record that implements the protocol"
  [record-name protocol]
  (let [protocol-sigs (:sigs @(resolve protocol))
        signatures (pmethods protocol-sigs)
        fields (->> protocol-sigs keys (map (comp symbol name)))]
    `(defrecord ~record-name [~@fields]
       ~protocol
       ~@(map (fn [{:keys [name args]}]
                `(~name ~args
                  ((~(keyword name) ~(first args)) ~@args)))
              signatures))))

(defmacro protocol-spy
  "Generates a record implementing the protocol and creates a new instance
  of the record with the spies provided."
  [protocol & [spies]]
  (let [signatures (:sigs @(resolve protocol))
        rname (gensym protocol)]
    `(do
       (defspy ~rname ~protocol)
       (~(symbol (str 'map-> rname))
        ~(into {} (map (fn [[k v]]
                         {k (get spies k '(spy/spy))})
                       signatures))))))
