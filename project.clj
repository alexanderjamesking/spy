(defproject tortue/spy "0.12.0"
  :description "Spy - a Clojure and ClojureScript library for stubs, spies and mocks"
  :url "https://github.com/alexanderjamesking/spy"
  :license {:name "MIT License"
            :url "https://opensource.org/licenses/MIT"
            :year 2017
            :key "mit"}
  :plugins [[lein-cljsbuild "1.1.7"]
            [lein-doo "0.1.8"]
            [lein-codox "0.10.3"]
            [lein-cloverage "1.0.10"]]
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [org.clojure/clojurescript "1.10.238"]]
  :profiles {:dev {:dependencies [[org.clojure/test.check "0.9.0"]]}}
  :deploy-repositories [["releases" :clojars]]
  :clean-targets ["target" "out"]
  :cljsbuild {:builds [{:id "test"
                        :source-paths ["src" "test"]
                        :compiler {:output-to "target/test.js"
                                   :main 'spy.runner
                                   :optimizations :whitespace}}]}
  :aliases {"test" ["do" ["clean"] ["test"] ["doo" "nashorn" "test" "once"]]})
