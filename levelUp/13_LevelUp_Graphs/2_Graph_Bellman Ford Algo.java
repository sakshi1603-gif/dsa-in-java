// LU: Graph_Bellman Ford Algo
// Success rate: 20.00%
// Given a weighted and directed graph of V vertices and E edges, find the shortest distance of all the vertices from the source vertex S. If a vertex cannot be reached from S, mark the distance as 10^8. If the graph contains a negative cycle, return an array consisting of only -1.

// Input format:
// The first line contains two integers V (number of vertices) and E (number of edges).
// The next E lines contain three integers u, v, and wt, where u is the source vertex of an edge, v is the destination vertex, and wt is the weight of the edge.
// The last line contains the source vertex S.

// Output format:
// If the graph contains a negative cycle, return -1.
// Otherwise, return an array containing the shortest distances from the source vertex S to all vertices. If a vertex cannot be reached, its distance should be 100000000.

// Constraints:
// 1 ≤ V ≤ 500
// 1 ≤ E ≤ V*(V-1)
// -1000 ≤ adj[i][j] ≤ 1000
// 0 ≤ S < V