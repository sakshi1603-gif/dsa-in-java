// LU: Maths(GCD)_ X of a Kind in a deck
// Success rate: 39.06%
// You are given an integer array deck, where deck[i] represents the number written on the ith card. Your task is to determine if it's possible to partition the cards into one or more groups such that:

// Each group has exactly x cards where x > 1.
// All the cards in one group have the same integer written on them.
// Return true if such a partition is possible, otherwise return false.

// Input Format:
// An integer n, the number of cards in the deck.
// An integer array deck of size n representing the numbers on the cards.

// Output Format:
// Return true if the partition is possible, otherwise false.

// Constraints:
// 1 <= deck.length <= 10^4
// 0 <= deck[i] < 10^4
import java.util.*;

public class lect1_6_Maths {

    public static boolean hasGroupsSizeX(int[] deck) {
        HashMap<Integer, Integer> hm = new HashMap<>();

        // Count the frequency of each card
        for (int i = 0; i < deck.length; i++) {
            if (hm.containsKey(deck[i])) {
                hm.put(deck[i], hm.get(deck[i]) + 1);
            } else {
                hm.put(deck[i], 1);
            }
        }

        int ans = 0;

        // Find GCD of all frequencies
        for (int freq : hm.values()) {
            ans = GCD(ans, freq);
        }

        return ans > 1;
    }

    public static int GCD(int a, int b) {
        if (a == 0) {
            return b;
        }
        return GCD(b % a, a);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input size of the array
        int n = sc.nextInt();

        // Input array elements
        int[] deck = new int[n];
        for (int i = 0; i < n; i++) {
            deck[i] = sc.nextInt();
        }

        // Print result
        System.out.println(hasGroupsSizeX(deck));

        sc.close();
    }
}