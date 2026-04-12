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

import java.util.*;
public class Graphs_Topological_Sort {
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
		TopogicalSort(Graph , v ,e);
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
	public static void TopogicalSort (List<List<Integer>>Graph , int v , int e ){
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
		while(q.size()>0){
			int rem = q.remove();
			System.out.print(rem+" ");
			List<Integer>nbrs = Graph.get(rem);
			for(int x : nbrs){
				indegree[x]--;
				if(indegree[x]==0){
					q.add(x);
				}
			}
		}
	}
}