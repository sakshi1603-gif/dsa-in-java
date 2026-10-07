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
import java.util.Arrays;

public class lect1_2_Graph_BellmanFord_Algo {

    static int[] BellmanFord(int[][] edges, int src, int V) {

        // Step 1: Initialize distances
        int[] ans = new int[V];
        Arrays.fill(ans, Integer.MAX_VALUE);

        // Distance from source to itself = 0
        ans[src] = 0;

        // Step 2: Relax all edges V-1 times
        for (int i = 0; i < V - 1; i++) {

            for (int j = 0; j < edges.length; j++) {

                int u = edges[j][0];
                int v = edges[j][1];
                int w = edges[j][2];

                // Relaxation
                if (ans[u] != Integer.MAX_VALUE &&
                    ans[u] + w < ans[v]) {

                    ans[v] = ans[u] + w;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int[][] edges = {
            {0, 1, 4},
            {0, 2, 5},
            {1, 2, -3},
            {2, 3, 4},
            {1, 3, 5}
        };

        int V = 4;
        int src = 0;

        int[] result = BellmanFord(edges, src, V);

        System.out.println(Arrays.toString(result));
    }
}