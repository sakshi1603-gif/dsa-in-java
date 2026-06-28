// LU: Sorting_Merge Two Sorted Array
// Success rate: 38.62%
// Given two sorted arrays with N and M elements. Merge them into one sorted array and Print them.

// Input Format:
// The first line contains two integers n and m representing the size of 2 arrays
// The second line contains n elements of first array.
// The third line contains m elements of second array.

// Output Format:
// Print the merged sorted array in a line separated by space

// Constraints:
// 1<= N <= 10 ^ 6
// 1<= A[i] <=10 ^ 9
import java.util.*;

public class lect1_2_Sorting_Merge {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int m = scn.nextInt();

        int[] arr1 = new int[n];
        int[] arr2 = new int[m];

        for (int i = 0; i < n; i++) {
            arr1[i] = scn.nextInt();
        }

        for (int i = 0; i < m; i++) {
            arr2[i] = scn.nextInt();
        }

        merge(arr1, arr2);
    }

    public static void merge(int[] arr1, int[] arr2) {

        int n = arr1.length;
        int m = arr2.length;

        int[] ans = new int[n + m];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < n && j < m) {

            if (arr1[i] <= arr2[j]) {
                ans[k++] = arr1[i++];
            } else {
                ans[k++] = arr2[j++];
            }
        }

        while (i < n) {
            ans[k++] = arr1[i++];
        }

        while (j < m) {
            ans[k++] = arr2[j++];
        }

        for (int x : ans) {
            System.out.print(x + " ");
        }
    }
}