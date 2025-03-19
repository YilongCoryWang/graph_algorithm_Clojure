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
(-main)
```

## Dependencies

- [Clojure](https://clojure.org/)
- [data.priority-map](https://github.com/clojure/data.priority-map) (for priority queue management in Dijkstra's algorithm)

## License

MIT License
