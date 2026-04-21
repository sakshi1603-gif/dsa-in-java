
import java.util.*;

// Arrays1_Equilibrium Index
// Success rate: 22.36%
// Given an array of integers nums, calculate the pivot index of this array.

// The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to the sum of all the numbers strictly to the right of the index.

// If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left. This also applies to the right edge of the array.

// Return the leftmost pivot index. If no such index exists, return -1.

// Input Format:
// An integer n representing the number of elements in the array.
// n integers representing the elements of the array.

// Output Format:
// An integer representing the leftmost pivot index or -1 if no such index exists.

// Constraints:
// 1 <= nums.length <= 104
// -1000 <= nums[i] <= 1000

class Arrays1_Equilibrium_Index_3 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // Read size of array
        int n = scn.nextInt();
        int[] arr = new int[n];

        // Input array elements
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        // Print pivot index
        System.out.println(pivotIndex(arr, n));
    }

    // Function to find pivot index
    public static int pivotIndex(int[] arr, int n) {

        // Edge case: single element is always pivot
        if (n == 1) return 0;

        // Generate prefix sum array
        int[] pf = prefixsum(arr, n);

        int index = -1; // default if no pivot found

        // Check for pivot in middle elements
        for (int i = 1; i < n - 1; i++) {

            // Sum of elements before index i
            int left = pf[i - 1];

            // Sum of elements after index i
            int right = pf[n - 1] - pf[i];

            // If both sides are equal → pivot found
            if (left == right) {
                index = i;
            }
        }

        // Check if first index is pivot (left = 0)
        if (pf[n - 1] - pf[0] == 0) {
            index = 0;
        }

        // Check if last index is pivot (right = 0)
        if (pf[n - 2] == 0) {
            index = n - 1;
        }

        return index;
    }

    // Function to compute prefix sum array
    public static int[] prefixsum(int[] arr, int n) {

        int[] pf = new int[n];

        // First element remains same
        pf[0] = arr[0];

        // Build prefix sum array
        for (int i = 1; i < n; i++) {
            pf[i] = pf[i - 1] + arr[i];
        }

        return pf;
    }
}

//google level 
// 👉 Key idea:

// Total sum of array
// Keep running left sum
// Compute right sum on the fly
// import java.util.*;

// public class Main {
//     public static void main(String[] args) {
//         Scanner scn = new Scanner(System.in);

//         int n = scn.nextInt();
//         int[] arr = new int[n];

//         for (int i = 0; i < n; i++) {
//             arr[i] = scn.nextInt();
//         }

//         System.out.println(pivotIndex(arr));
//     }

//     // Optimal O(n) time, O(1) space solution
//     public static int pivotIndex(int[] arr) {

//         int totalSum = 0;

//         // Step 1: Calculate total sum of array
//         for (int num : arr) {
//             totalSum += num;
//         }

//         int leftSum = 0;

//         // Step 2: Traverse and check pivot
//         for (int i = 0; i < arr.length; i++) {

//             // right sum = total - left - current element
//             int rightSum = totalSum - leftSum - arr[i];

//             // Check pivot condition
//             if (leftSum == rightSum) {
//                 return i; // return immediately (clean & efficient)
//             }

//             // Update left sum
//             leftSum += arr[i];
//         }

//         // No pivot found
//         return -1;
//     }
// }