
// LU: BS_ Find Minimum in rotated sorted array 2
// Success rate: 67.86%
// Suppose an array of length n, sorted in ascending order, is rotated between 1 and n times. For example, the array nums = [0,1,4,4,5,6,7] might become:

// [4,5,6,7,0,1,4] if it was rotated 4 times.
// [0,1,4,4,5,6,7] if it was rotated 7 times.
// Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

// Given a sorted rotated array nums that may contain duplicates, return the minimum element of this array.

// You must write an algorithm that runs in O(log n) time.

// Input Format:
// The first line contains a single integer n denoting the number of elements in the array.
// The second line contains n space-separated integers denoting the elements of the array nums.

// Output Format:
// Print a single integer, which is the minimum element of the rotated array.

// Constraints:
// n == nums.length
// 1 <= n <= 5000
// -5000 <= nums[i] <= 5000
// nums is sorted and rotated between 1 and n times.
import java.util.*;

public class lect2_4_Find_Min_rotated_sorted_arr2 {

    public static int findMin(int[] nums) {

        int low = 0;
        int high = nums.length - 1;
        int ans = 0;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (nums[mid] == nums[low] && nums[mid] == nums[high]) {

                if (nums[mid] < nums[ans]) {
                    ans = mid;
                }

                low++;
                high--;

            } 
            else if (nums[mid] <= nums[high]) {

                if (nums[mid] < nums[ans]) {
                    ans = mid;
                }

                high = mid - 1;

            } 
            else {

                if (nums[low] < nums[ans]) {
                    ans = low;
                }

                low = mid + 1;
            }
        }

        return nums[ans];
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int result = findMin(nums);

        System.out.println(result);

        sc.close();
    }
}