// Stack_Remove Adjacent Duplicate
// Success rate: 21.37%
// Given a string S, Remove equal pair of adjacent character and return the final String

// Input Format:
// A single line containing the string

// Output Format:
// Print the String after removing all the adjacent same characters

// Constraints:
// 1 <= S.length() <= 10^5

import java.util.Scanner;
import java.util.Stack;

public class Stack_Remove_Adjacent_Duplicate {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();
        System.out.println(removeDuplicate(s));
    }

    public static String removeDuplicate(String s) {
        Stack<Character> st = new Stack<>();

        // Process characters
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (st.isEmpty() || st.peek() != ch) {
                st.push(ch);
            } else {
                st.pop(); // remove adjacent duplicate
            }
        }

        // Convert stack to string using simple for loop
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < st.size(); i++) {
            result.append(st.get(i));
        }

        return result.toString();
    }
}
