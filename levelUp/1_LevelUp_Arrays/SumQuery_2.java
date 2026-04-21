import java.util.*;

/*
QUESTION:
Given an array of integers of size n, process q queries.
Each query consists of two integers L and R, representing a range.

For every query, find the sum of elements from index L to R (inclusive).

Constraints:
- 0-based indexing is used
- 0 <= L <= R < n

Approach:
- Use Prefix Sum to preprocess the array
- Prefix sum allows answering each query in O(1) time
*/

public class SumQuery_2 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		// Read size of array
		int n = scn.nextInt();
		int[] arr = new int[n];

		// Input array elements
		for(int i = 0; i < n; i++){
			arr[i] = scn.nextInt();
		}

		// Number of queries
		int q = scn.nextInt();

		// Store queries (each query has L and R)
		int[][] Queries = new int[q][2];
		for(int i = 0; i < q; i++){
			Queries[i][0] = scn.nextInt(); // L
			Queries[i][1] = scn.nextInt(); // R
		}

		// Process all queries
		SumIntRange(arr, Queries, q);
	}

	// Function to compute prefix sum array
	public static int[] prefixsum(int[] arr, int n) {
		int[] pf = new int[n];

		// First element remains same
		pf[0] = arr[0];

		// Build prefix sum array
		for(int i = 1; i < n; i++){
			pf[i] = pf[i - 1] + arr[i];
		}

		return pf;
	}

	// Function to answer all range sum queries
	public static void SumIntRange(int[] arr, int[][] Queries, int q){
		// Precompute prefix sum
		int[] pf = prefixsum(arr, arr.length);

		// Process each query
		for(int i = 0; i < q; i++){
			int L = Queries[i][0]; // left index
			int R = Queries[i][1]; // right index

			int sum;

			// If range does not start from index 0
			if(L > 0){
				sum = pf[R] - pf[L - 1];
			} 
			// If range starts from index 0
			else {
				sum = pf[R];
			}

			// Output the result
			System.out.println(sum);
		}
	}
}