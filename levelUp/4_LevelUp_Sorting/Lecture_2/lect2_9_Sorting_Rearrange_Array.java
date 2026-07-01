// LU: Sorting_Rearrange Array
// Success rate: 41.74%
// Given N elements, Rearrange the array so that

// a) arr[0] should go to correct sorted position
// b) all elements <=arr[0] should go to leftside of arr[0]
// c) all elements >arr[0] should go to rightside of arr[0]

// Input Format:
// The first line contains integer n representing the size of array
// The second line contains n elements of array.

// Output Format:
// Print the array after rearranging.

// Constraints:
// 1<= N <= 10 ^ 6
// 1<= A[i] <=10 ^ 9
import java.util.*;

public class lect2_9_Sorting_Rearrange_Array {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        Sorting_Rearrange(arr);

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]);
            if (i != n - 1) {
                System.out.print(" ");
            }
        }

        scn.close();
    }
    public static void Sorting_Rearrange(int[] arr) {
        int pivot = arr[0];
        int p1 = 1;
        int p2 = arr.length - 1;

        while (p1 <= p2) {
            if (arr[p1] <= pivot) {
                p1++;
            } else if (arr[p2] > pivot) {
                p2--;
            } else {
                int temp = arr[p1];
                arr[p1] = arr[p2];
                arr[p2] = temp;
                p1++;
                p2--;
            }
        }

        arr[0] = arr[p2];
        arr[p2] = pivot;
    }

}