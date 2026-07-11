// LU: Hashmap 2_Subarray with equal 0, 1 and 2
// Success rate: 34.62%
// Given a string str of length N consisting of only '0's, '1's, and '2's, count the number of substrings that have an equal number of '0's, '1's, and '2's.

// Input Format:
// A single line containing the string str consisting of '0's, '1's, and '2's.

// Output Format:
// A single integer representing the number of substrings with equal counts of '0's, '1's, and '2's.

// Constraints:
// 1 ≤ N ≤ 10^5
import java.util.*;

public class lect2_4_Subarray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        HashMap<String, Integer> map = new HashMap<>();

        int c0 = 0;
        int c1 = 0;
        int c2 = 0;

        long ans = 0;

        map.put("0#0", 1);

        for (char ch : str.toCharArray()) {

            if (ch == '0')
                c0++;
            else if (ch == '1')
                c1++;
            else
                c2++;

            int d1 = c1 - c0;
            int d2 = c2 - c1;

            String key = d1 + "#" + d2;

            ans += map.getOrDefault(key, 0);

            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        System.out.println(ans);
    }
}