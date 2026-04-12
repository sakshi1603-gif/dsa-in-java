// DP_Climb Stairs
// Success rate: 37.29%
// You are climbing a staircase that has n steps to reach the top. Each time you can either take 1 step or 2 steps. Determine the number of distinct ways you can reach the top of the staircase.

// Input Format:
// A single integer n, representing the number of steps in the staircase.

// Output Format:
// A single integer representing the number of distinct ways to climb to the top.

// Constraints:
// 1 <= n <= 45

import java.util.Arrays;
import java.util.Scanner;
public class DP_Climb_Stairs {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] dp = new int[n+1];
		Arrays.fill(dp,-1);
		System.out.println(DP_Climb_Stairs(n,dp));
	}
	public static int DP_Climb_Stairs(int n , int[] dp){
		if(n==1 ||n==2){
			return n;
		}
		if(dp[n]!=-1){
			return dp[n];
		}
		int x = DP_Climb_Stairs(n-1,dp);
		int y = DP_Climb_Stairs(n-2,dp);
		dp[n]=x+y;
		return x+y;
	}
}