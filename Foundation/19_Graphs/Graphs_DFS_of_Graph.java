// Graphs_ DFS of Graph
// Success rate: 28.67%
// You are given a connected undirected graph. Your task is to perform a Depth First Traversal (DFS) of the graph starting from the 0th vertex. The DFS traversal should be done recursively, visiting vertices from left to right according to the adjacency list.

// Input Format:
// The first line contains an integer V, the number of vertices in the graph.
// The second line contains an integer E, the number of edges in the graph.
// The next E lines contain two integers each, u and v, representing an edge between the vertices u and v.

// Output Format:
// A list containing the DFS traversal of the graph starting from the 0th vertex.

// Constraints:
// 1 ≤ V, E ≤ 104
import java.util.*;

public class Graphs_DFS_of_Graph {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int v = scn.nextInt();
        int e = scn.nextInt();

        int[][] arr = new int[e][2];

        for(int i = 0; i < e; i++){
            arr[i][0] = scn.nextInt();
            arr[i][1] = scn.nextInt();
        }

        List<List<Integer>> Graph = construction(arr, v, e);

        boolean[] vis = new boolean[v];

        DFStraversal(Graph, vis, 0);
    }

    public static List<List<Integer>> construction(int[][] arr, int v, int e){
        List<List<Integer>> Graph = new ArrayList<>();

        for(int i = 0; i < v; i++){
            Graph.add(new ArrayList<>());
        }

        for(int i = 0; i < e; i++){
            int u = arr[i][0];
            int x = arr[i][1];

            Graph.get(u).add(x);
            Graph.get(x).add(u); // remove if directed
        }

        return Graph;
    }

    public static void DFStraversal(List<List<Integer>> Graph, boolean[] vis, int src){
        vis[src] = true;
        System.out.print(src + " ");

        for(int nbr : Graph.get(src)){
            if(!vis[nbr]){
                DFStraversal(Graph, vis, nbr);
            }
        }
    }
}