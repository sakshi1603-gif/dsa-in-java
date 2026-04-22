// Arrays1_TrappingRainWater
// Success rate: 26.27%
// Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

// Input Format:
// The first line contains an integer n, the number of bars.
// The second line contains n space-separated non-negative integers representing the elevation map.

// Output Format:
// A single integer representing the total amount of water that can be trapped.

// Constraints:
// n == height.length
// 1 <= n <= 2 * 104
// 0 <= height[i] <= 105

import java.util.*;
public class Arrays1_TrappingRainWater_5 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int [] arr=new int[n];
		for(int i = 0 ; i < n ; i++){
			arr [i] = scn.nextInt();
		}
		int amount = TrappingRainWater( arr , n );
		System.out.println( amount );
	} 
	public static int TrappingRainWater( int [] arr , int n){
		if(n <= 2) return 0; 

		int [] pmax = PrefixMax(arr , n );
		int [] smax = SufixMax(arr , n );
		int amount= 0;
		for(int i=1;i<n-1;i++){
			int lb = pmax[i-1];
			int rb = smax[i+1];
			int yb = Math.min(lb , rb);
			int waterAtIndex  = yb-arr[i];
			if(waterAtIndex >0){
				amount = amount +waterAtIndex ;
			}
		}
		return amount;
	}
	public static int[] PrefixMax(int [] arr , int n){
		int [] pmax = new int[n];
		pmax[0]=arr[0];
		for(int i=1;i<n;i++){
			pmax[i]=Math.max(pmax[i-1],arr[i]);
		}
		return pmax;
	}
	public static int [] SufixMax(int [] arr , int n ){
		int [] smax = new int[n];
		smax[n-1]=arr[n-1];
		for(int i=n-2;i>=0;i--){
			smax[i]=Math.max(smax[i+1],arr[i]);
		}
		return smax;
	}
}

//Time Complexity = O(n);
//Space Complexity = o(n);
// we can solve this in O(1) space complexity which will  be learning in the two pointer 