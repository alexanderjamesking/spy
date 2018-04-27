# clj-spy

Spy - a Clojure and ClojureScript library for stubs, spies and mocks.

[![Build Status](https://travis-ci.org/alexanderjamesking/clj-spy.svg?branch=master)](https://travis-ci.org/alexanderjamesking/clj-spy)
[![Clojars Project](https://img.shields.io/clojars/v/clj-spy.svg)](https://clojars.org/clj-spy)

This library is aimed at users of [clojure.test](https://clojure.github.io/clojure/clojure.test-api.html). 
It records calls and responses to a function, and allows you to verify interactions with the function.

Typically you want one of the following:

1. Stub - A function that returns a hardcoded value
2. Spy - A wrapper around a function so you can verify interactions with the function
3. Fake / Mock / Test Double - A function with a fake implementation that you want to use instead of the real thing

See [Test Doubles, Fakes, Mocks and Stubs](https://blog.pragmatists.com/test-doubles-fakes-mocks-and-stubs-1a7491dfa3da) for more detail.

This library focuses on the Spy part hence the name, but it can be used for all 3 of the above.

To implement a Stub in Clojure you can use [constantly](https://clojuredocs.org/clojure.core/constantly), you don't need a library for that!

To implement a Spy you need a way to record calls to the function, this library does this using an [atom](https://clojuredocs.org/clojure.core/atom) and attaching the calls to the function, and responses from the function to the function itself using [metadata](https://clojure.org/reference/metadata).

To implement a Fake you just need to implement a function that has the same contract as the one you're replacing, the best person to do this is you, so this library doesn't deal with fakes.


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
