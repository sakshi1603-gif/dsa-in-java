// Heaps_Kth Largest Element
// Success rate: 38.81%
// Given an integer array nums and an integer k, return the kth largest element in the array. Note that this is the kth largest element when the array is sorted in descending order. Can you solve this problem without sorting the entire array?

// Input Format:
// The first line contains an integer n representing the number of elements in the array.
// The second line contains n space-separated integers representing the elements of the array.
// The third line contains the integer k.

// Output Format:
// Output a single integer representing the kth largest element in the array.

// Constraints:
// 1 <= k <= nums.length <= 105
// -104 <= nums[i] <= 104
import java.util.PriorityQueue;
import java.util.Scanner;
public class Heaps_Kth_Largest_Element {
	public static void main(String[] args) {
		Scanner scn= new Scanner (System.in);
		int n =scn.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n ;i++){
			arr[i]=scn.nextInt();
		}
		int k =scn.nextInt();
		
		System.out.println(KthLargestElement(arr, n ,k));

	}
	public static int KthLargestElement(int[] arr ,int n ,int k){
		PriorityQueue<Integer>pq=new PriorityQueue<>();
		for(int i =0;i<k;i++){
			pq.add(arr[i]);
		}
		for(int i=k;i<n;i++){
			if(pq.peek()<arr[i]){
				pq.remove();
				pq.add(arr[i]);
			}
		}
		return pq.peek();
	}
}