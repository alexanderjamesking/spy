(ns build
  (:require [clojure.tools.build.api :as b]
            [deps-deploy.deps-deploy :as deploy]))

(def lib 'tortue/spy)
(def version (or (System/getenv "RELEASE_VERSION") "dev"))
(def class-dir "target/classes")
(def src-dirs ["src/clj" "src/cljc" "src/cljs" "resources"])
(def basis (delay (b/create-basis {:project "deps.edn"})))
(def jar-file (format "target/%s-%s.jar" (name lib) version))

(defn- assert-release-version []
  (assert (re-matches #"\d+\.\d+\.\d+" version)
          (str "RELEASE_VERSION must be set to a valid version (e.g. 2.16.0), got: " version)))

(defn clean [_]
  (b/delete {:path "target"}))

(defn jar [_]
  (b/delete {:path class-dir})
  (b/write-pom {:class-dir class-dir
                :lib       lib
                :version   version
                :basis     @basis
                :description "Spy - a Clojure and ClojureScript library for stubs, spies and mocks"
                :url         "https://github.com/alexanderjamesking/spy"
                :scm         {:url "https://github.com/alexanderjamesking/spy"}
                :pom-data    [[:licenses
                               [:license
                                [:name "MIT License"]
                                [:url "https://opensource.org/licenses/MIT"]]]]})
  (b/copy-dir {:src-dirs   src-dirs
               :target-dir class-dir})
  (b/jar {:class-dir class-dir
          :jar-file  jar-file}))

(defn deploy-jar [_]
  (assert-release-version)
  (jar nil)
  (deploy/deploy {:installer :remote
                  :artifact  jar-file
                  :pom-file  (b/pom-path {:lib lib :class-dir class-dir})}))
