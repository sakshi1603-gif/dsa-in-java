// LU: Sorting_Inversion Count
// Success rate: 22.38%
// Given an array of integers, find the Inversion Count in the array. An inversion occurs if there are indices i and j such that arr[i] > arr[j] and i < j.

// The Inversion Count of an array indicates how far it is from being sorted. An already sorted array has an inversion count of 0. If the array is sorted in reverse order, the inversion count is at its maximum.

// Input Format:
// The first line contains an integer N, the size of the array.
// The second line contains N space-separated integers representing the elements of the array.

// Output Format:
// Print a single integer representing the inversion count of the array.

// Constraints:
// 1 ≤ n ≤ 5*10^5
// 1 ≤ arr[i] ≤ 10^18
import java.util.*;

public class lect1_5_Sorting_Inversion {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        long ans = mergeSort(arr, 0, n - 1);
        System.out.println(ans);
    }

    public static long mergeSort(int[] arr, int low, int high) {

        if (low >= high) {
            return 0;
        }

        int mid = low + (high - low) / 2;

        long leftCount = mergeSort(arr, low, mid);
        long rightCount = mergeSort(arr, mid + 1, high);
        long mergeCount = merge(arr, low, mid, high);

        return leftCount + rightCount + mergeCount;
    }

    public static long merge(int[] arr, int low, int mid, int high) {

        int p1 = low;
        int p2 = mid + 1;
        int p3 = 0;

        int[] temp = new int[high - low + 1];
        long count = 0;

        while (p1 <= mid && p2 <= high) {

            if (arr[p1] <= arr[p2]) {
                temp[p3++] = arr[p1++];
            } else {
                count += (mid - p1 + 1);
                temp[p3++] = arr[p2++];
            }
        }

        while (p1 <= mid) {
            temp[p3++] = arr[p1++];
        }

        while (p2 <= high) {
            temp[p3++] = arr[p2++];
        }

        for (int i = low, j = 0; i <= high; i++, j++) {
            arr[i] = temp[j];
        }

        return count;
    }
}