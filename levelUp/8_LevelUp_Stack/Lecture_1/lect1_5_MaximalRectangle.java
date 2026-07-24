//leetcode 85 Hard
import java.util.*;
public class lect1_5_MaximalRectangle {

    public static int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        int ans = 0;
        int[] arr = new int[col];

        for (int i = 0; i < row; i++) {

            // Build histogram
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1') {
                    arr[j]++;
                } else {
                    arr[j] = 0;
                }
            }

            ans = Math.max(ans, largestRectangleArea(arr));
        }

        return ans;
    }

    public static int largestRectangleArea(int[] arr) {
        int n = arr.length;
        int maxArea = 0;

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {

            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {

                int height = arr[st.pop()];

                int right = i - 1;
                int left = st.isEmpty() ? -1 : st.peek();

                int width = right - left;
                int area = height * width;

                maxArea = Math.max(maxArea, area);
            }

            st.push(i);
        }

        while (!st.isEmpty()) {

            int height = arr[st.pop()];

            int right = n - 1;
            int left = st.isEmpty() ? -1 : st.peek();

            int width = right - left;
            int area = height * width;

            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    public static void main(String[] args) {

        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };

        System.out.println("Maximum Rectangle Area = " + maximalRectangle(matrix));
    }
}