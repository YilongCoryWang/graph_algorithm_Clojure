# Graph Algorithms in Clojure

This project provides an implementation of essential graph algorithms in Clojure, focusing on graph generation, shortest path computation using Dijkstra's algorithm, and key graph metrics.

## Modules Overview

### 1. Graph Generator (`src/graph/graph_generator.clj`)

This module generates random weighted graphs, where nodes are connected by edges with assigned weights.

### 2. Dijkstra's Algorithm (`src/graph/dijkstra.clj`)

Find the shortest path between nodes in a weighted directed graph with Dijkstra's Algorithm.

### 3. Graph Metrics (`src/graph/graph_metrics.clj`)

Calculates important graph properties:

- **Eccentricity**: The longest shortest path from a node to any other reachable node.
- **Radius**: The minimum eccentricity among all nodes.
- **Diameter**: The maximum eccentricity among all nodes.

## Usage

This project can be used for graph analysis, including finding optimal paths and understanding graph properties like connectivity and centrality.

### Running the Example

Execute the main function to generate a graph and compute its shortest paths and metrics:

```clojure
lein repl
graph.core=> (-main)

or

graph.core=> (def random-graph (gg/make-graph 10 10))
#'graph.core/random-graph
graph.core=> (dj/shortest-path random-graph (first (keys random-graph)) (last (keys random-graph)))
(:node-2 :node-5)
graph.core=> (gm/eccentricity random-graph (first (keys random-graph)))
28
graph.core=> (gm/radius random-graph)
9
graph.core=> (gm/diameter random-graph)
39
graph.core=> random-graph
{:node-2 ([:node-3 10] [:node-5 5]), :node-1 ([:node-2 2]), :node-6 ([:node-7 5]), :node-9 ([:node-10 9]), :node-7 ([:node-8 5]), :node-3 ([:node-4 10]), :node-8 ([:node-9 3]), :node-4 ([:node-5 6]), :node-10 (), :node-5 ([:node-6 1])}
```

## Dependencies

- [Clojure](https://clojure.org/)
- [data.priority-map](https://github.com/clojure/data.priority-map) (for priority queue management in Dijkstra's algorithm)

## License

MIT License
