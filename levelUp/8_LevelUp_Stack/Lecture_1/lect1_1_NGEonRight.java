// LU: Stacks_ NGE on Right
// Success rate: 30.95%
// Given an array arr[] of n elements, the task is to find the next greater element for each element in the array according to their order of appearance. The next greater element for a given element is the closest element to its right that is greater than the current element. If no such element exists, the next greater element for that position is -1. For instance, the next greater element for the last element is always -1.

// Input Format:
// The first line contains an integer n, the number of elements in the array.
// The second line contains n space-separated integers, representing the elements of the array arr[].

// Output Format:
// Output a single line containing n space-separated integers, representing the next greater elements for each array element.

// Constraints:
// 1 ≤ n ≤ 10^6
// 0 ≤ arr[i] ≤ 10^18
import java.util.*;

public class lect1_1_NGEonRight {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int[] nextGreaterIndex = nextGreaterOnRight(arr);

        for (int i = 0; i < n; i++) {
            if (nextGreaterIndex[i] == -1) {
                System.out.print(-1 + " ");
            } else {
                System.out.print(arr[nextGreaterIndex[i]] + " ");
            }
        }
    }

    public static int[] nextGreaterOnRight(int[] arr) {

        int n = arr.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {

            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                ans[st.pop()] = i;
            }

            st.push(i);
        }

        return ans;
    }
}