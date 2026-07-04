// LU: Maths(GCD)_ Delete to Maximize GCD
// Success rate: 35.71%
// Given an array arr[] of length N ≥ 2. The task is to remove an element from the given array such that the GCD of the array after removing it is maximized.

// Input Format:
// The first line contains the length of array N
// The second line contains N element representing the element of Array

// Output Format:
// The maximum Possible GCD after deleting 1 element

// Constraints:
// 1 <= N <= 10^4
// 1 <= arr[i] <= 10^9

// Sample test cases
import java.util.Scanner;

public class lect1_4_DeleteTOMaxGCD {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int ans = DeleteTOMax(arr);
        System.out.println(ans);
    }

    public static int DeleteTOMax(int[] arr) {
        int n = arr.length;

        // Edge case
        if (n == 1) {
            return 0;
        }

        int[] pgcd = Pgcd(arr);
        int[] sgcd = Sgcd(arr);

        int ans = 0;

        // Delete first element
        ans = sgcd[1];

        // Delete middle elements
        for (int i = 1; i < n - 1; i++) {
            int left = pgcd[i - 1];
            int right = sgcd[i + 1];
            ans = Math.max(ans, GCD(left, right));
        }

        // Delete last element
        ans = Math.max(ans, pgcd[n - 2]);

        return ans;
    }

    public static int[] Pgcd(int[] arr) {
        int n = arr.length;
        int[] pgcd = new int[n];

        pgcd[0] = arr[0];

        for (int i = 1; i < n; i++) {
            pgcd[i] = GCD(pgcd[i - 1], arr[i]);
        }

        return pgcd;
    }

    public static int[] Sgcd(int[] arr) {
        int n = arr.length;
        int[] sgcd = new int[n];

        sgcd[n - 1] = arr[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            sgcd[i] = GCD(sgcd[i + 1], arr[i]);
        }

        return sgcd;
    }

    public static int GCD(int a, int b) {
        if (a == 0) {
            return b;
        }
        return GCD(b % a, a);
    }
}