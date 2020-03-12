(defproject district0x/district-ui-router "1.0.6"
  :description "district UI module for URI routing"
  :url "https://github.com/district0x/district-ui-router"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :dependencies [[org.clojure/clojure "1.10.1"]
                 [org.clojure/clojurescript "1.10.597"]
                 [mount "0.1.16"]
                 [re-frame "0.12.0"]

                 [funcool/bide "1.6.0"]
                 [day8.re-frame/async-flow-fx "0.1.0"]
                 
                 [district0x/re-frame-window-fx "1.0.2"]]

  :doo {:paths {:karma "./node_modules/karma/bin/karma"}
        :build "tests"
        :alias {:default [:chrome]}}

  :npm {:devDependencies [[karma "1.7.1"]
                          [karma-chrome-launcher "2.2.0"]
                          [karma-cli "1.0.1"]
                          [karma-cljs-test "0.1.0"]]}

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
                                   :optimizations :none}}]})
