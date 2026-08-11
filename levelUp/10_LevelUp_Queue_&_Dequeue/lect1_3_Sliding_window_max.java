// LU: Dequeue_ Sliding window maximum
// Success rate: 25.30%
// You are given an array of integers nums, and there is a sliding window of size k that moves from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

// Return an array representing the maximum value in each sliding window.

// Input Format:
// The first line contains an integer n, the size of the array nums.
// The second line contains n space-separated integers, representing the elements of the array nums.
// The third line contains an integer k, representing the size of the sliding window.

// Output Format:
// Output an array of integers, where each element is the maximum value in the current sliding window.

// Constraints:
// 1 <= nums.length <= 10^5
// -10^4 <= nums[i] <= 10^4
// 1 <= k <= nums.length
import java.util.*;

public class lect1_3_Sliding_window_max {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;

        List<Integer> st = new ArrayList<>();
        Deque<Integer> dq = new ArrayDeque<>();

        // First window
        for (int i = 0; i < k; i++) {

            while (!dq.isEmpty() && nums[dq.getLast()] <= nums[i]) {
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

            // Remove smaller elements
            while (!dq.isEmpty() && nums[dq.getLast()] <= nums[i]) {
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

        int[] ans = maxSlidingWindow(nums, k);

        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }

        sc.close();
    }
}