// LU: Hashmap 1_Grid Illumination
// Success rate: 34.72%
// You are given a 2D grid of size n x n, where each cell has a lamp that is initially turned off. A 2D array lamps is provided where lamps[i] = [rowi, coli] indicates that the lamp at grid[rowi][coli] is turned on. When a lamp is turned on, it illuminates its cell and all cells in the same row, column, or diagonal.

// Another 2D array queries is provided where queries[j] = [rowj, colj]. For each query, determine if the cell grid[rowj][colj] is illuminated. After answering the query, turn off the lamp at grid[rowj][colj] and its 8 adjacent lamps if they exist.

// Return an array ans where ans[j] is 1 if the cell in the j-th query was illuminated, and 0 if it was not.

// Input Format:
// n (int): The size of the grid.
// lamps (2D array of integers): Array where each element is [rowi, coli], representing the positions of the lamps.
// queries (2D array of integers): Array where each element is [rowj, colj], representing the positions for the queries.

// Output Format:
// An array of integers ans, where each element ans[j] is 1 if the cell in the j-th query was illuminated, otherwise 0.

// Constraints:
// 1 <= n <= 109
// 0 <= lamps.length <= 20000
// 0 <= queries.length <= 20000
// lamps[i].length == 2
// 0 <= rowi, coli < n
// queries[j].length == 2
// 0 <= rowj, colj < n

import java.util.*;

public class lect1_1_GridIllumination {

    public static int[] gridIllumination(int n, int[][] lamps, int[][] queries) {

        HashMap<Integer, Integer> rows = new HashMap<>();
        HashMap<Integer, Integer> cols = new HashMap<>();
        HashMap<Integer, Integer> diag = new HashMap<>();
        HashMap<Integer, Integer> antiDiag = new HashMap<>();
        HashMap<Long, Integer> lampMap = new HashMap<>();

        // Store all lamps
        for (int[] lamp : lamps) {
            int x = lamp[0];
            int y = lamp[1];

            long key = (long) x * n + y;

            if (lampMap.containsKey(key))
                continue;

            lampMap.put(key, 1);

            rows.put(x, rows.getOrDefault(x, 0) + 1);
            cols.put(y, cols.getOrDefault(y, 0) + 1);
            diag.put(x - y, diag.getOrDefault(x - y, 0) + 1);
            antiDiag.put(x + y, antiDiag.getOrDefault(x + y, 0) + 1);
        }

        int[][] dirs = {
                {-1,-1}, {-1,0}, {-1,1},
                {0,-1}, {0,0}, {0,1},
                {1,-1}, {1,0}, {1,1}
        };

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int x = queries[i][0];
            int y = queries[i][1];

            if (rows.getOrDefault(x, 0) > 0 ||
                cols.getOrDefault(y, 0) > 0 ||
                diag.getOrDefault(x - y, 0) > 0 ||
                antiDiag.getOrDefault(x + y, 0) > 0) {

                ans[i] = 1;
            }

            // Turn off lamps in 3x3 area
            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n)
                    continue;

                long key = (long) nx * n + ny;

                if (!lampMap.containsKey(key))
                    continue;

                lampMap.remove(key);

                rows.put(nx, rows.get(nx) - 1);
                if (rows.get(nx) == 0)
                    rows.remove(nx);

                cols.put(ny, cols.get(ny) - 1);
                if (cols.get(ny) == 0)
                    cols.remove(ny);

                diag.put(nx - ny, diag.get(nx - ny) - 1);
                if (diag.get(nx - ny) == 0)
                    diag.remove(nx - ny);

                antiDiag.put(nx + ny, antiDiag.get(nx + ny) - 1);
                if (antiDiag.get(nx + ny) == 0)
                    antiDiag.remove(nx + ny);
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Grid size
        int n = sc.nextInt();

        // Lamps
        int l = sc.nextInt();
        int[][] lamps = new int[l][2];

        for (int i = 0; i < l; i++) {
            lamps[i][0] = sc.nextInt();
            lamps[i][1] = sc.nextInt();
        }

        // Queries
        int q = sc.nextInt();
        int[][] queries = new int[q][2];

        for (int i = 0; i < q; i++) {
            queries[i][0] = sc.nextInt();
            queries[i][1] = sc.nextInt();
        }

        int[] ans = gridIllumination(n, lamps, queries);

        for (int x : ans) {
            System.out.print(x + " ");
        }

        sc.close();
    }
}