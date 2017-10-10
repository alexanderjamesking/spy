(ns spy.runner
  (:require  [doo.runner :refer-macros [doo-tests]]
             [spy.core-test]
             [spy.core-test-cljs]))

(doo-tests 'spy.core-test
           'spy.core-test-cljs)
