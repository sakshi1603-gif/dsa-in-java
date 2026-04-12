// DP_Cherry Pickup
// Success rate: 30.72%
// You are given an n x n grid representing a field of cherries, where each cell contains one of three possible values:

// 0: The cell is empty, and you can pass through.
// 1: The cell contains a cherry that you can pick up and pass through.
// -1: The cell contains a thorn that blocks your way.
// Your goal is to collect the maximum number of cherries by following these rules:

// Start at the top-left corner of the grid (0, 0) and reach the bottom-right corner (n - 1, n - 1) by only moving right or down through valid cells (cells with values 0 or 1).
// After reaching (n - 1, n - 1), return to (0, 0) by moving left or up through valid cells.
// When passing through a cell with a cherry (1), you pick it up, and the cell becomes empty (0).
// If there is no valid path from (0, 0) to (n - 1, n - 1), then no cherries can be collected.

// Input Format:
// A 2D integer array grid of size n x n where grid[i][j] represents the value at cell (i, j).

// Output Format:
// A single integer representing the maximum number of cherries that can be collected.

// Constraints:
// n == grid.length
// n == grid[i].length
// 1 <= n <= 50
// grid[i][j] is -1, 0, or 1.
// grid[0][0] != -1
// grid[n - 1][n - 1] != -1

import java.util.*;

public class DP_Cherry_Pickup {

    static int n;
    static int[][] grid;
    static int[][][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        grid = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                grid[i][j] = sc.nextInt();
            }
        }

        dp = new int[n][n][n];

        // initialize dp with -1
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }

        int result = solve(n-1, n-1, n-1);
        System.out.println(Math.max(0, result));
    }

    static int solve(int r1, int c1, int r2) {

        int c2 = r1 + c1 - r2;

        // boundary check
        if(r1 < 0 || c1 < 0 || r2 < 0 || c2 < 0 || c2 >= n)
            return Integer.MIN_VALUE;

        // thorn check
        if(grid[r1][c1] == -1 || grid[r2][c2] == -1)
            return Integer.MIN_VALUE;

        // base case
        if(r1 == 0 && c1 == 0)
            return grid[0][0];

        if(dp[r1][c1][r2] != -1)
            return dp[r1][c1][r2];

        int w = solve(r1-1, c1, r2-1); // up, up
        int x = solve(r1, c1-1, r2);   // left, left
        int y = solve(r1, c1-1, r2-1); // left, up
        int z = solve(r1-1, c1, r2);   // up, left

        int best = Math.max(Math.max(w, x), Math.max(y, z));

        if(best == Integer.MIN_VALUE)
            return dp[r1][c1][r2] = Integer.MIN_VALUE;

        int cherries;

        if(r1 == r2 && c1 == c2)
            cherries = grid[r1][c1];
        else
            cherries = grid[r1][c1] + grid[r2][c2];

        dp[r1][c1][r2] = best + cherries;
        return dp[r1][c1][r2];
    }
}
