// Graphs_ Rotting oranges
// Success rate: 26.36%
// You are given a grid of size m x n where each cell can have one of the following three values:

// 0: Represents an empty cell.
// 1: Represents a fresh orange.
// 2: Represents a rotten orange.
// Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

// Return the minimum number of minutes required until no cell contains a fresh orange. If it is impossible to rot all the fresh oranges, return -1.

// Input Format:
// The first line contains two integers, m and n, representing the number of rows and columns in the grid, respectively.
// The next m lines each contain n integers, representing the state of each cell in the grid (0, 1, or 2).

// Output Format:
// An integer representing the minimum number of minutes required to rot all fresh oranges, or -1 if it is impossible.

// Constraints:
// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 10
// grid[i][j] is 0, 1, or 2.
import java.util.*;

class Pair {
    int i;
    int j;
    int t;

    Pair(int i, int j, int t) {
        this.i = i;
        this.j = j;
        this.t = t;
    }
}

public class Graphs_Rotting_oranges {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int m = scn.nextInt();

        int[][] mat = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = scn.nextInt();   // FIXED
            }
        }

        int result = RottenOranges(n, m, mat);   // FIXED
        System.out.println(result);
    }

    public static int RottenOranges(int n, int m, int[][] mat) {  // FIXED
        Queue<Pair> q = new LinkedList<>();   // FIXED

        // Add all rotten oranges initially
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 2) {
                    q.add(new Pair(i, j, 0));   // FIXED
                }
            }
        }

        int ans = 0;

        while (!q.isEmpty()) {
            Pair rem = q.remove();

            int crow = rem.i;
            int ccol = rem.j;
            int ctime = rem.t;

            ans = ctime;

            // UP
            if (crow - 1 >= 0 && mat[crow - 1][ccol] == 1) {
                q.add(new Pair(crow - 1, ccol, ctime + 1));
                mat[crow - 1][ccol] = 2;
            }

            // DOWN
            if (crow + 1 < n && mat[crow + 1][ccol] == 1) {
                q.add(new Pair(crow + 1, ccol, ctime + 1));
                mat[crow + 1][ccol] = 2;
            }

            // LEFT
            if (ccol - 1 >= 0 && mat[crow][ccol - 1] == 1) {
                q.add(new Pair(crow, ccol - 1, ctime + 1));
                mat[crow][ccol - 1] = 2;
            }

            // RIGHT
            if (ccol + 1 < m && mat[crow][ccol + 1] == 1) {
                q.add(new Pair(crow, ccol + 1, ctime + 1));
                mat[crow][ccol + 1] = 2;
            }
        }

        // Check if any fresh orange remains
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) {
                    return -1;
                }
            }
        }

        return ans;
    }
}