// LU: BS_ Median of two sorted Arrays
// Success rate: 28.81%
// Given two sorted arrays nums1 and nums2 of sizes m and n respectively, find and return the median of the two sorted arrays. The overall runtime complexity of your solution should be O(log(m+n)).

// Input Format:
// The first line contains an integer m — the size of the first array nums1.
// The second line contains m space-separated integers representing the elements of nums1.
// The third line contains an integer n — the size of the second array nums2.
// The fourth line contains n space-separated integers representing the elements of nums2.

// Output Format:
// Output a single floating-point number representing the median of the two sorted arrays.

// Constraints:
// nums1.length == m
// nums2.length == n
// 0 <= m <= 1000
// 0 <= n <= 1000
// 1 <= m + n <= 2000
// -106 <= nums1[i], nums2[i] <= 106
import java.util.*;

public class lect3_3_Median_of_two_sorted_Arrays {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int length1 = nums1.length;
        int length2 = nums2.length;

        if (length1 > length2) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int totalLength = length1 + length2;

        int low = 0;
        int high = length1;

        while (low <= high) {

            int partition1 = low + (high - low) / 2;
            int partition2 = (totalLength + 1) / 2 - partition1;

            int right1 = (partition1 == length1) ? Integer.MAX_VALUE : nums1[partition1];
            int right2 = (partition2 == length2) ? Integer.MAX_VALUE : nums2[partition2];
            int left1 = (partition1 == 0) ? Integer.MIN_VALUE : nums1[partition1 - 1];
            int left2 = (partition2 == 0) ? Integer.MIN_VALUE : nums2[partition2 - 1];

            if (left1 <= right2 && left2 <= right1) {

                if (totalLength % 2 == 0) {
                    double leftMax = Math.max(left1, left2);
                    double rightMin = Math.min(right1, right2);

                    return (leftMax + rightMin) / 2.0;
                }

                return Math.max(left1, left2);
            }

            else if (left2 > right1) {
                low = partition1 + 1;
            }

            else {
                high = partition1 - 1;
            }
        }

        return 0.0;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums1 = new int[n];

        for (int i = 0; i < n; i++) {
            nums1[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] nums2 = new int[m];

        for (int i = 0; i < m; i++) {
            nums2[i] = sc.nextInt();
        }

        double ans = findMedianSortedArrays(nums1, nums2);

        System.out.println(ans);

        sc.close();
    }
}