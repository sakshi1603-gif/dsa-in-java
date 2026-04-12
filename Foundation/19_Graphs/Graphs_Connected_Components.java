// Graphs_ Connected Components
// Success rate: 34.50%
// You are given an undirected graph with V vertices represented as an adjacency matrix. Two vertices u and v are said to belong to a single province if there is a path connecting them. Your task is to find the number of provinces in the graph.

// Note: A province is a group of directly or indirectly connected cities and does not include any cities outside of the group.

// Input Format:
// First line: An integer V representing the number of vertices in the graph.
// Next V lines: Each line contains V integers representing the adjacency matrix of the graph. A value of 1 indicates a direct connection between two cities, while a 0 indicates no direct connection.

// Output Format:
// A single integer representing the number of provinces in the graph

// Constraints:
// 1 ≤ V ≤ 500

import java.util.*;
public class Graphs_Connected_Components {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int v = scn.nextInt();
		int[][] arr = new int[v][v];

		for(int i =0;i<v;i++){
			for(int j=0;j<v;j++){
				arr[i][j]=scn.nextInt();
			}
		}
		
		List<List<Integer>>Graph = Contruction(arr , v);
		int count =0;
		boolean[] vis = new boolean [v];
		for(int i=0;i<v;i++){
			if(vis[i]==false){
				DFS(Graph , vis , i );
				count++;
			}
		}
		System.out.println(count);
	}
	public static List<List<Integer>> Contruction(int[][] arr, int v) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < v; i++) {
            for (int j = i; j < v; j++) {
                if (arr[i][j] == 1) {
                    graph.get(i).add(j);
                    if (i != j) {
                        graph.get(j).add(i);
                    }
                }
            }
        }

        return graph;
    }
	public static void DFS(List<List<Integer>> graph, boolean[] vis, int src){
    	vis[src] = true;

    	for(int v : graph.get(src)){
        	if(!vis[v]){
            DFS(graph, vis, v);
        }
    }}
	
}