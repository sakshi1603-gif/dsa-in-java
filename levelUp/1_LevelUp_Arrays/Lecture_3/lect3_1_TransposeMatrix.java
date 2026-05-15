// Arrays3_TransposeMatrix
// Success rate: 37.13%
// Write a program to find the transpose of a square matrix of size N*N.

// The transpose of a matrix is the matrix flipped over its main diagonal, switching the matrix's row and column indices.

// Input Format:
// First line contains an integer N
// Next N lines contain the matrix with N numbers in each line.]

// Output Format:
// Output N lines containing the transposed matrix with N numbers in each line.

// Constraints:
// 1<=N<=10^3
// -10^9<=mat[i][j]<=10^9
import java.util.Scanner;
public class lect3_1_TransposeMatrix {
	public static void main(String[] args) {
		Scanner scn = new Scanner (System.in);
		int n = scn.nextInt();
		int [][] mat = new int[n][n];
		for(int i =0;i<n;i++){
			for(int j=0;j<n;j++){
				mat[i][j]= scn.nextInt();
			}
		}
		TransposeMatrix(n ,mat);
	}
	public static void TransposeMatrix(int n , int[][] mat){
		for(int i=1;i<n;i++){
			for(int j=0;j<i;j++){
				//swaping of mat[i][j] with mat[j][i]
				int temp = mat[i][j];
				mat[i][j] = mat[j][i];
				mat[j][i] = temp;
			}
		}

		for(int i =0;i<n;i++){
			for(int j=0;j<n;j++){
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
	}
}