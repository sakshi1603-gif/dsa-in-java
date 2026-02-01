// Binary Search_ Search in Array
// Success rate: 24.53%
// Given a sorted array of n integers and a number k, Return true if k is present otherwise return false.

// Input Format:
// First line contains integer n representing the length of array
// Second line contains n integers
// Third line contains integer k

// Output Format:
// Return true if k is present else false.

// Constraints:
// 1 <= n <= 10^9


import java.util.Scanner;

public class Binary_Search {
	public static void main(String[] args) {
		Scanner scn = new Scanner (System.in);
		int n =scn.nextInt();
		int [] arr= new int[n];
		for(int i=0;i<n ;i++){
			arr[i]=scn.nextInt();
		}
		int k=scn.nextInt();
		System.out.println(binarySearch(arr,n,k));
	}
	public static boolean binarySearch(int[] arr,int n,int k){
		int low =0;
		int high=n-1;
		while(low<=high){
        int m = low + (high - low) / 2;
			if(arr[m]==k){
				return true;
			}else if(arr[m]<k){
				low =m+1;
			}else{
				high=m-1;
			}
		}
		return false;
}
}