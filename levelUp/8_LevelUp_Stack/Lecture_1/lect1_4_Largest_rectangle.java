// LU: Stacks_ Largest rectangle in a histogram
// Success rate: 22.14%
// Given an array of integers heights representing the heights of bars in a histogram, where the width of each bar is 1, the task is to find and return the area of the largest rectangle that can be formed within the histogram.

// Input Format:
// The first line contains an integer n, the number of bars in the histogram.
// The second line contains n space-separated integers representing the heights of the bars in the histogram.

// Output Format:
// Output a single integer representing the area of the largest rectangle that can be formed in the histogram.

// Constraints:
// 1 <= heights.length <= 105
// 0 <= heights[i] <= 104
import java.util.*;
public class lect1_4_Largest_rectangle {
	public static void main(String[] args) {
		Scanner scn  = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++){
			arr[i]=scn.nextInt();
		}
		System.out.println(largestRectangleArea(arr));
	}
	public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            while (st.size() > 0 && heights[st.peek()] >= heights[i]) {
                int hght = st.pop();
                int right = i - 1;
                int left = 0;
                if (st.size() != 0) {
                    left = st.peek() + 1;
                }
                int width = right - left + 1;
                int area = heights[hght] * width;
                ans = Math.max(ans, area);
            }
            st.push(i);
        }
        while (st.size() > 0) {
            int hght = st.pop();
            int left = 0;
            if (st.size() > 0) {
                left = st.peek() + 1;
            }
            int right = n - 1;
            int width = right - left + 1;
            int area = heights[hght] * width;
            ans = Math.max(ans, area);
        }
        return ans;
    }
}