// Arrays5_Print Spiral
// Success rate: 42.55%
// Given an m x n matrix, return all the elements of the matrix in spiral order.

// Input Format:
// An integer m (number of rows).
// An integer n (number of columns).
// A 2D matrix of size m x n where each element is an integer.

// Output Format:
// A list of integers representing the elements of the matrix in spiral order.

// Constraints:
// m == matrix.length
// n == matrix[i].length
// 1 <= m, n <= 10
// -100 <= matrix[i][j] <= 100

import java.util.*;

public class lect5_5_Print_Spiral {
	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();
		int m = scn.nextInt();

		int[][] matrix = new int[n][m];

		for(int i = 0; i < n; i++){
			for(int j = 0; j < m; j++){
				matrix[i][j] = scn.nextInt();
			}
		}

		List<Integer> ans = spiralOrder(matrix);

		for(int val : ans){
			System.out.print(val + " ");
		}
	}

	public static List<Integer> spiralOrder(int[][] matrix) {

		int n = matrix.length;
		int m = matrix[0].length;

		List<Integer> ans = new ArrayList<>();

		int i = 0;
		int j = 0;

		int csteps = m - 1;
		int rsteps = n - 1;

		while(csteps >= 1 && rsteps >= 1){

			for(int k = 0; k < csteps; k++){
				ans.add(matrix[i][j]);
				j++;
			}

			for(int k = 0; k < rsteps; k++){
				ans.add(matrix[i][j]);
				i++;
			}

			for(int k = 0; k < csteps; k++){
				ans.add(matrix[i][j]);
				j--;
			}

			for(int k = 0; k < rsteps; k++){
				ans.add(matrix[i][j]);
				i--;
			}

			i++;
			j++;

			csteps = csteps - 2;
			rsteps = rsteps - 2;
		}

		if(rsteps == 0 && csteps != 0){

			for(int k = 0; k < csteps + 1; k++){
				ans.add(matrix[i][j]);
				j++;
			}
		}

		if(csteps == 0 && rsteps != 0){

			for(int k = 0; k < rsteps + 1; k++){
				ans.add(matrix[i][j]);
				i++;
			}
		}

		if(csteps == 0 && rsteps == 0){
			ans.add(matrix[i][j]);
		}

		return ans;
	}
}