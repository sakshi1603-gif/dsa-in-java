// DP_Perfect Squares
// Success rate: 32.99%
// Given an integer n, find the minimum number of perfect square numbers whose sum equals n.

// A perfect square is an integer that is the square of another integer. For example, 1, 4, 9, and 16 are perfect squares, whereas 3 and 11 are not.

// Input Format:
// A single integer n.

// Output Format:
// A single integer representing the least number of perfect square numbers that sum to n.

// Constraints:
// 1 <= n <= 10^4

import java.util.*;

public class DP_Perfect_Squares {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;

        for(int i = 1; i <= n; i++){
            for(int j = 1; j * j <= i; j++){
                dp[i] = Math.min(dp[i], dp[i - j*j] + 1);
            }
        }

        System.out.println(dp[n]);
    }
}