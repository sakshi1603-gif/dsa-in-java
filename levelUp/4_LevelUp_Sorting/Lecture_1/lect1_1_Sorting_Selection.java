// LU: Sorting_Selection Sort
// Success rate: 37.21%
// Given N array Integers, Sort the array using Selection sort technique

// Input Format:
// Integer representing N representing length of array
// N numbers of Array

// Output Format:
// Print the sorted array in a line separated by space

// Constraints:
// 1<= N <= 10 ^ 6
// 1<= A[i] <=10 ^ 9
import java.util.*;

public class lect1_1_Sorting_Selection {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        selectionSort(arr);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void selectionSort(int[] arr) {

        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {

            int minIndex = i;

            for (int j = i + 1; j < n; j++) {

                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }

            }

            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
}