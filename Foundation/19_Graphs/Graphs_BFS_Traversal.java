// Graphs_ BFS Traversal
// Success rate: 31.57%
// Given a directed graph, perform a Breadth First Traversal (BFS) starting from vertex 0. You can move from node u to node v only if there is a directed edge from u to v. The BFS traversal should start from the 0th vertex and proceed left to right according to the input graph. Only consider nodes that are directly or indirectly connected to node 0.

// t Format:
// The first line contains an integer V representing the number of vertices in the graph.
// The second line contains an integer E representing the number of edges in the graph.
// The next E lines each contain two integers u and v, denoting an edge from vertex u to vertex v.

// Output Format:
// A single line of space-separated integers representing the BFS traversal starting from vertex 0.

// Constraints:
// 1 ≤ V, E ≤ 104

import java.util.*;

public class Graphs_BFS_Traversal {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt(); // number of nodes (vertices)
        int m = scn.nextInt(); // number of edges

        int[][] arr = new int[m][2]; // storing edges

        // input edges
        for (int i = 0; i < m; i++) {
            arr[i][0] = scn.nextInt(); // u
            arr[i][1] = scn.nextInt(); // v
        }

        // construct graph using adjacency list
        List<List<Integer>> graph = Construction(n, m, arr);

        // perform BFS traversal
        BFS(graph, n);
    }

    public static List<List<Integer>> Construction(int n, int m, int[][] arr) {
        List<List<Integer>> graph = new ArrayList<>();

        // step 1: initialize adjacency list for n nodes
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // step 2: add edges (undirected graph)
        for (int i = 0; i < m; i++) {
            int u = arr[i][0];
            int v = arr[i][1];

            graph.get(u).add(v); // u → v
            graph.get(v).add(u); // v → u
        }

        return graph;
    }

    public static void BFS(List<List<Integer>> graph, int n) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n]; // track visited nodes

        // start BFS from node 0
        q.add(0);
        visited[0] = true;

        // process until queue becomes empty
        while (!q.isEmpty()) {
            int rem = q.remove(); // remove front element
            System.out.print(rem + " "); // process node

            // visit all neighbors of current node
            List<Integer> nbrs = graph.get(rem);

            for (int v : nbrs) {
                // if neighbor is not visited
                if (!visited[v]) {
                    q.add(v);        // add to queue
                    visited[v] = true; // mark visited
                }
            }
        }
    }
}