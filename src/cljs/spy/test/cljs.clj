(ns spy.test.cljs
  (:require [cljs.test :as t]
            [spy.test :refer [assert-called-n-times
                              assert-not-called
                              assert-called-once
                              assert-called-with-args]]))

(defmethod t/assert-expr 'spy/called-n-times?
  [_menv msg form]
  `(assert-called-n-times ~msg ~form t/do-report))

(defmethod t/assert-expr 'spy/not-called?
  [_menv msg form]
  `(assert-not-called ~msg ~form t/do-report))

(defmethod t/assert-expr 'spy/called-once?
  [_menv msg form]
  `(assert-called-once ~msg ~form t/do-report))

(defmethod t/assert-expr 'spy/called-with?
  [_menv msg form]
  `(assert-called-with-args ~msg ~form t/do-report))

(defmethod t/assert-expr 'spy/not-called-with?
  [_menv msg form]
  `(assert-called-with-args ~msg ~form t/do-report))

(defmethod t/assert-expr 'spy/called-once-with?
  [_menv msg form]
  `(assert-called-with-args ~msg ~form t/do-report))

(defmethod t/assert-expr 'spy/called-at-least-n-times?
  [_menv msg form]
  `(assert-called-n-times ~msg ~form t/do-report))

(defmethod t/assert-expr 'spy/called?
  [_menv msg form]
  `(assert-called-once ~msg ~form t/do-report))

(defmethod t/assert-expr 'spy/called-at-least-once?
  [_menv msg form]
  `(assert-called-once ~msg ~form t/do-report))

(defmethod t/assert-expr 'spy/called-no-more-than-n-times?
  [_menv msg form]
  `(assert-called-n-times ~msg ~form t/do-report))

(defmethod t/assert-expr 'spy/called-no-more-than-once?
  [_menv msg form]
  `(assert-called-once ~msg ~form t/do-report))
