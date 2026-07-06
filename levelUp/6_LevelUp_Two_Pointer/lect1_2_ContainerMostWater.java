// LU: Two Pointers_Container with most water
// Success rate: 48.72%
// You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the i-th line are (i, 0) and (i, height[i]).

// Find two lines that, together with the x-axis, form a container, such that the container can store the maximum amount of water.
// Input Format:
// An integer array height of length n.
// Output Format:
// Return the maximum amount of water a container can store.
// Constraints:
// n == height.length
// 2 <= n <= 10^5
// 0 <= height[i] <= 10^4
import java.util.*;

public class lect1_2_ContainerMostWater {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] height = new int[n];
        for (int i = 0; i < n; i++) {
            height[i] = scn.nextInt();
        }
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int ans = 0;
        while (i < j) {
            int weight = (j - i) * (Math.min(height[i], height[j]));
            ans = Math.max(ans, weight);
            if (height[i] <= height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return ans;
    }
}
