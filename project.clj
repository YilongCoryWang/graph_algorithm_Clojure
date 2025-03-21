(defproject graph "0.1.0-SNAPSHOT"
  :description "Data structure graph - Cory Wang"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.0"] [org.clojure/data.priority-map "1.1.0"]]
  :main ^:skip-aot graph.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
