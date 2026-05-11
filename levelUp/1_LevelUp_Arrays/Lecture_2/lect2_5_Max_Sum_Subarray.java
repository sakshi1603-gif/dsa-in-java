// Arrays2_Max Sum Subarray
// Success rate: 49.50%
// Given an integer array nums, find the subarray with the largest sum, and return its sum.

// Input Format:
// The first line contains an integer n (length of the array nums).
// The second line contains n space-separated integers representing the elements of the array nums.

// Output Format:
// A single integer representing the sum of the subarray with the largest sum.

// Constraints:
// 1 <= nums.length <= 105
// -104 <= nums[i] <= 104


import java.util.*;

public class lect2_5_Max_Sum_Subarray {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        System.out.println(MaxSumSubarray(n, arr));
    }

    public static int MaxSumSubarray(int n, int[] arr) {
		int sum = 0 ;
		int ans = Integer.MIN_VALUE;
		for(int i=0;i<n;i++){
			if(sum >0){
				sum = sum + arr[i];
			}else{
				sum = arr[i];
			}
			if(ans < sum ){
				ans = sum;
			}
		}
		return ans ; 
	}
}