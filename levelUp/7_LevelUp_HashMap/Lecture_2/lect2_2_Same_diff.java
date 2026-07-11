// LU: Hashmap 2_Same Differences
// Success rate: 57.78%
// You are given an array a of n integers. Count the number of pairs of indices (i, j) such that i < j and a[j] - a[i] = j - i.

// Input Format:
// The first line contains one integer t (1 ≤ t ≤ 10^4) — the number of test cases.
// For each test case:
// The first line contains one integer n (1 ≤ n ≤ 2 × 10^5) — the size of the array.
// The second line contains n integers a1, a2, ..., an (1 ≤ ai ≤ n) — the elements of the array.

// Output Format:
// For each test case, output a single integer — the number of pairs (i, j) such that i < j and a[j] - a[i] = j - i.

// Constraints:
// The sum of n over all test cases does not exceed 2 × 10^5.
import java.util.*;

public class lect2_2_Same_diff {

    public static long SameDifferences(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        long ans = 0;

        for (int i = 0; i < nums.length; i++) {

            int key = nums[i] - i;

            if (map.containsKey(key)) {
                ans += map.get(key);
            }

            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        return ans;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {

            int n = sc.nextInt();

            int[] nums = new int[n];

            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }

            System.out.println(SameDifferences(nums));
        }

        sc.close();
    }
}