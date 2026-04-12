// DP_Fibonacci Number
// Success rate: 20.75%
// The Fibonacci numbers, represented as F(n), form a sequence known as the Fibonacci sequence. In this sequence, each number is the sum of the two preceding ones, beginning with 0 and 1. Specifically:

// F(0) = 0
// F(1) = 1
// F(n) = F(n - 1) + F(n - 2) for n > 1
// Given an integer n, calculate the value of F(n).

// Input Format:
// A single integer n.

// Output Format:
// A single integer representing F(n).

// Constraints:
// 0 <= n <= 30
import java.util.Arrays;
import java.util.Scanner;

public class DP_Fibonacci_Number {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        System.out.println(Dp_fibonacci_no(n, dp));
    }

    public static int Dp_fibonacci_no(int n, int[] dp) {
        if (n == 0 || n == 1) {
            return n;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        int x = Dp_fibonacci_no(n - 1, dp);
        int y = Dp_fibonacci_no(n - 2, dp);

        dp[n] = x + y;
        return dp[n];
    }
}
