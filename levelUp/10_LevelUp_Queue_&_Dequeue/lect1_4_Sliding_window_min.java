// LU: Dequeue_ Sliding window minimum
// Success rate: 46.94%
// Given an array of n integers, find the minimum element in each sliding window of size k. Return the list containing the minimum elements of each sliding window.

// Input Format:
// The first line contains an integer n, the size of the array.
// The second line contains n space-separated integers representing the elements of the array.
// The third line contains an integer k, the size of the sliding window.

// Output Format:
// Return a list containing the minimum element in each sliding window of size k.

// Constraints:
// 1 <= nums.length <= 10^5
// -10^4 <= nums[i] <= 10^4
// 1 <= k <= nums.length
import java.util.*;

public class lect1_4_Sliding_window_min {

    public static int[] minSlidingWindow(int[] nums, int k) {
        int n = nums.length;

        List<Integer> st = new ArrayList<>();
        Deque<Integer> dq = new ArrayDeque<>();

        // First window
        for (int i = 0; i < k; i++) {

            // Remove larger elements
            while (!dq.isEmpty() && nums[dq.getLast()] >= nums[i]) {
                dq.removeLast();
            }

            dq.addLast(i);
        }

        st.add(nums[dq.getFirst()]);

        // Remaining windows
        for (int i = k; i < n; i++) {

            // Remove elements outside the window
            if (!dq.isEmpty() && dq.getFirst() <= i - k) {
                dq.removeFirst();
            }

            // Remove larger elements
            while (!dq.isEmpty() && nums[dq.getLast()] >= nums[i]) {
                dq.removeLast();
            }

            dq.addLast(i);

            st.add(nums[dq.getFirst()]);
        }

        // Convert List to array
        int[] ans = new int[n - k + 1];

        int i = 0;
        for (int elem : st) {
            ans[i] = elem;
            i++;
        }

        return ans;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        int[] ans = minSlidingWindow(nums, k);

        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }

        sc.close();
    }
}