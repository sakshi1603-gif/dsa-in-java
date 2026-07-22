// LU: Hashmap 5_ Anagram Palindrome
// Success rate: 68.42%
// Given a string S, determine if it is possible to rearrange the characters of the string to form a palindrome. Return 1 if it is possible, otherwise return 0.

// Input Format:

// The input contains a single line with the string S.
// Output Format:

// Output 1 if the string can be rearranged to form a palindrome, otherwise output 0

// Constraints:
// 1 <= S <= 10^6
import java.util.*;

public class lect5_2_Anagram_Palindrome {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();
        System.out.println(AnagramPalindrome(s));
    }

    public static int AnagramPalindrome(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        }

        int oddCount = 0;

        for (char key : hm.keySet()) {
            int freq = hm.get(key);

            if (freq % 2 != 0) {
                oddCount++;
            }
        }

        if (oddCount <= 1) {
            return 1;
        }

        return 0;
    }
}