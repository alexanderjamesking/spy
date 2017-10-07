(ns spy.runner
  (:require  [doo.runner :refer-macros [doo-tests]]
             [spy.core-test]))

(doo-tests 'spy.core-test)
