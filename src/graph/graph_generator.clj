(ns graph.graph-generator
  (:require [clojure.set :as set]))

(defn extend-graph []
  {:node-1 [[:node-2 1] [:node-3 2]]
   :node-2 [[:node-4 4]]
   :node-3 [[:node-4 2]]
   :node-4 []})

(defn make-graph [n s]
  (when (and (>= s (dec n)) (<= s (* n (dec n))))
    (let [nodes (map #(keyword (str "node-" %)) (range 1 (inc n)))
          required-edges (map vector nodes (rest nodes))
          all-edges (set/difference
                      (set (for [a nodes, b nodes :when (not= a b)] [a b]))
                      (set required-edges))
          additional-edges (take (- s (count required-edges)) (shuffle all-edges))
          final-edges (concat required-edges additional-edges)
          weighted-edges (map (fn [[from to]] [from [to (inc (rand-int 10))]]) final-edges)]
      (reduce (fn [acc node]
                (assoc acc node (map second (filter #(= (first %) node) weighted-edges))))
              {} nodes))))

