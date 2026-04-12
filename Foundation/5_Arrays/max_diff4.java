// Given n length array "arr". Find (i,j) with maximum value of (abs(arr[i] - arr[j]) + i - j). 
//You need to print max value of (abs(arr[i] - arr[j]) + i - j) possible and not the (i,j) itself.

// Note 1: abs represents the postive part only. ex: abs(8) = 8 and abs(-8) = 8.

// Note 2: Doing it by checking all the possible pairs. Works but can you do something smart?

// Input Format:
// Each of the test cases have 2 lines.
// The First line contains the size of the array n.
// The second line contains the n elements of the array.

// Output Format:
// Print the maximum value of (abs(arr[i] - arr[j]) + i - j) Possible.


import java.util.Scanner;

public class max_diff4 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int result = findMaxValue(arr);
        System.out.println(result);
    }

    public static int findMaxValue(int[] arr) {
        int n = arr.length;

        int max1 = Integer.MIN_VALUE, min1 = Integer.MAX_VALUE;
        int max2 = Integer.MIN_VALUE, min2 = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            max1 = Math.max(max1, arr[i] + i);
            min1 = Math.min(min1, arr[i] + i);

            max2 = Math.max(max2, arr[i] - i);
            min2 = Math.min(min2, arr[i] - i);
        }

        return Math.max(max1 - min1, max2 - min2);
    }
}
