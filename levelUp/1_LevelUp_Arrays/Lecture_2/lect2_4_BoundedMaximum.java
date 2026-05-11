// Arrays2_BoundedMaximum
// Success rate: 33.61%
// Given an integer array nums and two integers left and right, return the number of contiguous non-empty subarrays such that the value of the maximum array element in that subarray is in the range [left, right].

// Input Format:
// The first line contains an integer n (length of the array nums).
// The second line contains n space-separated integers representing the elements of the array nums.
// The third line contains two space-separated integers left and right.

// Output Format:
// A single integer representing the number of contiguous non-empty subarrays where the value of the maximum array element in that subarray is in the range [left, right].

// Constraints:
// 1 <= nums.length <= 105
// 0 <= nums[i] <= 109
// 0 <= left <= right <= 109


import java.util.*;

public class lect2_4_BoundedMaximum {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int[] range = new int[2];

        for (int i = 0; i < 2; i++) {
            range[i] = scn.nextInt();
        }

        System.out.println(BoundedMaximum(n, arr, range));
    }

    public static int BoundedMaximum(int n, int[] arr, int[] range) {

        int left = range[0];
        int right = range[1];

        int ans = 0;

        int lgei = 0;
        int prevvalidcount = 0;

        for (int ep = 0; ep < n; ep++) {

            if (arr[ep] > right) {

                prevvalidcount = 0;
                lgei = ep + 1;

            } else if (arr[ep] >= left && arr[ep] <= right) {

                int currentValid = ep - lgei + 1;

                ans = ans + currentValid;

                prevvalidcount = currentValid;

            } else {

                ans = ans + prevvalidcount;
            }
        }

        return ans;
    }
}