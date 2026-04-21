# Contributing

Pull requests are welcome. Please run the test suite and check that all tests pass prior to submission.

```
make test       # Clojure tests
make test-cljs  # ClojureScript tests (requires npm install)
```

## Releasing

1. Commit and push any final changes to master
2. Tag the release: `git tag <version> && git push --tags` — CI deploys to Clojars
3. Verify the release appears on https://clojars.org/tortue/spy
