(ns spy.core)

(defn spy
  "If no function is supplied, returns a function that takes any number of args
  and returns nil.

  If a function is supplied, returns a function that wraps the function.

  Adds metadata {:calls (atom []) :responses (atom [])} to the function, calls
  and responses are recorded and stored inside the atoms.

  If an exception is thrown by the function this is caught, recorded as a response
  nested in a map under the key :thrown, and rethrown."
  ([] (spy (constantly nil)))
  ([f] (let [calls (atom [])
             responses (atom [])
             record-call! (fn [args] (swap! calls conj args))
             record-response! (fn [response] (swap! responses conj response))
             record-exception! (fn [e]
                                 (swap! responses
                                        conj
                                        {:thrown #?(:clj (Throwable->map e)
                                                    :cljs e)}))]
         (with-meta (fn [& args]
                      (record-call! args)
                      (try
                        (let [response (apply f args)]
                          (record-response! response)
                          response)
                        (catch #?(:clj Exception :cljs js/Object) e
                            (record-exception! e)
                          (throw e))))
           {:calls calls
            :responses responses}))))

(defn reset-spy!
  "Resets the calls and responses on the spy f."
  [f]
  (reset! (-> f meta :calls) [])
  (reset! (-> f meta :responses) []))

(defn stub
  "Returns a spy function that returns the value supplied, or nil
  if no value is supplied."
  ([] (spy))
  ([value] (spy (constantly value))))

(defn mock
  "An alias for spy, behaviour for the function is provided by the user."
  [f]
  (spy f))

(defn stub-throws
  "Returns a spy function that throws the exception provided."
  [exception]
  (spy (fn [] (throw exception))))

(defn calls
  "Returns a list of all calls to the spy f."
  [f]
  (some-> f meta :calls deref))

(defn responses
  "Returns a list of all responses returned by the spy f."
  [f]
  (some-> f meta :responses deref))

(defn nth-response
  "Returns the response of the spy f at the index n."
  [n f]
  (nth (responses f) n nil))

(defn first-response
  "Returns the first response returned by the spy f."
  [f]
  (nth-response 0 f))

(defn last-response
  "Returns the last response returned by the spy f."
  [f]
  (last (responses f)))

(defn call-count
  "Returns the count of the number of calls to the spy f."
  [f]
  (count (calls f)))

(defn called-n-times?
  "Returns true if the spy f was called n times, false if not."
  [n f]
  (= n (call-count f)))

(def not-called? (partial called-n-times? 0))
(def called-once? (partial called-n-times? 1))

(defn called-with? [f & args]
  (not (nil? (some #(= args %) (calls f)))))

(def not-called-with? (complement called-with?))

(defn called-once-with? [f & args]
  (= [args] (calls f)))

(defn called-at-least-n? [n f]
  (>= (call-count f) n))

(defn called-at-least? [n f]
  (called-at-least-n? n f))

(def called? (partial called-at-least? 1))
(def called-at-least-once? (partial called-at-least? 1))

(defn called-at-most-n? [n f]
  (<= (call-count f) n))

(def called-no-more-than-once? (partial called-at-most-n? 1))
(defn called-no-more-than-n? [n f] (called-at-most-n? n f))

(defn nth-call [n f]
  (let [f-calls (calls f)]
    (when (< n (count f-calls))
      (nth f-calls n nil))))

(def first-call (partial nth-call 0))

(defn last-call [f]
  (last (calls f)))
