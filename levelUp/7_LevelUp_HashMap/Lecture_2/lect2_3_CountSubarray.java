// LU: Hashmap 2_Subarray with equal 0 and 1
// Success rate: 54.35%
// Given an array containing 0s and 1s, find the number of subarrays that have an equal number of 0s and 1s.

// Input Format:
// The first line contains a single integer n (1 ≤ n ≤ 10^5), the length of the array.
// The second line contains n integers, each either 0 or 1, representing the elements of the array.

// Output Format:
// Print a single integer representing the number of subarrays with an equal number of 0s and 1s.

// Constraints:
// 1 <= n <= 10^6
// 0 <= A[i] <= 1
import java.util.*;

public class lect2_3_CountSubarray {

    public static long countSubarrays(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);

        int sum = 0;
        long ans = 0;

        for (int num : nums) {

            if (num == 0)
                sum--;
            else
                sum++;

            ans += map.getOrDefault(sum, 0);

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] nums = new int[n];

        for (int i = 0; i < n; i++)
            nums[i] = sc.nextInt();

        System.out.println(countSubarrays(nums));

        sc.close();
    }
}