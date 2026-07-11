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
        int[] pf = PrefixSum(nums);

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int ans = 0;

        for (int ep = 0; ep < pf.length; ep++) {

            int need = pf[ep] - k;

            if (map.containsKey(need)) {
                ans += map.get(need);
            }

            map.put(pf[ep], map.getOrDefault(pf[ep], 0) + 1);
        }

        return ans;
    }

    public static int[] PrefixSum(int[] nums) {
        int[] pf = new int[nums.length];

        pf[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            pf[i] = pf[i - 1] + nums[i];
        }

        return pf;
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