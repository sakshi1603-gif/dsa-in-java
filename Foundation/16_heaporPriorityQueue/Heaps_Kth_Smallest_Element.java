// Heaps_Kth Smallest Element
// Success rate: 23.08%
// Given an array arr[] and an integer k, where k is smaller than the size of the array, find the kth smallest element in the given array. It is guaranteed that all elements in the array are distinct.

// Input Format:
// The first line contains two integers: n (the size of the array) and k (the position of the smallest element to find).
// The second line contains n distinct integers representing the elements of the array.

// Output Format:
// Output a single integer: the kth smallest element in the array.

// Constraints:
// 1 <= n <= 105
// l = 0
// r = N-1
// 1<= arr[i] <= 105
// 1 <= k <= n

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;
public class Heaps_Kth_Smallest_Element {
	public static void main(String[] args) {
		Scanner scn= new Scanner (System.in);
		int n = scn.nextInt();
		int k = scn.nextInt();
		int[]arr = new int[n];
		for(int i=0;i<n;i++){
			arr[i]=scn.nextInt();
		}
		System.out.println(KthSmallestElement(arr,n,k));
	}
	public static int KthSmallestElement(int[] arr , int n,int k){
		PriorityQueue<Integer>pq =new PriorityQueue<>(Collections.reverseOrder());
		for (int i=0;i<k;i++){
			pq.add(arr[i]);
		}
		for(int i=k;i<n;i++){
			if(pq.peek()>arr[i]){
				pq.remove();
				pq.add(arr[i]);
			}
		}
		return pq.peek();
	}
}