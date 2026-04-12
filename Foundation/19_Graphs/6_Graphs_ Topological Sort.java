// Graphs_ Topological Sort
// Success rate: 29.30%
// Given an adjacency list for a Directed Acyclic Graph (DAG) where adj_list[i] contains a list of all vertices j such that there is a directed edge from vertex i to vertex j, with V vertices and E edges, your task is to find any valid topological sorting of the graph. In a topological sort, for every directed edge u -> v, u must come before v in the ordering.

// Input Format:
// V: An integer representing the number of vertices.
// E: An integer representing the number of edges.
// Next E lines, each containing two integers u and v, indicating a directed edge from vertex u to vertex v.

// Output Format:
// An array of integers representing a valid topological ordering of the vertices.

// Constraints:
// 2 ≤ V ≤ 104
// 1 ≤ E ≤ (N*(N-1))/2