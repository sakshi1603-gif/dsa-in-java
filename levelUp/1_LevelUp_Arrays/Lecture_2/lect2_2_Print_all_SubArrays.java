// Arrays2_Print all SubArrays
// Success rate: 31.36%
// You are given an array of size 'n' and n elements of the same array. You are required to find and print all the subarrays of the given array. Each subarray should be space seperated and on a seperate lines. Refer to sample input and output.

// Input Format:
// The first line contains and integer n
// The second line contains n integer of array

// Output Format:
// Print all the subarrays where each subarray should be space seperated and on a seperate lines

// Constraints:
// 1 <= n <= 10
// 0 <= arr[i] <= 10 ^9

import java.util.*;
public class lect2_2_Print_all_SubArrays {
	public static void main(String[] args) {
		Scanner scn = new Scanner (System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i =0;i<n;i++){
			arr[i]= scn.nextInt();
		}
		Subarray(n , arr );
	}
	public static void Subarray(int n , int [] arr ){
		for(int sp = 0 ; sp < n ; sp++){
			for(int ep = sp ; ep < n ; ep++){
				for(int i =sp;i<ep+1;i++){
					System.out.print(arr[i]+" ");
				}
				System.out.println();
			}
		}
		
	}
}