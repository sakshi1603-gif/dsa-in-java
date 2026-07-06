// LU: Two Pointers_Two Sum
// Success rate: 19.73%
// Given an array of integers nums and an integer target, your task is to return the indices of the two numbers in the array that add up to the target value.

// You can assume that each input will have exactly one solution, and you cannot use the same element twice. The returned indices can be in any order.

// Input Format:
// An integer array nums of length n (1 ≤ n ≤ 10⁴).
// An integer target which is the sum to be found.

// Output Format:
// An integer array of size 2 containing the indices of the two numbers that add up to the target.

// Constraints:
// 2 <= nums.length <= 10^4
import java.util.*;

public class lect1_1_TwoPointers_TwoSum {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int k = scn.nextInt();

        int[] ans = TwoSum(arr, k);

        System.out.println(ans[0] + " " + ans[1]);
    }

    public static int[] TwoSum(int[] arr, int k) {

        int i = 0;
        int j = arr.length - 1;

        while (i < j) {
            int sum = arr[i] + arr[j];

            if (sum == k) {
                return new int[]{i, j}; 
            }
            else if (sum > k) {
                j--;
            }
            else {
                i++;
            }
        }

        return new int[]{-1, -1};
    }
}