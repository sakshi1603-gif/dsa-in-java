// LU: Maths(GCD)_ Number of Subarrays With GCD Equal to K
// Success rate: 39.39%
// Given an integer array nums and an integer k, return the number of subarrays within nums where the greatest common divisor (GCD) of the subarray's elements is k.

// A subarray is a contiguous, non-empty sequence of elements within an array.

// Input Format:
// The first line contains two integers n and k where n is the size of the array.
// The second line contains n space-separated integers representing the array nums.

// Output Format:
// Print a single integer representing the number of subarrays whose elements have a GCD equal to k.

// Constraints:
// 1 <= nums.length <= 1000
// 1 <= nums[i], k <= 10^9
import java.util.Scanner;

public class lect1_5_Number_of_Subarrays {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int k = scn.nextInt();

        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = scn.nextInt();
        }

        int ans = subarrayGCD(nums, k);
        System.out.println(ans);
    }

    public static int subarrayGCD(int[] nums, int k) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            int gcd = 0;

            for (int j = i; j < nums.length; j++) {
                gcd = GCD(gcd, nums[j]);

                if (gcd < k)
                    break;

                if (gcd == k)
                    count++;
            }
        }

        return count;
    }

    public static int GCD(int a, int b) {
        if (b == 0)
            return a;
        return GCD(b, a % b);
    }
}