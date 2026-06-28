// LU: Sorting_Merge Two Sorted SubArray
// Success rate: 36.54%
// Given a sorted arrays with N elements and 3 indices s, m and e such that subarray [s,m] is sorted, subarray [m+1,e] is sorted. Sort the subarray [s,e].

// Note: s to m and then m+1 to e are continuous subarray

// Input Format:
// The first line contains integer n representing size of array
// The second line contains n elements of array.
// The third line contains 3 elements representing s,m and e index.

// Output Format:
// Print the array after sorting subarray [s,e] in a line separated by space

// Constraints:
// 1<= N <= 10 ^ 6
// 1<= A[i] <=10 ^ 9
import java.util.*;

public class lect1_3_Sorting_Merge_Two_Sorted_SubArray {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int s = scn.nextInt();
        int m = scn.nextInt();
        int e = scn.nextInt();

        merge(arr, s, m, e);

        for (int x : arr) {
            System.out.print(x + " ");
        }
    }

    public static void merge(int[] arr, int s, int m, int e) {

        int[] temp = new int[e - s + 1];

        int i = s;
        int j = m + 1;
        int k = 0;

        while (i <= m && j <= e) {

            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= m) {
            temp[k++] = arr[i++];
        }

        while (j <= e) {
            temp[k++] = arr[j++];
        }

        for(int x = 0; x < temp.length; x++) {
            arr[s + x] = temp[x];
        }
    }
}