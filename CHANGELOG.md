# Changelog

## [2.0.0] - 2019-05-7
- Rewrite of `spy.protocol/spy` to work as a spy, the previous implementation was not really a spy as it didn't proxy to a real implementation. You now need to provide a protocol and an implementation of the protocol to spy on.

## [1.7.0]
- Accidental release (actually `2.0.0`)

## [1.6.0] - 2019-01-27
- Added `called-n-times-with?`

## [1.5.0] - 2019-01-15
- Added `call-matching?` so users can provide their own matching `fn`.

## [1.4.0] - 2018-05-31
- Simplified the way spies are created for Protocols, now using `reify` instead of `defrecord`. This introduces a breaking change as spies are now added to the reified object as metadata so must be extracted before assertions can happen on them, see the README or tests for an example.

## [1.2.0] - 2018-05-24
- Assert ns with macros for Clojure and fns for ClojureScript
- Project restructured but API remains the same

## [1.1.0] - 2018-05-13
- Support for spying on Protocols (Clojure only - no ClojureScript support yet).

## [1.0.0] - 2018-04-29
- spy.core functions providing basic stubbing / spying functionality and checker functions returning booleans.
