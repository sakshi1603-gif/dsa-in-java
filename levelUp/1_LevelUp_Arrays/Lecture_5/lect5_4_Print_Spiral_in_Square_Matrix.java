// Arrays5_Print Spiral in Square Matrix
// Success rate: 36.67%
// Given a square matrix of N*N, print the Spiral order of the matrix.

// Input Format:
// First line contains an integer n representing size of matrix.
// Each of next n lines contain n integer representing array elements.

// Output Format:
// Print the spiral form of the matrix.

// Constraints:
// 1 <= N <= 100
// 1 <= arr[i] <= 10^4

import java.util.*;

public class lect5_4_Print_Spiral_in_Square_Matrix {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();
		int[][] mat = new int[n][n];

		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				mat[i][j] = scn.nextInt();
			}
		}

		PrintSpiral(mat, n);
	}

	public static void PrintSpiral(int[][] mat, int n) {

		int i = 0;
		int j = 0;
		int steps = n - 1;

		while(steps >= 1) {
			for(int k = 0; k < steps; k++) {
				System.out.print(mat[i][j] + " ");
				j++;
			}
			for(int k = 0; k < steps; k++) {
				System.out.print(mat[i][j] + " ");
				i++;
			}
			for(int k = 0; k < steps; k++) {
				System.out.print(mat[i][j] + " ");
				j--;
			}
			for(int k = 0; k < steps; k++) {
				System.out.print(mat[i][j] + " ");
				i--;
			}

			i++;
			j++;

			steps -= 2;
		}

		// center element for odd n
		if(n % 2 != 0) {
			System.out.print(mat[i][j]);
		}
	}
}