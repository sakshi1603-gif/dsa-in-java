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
import java.util.*;

public class lect1_1_DijkstraAlgorithm {

    // Pair class
    static class Pair {
        int v;
        int wt;

        Pair(int v, int wt) {
            this.v = v;
            this.wt = wt;
        }
    }

    // Dijkstra Algorithm
    static int[] dijkstra(List<List<Pair>> graph, int src) {

        int n = graph.size();

        int[] ans = new int[n];
        Arrays.fill(ans, Integer.MAX_VALUE);

        // Priority Queue: {distance, vertex}
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> a.wt - b.wt
        );

        // Source distance = 0
        ans[src] = 0;

        pq.add(new Pair(src, 0));

        while (pq.size() > 0) {

            Pair rem = pq.remove();

            int v = rem.v;
            int wt = rem.wt;

            // Ignore outdated pair
            if (ans[v] != wt) {
                continue;
            }

            // Visit neighbours
            List<Pair> nbrs = graph.get(v);

            for (Pair nbr : nbrs) {

                int u = nbr.v;
                int edgeWt = nbr.wt;

                // Relaxation
                if (ans[u] > ans[v] + edgeWt) {

                    ans[u] = ans[v] + edgeWt;

                    pq.add(new Pair(u, ans[u]));
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int V = 4;

        // Create graph
        List<List<Pair>> graph = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        // Undirected edges
        graph.get(0).add(new Pair(1, 3));
        graph.get(1).add(new Pair(0, 3));

        graph.get(0).add(new Pair(2, 1));
        graph.get(2).add(new Pair(0, 1));

        graph.get(1).add(new Pair(3, 5));
        graph.get(3).add(new Pair(1, 5));

        graph.get(2).add(new Pair(3, 2));
        graph.get(3).add(new Pair(2, 2));

        // Source
        int src = 0;

        // Run Dijkstra
        int[] result = dijkstra(graph, src);

        // Print answer
        System.out.println("Shortest distances:");

        for (int i = 0; i < result.length; i++) {
            System.out.println("0 -> " + i + " = " + result[i]);
        }
    }
}