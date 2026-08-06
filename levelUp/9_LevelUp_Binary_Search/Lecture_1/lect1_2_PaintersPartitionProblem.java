// LU: BS_ Painter's partition Problem
// Success rate: 38.82%
// Dilpreet wants to paint his dog's home, which consists of n boards of different lengths. The length of the i-th board is given by arr[i], where arr[] is an array of n integers. He hired k painters for the job, and each painter takes 1 unit time to paint 1 unit length of the board. The goal is to find the minimum time required to paint all the boards if all painters start together, with the constraint that each painter can only paint a continuous section of the boards (e.g., boards numbered {2,3,4} or only board {1}, but not boards {2,4,5}).

// Input Format:
// The first line contains an integer n, the number of boards.
// The second line contains n space-separated integers representing the lengths of the boards.
// The third line contains an integer k, the number of painters.
// Output Format:
// Print the minimum time required to paint all the boards.

// Constraints:
// 1 ≤ n ≤ 10^5
// 1 ≤ k ≤ 10^5
// 1 ≤ arr[i] ≤ 10^5
import java.util.*;

public class lect1_2_PaintersPartitionProblem {

    public static int PainterPartition(int[] Time, int k) {
        int low = 0;
        int high = 0;

        for (int t : Time) {
            low = Math.max(low, t);
            high += t;
        }

        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int reqdworker = calculate(Time, mid);

            if (reqdworker <= k) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    public static int calculate(int[] Time, int mid) {
        int reqdworker = 1;
        int sum = 0;

        for (int t : Time) {
            if (sum + t > mid) {
                reqdworker++;
                sum = 0;
            }
            sum += t;
        }

        return reqdworker;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] Time = new int[n];
        for (int i = 0; i < n; i++) {
            Time[i] = sc.nextInt();
        }
        int k = sc.nextInt();

        System.out.println(PainterPartition(Time, k));

        sc.close();
    }
}