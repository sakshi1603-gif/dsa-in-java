// Arrays 1_ Product of Array Except self
// Success rate: 26.46%
// Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

// The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

// You must write an algorithm that runs in O(n) time and without using the division operation.

// Input Format:
// The first line contains an integer n, the size of the array.
// The second line contains n space-separated integers representing the elements of the array nums.

// Output Format:
// A single line containing n space-separated integers representing the elements of the answer array.

// Constraints:
// 2 <= nums.length <= 105
// -30 <= nums[i] <= 30
// The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.


import java.util.*;
public class Arrays_1_Product_of_Array_Except_self_4 {
	public static void main(String[] args) {
		Scanner scn = new Scanner (System.in);
		int n = scn.nextInt();
		int [] arr = new int[n];
		for(int i=0;i<n ;i++){
			arr[i]=scn.nextInt();
		}
		int [] ans = productOfArray(arr , n );
		for(int i=0;i<n ;i++){
			System.out.print(ans[i]+" ");
		}
	}
	public static int [] productOfArray(int [] arr , int n ){
		if (n == 0) return new int[0];

		int[] preproduct = new int [n];
		// Step 1: Prefix product
		preproduct[0]= arr[0];
		for(int i=1;i<n ;i++){
			preproduct[i]=preproduct[i-1]*arr[i];
		}
		// Step 2: Suffix product
		int suffix=1;
		for(int i=n-1;i>0;i--){
			preproduct[i]=preproduct[i-1]*suffix;
			suffix= suffix*arr[i];
		}
		// Step 3: First element
		preproduct[0]=suffix;
		return preproduct;
	}
}