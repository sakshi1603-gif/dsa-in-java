// Arrays3_Sum of all Submatrix
// Success rate: 45.33%
// Given a NxM 2-D matrix, the task to find the sum of all the submatrices.

// Input Format:
// The first line contains two integers n and m.
// Each of next n line contains m integers.

// Output Format:
// Return the sum of all the submatrices.

// Constraints:
// 1 <= n,m <= 100
// 1 <= mat[i][j] <= 100
import java.util.*;

public class lect3_4_Sum_of_all_Submatrix {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int m = scn.nextInt();

        int[][] arr = new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j]=scn.nextInt();
            }
        }

        System.out.println(Sum_of_all_Submatrix(n,m,arr));
    }

    public static long Sum_of_all_Submatrix(int n,int m,int[][] arr){

        long ans = 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){

                long occ = (long)(i+1)*(j+1)*(n-i)*(m-j);

                ans += occ * arr[i][j];
            }
        }

        return ans;
    }
}