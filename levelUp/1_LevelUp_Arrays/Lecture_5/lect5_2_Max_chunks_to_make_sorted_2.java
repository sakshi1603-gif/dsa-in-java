// Arrays5_Max chunks to make sorted 2
// Success rate: 35.22%
// You are given an integer array arr.
// We need to split arr into the maximum number of chunks (i.e., partitions) such that, when each chunk is individually sorted and then concatenated, the result matches the sorted version of the entire array.

// Return the largest number of chunks we can create to achieve this.

// Input Format:
// The first line contains an integer n, the length of the array arr.
// The second line contains n space-separated integers representing the array arr.

// Output Format:
// Output a single integer, the largest number of chunks that can be created to sort the array.

// Constraints:
// 1 <= arr.length <= 2000
// 0 <= arr[i] <= 10^8
import java.util.*;

class Solution {

    public int maxChunksToSorted(int[] arr) {

        int n = arr.length;

        int[] prefixMax = prefix(arr, n);
        int[] suffixMin = suffix(arr, n);

        int count = 0;

        for (int i = 0; i < n - 1; i++) {

            if (prefixMax[i] <= suffixMin[i + 1]) {
                count++;
            }
        }

        return count + 1;
    }

    public int[] prefix(int[] arr, int n) {

        int[] prefixMax = new int[n];

        prefixMax[0] = arr[0];

        for (int i = 1; i < n; i++) {
            prefixMax[i] = Math.max(prefixMax[i - 1], arr[i]);
        }

        return prefixMax;
    }

    public int[] suffix(int[] arr, int n) {

        int[] suffixMin = new int[n];

        suffixMin[n - 1] = arr[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            suffixMin[i] = Math.min(suffixMin[i + 1], arr[i]);
        }

        return suffixMin;
    }
}

public class lect5_2_Max_chunks_to_make_sorted_2 {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        Solution obj = new Solution();

        System.out.println(obj.maxChunksToSorted(arr));
    }
}