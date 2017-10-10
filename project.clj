(defproject clj-spy "0.8.0"
  :description "Spy - a Clojure and ClojureScript library for stubs, spies and mocks"
  :url "http://www.alexanderjamesking.com"
  :license {:name "MIT License"
            :url "https://opensource.org/licenses/MIT"
            :year 2017
            :key "mit"}
  :plugins [[lein-cljsbuild "1.1.7"]
            [lein-doo "0.1.8"]]
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.9.946"]]
  :deploy-repositories [["releases" :clojars]]
  :clean-targets ["target" "out"]
  :cljsbuild {:builds [{:id "test"
                        :source-paths ["src" "test"]
                        :compiler {:output-to "target/test.js"
                                   :main 'spy.runner
                                   :optimizations :whitespace}}]}
  :aliases {"test" ["do" ["clean"] ["test"] ["doo" "nashorn" "test" "once"]]})
