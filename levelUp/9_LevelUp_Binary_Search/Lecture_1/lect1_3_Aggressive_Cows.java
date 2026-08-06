// LU: BS_ Aggressive Cows
// Success rate: 32.04%
// You are given an array consisting of n integers representing the positions of stalls. You are also given an integer k representing the number of aggressive cows. The task is to assign stalls to k cows such that the minimum distance between any two cows is maximized.

// Input Format:
// The first line of input contains two space-separated integers n (number of stalls) and k (number of cows).
// The second line contains n space-separated integers representing the positions of the stalls.

// Output Format:
// Return the maximum possible minimum distance between any two cows.

// 2 <= n <= 10^5
// 2 <= k <= n
// 0 <= stalls[i] <= 10^9
import java.util.*;

public class lect1_3_Aggressive_Cows {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int k = scn.nextInt();

        int[] dist = new int[n];
        for (int i = 0; i < n; i++) {
            dist[i] = scn.nextInt();
        }

        Arrays.sort(dist);

        System.out.println(aggressiveCows(dist, k));
    }

    public static int aggressiveCows(int[] dist, int k) {

        int low = 1;
        int high = dist[dist.length - 1] - dist[0];
        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int cowsPlaced = cowsCount(dist, mid);

            if (cowsPlaced >= k) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    public static int cowsCount(int[] dist, int minDistance) {

        int cows = 1;
        int prevPos = dist[0];

        for (int i = 1; i < dist.length; i++) {
            if (dist[i] - prevPos >= minDistance) {
                cows++;
                prevPos = dist[i];
            }
        }

        return cows;
    }
}