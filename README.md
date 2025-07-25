<img src="docs/logo.svg" width="266">

[![Clojars Project](https://img.shields.io/clojars/v/tortue/spy.svg)](https://clojars.org/tortue/spy)

# Spy

Spy - a Clojure and ClojureScript library for stubs, spies and mocks. This library is aimed at users of [clojure.test](https://clojure.github.io/clojure/clojure.test-api.html).

It records calls and responses to and from a function, allowing you to verify interactions. Terms used in this library are as follows, there are many different names for Mocks, see [Test Doubles, Fakes, Mocks and Stubs](https://blog.pragmatists.com/test-doubles-fakes-mocks-and-stubs-1a7491dfa3da) for more detail.

1. Stub - function that returns a hardcoded value
2. Spy - wrapper around a function allowing verification of interactions with the function
3. Mock  - function with a fake implementation to be used in place of the real thing

## Usage

### REPL (Clojure)

```clojure
(require '[spy.core :as spy]       ;; the core library with functions returning booleans
         '[spy.assert :as assert]  ;; assertions wrapping clojure.test/is
         '[spy.test]               ;; assert-expr definitions for clojure.test
         '[clojure.test :refer [testing is]])

(defn adder [x y] (+ x y))

(def spy-adder (spy/spy adder))

(is (= [] (spy/calls spy-adder)))
(is (= [] (spy/responses spy-adder)))

(is (true? (spy/not-called? spy-adder))) ;; spy.core/not-called? returns a boolean

(assert/not-called? spy-adder) ;; spy.assert/not-called? returns a boolean, but also wraps clojure.test/is so failures are reported

(testing "Let's see what a failure looks like..."
  (assert/called? spy-adder))

;; FAIL in () (form-init4641634702245604141.clj:37)
;; Let's see what a failure looks like...
;; Expected at least 1 call
;; Actual: 0 calls.
;; expected: (spy.core/called-at-least-n-times? spy-adder 1)
;;   actual: (not (spy.core/called-at-least-n-times? #function[clojure.lang.AFunction/1] 1))
;; false


(testing "calling the function"
  (is (= 3 (spy-adder 1 2))))

(testing "calls to the spy can be accessed via spy/calls"
  (is (= [[1 2]] (spy/calls spy-adder))))

(testing "responses from the spy can be accessed via spy/responses"
  (is (= [3] (spy/responses spy-adder))))

(testing "let's do another call"
  (is (= 42 (spy-adder 40 2))))

(testing "calls and responses are stored on the spy using metadata"
  (meta spy-adder) ;; {:calls     #atom[[(1 2)] 0x7612740d],
                   ;;  :responses #atom[[3] 0x26525904]}
  (let [{:keys [calls responses]} (meta spy-adder)]
    (is (= [[1 2] [40 2]] @calls))
    (is (= [3 42] @responses))))

(testing "but they can be access via spy/calls and spy/responses"
  (is (= [[1 2] [40 2]] (spy/calls spy-adder)))
  (is (= [3 42] (spy/responses spy-adder))))

(testing "we can check if the spy was called with some arguments"
  (is (true? (spy/called-with? spy-adder 1 2)))
  (is (false? (spy/called-with? spy-adder 1 59))))

(testing "but spy.assert gives us better error messages when our assertions don't hold true"
  (assert/called-with? spy-adder 66 99))

(testing "spy defines assert-expr for core spy verification"
  (is (spy/called? spy-adder))
  (is (spy/called-with? spy-adder 66 99)))

;; FAIL in () (form-init15061478131364358.clj:197)
;; assert gives us better error messages when our assertions don't hold true
;; Expected a call with (66 99)
;; Actual calls: [(1 2) (40 2)]
;; expected: (spy.core/called-with? spy-adder 66 99)
;;   actual: (not (spy.core/called-with? #function[clojure.lang.AFunction/1] 66 99))
;;false

```

### Spies

```spy.core/spy``` wraps a function and records calls to the function and responses returned by the function, this is done using an [atom](https://clojuredocs.org/clojure.core/atom). Calls and responses are stored on the function itself using [metadata](https://clojure.org/reference/metadata).

```clojure
(defn my-adder [x y]
  (+ x y))

(let [f (spy/spy my-adder)] ;; create a spy that wraps a simple adder function
      (is (spy/not-called? f)) ;; verify it hasn't been called yet
      (is (= 3 (f 1 2))) ;; call the function
      (is (spy/called-with? f 1 2)) ;; verify it was called with the arguments
      (is (spy/called-once? f))) ;; verify it was called only once
```

### Stubs

A stub is a spy that wraps [constantly](https://clojuredocs.org/clojure.core/constantly), providing us with a function that returns a value and giving us the ability to verify calls were made to the stub.

```clojure
(let [f (spy/stub 42)] ;; create a stub that returns a hardcoded value
      (is (spy/not-called? f)) ;; verify the stub has not been called yet
      (f) ;; call the stub
      (is (spy/called? f))
      (is (spy/called-once? f))
      (f) ;; call it for a second time
      (f) ;; call if for a third time
      (is (spy/called-n-times? f 3))) ;; verify it was called 3 times
```

### Mocks  (also known as Fakes / Test Doubles)

To implement a mock you just need to implement a function that has the same contract as the one you're replacing, the best person to do this is you! For convenience this library provides ```s/mock``` which is an alias for ```s/spy```, it's up to you to write the function that mocks the behaviour:

```clojure
(let [f (spy/mock (fn [x] (if (= 1 x)
                            :one
                            :something-else)))]
      (is (= :one (f 1)))
      (is (spy/called-once? f))
      (is (= :something-else (f 42))))
```

### Custom Call Matching

The `call-matching?` function allows you to write custom predicates to verify that your spy was called with arguments that match specific conditions.

```clojure
(let [f (spy/spy (fn [x y] (+ x y)))]
  (f 42 88)
  ;; Check if any call had 42 as the first argument
  (is (spy/call-matching? f (fn [call-args]
                              (= 42 (first call-args)))))

  ;; You can also match against maps
  (let [f2 (spy/spy)]
    (f2 {:command "hello" :value 42})
    (is (spy/call-matching? f2 (fn [args]
                                 (= "hello" (:command (first args))))))))
```

### Exceptions

If you spy on a function that throws an exception then Spy will catch your exception, record it in the responses, then re-throw the original exception, thus enabling you to test that the exception was thrown. A ```stub-throws``` helper function is provided.

#### Clojure
```clojure
(let [f (spy/stub-throws (Exception. "Goodbye World!"))]
      (is (thrown? Exception (f)))
      (is (= 1 (count (spy/responses f))))
      (is (contains? (spy/first-response f) :thrown))
      (is (= "Goodbye World!" (-> (spy/first-response f) :thrown :cause))))
```

#### ClojureScript
```clojure
(let [f (spy/stub-throws (js/Error "Goodbye World!"))]
      (is (thrown? js/Object (f)))
      (is (= 1 (count (spy/responses f))))
      (is (contains? (spy/first-response f) :thrown)))
```

### Using with-redefs to replace functions with spies

If you are testing synchronous code then you can replace functions using [with-redefs](https://clojuredocs.org/clojure.core/with-redefs), if you're testing async code then it's safer to pass the functions in using dependency injection, I don't recommend using ~with-redefs~.

```clojure
(ns spy-example.core-test
  (:require [clojure.test :refer [deftest testing is]]
            [spy.core :as spy]))

(def beatle->email
  {:john   "john.lennon@beatles.com"
   :paul   "paul.mccartney@beatles.com"
   :george "george.harrison@beatles.com"
   :ringo  "ringo.starr@beatles.com"})

(defn lookup-email [beatle-id]
  (get beatle->email beatle-id))

(defn send-message [email message]
  (println (str "Sending " message " to " email))
  nil)

(defn email-beatle [beatle-id message]
  (when-let [email (lookup-email beatle-id)]
    (send-message email message)))

(deftest email-beatle-test
  (testing "A message is sent to a Beatle"
    ;; example 1 - wrap the original fn (so it is still called)
    (with-redefs [send-message (spy/spy send-message)]
      (email-beatle :ringo "Hello Ringo!")
      (is (spy/called-once? send-message))
      (is (spy/called-with? send-message "ringo.starr@beatles.com" "Hello Ringo!"))))

  (testing "A message is not sent to a Rolling Stone"
    ;; example 2 - call spy without passing a fn (to avoid sending the email)
    (with-redefs [send-message (spy/spy)]
      (email-beatle :mick "Hello Mr Jagger!")
      (is (spy/not-called? send-message)))))
```

### Protocols

Currently, only Clojure is supported. I'm open to suggestions on how to support ClojureScript, contributions are welcome.

`spy.protocol/mock` uses the same signature as `reify` and can be used
to mock multiple protocols.

``` clojure
(require '[spy.protocol :as protocol])

(defprotocol Rockable
  (rock [this x] "rock this!"))

(defprotocol Tuneable
  (tune [this x y]))

(def my-mock
  (protocol/mock
    Rockable
    (rock [_ x]
      (str "Rock: " x "!"))

    Tuneable
    (tune [_ x y]
      (str "Tune: " x ", " y "!"))))

;; `protocol/spies` returns a map of the spy functions on the mock
(protocol/spies my-mock)
;; {:rock #function[clojure.lang.AFunction/1],
;;  :tune #function[clojure.lang.AFunction/1]}

;; use the core functions from the spy ns on the protocol spy
(spy/call-count (:rock (protocol/spies my-mock)))
;; 0

;; call the rock method
(rock my-mock "Living easy, lovin' free")

;; extract the spy from the mock and verify
(spy/called-with? (:rock (protocol/spies my-mock))
                  my-mock
                  "Living easy, lovin' free")
;; true
```

You will also find a `spy` macro within the protocol namespace, this
can also be used to spy on multiple protocols: `(spy.protocol/spy Proto1...ProtoN impl)`

## Contributing

Pull requests are welcome. Please run the test suite and check that all tests pass prior to submission.

Tests:
```
$ lein test
```

Code coverage:
```
$ lein cloverage
```

## License
```
MIT License

Copyright (c) 2025 Alexander James King

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
