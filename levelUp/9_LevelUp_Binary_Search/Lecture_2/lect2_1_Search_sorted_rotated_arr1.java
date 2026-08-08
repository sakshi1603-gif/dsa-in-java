// LU: BS_ Search in sorted rotated array 1
// Success rate: 53.33%
// You are given an integer array nums sorted in ascending order with distinct values. The array may have been rotated at an unknown pivot index such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] where 0 <= k < nums.length. Given this rotated array and an integer target, your task is to find the index of target in nums. If target is not found, return -1.
// Your solution must have a time complexity of O(log n).

// Input format:
// The first line contains an integer n representing the size of the array.
// The second line contains n space-separated integers representing the array nums.
// The third line contains an integer target.

// Output format:
// Return the index of the target if it is in the array; otherwise, return -1.

// Constraints:
// 1 <= nums.length <= 5000
// -10^4 <= nums[i] <= 10^4
// All values of nums are unique.
// nums is an ascending array that is possibly rotated.
// -10^4 <= target <= 10^4
import java.util.*;

public class lect2_1_Search_sorted_rotated_arr1 {

    public static int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // Left half is sorted
            if (nums[low] <= nums[mid]) {

                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }

            } 
            // Right half is sorted
            else {

                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input:
        // n
        // array elements
        // target

        int n = sc.nextInt();

        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int target = sc.nextInt();

        int result = search(nums, target);

        System.out.println(result);

        sc.close();
    }
}