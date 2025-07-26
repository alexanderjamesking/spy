(defproject tortue/spy "2.16.0-SNAPSHOT"
  :description "Spy - a Clojure and ClojureScript library for stubs, spies and mocks"
  :url "https://github.com/alexanderjamesking/spy"
  :license {:name "MIT License"
            :url "https://opensource.org/licenses/MIT"
            :year 2022
            :key "mit"}
  :plugins [[lein-cloverage "1.2.4"]]
  :profiles {:provided {:dependencies [[org.clojure/clojure "1.12.1"]
                                       [org.clojure/clojurescript "1.12.42"]]}}
  :source-paths ["src/clj" "src/cljc" "src/cljs"]
  :test-paths ["test/clj" "test/cljc"]
  :deploy-repositories [["releases" :clojars]]
  :aliases {"coverage" ["cloverage" "--ns-exclude-regex" "spy.test.cljs"]})
