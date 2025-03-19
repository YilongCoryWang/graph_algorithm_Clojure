(ns graph.dijkstra
  (:require [clojure.data.priority-map :refer [priority-map]]))

(defn dijkstra [graph start]
  (loop [distances (assoc (into {} (map (fn [[node _]] [node Double/POSITIVE_INFINITY]) graph))
                          start 0)
         queue (priority-map start 0)
         previous {}]
    (if (empty? queue)
      [distances previous]
      (let [[current-node current-dist] (peek queue)
            queue (pop queue)
            neighbors (get graph current-node [])]
        (let [[new-distances new-queue new-previous]
              (reduce (fn [[dists pq prev] [neighbor weight]]
                        (let [alt (+ current-dist weight)]
                          (if (< alt (get dists neighbor Double/POSITIVE_INFINITY))
                            [(assoc dists neighbor alt)
                             (assoc pq neighbor alt)
                             (assoc prev neighbor current-node)]
                            [dists pq prev])))
                      [distances queue previous]
                      neighbors)]
          (recur new-distances new-queue new-previous))))))
  
(defn reconstruct-path [previous target]
  (loop [node target path []]
    (if (nil? node)
      (if (empty? path) [:error "No path found"] path)
      (recur (get previous node) (conj path node)))))

(defn shortest-path [graph start target]
  (if (= start target)
    [start]
    (let [[final-distances final-previous] (dijkstra graph start)]
      (if (= (get final-distances target Double/POSITIVE_INFINITY)
             Double/POSITIVE_INFINITY)
        [:error "No path found"]
        (reverse (reconstruct-path final-previous target))))))

