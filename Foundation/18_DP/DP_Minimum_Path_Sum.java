// DP_Minimum Path Sum
// Success rate: 40.22%
// Given a m x n grid filled with non-negative numbers, find a path from the top-left corner to the bottom-right corner that minimizes the sum of all numbers along the path.

// You can only move either down or to the right at any point in time.

// Input Format:
// A 2D integer array grid of size m x n where grid[i][j] represents the number at cell (i, j).

// Output Format:
// A single integer representing the minimum sum of numbers along the path from the top-left to the bottom-right corner.

// Constraints:
// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 200
// 0 <= grid[i][j] <= 200
import java.util.Scanner;
public class DP_Minimum_Path_Sum {
	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int m=scn.nextInt();
		int n =scn.nextInt();
		int [][] arr=new int[m][n];
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				arr[i][j]=scn.nextInt();
			}
		}
		int [][] dp=new int[m][n];
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				dp[i][j]=-1;
			}
		}
		
		System.out.println(minimum_path_sum(arr,m-1,n-1,dp));
	}
	public static int minimum_path_sum(int[][] arr, int i, int j, int[][] dp){

    	if(i == 0 && j == 0)
    	    return arr[0][0];

    	if(i < 0 || j < 0)
    	    return Integer.MAX_VALUE;

    	if(dp[i][j] != -1)
    	    return dp[i][j];

    	int up = minimum_path_sum(arr, i-1, j, dp);
    	int left = minimum_path_sum(arr, i, j-1, dp);

    	dp[i][j] = arr[i][j] + Math.min(up, left);

    	return dp[i][j];
	}	

}