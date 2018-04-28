[![Build Status](https://travis-ci.org/alexanderjamesking/clj-spy.svg?branch=master)](https://travis-ci.org/alexanderjamesking/clj-spy)
[![Clojars Project](https://img.shields.io/clojars/v/clj-spy.svg)](https://clojars.org/clj-spy)

# Spy

Spy - a Clojure and ClojureScript library for stubs, spies and mocks.

This library is aimed at users of [clojure.test](https://clojure.github.io/clojure/clojure.test-api.html).

It records calls and responses to a function, and allows you to verify interactions with the function.

Typically you want one of the following:

1. Stub - A function that returns a hardcoded value
2. Spy - A wrapper around a function so you can verify interactions with the function
3. Fake / Mock / Test Double - A function with a fake implementation that you want to use instead of the real thing

See [Test Doubles, Fakes, Mocks and Stubs](https://blog.pragmatists.com/test-doubles-fakes-mocks-and-stubs-1a7491dfa3da) for more detail.

## Usage

Include the dependency in your project: ```[clj-spy "0.9.0"]```

### REPL

```clojure
user> (require '[spy.core :as spy])
nil
user> (defn adder [x y]
        (+ x y))
#'user/adder
user> (def spy-adder (spy/spy adder))
#'user/spy-adder
user> (spy/calls spy-adder)
[]
user> (spy/responses spy-adder)
[]
user> (spy-adder 1 2)
3
user> (spy/calls spy-adder)
[(1 2)]
user> (spy/responses spy-adder)
[3]
user> (spy-adder 40 2)
42
user> (spy/calls spy-adder)
[(1 2) (40 2)]
user> (spy/responses spy-adder)
[3 42]
user>
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
      (is (spy/called-n? 3 f))) ;; verify it was called 3 times
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

## License
```
MIT License

Copyright (c) 2018 Alex King

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
