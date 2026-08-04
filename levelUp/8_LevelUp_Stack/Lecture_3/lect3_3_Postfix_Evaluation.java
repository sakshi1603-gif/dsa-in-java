// LU: Stacks_ Postfix Evaluation
// Success rate: 17.14%
// You are given an array of strings tokens that represents an arithmetic expression in Reverse Polish Notation (RPN). Evaluate the expression and return its integer value.

// Valid Operators: +, -, *, /
// Operands: May be integers or other expressions.
// Division: Truncates toward zero.
// Constraints: No division by zero. The expression is valid and results fit in a 32-bit integer.

// Input Format:
// An array of strings tokens representing the arithmetic expression in RPN.

// Output Format:
// An integer representing the result of the evaluated expression.

// Constraints:
// 1 <= tokens.length <= 10^4
// tokens[i] is either an operator: "+", "-", "*", or "/", or an integer in the range [-200, 200].
import java.util.*;

public class lect3_3_Postfix_Evaluation {

    public static int calc(int a, int b, String op) {
        if (op.equals("+")) {
            return a + b;
        } else if (op.equals("-")) {
            return a - b;
        } else if (op.equals("*")) {
            return a * b;
        } else {
            return a / b;
        }
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for (String token : tokens) {
            if (!token.equals("+") &&
                !token.equals("-") &&
                !token.equals("*") &&
                !token.equals("/")) {

                st.push(Integer.parseInt(token));
            } else {
                int val2 = st.pop();
                int val1 = st.pop();
                st.push(calc(val1, val2, token));
            }
        }

        return st.pop();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read number of tokens
        int n = sc.nextInt();

        // Read tokens
        String[] tokens = new String[n];
        for (int i = 0; i < n; i++) {
            tokens[i] = sc.next();
        }

        // Evaluate and print result
        int ans = evalRPN(tokens);
        System.out.println(ans);

        sc.close();
    }
}