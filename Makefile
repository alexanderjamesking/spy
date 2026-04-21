.PHONY: test test-cljs clean jar deploy

test:
	clojure -M:test -m cognitect.test-runner

test-cljs:
	npm test

clean:
	clojure -T:build clean

jar:
	clojure -T:build jar

deploy:
	clojure -T:build deploy-jar
