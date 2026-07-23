// LU: minimum Characters to be added to make Palindrome
// Success rate: 34.12%
// Given a string str of length N, the task is to find the minimum number of characters that need to be added at the front of the string to make it a palindrome. A palindrome is a word that reads the same backward as forward, such as "madam".

// Input Format:
// A single string str of length N consisting of lowercase English letters.

// Output Format:
// An integer representing the minimum number of characters that need to be added at the front to make the string a palindrome.

// Constraints:
// 1 <= S.length <= 10^6


import java.util.Scanner;

public class lect2_2_minimum_Characters {

    public static int minCharsToPalindrome(String s) {
        String reversed = new StringBuilder(s).reverse().toString();

        String temp = s + "#" + reversed;

        int[] lps = buildLPS(temp);

        int longestPalPrefix = lps[lps.length - 1];

        return s.length() - longestPalPrefix;
    }

    public static int[] buildLPS(String s) {
        int n = s.length();
        int[] lps = new int[n];

        int len = 0;
        int i = 1;

        while (i < n) {
            if (s.charAt(i) == s.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        System.out.println(minCharsToPalindrome(s));

        sc.close();
    }
}