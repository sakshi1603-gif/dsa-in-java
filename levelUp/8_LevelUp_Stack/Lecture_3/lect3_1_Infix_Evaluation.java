// LU: Stacks_ Infix Evaluation
// Success rate: 24.73%
// Given a string s representing a mathematical expression, evaluate the expression and return its value.

// The integer division should truncate toward zero.

// You can assume that the given expression is always valid, and all intermediate results will fall within the range of [-2^31, 2^31 - 1].

// Note: You are not allowed to use any built-in functions that evaluate strings as mathematical expressions, such as eval().

// Input Format:
// A single string s representing the mathematical expression.

// Output Format:
// An integer representing the evaluated result of the expression
import java.util.*;

public class lect3_1_Infix_Evaluation {

    public static int calc(int a, int b, char op) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        } else if (op == '*') {
            return a * b;
        } else {
            return a / b;
        }
    }

    public static int prec(char op) {
        if (op == '+' || op == '-') {
            return 0;
        } else {
            return 1;
        }
    }

    public static int calculate(String s) {

        Stack<Integer> operand = new Stack<>();
        Stack<Character> operator = new Stack<>();

        int i = 0;

        while (i < s.length()) {

            if (s.charAt(i) == ' ') {
                i++;
                continue;
            }

            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {

                int num = 0;

                while (i < s.length()
                        && s.charAt(i) >= '0'
                        && s.charAt(i) <= '9') {

                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }

                operand.push(num);
                i--;
            } else {

                while (!operator.isEmpty()
                        && prec(s.charAt(i)) <= prec(operator.peek())) {

                    char op = operator.pop();

                    int val2 = operand.pop();
                    int val1 = operand.pop();

                    operand.push(calc(val1, val2, op));
                }

                operator.push(s.charAt(i));
            }

            i++;
        }

        while (!operator.isEmpty()) {

            char op = operator.pop();

            int val2 = operand.pop();
            int val1 = operand.pop();

            operand.push(calc(val1, val2, op));
        }

        return operand.pop();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        System.out.println(calculate(s));

        sc.close();
    }
}