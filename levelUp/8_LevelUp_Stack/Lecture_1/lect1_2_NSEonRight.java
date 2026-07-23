// LU: Stacks_ NSE on Right
// Success rate: 39.76%
// Professor X wants his students to assist each other in the chemistry lab. He suggests that every student should help a classmate who scored lower marks than themselves in chemistry and whose roll number appears later. However, the students prefer not to search too far; each student chooses the first roll number after them that meets this criterion. The task is to find the marks of the classmate each student selects. Note that one student may be chosen by multiple classmates.

// Input Format:
// The first line contains an integer n, the number of students.
// The second line contains n space-separated integers, representing the chemistry marks of the students in order of their roll numbers.

// Output Format:
// Output a single line containing n space-separated integers, representing the marks of the classmate each student picks. If no such classmate exists, output -1 for that student.

// Constraints:
// 1 ≤ N ≤ 5*10^5
import java.util.*;

public class lect1_2_NSEonRight {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int[] nextSmallerIndex = nextSmallerOnRight(arr);

        for (int i = 0; i < n; i++) {
            if (nextSmallerIndex[i] == -1) {
                System.out.print(-1 + " ");
            } else {
                System.out.print(arr[nextSmallerIndex[i]] + " ");
            }
        }
    }

    public static int[] nextSmallerOnRight(int[] arr) {

        int n = arr.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {

            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                ans[st.pop()] = i;
            }

            st.push(i);
        }

        return ans;
    }
}