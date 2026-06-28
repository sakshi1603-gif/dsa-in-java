// LU: Sorting_Merge Sort
// Success rate: 9.78%
// Given an array arr[], sort the array using the merge sort algorithm. Merge sort is a divide-and-conquer algorithm that recursively splits the array into two halves, sorts each half, and then merges the sorted halves back together.

// Input Format:
// The first line contains an integer n, the size of the array.
// The second line contains n space-separated integers representing the elements of the array.

// Output Format:
// Output the sorted array as a single line of space-separated integers.

// Constraints:
// 1 <= N <= 10^5
// 1 <= arr[i] <= 10^5
import java.util.*;

public class lect1_4_Sorting_Merge_Sort {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        mergeSort(arr, 0, n - 1);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void mergeSort(int[] arr, int low, int high) {

        if (low >= high) {
            return;
        }

        int mid = low + (high - low) / 2;

        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);

        merge(arr, low, mid, high);
    }

    public static void merge(int[] arr, int low, int mid, int high) {

        int[] temp = new int[high - low + 1];

        int i = low;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= high) {

            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }

        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= high) {
            temp[k++] = arr[j++];
        }

        for (int x = 0; x < temp.length; x++) {
            arr[low + x] = temp[x];
        }
    }
}