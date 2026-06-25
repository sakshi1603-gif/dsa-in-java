// BITS1_SingleNumber2
// Success rate: 33.79%
// Given an integer array nums where every element appears exactly three times except for one element, which appears exactly once. Your task is to find and return the single element that appears only once.

// You must implement a solution with linear runtime complexity and use only constant extra space.

// Input Format:
// A single integer array nums.

// Output Format:
// An integer representing the single element that appears exactly once in the array

// Constraints:
// 1 <= nums.length <= 3 * 10^4
// -2^31 <= nums[i] <= 2^31 - 1
// Each element in nums appears exactly three times except for one element which appears once.
import java.util.*;

public class lect1_6_SingleNumber2 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int ans = SingleElement(n, arr);
        System.out.println(ans);
    }

    public static int SingleElement(int n, int[] arr) {
        int ans = 0;

        for (int i = 0; i < 32; i++) {
            int count = 0;

            for (int j = 0; j < n; j++) {
                if ((arr[j] & (1 << i)) != 0) {
                    count++;
                }
            }

            if (count % 3 != 0) {
                ans = ans | (1 << i);
            }
        }

        return ans;
    }
}