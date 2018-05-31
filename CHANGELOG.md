# Changelog

## [1.4.0] - 2018-05-31
- Simplified the way spies are created for Protocols, now using `reify` instead of `defrecord`. This introduces a breaking change as spies are now added to the reified object as metadata so must be extracted before assertions can happen on them, see the README or tests for an example.

## [1.2.0] - 2018-05-24
- Assert ns with macros for Clojure and fns for ClojureScript
- Project restructured but API remains the same

## [1.1.0] - 2018-05-13
- Support for spying on Protocols (Clojure only - no ClojureScript support yet).

## [1.0.0] - 2018-04-29
- spy.core functions providing basic stubbing / spying functionality and checker functions returning booleans.
