// DP_Number of Paths
// Success rate: 30.49%
// There is a robot on an m x n grid. The robot starts at the top-left corner of the grid (i.e., at grid[0][0]) and aims to reach the bottom-right corner (i.e., at grid[m - 1][n - 1]). The robot can move only in two directions at any point: either down or to the right.

// Given two integers m and n, find the number of unique paths the robot can take to reach the bottom-right corner from the top-left corner.

// The test cases are structured such that the answer will always be less than or equal to 2 * 10^9.

// Input Format:
// Two integers m and n representing the dimensions of the grid.

// Output Format:
// A single integer representing the number of unique paths the robot can take to reach the bottom-right corner.

// Constraints:
// 1 <= m, n <= 100

import java.util.Scanner;
public class DP_Number_of_Paths {
	public static void main(String[] args) {
		Scanner scn = new Scanner (System.in);
		int m =scn.nextInt();
		int n =scn.nextInt();
		int[][] dp = new int[m][n];
		for(int i =0;i<m;i++){
			for(int j=0;j<n;j++){
				dp[i][j] =-1;
			}
		}
		System.out.println(Dp_Number_of_Paths(m-1,n-1,dp));
	}
	public static int Dp_Number_of_Paths(int i,int j ,int [][]dp){
		if(i < 0 || j < 0) return 0;
		if(i==0||j==0){
			    dp[i][j] = 1;
				return  1;
		}
		if(dp[i][j]!=-1){return dp[i][j];}
		int x =Dp_Number_of_Paths(i-1,j,dp);
		int y =Dp_Number_of_Paths(i,j-1,dp);
		dp[i][j]=x+y;
		return x+y;
	}
}