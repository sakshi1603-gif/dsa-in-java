// LU: Hashmap 1_Longest Consecutive Sequence
// Success rate: 38.71%
// Given an unsorted array of integers nums, return the length of the longest sequence of consecutive elements. The algorithm must run in O(n) time.

// Input Format:
// An integer array nums representing the unsorted elements.

// Output Format:
// An integer representing the length of the longest consecutive sequence.

// Constraints:
// 0 <= nums.length <= 10^5
// -10^9 <= nums[i] <= 10^9
import java.util.*;

public class lect1_3_LongestConsecutiveSequence{

    public static int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int maxLen = 0;

        for (int num : nums) {

            if (!hm.containsKey(num)) {

                int start = num;
                int end = num;

                if (hm.containsKey(num - 1)) {
                    start = num - hm.get(num - 1);
                }

                if (hm.containsKey(num + 1)) {
                    end = num + hm.get(num + 1);
                }

                int length = end - start + 1;

                hm.put(start, length);
                hm.put(end, length);

                if (start != num && end != num) {
                    hm.put(num, 1);
                }

                maxLen = Math.max(maxLen, length);
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Output
        System.out.println(longestConsecutive(nums));

        sc.close();
    }
}