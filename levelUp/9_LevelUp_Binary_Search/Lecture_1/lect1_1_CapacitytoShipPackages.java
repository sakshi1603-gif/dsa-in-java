// LU: BS_ Capacity to Ship Packages
// Success rate: 35.59%
// You are given a conveyor belt with packages that need to be shipped from one port to another within a specified number of days. The i-th package on the conveyor belt has a weight of weights[i]. Each day, you can load the ship with packages from the conveyor belt in the given order, but the total weight loaded on the ship each day cannot exceed the ship's maximum weight capacity. Your task is to find the minimum weight capacity of the ship that allows all the packages to be shipped within the given number of days.

// Input Format:
// int[] weights: An array of integers representing the weights of the packages.
// int days: An integer representing the number of days within which all packages must be shipped.

// Output Format:
// int: The minimum weight capacity of the ship that allows all packages to be shipped within the specified number of days.

// Constraints:
// 1 <= days <= weights.length <= 5 * 10^4
// 1 <= weights[i] <= 500
import java.util.*;

public class lect1_1_CapacitytoShipPackages {

    public static int shipWithinDays(int[] weights, int days) {
        int low = 0;
        int high = 0;

        for (int w : weights) {
            low = Math.max(low, w);
            high += w;
        }

        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int requiredDays = calculate(weights, mid);

            if (requiredDays <= days) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    public static int calculate(int[] weights, int capacity) {
        int requiredDays = 1;
        int sum = 0;

        for (int w : weights) {
            if (sum + w > capacity) {
                requiredDays++;
                sum = 0;
            }
            sum += w;
        }

        return requiredDays;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int days = sc.nextInt();

        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            weights[i] = sc.nextInt();
        }

        System.out.println(shipWithinDays(weights, days));

        sc.close();
    }
}