// LU: Two Pointers_Sort 0,1 and 2
// Success rate: 44.58%
// You are given an array of size N containing only the integers 0, 1, and 2. Your task is to sort the array in ascending order.

// Input Format:
// An integer N, the size of the array.
// An array arr of size N containing only 0, 1, and 2.

// Output Format:
// The sorted array in ascending order.

// Constraints:
// 1 <= N <= 10^6
// 0 <= A[i] <= 2
import java.util.*;

public class lect1_3_Two_Pointers_Sort {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int i = 0;
        int j = 0;
        int k = nums.length - 1;

        while (j <= k) {

            if (nums[j] == 0) {

                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;

                i++;
                j++;

            } else if (nums[j] == 1) {

                j++;

            } else {

                int temp = nums[j];
                nums[j] = nums[k];
                nums[k] = temp;

                k--;
            }
        }

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}