// LU: Search for a given Pattern P in Text T
// Success rate: 26.20%
// Given a text and a pattern, the task is to determine whether the pattern exists within the text.

// Input Format:
// The first line contains a string text, representing the text in which to search for the pattern.
// The second line contains a string pat, representing the pattern to search for.

// Output Format:
// Output 1 if the pattern exists in the text, otherwise output 0.

// Constraints:
// 1 ≤ text, pat ≤ 10^5
// Both of the string contains lower case English alphabets
import java.util.*;

class lect1_1_Search_given_pattern {

    public static int[] calculateLPS(char[] s) {
        int n = s.length;
        int[] lps = new int[n];

        for (int i = 1; i < n; i++) {
            int len = lps[i - 1];

            while (len > 0 && s[i] != s[len]) {
                len = lps[len - 1];
            }

            if (s[i] == s[len]) {
                lps[i] = len + 1;
            }
        }

        return lps;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine();
        String pat = sc.nextLine();

        String combined = pat + "#" + text;

        int[] lps = calculateLPS(combined.toCharArray());

        int m = pat.length();

        for (int value : lps) {
            if (value == m) {
                System.out.println(1);
                return;
            }
        }

        System.out.println(0);
    }
}