// Sorting_Good Integer Distinct
// Success rate: 45.00%
// Given N array Integers, Calculate number of good integers. An element is said to be good integers, if {No. of element < element == element itself}

// Note: Array elements are distinct.

// Input Format:
// Integer representing N representing length of array
// N numbers of Array

// Output Format:
// Count of Good Integers

// Constraints:
// 1<= N <= 10 ^ 6
// 1<= A[i] <=10 ^ 9

import java.util.Arrays;
import java.util.Scanner;
public class Sorting_Good_Integer_Distinct {
	public static void main(String[] args) {
		Scanner scn= new Scanner(System.in);
		int n =scn.nextInt();
		int[] arr=new int[n];
		for(int i =0;i<n;i++){
			arr[i]=scn.nextInt();
		}
		System.out.println(Good_Integer(arr,n));
	}
	public static int Good_Integer(int arr[], int n ){
		Arrays.sort(arr);
		int ans=0;
		for(int i =0;i<n;i++){
			if(arr[i]==i){
				ans++;
			}
		}
		return ans;
	}

}