// Binary Search_Single Element in Array
// Success rate: 32.53%
// You are given an array consisting of n integers where every element appears exactly twice, except for one element which appears exactly once. Duplicate Numbers are adjacent to each other.

// Return the single element that appears only once.

// Your solution must run in O(log n) time and O(1) space.

// Input Format:
// First line contains integer n representing the length of array
// Second line contains n integers

// Output Format:
// Return the number appearing only once.

// Constraints:
// 1 <= n <= 10^9

import java.util.Scanner;
public class Binary_Search_Single_Element {
	public static void main(String[] args) {
		Scanner scn = new Scanner (System.in);
		int n =scn.nextInt();
		int [] arr= new int[n];
		for(int i=0;i<n ;i++){
			arr[i]=scn.nextInt();
		}
		System.out.println(unique_elem(arr,n));
	}
	public static int unique_elem(int[] arr,int n){
		if(arr[0]!=arr[1]){ return arr[0];}
		if(arr[n-1]!=arr[n-2]){return arr[n-1];}
		int lo=2;
		int hi=n-3;
		while(lo<=hi){
			int m=lo+((hi-lo)/2);
			if(arr[m]!=arr[m-1]&&arr[m]!=arr[m+1]){
				return arr[m];
			}
			if(arr[m]==arr[m-1]){m--;}
			if(m%2==0){
				lo=m+2;
			}else{
				hi=m-1;
			}
		}
		return -1;
	}
}