// LU: Stacks_ NSE on Left
// Success rate: 50.00%
// Given an array a of integers with length n, the task is to find the nearest smaller number for each element in the array such that the smaller element is on the left side. If no such smaller element is present on the left, print -1 for that position.

// Input Format:
// The first line contains an integer n, the number of elements in the array.
// The second line contains n space-separated integers representing the elements of the array a[].

// Output Format:
// Output a single line containing n space-separated integers representing the nearest smaller numbers on the left side for each element. If no smaller element exists on the left, print -1 for that element.

// Constraints:
// 1 ≤ n ≤ 10000
// 0 ≤ a[i] ≤ 10^4
import java.util.*;

public class lect1_3_NSEonLeft {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int[] nextSmallerIndex = nextSmallerOnLeft(arr);

        for (int i = 0; i < n; i++) {
            if (nextSmallerIndex[i] == -1) {
                System.out.print(-1 + " ");
            } else {
                System.out.print(arr[nextSmallerIndex[i]] + " ");
            }
        }
    }

public static int[] nextSmallerOnLeft(int[] arr) {

    int n = arr.length;
    int[] ans = new int[n];
    Arrays.fill(ans, -1);

    Stack<Integer> st = new Stack<>();

    for (int i = n - 1; i >= 0; i--) {

        while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
            ans[st.pop()] = i;
        }

        st.push(i);
    }

    return ans;
}
}