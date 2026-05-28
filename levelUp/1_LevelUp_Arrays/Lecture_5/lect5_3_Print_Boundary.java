// Arrays5_Print Boundary
// Success rate: 42.75%
// Given a square matrix of N*N, print the outer boundary in clockwise direction

// Input Format:
// First line contains an integer n representing size of matrix.
// Each of next n lines contain n integer representing array elements.'

// Output Format:
// Print the outer boundary in clockwise direction in a line with space in between each.

// Constraints:
// 1 <= N <= 100
// 1 <= arr[i] <= 10^4

import java.util.*;
public class lect5_3_Print_Boundary {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[][] mat = new int[n][n];
		for(int i=0 ; i<n ; i++){
			for(int j=0 ; j<n ; j++){
				mat[i][j] = scn.nextInt();
			}
		}
		PrintBoundary(mat , n );
	}
	public static void PrintBoundary(int [][] mat , int n ){
		int i=0;
		int j=0;
		for(int k=0 ; k<n-1 ; k++){
			System.out.print(mat[i][j]+" ");
			j++;
		}
		for(int k=0 ; k<n-1 ; k++){
			System.out.print(mat[i][j]+" ");
			i++;
		}
		for(int k=0 ; k<n-1 ; k++){
			System.out.print(mat[i][j]+" ");
			j--;
		}
		for(int k=0 ; k<n-1 ; k++){
			System.out.print(mat[i][j]+" ");
			i--;
		}
	}
}