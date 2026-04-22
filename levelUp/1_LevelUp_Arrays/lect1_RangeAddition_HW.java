import java.util.*;


// 🧩 Problem: Range Addition

// You are given an integer n, representing the size of an array initialized with all zeros.

// You are also given a list of k updates. Each update is represented as an array of 3 integers:

// [startIndex, endIndex, increment]
// 📌 Task:

// For each update:

// Add increment to every element in the array from index startIndex to endIndex (inclusive).

// Return the final modified array after all updates are applied.


public class lect1_RangeAddition_HW {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt(); // size of array
        int k = scn.nextInt(); // number of updates

        int[][] updates = new int[k][3];

        // Read updates: [start, end, increment]
        for (int i = 0; i < k; i++) {
            updates[i][0] = scn.nextInt();
            updates[i][1] = scn.nextInt();
            updates[i][2] = scn.nextInt();
        }

        int[] result = applyRangeAddition(n, updates);

        // Print final array
        for (int val : result) {
            System.out.println(val);
        }

        scn.close();
    }

    /**
     * Applies range updates using Difference Array technique.
     * Time Complexity: O(n + k)
     */
    public static int[] applyRangeAddition(int n, int[][] updates) {

        int[] diff = new int[n];

        // Step 1: Apply updates in O(1)
        for (int[] update : updates) {
            int start = update[0];
            int end = update[1];
            int increment = update[2];

            diff[start] += increment;

            if (end + 1 < n) {
                diff[end + 1] -= increment;
            }
        }

        // Step 2: Build final array using prefix sum
        int[] result = new int[n];
        result[0] = diff[0];

        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] + diff[i];
        }

        return result;
    }
}