// Sorting_Order of Removal
// Success rate: 29.41%
// Given N length Array, at every step remove an array element. Cost to remove element = sum of array elements present. Find min cost to remove all the elements.

// Note: Add to cost first and then remove.

// Input Format:
// Integer representing N representing length of array
// N numbers of Array

// Output Format:
// Return the min cost to remove all the elements.

// Constraints:
// 1<= N <= 10 ^ 6
// 1<= A[i] <=10 ^ 9

import java.util.Arrays;
import java.util.Scanner;

public class Sorting_Order_of_Removal {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();

		int[] arr = new int[n];
		for(int i = 0; i < n; i++){
			arr[i] = scn.nextInt();  
		}

		System.out.println(removalOrder(arr, n));
	}

	public static int removalOrder(int[] arr, int n){
		Arrays.sort(arr);   // ascending order
		int ans = 0;

		for(int i = n - 1; i >= 0; i--){
			ans = ans + (arr[i] * (n - i));
		}
		return ans;
	}
}
