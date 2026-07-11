// LU: Hashmap 2_Subarray sum equals k
// Success rate: 45.65%
// Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals k.

// A subarray is a contiguous non-empty sequence of elements within an array.

// Input Format:
// The first line contains an integer n, the number of elements in the array.
// The second line contains n integers, the elements of the array.
// The third line contains an integer k, the target sum for the subarrays.

// Output Format:
// Print a single integer representing the total number of subarrays whose sum equals k.

// Constraints:
// 1 <= nums.length <= 2 * 10^4
// -1000 <= nums[i] <= 1000
// -10^7 <= k <= 10^7
import java.util.*;

public class lect2_1_SubarraySum  {

    public static int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int prefixSum = 0;
        int count = 0;

        for (int num : nums) {
            prefixSum += num;

            count += map.getOrDefault(prefixSum - k, 0);

            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        System.out.println(subarraySum(nums, k));

        sc.close();
    }
}