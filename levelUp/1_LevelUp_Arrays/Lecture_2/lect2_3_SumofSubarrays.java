// Arrays2_SumofSubarrays
// Success rate: 41.31%
// Given an array A with N elements , you need to find the sum all sub arrays of array A.

// Input Format:
// First line contains size of the array
// Second line contains the elements of the array

// Output Format:
// Print the Sum of Subarray using Contribution technique.

// Constraints:
// 1 ≤ N ≤ 10^3
// 1 ≤ A[i] ≤ 10^3

import java.util.*;
public class lect2_3_SumofSubarrays {
	public static void main(String[] args) {
		Scanner scn = new Scanner (System.in);

		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n ;i++){
			arr[i]=scn.nextInt();
		}
		int ans = SumofSubarrays(n , arr);
		System.out.println(ans);
	}
	public static int SumofSubarrays(int n , int [] arr){
		int ans=0;;
		for(int i=0;i<n ;i++ ){
			int occ = (i+1)*(n-i);
			ans = ans + (occ*arr[i]);
		}
		return ans;
	}
}