// LU: Hashmap 5_ Find all Anagrams
// Success rate: 21.11%
// Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.

// An anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

// Input Format:
// The first line contains the string s.
// The second line contains the string p.

// Output Format:
// Print a list of integers representing the starting indices of the anagrams of p in s.

// Constraints:
// 1 <= s.length, p.length <= 3 * 104
// s and p consist of lowercase English letters.
import java.util.*;

public class lect5_1_Find_all_Anagrams {

    public static List<Integer> findAnagrams(String s, String p) {
        if (p.length() > s.length()) {
            return new ArrayList<>();
        }

        HashMap<Character, Integer> hms = new HashMap<>();
        HashMap<Character, Integer> hmp = new HashMap<>();

        // Frequency map of pattern
        for (int i = 0; i < p.length(); i++) {
            hmp.put(p.charAt(i), hmp.getOrDefault(p.charAt(i), 0) + 1);
        }

        int matchCount = 0;
        List<Integer> ans = new ArrayList<>();

        // First window
        for (int i = 0; i < p.length(); i++) {
            char ch = s.charAt(i);
            hms.put(ch, hms.getOrDefault(ch, 0) + 1);

            if (hms.get(ch) <= hmp.getOrDefault(ch, 0)) {
                matchCount++;
            }
        }

        if (matchCount == p.length()) {
            ans.add(0);
        }

        int sp = 0;
        int ep = p.length();

        // Sliding window
        while (ep < s.length()) {

            // Add new character
            char add = s.charAt(ep);
            hms.put(add, hms.getOrDefault(add, 0) + 1);

            if (hms.get(add) <= hmp.getOrDefault(add, 0)) {
                matchCount++;
            }

            // Remove old character
            char remove = s.charAt(sp);
            hms.put(remove, hms.get(remove) - 1);

            if (hms.get(remove) < hmp.getOrDefault(remove, 0)) {
                matchCount--;
            }

            if (matchCount == p.length()) {
                ans.add(sp + 1);
            }

            sp++;
            ep++;
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        String p = sc.next();

        List<Integer> result = findAnagrams(s, p);

        System.out.println(result);

        sc.close();
    }
}