// Arrays3_RangeSum2D
// Success rate: 34.63%
// Given a 2D matrix matrix, handle multiple queries of the following type:

// Calculate the sum of the elements of matrix inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).

// Implement the NumMatrix class:

// NumMatrix(int[][] matrix) initializes the object with the integer matrix matrix.
// int sumRegion(int row1, int col1, int row2, int col2) returns the sum of the elements of matrix inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
// You must design an algorithm where sumRegion works in O(1) time complexity.

// Input Format:
// The first part of the input is the 2D integer matrix matrix.
// The next part contains multiple queries, where each query is defined by four integers row1, col1, row2, col2.

// Output Format:
// For each query, output the sum of the elements of matrix inside the specified rectangle.

// Constraints:
// m == matrix.length
// n == matrix[i].length
// 1 <= m, n <= 200
// -104 <= matrix[i][j] <= 104
// 0 <= row1 <= row2 < m
// 0 <= col1 <= col2 < n
// At most 104 calls will be made to sumRegion.

import java.util.*;

public class lect3_3_RangeSum2D {

    static int[][] prefix;

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int m = scn.nextInt();
        int n = scn.nextInt();

        int[][] matrix = new int[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                matrix[i][j] = scn.nextInt();
            }
        }

        NumMatrix(matrix);

        int q = scn.nextInt();

        while(q-- > 0){
            int row1 = scn.nextInt();
            int col1 = scn.nextInt();
            int row2 = scn.nextInt();
            int col2 = scn.nextInt();

            System.out.println(
                sumRegion(row1,col1,row2,col2)
            );
        }
    }

    public static void NumMatrix(int[][] matrix){

        int m = matrix.length;
        int n = matrix[0].length;

        prefix = new int[m+1][n+1];

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){

                prefix[i][j] =
                matrix[i-1][j-1]
                + prefix[i-1][j]
                + prefix[i][j-1]
                - prefix[i-1][j-1];
            }
        }
    }

    public static int sumRegion(
        int row1,
        int col1,
        int row2,
        int col2
    ){

        return prefix[row2+1][col2+1]
             - prefix[row1][col2+1]
             - prefix[row2+1][col1]
             + prefix[row1][col1];
    }
}