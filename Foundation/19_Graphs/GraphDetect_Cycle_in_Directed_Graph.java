// Graphs_ Detect Cycle in Directed Graph
// Success rate: 45.60%
// Given a Directed Graph with V vertices (numbered from 0 to V-1) and E edges, determine whether the graph contains any cycles. A cycle in a graph is a path that starts and ends at the same vertex without repeating any edges.

// Input Format:
// The first line contains two integers, V and E, representing the number of vertices and edges, respectively.
// The next E lines each contain two integers u and v, indicating a directed edge from vertex u to vertex v.

// Output Format:
// Print true if the graph contains a cycle.
// Print false if the graph does not contain a cycle.

// Constraints:
// 1 ≤ V, E ≤ 105

import java.util.*;
public class GraphDetect_Cycle_in_Directed_Graph {
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
		boolean result =TopogicalSort(Graph , v ,e);
		System.out.println(result);

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
        }

        return Graph;
    }
	public static boolean TopogicalSort (List<List<Integer>>Graph , int v , int e ){
		int[] indegree = new int [v];
		for(int i =0;i<v;i++){
			List<Integer> nbrs = Graph.get(i);
			for(int x : nbrs){
				indegree[x]++;
			}
		}
		Queue<Integer>q = new LinkedList<>();
		for(int i=0;i<v;i++){
			if(indegree[i]==0){q.add(i);}
		}
		int count =0;
		while(q.size()>0){
			int rem = q.remove();
			count ++;
			List<Integer>nbrs = Graph.get(rem);
			for(int x : nbrs){
				indegree[x]--;
				if(indegree[x]==0){
					q.add(x);
				}
			}
		}
		if(count ==v){
			return false;
		}else{
			return true;
		}
	}
}