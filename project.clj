(defproject tortue/spy "2.3.0-SNAPSHOT"
  :description "Spy - a Clojure and ClojureScript library for stubs, spies and mocks"
  :url "https://github.com/alexanderjamesking/spy"
  :license {:name "MIT License"
            :url "https://opensource.org/licenses/MIT"
            :year 2018
            :key "mit"}
  :plugins [[lein-codox "0.10.3"]
            [lein-cloverage "1.0.10"]]
  :dependencies [[org.clojure/clojure "1.10.1"]]
  :source-paths ["src/clj" "src/cljc"]
  :test-paths ["test/clj" "test/cljc"]
  :deploy-repositories [["releases" :clojars]])
