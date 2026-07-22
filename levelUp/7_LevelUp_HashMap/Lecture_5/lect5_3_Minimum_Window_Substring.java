// LU: Hashmap 5_ Minimum Window Substring
// Success rate: 37.25%
// Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

// Input Format:
// The first line contains the string s (1 ≤ |s| ≤ 10^5).
// The second line contains the string t (1 ≤ |t| ≤ 10^5).

// Output Format:
// Output the minimum window substring of s that contains all characters of t. If no such substring exists, output an empty string "".
import java.util.*;

public class lect5_3_Minimum_Window_Substring {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        String s = scn.nextLine();
        String t = scn.nextLine();

        System.out.println(minWindow(s, t));
    }

    public static String minWindow(String s, String t) {

        if (t.length() > s.length()) {
            return "";
        }

        HashMap<Character, Integer> smap = new HashMap<>();
        HashMap<Character, Integer> tmap = new HashMap<>();

        int ansSp = 0;
        int ansEp = 0;

        for (int i = 0; i < t.length(); i++) {
            tmap.put(t.charAt(i), tmap.getOrDefault(t.charAt(i), 0) + 1);
        }

        int anslen = Integer.MAX_VALUE;
        int matchCount = 0;
        int sp = 0;
        int ep = 0;

        while (ep < s.length()) {

            if (matchCount == t.length()) {

                if (ep - sp < anslen) {
                    anslen = ep - sp;
                    ansSp = sp;
                    ansEp = ep;
                }

                char ch = s.charAt(sp);
                smap.put(ch, smap.get(ch) - 1);

                if (smap.get(ch) < tmap.getOrDefault(ch, 0)) {
                    matchCount--;
                }

                sp++;

            } else {

                char ch = s.charAt(ep);

                smap.put(ch, smap.getOrDefault(ch, 0) + 1);

                if (smap.get(ch) <= tmap.getOrDefault(ch, 0)) {
                    matchCount++;
                }

                ep++;
            }
        }

        while (matchCount == t.length()) {

            if (ep - sp < anslen) {
                anslen = ep - sp;
                ansSp = sp;
                ansEp = ep;
            }

            char ch = s.charAt(sp);

            smap.put(ch, smap.get(ch) - 1);

            if (smap.get(ch) < tmap.getOrDefault(ch, 0)) {
                matchCount--;
            }

            sp++;
        }

        if (anslen == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(ansSp, ansEp);
    }
}