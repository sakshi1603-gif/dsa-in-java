// LU: Hashmap 1_Brick Wall
// Success rate: 17.35%
// Given a rectangular brick wall in front of you with n rows of bricks. The i-th row has a certain number of bricks, each with the same height (one unit) but possibly different widths. The total width of each row is the same.

// You need to draw a vertical line from the top to the bottom of the wall, crossing the fewest bricks. If the line goes through the edge of a brick, that brick is not considered as crossed. You cannot draw the line along one of the two vertical edges of the wall.

// Given the 2D array wall, return the minimum number of bricks that the vertical line will cross.

// Input Format:
// An integer n representing the number of rows in the wall.
// Next, n lines follow, each containing a list of integers representing the width of bricks in each row.

// Output Format:
// An integer representing the minimum number of crossed bricks after drawing the vertical line.

// Constraints:
// n == wall.length
// 1 <= n <= 104
// 1 <= wall[i].length <= 104
// 1 <= sum(wall[i].length) <= 2 * 104
// sum(wall[i]) is the same for each row i.
// 1 <= wall[i][j] <= 231 - 1
import java.util.*;

public class lect1_2_Brick_Wall {

    public static int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxEdges = 0;

        for (List<Integer> row : wall) {
            int edgePosition = 0;

            for (int i = 0; i < row.size() - 1; i++) {
                edgePosition += row.get(i);
                map.put(edgePosition, map.getOrDefault(edgePosition, 0) + 1);
                maxEdges = Math.max(maxEdges, map.get(edgePosition));
            }
        }

        return wall.size() - maxEdges;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<List<Integer>> wall = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int m = sc.nextInt(); 
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                row.add(sc.nextInt());
            }
            wall.add(row);
        }
        System.out.println(leastBricks(wall));
        sc.close();
    }
}