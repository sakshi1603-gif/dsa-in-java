// Binary Search_Floor in an Array
// Success rate: 17.44%
// Given a sorted array of n integers and a number k, Return floor(k).

// Input Format:
// First line contains integer n representing the length of array
// Second line contains n integers
// Third line contains integer k

// Output Format:
// Return floor of k.

// Constraints:
// 1 <= n <= 10^9

import java.util.Scanner;

public class Binary_Search_Floor {
	public static void main(String[] args) {
		Scanner scn = new Scanner (System.in);
		int n =scn.nextInt();
		int [] arr= new int[n];
		for(int i=0;i<n ;i++){
			arr[i]=scn.nextInt();
		}
		int k=scn.nextInt();
		System.out.println(floor(arr,n,k));
	}
	public static int floor(int[] arr,int n,int k){
		int low =0;
		int high=n-1;
		int ans=Integer.MIN_VALUE;
		while(low<=high){
        int m = low + (high - low) / 2;
			if(arr[m]==k){
				return k;
			}else if(arr[m]<k){
				ans=arr[m];
				low =m+1;
			}else{
				high=m-1;
			}
		}
		return ans;
}
}