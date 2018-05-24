(ns ^{:author "Alexander James King",
      :doc "A testing framework for stubs, spies and mocks.
      Enables verification of interactions with a function."}
    spy.core)

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
  [f n]
  (nth (responses f) n nil))

(defn first-response
  "Returns the first response returned by the spy f."
  [f]
  (nth-response f 0))

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
  [f n]
  (= n (call-count f)))

(defn not-called?
  "Returns true if the spy f was never called, false if not."
  [f]
  (called-n-times? f 0))

(defn called-once?
  "Returns true if the spy f was called once, false if not."
  [f]
  (called-n-times? f 1))

(defn called-with?
  "Returns true if any of the calls to the spy f match the args, false if no calls match."
  [f & args]
  (not (nil? (some #(= args %) (calls f)))))

(defn not-called-with?
  "Returns true if the no calls to the spy f match the args, false if a call matches."
  [f & args]
  (not (apply called-with? f args)))

(defn called-once-with?
  "Returns true if there was only one call to the spy f and the args match, false if not."
  [f & args]
  (= [args] (calls f)))

(defn called-at-least-n-times?
  "Returns true if the spy f was called at least n times, false if not."
  [f n]
  (>= (call-count f) n))

(defn called?
  "Returns true is the spy f was called, false if not."
  [f]
  (called-at-least-n-times? f 1))

(defn called-at-least-once?
  "Returns true if the spy f was called at least once, false if not."
  [f]
  (called-at-least-n-times? f 1))

(defn called-no-more-than-n-times?
  "Returns true if the spy f was called no more than n times, false if not."
  [f n]
  (<= (call-count f) n))

(defn called-no-more-than-once?
  "Returns true if the spy f was called once or not at all, false if not."
  [f]
  (called-no-more-than-n-times? f 1))

(defn nth-call
  "Returns the nth call to the spy f for the index n."
  [f n]
  (let [f-calls (calls f)]
    (when (< n (count f-calls))
      (nth f-calls n nil))))

(defn first-call
  "Returns the first call to the spy f"
  [f]
  (nth-call f 0))

(defn last-call
  "Returns the last call to the spy f"
  [f]
  (last (calls f)))
