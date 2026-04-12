// Graphs_ Source to Destination Path
// Success rate: 32.45%
// You have been given edges of a graph and a source node(sn) and destination node(dn). Return true if there is a path from source node to destination node or false otherwise.

// Input Format:
// The first line contains two integers n and m representing no. of nodes and edges
// Next m line represents edges of the graph
// last line contains two integer representing source node(sn) and destination node(dn).

// Output Format:
// Return true or False

// Constraints:
// The nodes are fro 0 to n-1
import java.util.*;
public class Graphs_Source_to_Destination_Path {
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
		boolean vis= VisiteEdges(n , m , graph);
		System.out.println(vis);

	}
	public static List<List<Integer>> Construction(int n , int m , int[][] arr ){
		List<List<Integer>>graph = new ArrayList<>();

		for(int i =0;i<n;i++){
			graph.add(new ArrayList<>());
		}	

		for(int i =0;i<n ;i++){
			int u = arr[i][0];
			int v = arr[i][1];

			graph.get(u).add(v);
		}
		return graph;
	}
	public static boolean VisiteEdges(int n , int m , List<List<Integer>> Graph ){
		Queue<Integer>q= new LinkedList<>();
		boolean[] vis= new boolean[n];

		q.add(0);
		vis[0]= true;

		while(!q.isEmpty()){
			int rem = q.remove();
			List<Integer>nbrs= Graph.get(rem);
			for(int v : nbrs){
					if(vis[v]==false){
					q.add(v);
					vis[v]=true;
				}
			}
		}
		for(int i =0;i<n ;i++){
			if(vis[i]==false){
				return false;
			}
		}
		return true;

	}

}