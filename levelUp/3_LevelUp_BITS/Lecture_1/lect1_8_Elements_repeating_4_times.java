// BITS 1_Elements repeating four times
// Success rate: 73.47%
// Given an array arr[] of N positive elements in which every element is repeating four times but 1 element is repeating 1 time. Find the element repeating 1 time.

// Input Format:
// The first line contains size of array.
// Second line contains the elements of the array.

// Output Format:
// Output the required number.

// Constraints:
// 1 <= N <= 10^5
// 1 <= arr[i] <= 10^5
import java.util.*;

public class lect1_8_Elements_repeating_4_times {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int ans = SingleElement(n, arr);
        System.out.println(ans);
    }

    public static int SingleElement(int n, int[] arr) {
        int ans = 0;
		for(int i = 0;i<n;i++){
			ans = ans^arr[i];
		}
		return ans;
    }
}