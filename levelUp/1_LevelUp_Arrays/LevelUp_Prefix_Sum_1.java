import java.util.*;
// LevelUp_Prefix Sum
// Success rate: 28.68%
// Given an array nums. We define a prefix sum of an array as prefix[i] = sum(nums[0]+nums[1]..…nums[i]).

// Return the prefix sum of nums.

// Input Format:
// The first line contains an integer n representing size of nums array.
// The second line contains n integers of array.

// Output Format:
// Return the prefix sum.

// Constraints:
// 1 <= nums.length <= 1000

public class LevelUp_Prefix_Sum_1 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++){
			arr[i]=scn.nextInt();
		}
		
		PrefixArray(arr , n );
	}
	public static void PrefixArray(int[] arr , int n){
		int[] Pf = new int[n];
		Pf[0]= arr[0];
		for(int i =1 ;i<n;i++){
			Pf[i]=Pf[i-1]+arr[i];
		}
		for(int i=0;i<n;i++){
			System.out.print(Pf[i]+" ");
		}

	}
}