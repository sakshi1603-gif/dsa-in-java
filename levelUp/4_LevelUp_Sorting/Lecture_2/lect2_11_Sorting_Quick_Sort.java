// LU: Sorting_Quick Sort
// Success rate: 36.71%
// Quick Sort is a Divide and Conquer algorithm that selects a pivot element and partitions the given array around the chosen pivot. The goal is to sort the array using the Quick Sort algorithm.

// Given an array arr[], where the starting position is low (the index of the first element) and the ending position is high (the index of the last element), implement the Quick Sort algorithm to sort the array.

// Input Format:
// The first line contains an integer N, representing the size of the array.
// The second line contains N space-separated integers representing the elements of the array.

// Output Format:
// Print the sorted array as a single line of space-separated integers.

// Constraints:
// 1 <= N <= 10^3
// 1 <= arr[i] <= 10^4
import java.util.*;

public class lect2_11_Sorting_Quick_Sort {

    static Random rand = new Random();

    public static void quickSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }

        int pivotIndex = partition(arr, low, high);

        quickSort(arr, low, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, high);
    }

    public static int partition(int[] arr, int low, int high) {

        // Choose a random pivot
        int randomIndex = low + rand.nextInt(high - low + 1);
        swap(arr, low, randomIndex);

        int pivot = arr[low];
        int left = low + 1;
        int right = high;

        while (left <= right) {

            while (left <= right && arr[left] <= pivot) {
                left++;
            }

            while (left <= right && arr[right] > pivot) {
                right--;
            }

            if (left < right) {
                swap(arr, left, right);
            }
        }

        swap(arr, low, right);

        return right;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        quickSort(arr, 0, n - 1);

        for (int num : arr) {
            System.out.print(num + " ");
        }

        sc.close();
    }
}