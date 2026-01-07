// Given n length array "arr". Find (i,j) with maximum value of arr[i] - arr[j] + j - i. You need to print max value of (arr[i] - arr[j] + j - i) possible and not the (i,j) itself.

// Note: Doing it by checking all the possible pairs. Works but can you do something smart?

// Input Format:
// Each of the test cases have 2 lines.
// The First line contains the size of the array n.
// The second line contains the n elements of the array.

// Output Format:
// Print the maximum value of arr[i] - arr[j] + j - i Possible.



import java.util.Scanner;
public class max_diff5 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int maxelem = max(arr);
        System.out.println(maxelem);
    }

    public static int max(int[] arr) {
        int n = arr.length;
        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) { 
                int diff = Math.abs(arr[i] - arr[j] + j -i);
                if (diff > max) {
                    max = diff;
                }
            }
        }
        return max;
    }
}



// Input:

// 5
// 1 3 -1 8 2


// Calculations:

// i	arr[i]	arr[i]+i	arr[i]-i
// 0	1	1	1
// 1	3	4	2
// 2	-1	1	-3
// 3	8	11	5
// 4	2	6	-2

// max1 = 11, min1 = 1 → diff = 10

// max2 = 5, min2 = -3 → diff = 8

// So result = max(10, 8) = 10.

// ✅ Output: 10

// 💡 Summary
// Step	Meaning
// Input	Read size n and array elements
// Task	Find max(
// Logic	Convert to two linear forms (arr[i]+i) and (arr[i]-i)
// Time complexity	O(n)
// Space complexity	O(1)