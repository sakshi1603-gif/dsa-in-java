// HashMap_Count Distinct Elements
// Success rate: 46.53%
// Given an array arr[] of length N, The task is to count all distinct elements in arr[].

// Input Format:
// The first line contains size of array.
// Second line contains the elements of the array.

// Output Format:
// Output the count.

// Constraints:
// 1<=N<=10^5
// 1<=Arr[i]<=10^5

import java.util.HashSet;
import java.util.Scanner;
public class HashMap_Count_Distinct_Elements {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n =scn.nextInt();
		int[]arr=new int[n];
		for(int i=0;i<n;i++){
			arr[i]=scn.nextInt();
		}
		int result = distinctElement(arr);
		System.out.println(result);
	}
	public static int distinctElement(int []arr){
		int n = arr.length;
		HashSet<Integer> hs = new HashSet<>();

		for(int i =0;i<n;i++){
			hs.add(arr[i]);
		}
		return hs.size();
	}
}