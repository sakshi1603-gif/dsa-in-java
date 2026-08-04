// LU: Stacks_ Infix to Postfix
// Success rate: 29.87%
// Given an infix expression as a string str, convert this infix expression to a postfix expression.

// Infix Expression: The expression is of the form a op b, where the operator (op) is between every pair of operands.
// Postfix Expression: The expression is of the form a b op, where the operator follows every pair of operands.
// Note: The order of precedence is ^ (highest), * and / (equal), followed by + and - (equal). Ignore the right associativity of ^.

// Input Format:
// A single string str representing the infix expression.

// Output Format:
// A string representing the postfix expression.

// Constraints:
// 1 ≤ |str| ≤ 10^5
import java.util.*;

public class lect3_2_Infix_to_Postfix {

    public static int precedence(char ch) {
        if (ch == '^')
            return 3;
        if (ch == '*' || ch == '/')
            return 2;
        if (ch == '+' || ch == '-')
            return 1;
        return -1;
    }

    public static String infixToPostfix(String exp) {
        Stack<Character> st = new Stack<>();
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            if (Character.isLetterOrDigit(ch)) {
                ans.append(ch);
            }
            else if (ch == '(') {
                st.push(ch);
            }
            else if (ch == ')') {
                while (!st.isEmpty() && st.peek() != '(') {
                    ans.append(st.pop());
                }
                st.pop(); // Remove '('
            }
            else { // Operator
                while (!st.isEmpty() &&
                       precedence(ch) <= precedence(st.peek())) {
                    ans.append(st.pop());
                }
                st.push(ch);
            }
        }

        while (!st.isEmpty()) {
            ans.append(st.pop());
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String exp = sc.nextLine();

        System.out.println(infixToPostfix(exp));

        sc.close();
    }
}