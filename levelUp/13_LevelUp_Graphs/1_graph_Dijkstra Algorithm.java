// LU: graph_Dijkstra Algorithm
// Success rate: 16.39%
// Given a weighted, undirected, and connected graph with V vertices, represented as an adjacency list adj, where adj[i] contains lists of pairs [j, w]. Here, j is a vertex connected to i, and w is the weight of the edge between i and j. Given a source vertex S, your task is to find the shortest distance from the source vertex S to all other vertices. Return a list of integers representing the shortest distance from the source to each vertex.

// If a vertex is unreachable, the distance is considered infinity (Integer.MAX_VALUE). Assume the graph contains no negative weight cycles.

// Input Format:
// V: the number of vertices.
// adj: adjacency list of the graph.
// S: source vertex.

// Output Format:
// Return an array of shortest distances from the source vertex S to each vertex.

// Constraints:
// 1 ≤ V ≤ 1000
// 0 ≤ adj[i][j] ≤ 1000
// 1 ≤ adj.size() ≤ [ (V*(V - 1)) / 2 ]
// 0 ≤ S < V