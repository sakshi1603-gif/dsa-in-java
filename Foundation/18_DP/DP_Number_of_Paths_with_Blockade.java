// DP_Number of Paths with Blockade
// Success rate: 34.73%
// The problem is to count all the possible paths from top left to bottom right of a MxN matrix with the constraints that from each cell you can either move to right or down.

// mat[i][j] == 0 represents blocked cell and mat[i][j] == 1 represents unblocked cell and you can't move via blocked cell.

// Input Format:
// The first line contains the number of rows N and number of columns M of matrix.
// Each of next N rows contain m numbers representing the elements of array.

// Output Format:
// Print the number of possible paths

// Constraints:
// 1 <= m,n <=100
import java.util.Scanner;
public class DP_Number_of_Paths_with_Blockade {
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