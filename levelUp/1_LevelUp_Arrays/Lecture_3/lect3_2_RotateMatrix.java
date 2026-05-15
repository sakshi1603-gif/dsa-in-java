// Arrays3_RotateMatrix
// Success rate: 35.25%
// You are given an n x n 2D matrix representing an image. Rotate the image by 90 degrees (clockwise).

// You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

// Input Format:
// The first line contains an integer n (size of the matrix).
// The next n lines each contain n space-separated integers representing the elements of the matrix.

// Output Format:
// Output the rotated matrix as n lines, each containing n space-separated integers.

// Constraints:
// n == matrix.length == matrix[i].length
// 1 <= n <= 20
// -1000 <= matrix[i][j] <= 1000

import java.util.*;

public class lect3_2_RotateMatrix {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int[][] arr = new int[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                arr[i][j] = scn.nextInt();
            }
        }

        RotateMatrix(n, arr);

        // print matrix
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void RotateMatrix(int n, int[][] arr){
        TransposeMatrix(n, arr);

        for(int i = 0; i < n; i++){
            reverseArray(arr[i]);
        }
    }

    public static void TransposeMatrix(int n, int[][] arr){
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){

                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;

            }
        }
    }

    public static void reverseArray(int[] temp){
        int start = 0;
        int end = temp.length - 1;

        while(start < end){
            int t = temp[start];
            temp[start] = temp[end];
            temp[end] = t;

            start++;
            end--;
        }
    }
}