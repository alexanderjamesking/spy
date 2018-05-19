(ns spy.assert
  (:require [clojure.test :refer [is]]
            [spy.core :as spy]))

(defn called-once? [f]
  (is (spy/called-once? f)
      (str "Expected 1 call to spy, received " (spy/call-count f) " calls.")))
