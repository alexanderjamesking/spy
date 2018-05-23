(defproject tortue/spy "1.2.0-SNAPSHOT"
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
  :profiles {:dev {:dependencies [[org.clojure/test.check "0.9.0"]
                                  [org.clojure/tools.namespace "0.2.11"]]}}
  :deploy-repositories [["releases" :clojars]]
  :clean-targets ["target" "out"]
  :cljsbuild {:builds [{:id "test-phantom"
                        :source-paths ["src" "test"]
                        :compiler {:output-to "target/test-phantom/test.js"
                                   :output-dir "target/test-phantom/out"
                                   :main 'spy.runner
                                   :optimizations :none
                                   :process-shim false}}
                       {:id "test-nashorn"
                        :source-paths ["src" "test"]
                        :compiler {:output-to "target/test-nashorn/test.js"
                                   :output-dir "target/test-nashorn/out"
                                   :main 'spy.runner
                                   :optimizations :simple
                                   :process-shim false}}
                       {:id "test-node"
                        :source-paths ["src" "test"]
                        :compiler {:target :nodejs
                                   :output-to "target/test-node/test.js"
                                   :output-dir "target/test-node/out"
                                   :main 'spy.runner
                                   :optimizations :none
                                   :process-shim false}}]}
  :aliases {"test-phantom" ["doo" "phantom" "test-phantom" "once"]
            "test-nashorn" ["doo" "nashorn" "test-nashorn" "once"]
            "test-node"    ["doo" "node" "test-node" "once"]
            "test-cljs"    ["do" ["test-phantom"] ["test-nashorn"] ["test-node"]]
            "test-all"     ["do" ["clean"] ["test"] ["test-cljs"]]})
