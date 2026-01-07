// HashMap_FrequencyQueries
// Success rate: 28.22%
// Given N array elements and Q queries. For every query find frequency of element in array.

// Input Format:
// First line contains 2 integers N, M denoting size of the array and the number of queries.
// Second line contains the elements of the array.
// Third line contains M elements representin queries.

// Output Format:
// Output M integers in different lines denoting the frequency of each query.

// Constraints:
// 1 <= arr.length <= 10^5
// 1 <= arr[i], value <= 10^4
// 0 <= left <= right < arr.length



import java.util.HashMap;
import java.util.Scanner;

public class HashMap_FrequencyQueries {
	public static void main(String[] args) {
		Scanner scn= new Scanner(System.in);
		int n= scn.nextInt();
		int q= scn.nextInt();
		int[] arr = new int[n];
		int[] queries = new int[q];

		 for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        // Read query elements
        for (int i = 0; i < q; i++) {
            queries[i] = scn.nextInt();
        }
		 printFrequency(arr, queries);
	}
	public static void printFrequency(int[] arr , int[]queries){
		int n= arr.length;
		int q= queries.length;

		HashMap<Integer,Integer> hm = new  HashMap<>();
		for(int i =0;i<n;i++){
			if(!hm.containsKey(arr[i])){
				hm.put(arr[i],1);
			}else{
				int temp= hm.get(arr[i]);
				hm.put(arr[i],temp+1);
			}
		}
		for(int i=0;i<q;i++){
			if(!hm.containsKey(queries[i])){
				System.out.println(0);
			}else{
				System.out.println(hm.get(queries[i]));

			}
		}
	}
}

// ⏱ Complexity

// Time: O(n + q)

// Space: O(n)