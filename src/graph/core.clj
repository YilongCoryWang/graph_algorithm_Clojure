(ns graph.core
  (:require [graph.graph-generator :as gg]
            [graph.dijkstra :as dj]
            [graph.graph-metrics :as gm]
            )
  (:gen-class))

(defn -main
  "Run example graph operations"
  [& args]
  (let [random-graph (gg/make-graph 10 10)]
    (println "Random Graph:" random-graph)
    (println "Shortest Path:" (dj/shortest-path random-graph
                                               (first (keys random-graph))
                                               (last (keys random-graph))))
    (println "Eccentricity:" (gm/eccentricity random-graph (first (keys random-graph))))
    (println "Radius:" (gm/radius random-graph))
    (println "Diameter:" (gm/diameter random-graph))
    ))