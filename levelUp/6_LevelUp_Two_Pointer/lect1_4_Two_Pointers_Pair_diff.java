// LU: Two Pointers_Pair difference
// Success rate: 34.78%
// Given an array arr[] of size n and an integer x, return 1 if there exists a pair of elements in the array whose absolute difference is x. Otherwise, return -1.

// Input Format:
// An integer n representing the size of the array.
// An integer x representing the target absolute difference.
// An array arr[] of size n containing integers.

// Output Format:
// Return 1 if such a pair exists, otherwise return -1.

// Constraints:
// 1<=n<=10^6
// 1<=arr[i]<=10^6
// 0<=x<=10^5

// Sample test ca
import java.util.*;

public class lect1_4_Two_Pointers_Pair_diff {

    public static int pairDifference(int[] arr, int x) {

        Arrays.sort(arr);

        int i = 0;
        int j = 1;

        while (j < arr.length) {

            if (i == j) {
                j++;
                continue;
            }

            int diff = arr[j] - arr[i];

            if (diff == x)
                return 1;

            else if (diff < x)
                j++;

            else
                i++;
        }

        return -1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int x = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        System.out.println(pairDifference(arr, x));
    }
}