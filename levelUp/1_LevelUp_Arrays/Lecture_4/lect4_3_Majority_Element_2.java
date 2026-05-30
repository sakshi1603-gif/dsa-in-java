// Arrays4_Majority Element 2
// Success rate: 18.87%
// Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

// Input Format:
// An integer n representing the size of the array.
// An array of integers nums of size n.

// Output Format:
// A list of integers representing the elements that appear more than ⌊ n/3 ⌋ times.

// Constraints:
// 1 <= nums.length <= 5 * 104
// -109 <= nums[i] <= 109
import java.util.*;

public class lect4_3_Majority_Element_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int count1 = 0, count2 = 0;
        int val1 = 0, val2 = 0;

        // Boyer-Moore Voting Algorithm
        for (int num : nums) {
            if (num == val1) {
                count1++;
            } else if (num == val2) {
                count2++;
            } else if (count1 == 0) {
                val1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                val2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        // Verify candidates
        count1 = 0;
        count2 = 0;

        for (int num : nums) {
            if (num == val1) {
                count1++;
            } else if (num == val2) {
                count2++;
            }
        }

        if (count1 > n / 3) {
            System.out.print(val1 + " ");
        }

        if (count2 > n / 3) {
            System.out.print(val2 + " ");
        }
    }
}