// LU: BS_ Search a 2D Matrix
// Success rate: 46.43%
// You are given an m x n integer matrix matrix with the following two properties:

// Each row is sorted in non-decreasing order.
// The first integer of each row is greater than the last integer of the previous row.
// Given an integer target, return true if target is in matrix or false otherwise.

// You must write a solution with a time complexity of O(log(m * n)).

// Input Format:
// The first line contains two space-separated integers m and n, representing the number of rows and columns of the matrix.
// The next m lines each contain n space-separated integers representing the elements of the matrix.
// The last line contains the integer target.

// Output Format:
// Print true if the target is found in the matrix, otherwise print false.

// Constraints:
// m == matrix.length
// n == matrix[i].length
// 1 <= m, n <= 100
// -10^4 <= matrix[i][j], target <= 10^4
import java.util.*;

public class lect3_1_Search_2D_Matrix {

    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;

        int low = 0;
        int high = row * col - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int r = mid / col;
            int c = mid % col;

            if (matrix[r][c] == target) {
                return true;
            }

            if (matrix[r][c] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input: rows and columns
        int m = sc.nextInt();
        int n = sc.nextInt();

        // Input: matrix
        int[][] matrix = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        // Input: target
        int target = sc.nextInt();

        // Output
        System.out.println(searchMatrix(matrix, target));

        sc.close();
    }
}