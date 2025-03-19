(ns graph.graph-metrics
  (:require [graph.dijkstra :as dj]))

(defn calculate-path-weight [graph path]
  (reduce (fn [acc [from to]]
            (let [weight (some (fn [[n w]]
                                 (when (= n to) w))
                               (get graph from))]
              (+ acc (or weight 0))))
          0
          (partition 2 1 path)))

(defn eccentricity [graph vertex]
  (let [targets (remove #(= % vertex) (keys graph))  ; exclude the vertex itself
        distances (map (fn [target]
                         (let [path (dj/shortest-path graph vertex target)]
                           (if (= path [:error "No path found"])
                             Double/POSITIVE_INFINITY
                             (calculate-path-weight graph path))))
                       targets)
        valid-distances (remove #(= % Double/POSITIVE_INFINITY) distances)]
    (if (empty? valid-distances)
      [:error "Disconnected vertex"]
      (apply max valid-distances))))

(defn radius [graph]
  (let [eccs (map #(eccentricity graph %) (keys graph))
        valid (remove #(= % [:error "Disconnected vertex"]) eccs)]
    (apply min valid)))

(defn diameter [graph]
  (let [eccs (map #(eccentricity graph %) (keys graph))
        valid (remove #(= % [:error "Disconnected vertex"]) eccs)]
    (apply max valid)))


