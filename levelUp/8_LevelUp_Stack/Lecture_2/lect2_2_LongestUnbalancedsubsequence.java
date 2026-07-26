// LU: Stacks_Longest Unbalanced subsequence
// Success rate: 41.98%
// A student of Algoprep has recently found out about groupings of brackets (sequences of parentheses).

// A balanced parentheses sequence follows the following definition:

// An empty sequence is balanced.
// If R is a balanced sequence, then (R) is also balanced.
// If M and N represent two balanced sequences, then their concatenation MN is also balanced.
// the sequences (), ()() and (())() are balanced, while ()) and ))() are unbalanced.

// Now, you need to find the length of longest unbalanced subsequence of the given string (containing '(' and ')').

// Input Format:
// Each of the test cases have one line containing the parentheses sequence.

// Output Format:
// Output a line containing answer to the corresponding query.

// Constraints:
// 1 ≤ length of string ≤ 10^5
import java.util.*;

public class lect2_2_LongestUnbalancedsubsequence {
    public static void main(String[] args) {
        String s = ")))))))))))))))))))))))((";
        boolean ans = isValid(s);

        if (ans) {
            System.out.println(s.length() - 1);
        } else {
            System.out.println(s.length());
        }
    }

    public static boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for (char ch : s.toCharArray()) {

            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } else {

                if (st.isEmpty()) {
                    return false;
                }

                if (ch == ')' && st.peek() != '(') {
                    return false;
                }

                if (ch == '}' && st.peek() != '{') {
                    return false;
                }

                if (ch == ']' && st.peek() != '[') {
                    return false;
                }

                st.pop();
            }
        }

        return st.isEmpty();
    }
}