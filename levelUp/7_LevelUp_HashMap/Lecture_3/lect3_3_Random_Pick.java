// LU: Hashmap 3_ Random Pick with BlackList
// Success rate: 6.74%
// You are given an integer n and an array of unique integers blacklist. Your task is to design an algorithm to pick a random integer in the range [0, n - 1] that is not in the blacklist. The algorithm should ensure that any integer within the specified range and not in the blacklist is equally likely to be returned.

// Optimize the algorithm to minimize the number of calls to the built-in random function.

// Input Format:
// The first line contains an integer n.
// The second line contains an integer m, representing the number of elements in the blacklist.
// The third line contains m integers representing the blacklist.
// Hashmap 4_HashMap Operations
// Output Format:
// Return a random integer in the range [0, n - 1] that is not in the blacklist.

// Constraints:
// 1 <= n <= 10^9
// 0 <= blacklist.length <= min(10^5, n - 1)
// 0 <= blacklist[i] < n
// All the values of blacklist are unique.
// At most 2 * 10^4 calls will be made to pick.
import java.util.*;

class Solution {
    HashMap<Integer, Integer> map;
    Random r;
    int valid;

    public Solution(int n, int[] blacklist) {
        map = new HashMap<>();
        r = new Random();

        for (int i = 0; i < blacklist.length; i++) {
            map.put(blacklist[i], -1);
        }

        valid = n - blacklist.length;

        for (int i = 0; i < blacklist.length; i++) {
            if (blacklist[i] < valid) {
                while (map.containsKey(n - 1)) {
                    n--;
                }
                map.put(blacklist[i], n - 1);
                n--;
            }
        }
    }

    public int pick() {
        int val = r.nextInt(valid);

        if (map.containsKey(val)) {
            return map.get(val);
        }

        return val;
    }
}

public class lect3_3_Random_Pick {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] blacklist = new int[m];

        for (int i = 0; i < m; i++) {
            blacklist[i] = sc.nextInt();
        }

        Solution obj = new Solution(n, blacklist);

        // Call pick() 10 times to test
        for (int i = 0; i < 10; i++) {
            System.out.println(obj.pick());
        }

        sc.close();
    }
}