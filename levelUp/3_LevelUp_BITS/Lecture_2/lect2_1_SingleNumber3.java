// BITS 2_SingleNumber3
// Success rate: 21.67%
// Given an integer array nums where exactly two elements appear only once and all other elements appear exactly twice. Your task is to find and return the two elements that appear only once. The order of the elements in the output does not matter.

// You must write an algorithm that runs in linear runtime complexity and uses only constant extra space.

// Input Format:
// A single integer array nums with the constraint that exactly two elements appear once, and all other elements appear exactly twice.

// Output Format:
// An integer array containing the two elements that appear only once.

// Constraints:
// 2 <= nums.length <= 3 * 10^4
// -2^31 <= nums[i] <= 2^31 - 1
// Each integer in nums will appear twice, only two integers will appear once.
import java.util.*;

public class lect2_1_SingleNumber3 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int[] ans = SingleElement(n, arr);

        System.out.println(ans[0] + " " + ans[1]);
    }

    public static int[] SingleElement(int n, int[] arr) {
        // Step 1: XOR of all elements
        int val = 0;
        for (int i = 0; i < n; i++) {
            val ^= arr[i];
        }

        // Step 2: find first set bit in val
        int idx = 0;
        for (int i = 0; i < 32; i++) {
            if ((val & (1 << i)) != 0) {
                idx = i;
                break;
            }
        }

        // Step 3: divide into 2 sets and XOR separately
        int set1 = 0;
        int set2 = 0;

        for (int i = 0; i < n; i++) {
            if ((arr[i] & (1 << idx)) != 0) {
                set1 ^= arr[i];
            } else {
                set2 ^= arr[i];
            }
        }

        return new int[]{set1, set2};
    }
}