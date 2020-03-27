(defproject district0x/district-ui-router "1.0.7-SNAPSHOT"
  :description "district UI module for URI routing"
  :url "https://github.com/district0x/district-ui-router"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :dependencies [[org.clojure/clojure "1.10.1"]
                 [org.clojure/clojurescript "1.10.597"]
                 [mount "0.1.16"]
                 [re-frame "0.12.0"]

                 [funcool/cuerdas "2.2.0"]
                 [district0x/bide "1.6.1"]
                 [day8.re-frame/async-flow-fx "0.1.0"]
                 
                 [district0x/re-frame-window-fx "1.0.2"]]

  :doo {:paths {:karma "./node_modules/karma/bin/karma"}
        :build "tests"
        :alias {:default [:chrome-headless]}}

  :clean-targets ^{:protect false} ["target" "tests-output"]

  :npm {:devDependencies [[karma "^4.4.1"]
                          [karma-chrome-launcher "^3.1.0"]
                          [karma-cli "^2.0.0"]
                          [karma-cljs-test "^0.1.0"]]}

  :profiles {:dev {:dependencies [[com.cemerick/piggieback "0.2.2"]
                                  [day8.re-frame/test "0.1.5"]
                                  [org.clojure/clojure "1.8.0"]
                                  [org.clojure/tools.nrepl "0.2.13"]
                                  [doo "0.1.11"]]
                   :plugins [[lein-cljsbuild "1.1.7"]
                             [lein-doo "0.1.10"]
                             [lein-npm "0.6.2"]
                             [lein-ancient "0.6.15"]]}}

  :cljsbuild {:builds [{:id "tests"
                        :source-paths ["src" "test"]
                        :compiler {:output-to "tests-output/tests.js"
                                   :output-dir "tests-output"
                                   :main "tests.runner"
                                   :optimizations :none}}]}

  :deploy-repositories [["snapshots" {:url "https://clojars.org/repo"
                                      :username :env/clojars_username
                                      :password :env/clojars_password
                                      :sign-releases false}]
                        ["releases"  {:url "https://clojars.org/repo"
                                      :username :env/clojars_username
                                      :password :env/clojars_password
                                      :sign-releases false}]]
  :release-tasks [["vcs" "assert-committed"]
                  ["change" "version" "leiningen.release/bump-version" "release"]
                  ["deploy"]])
