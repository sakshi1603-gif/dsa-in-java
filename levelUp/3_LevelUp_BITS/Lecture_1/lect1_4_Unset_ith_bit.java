// BITS 1_Unset ith bit
// Success rate: 48.08%
// Given numbers n and k, unset the kth bit of number n. Rightmost bit is considered 0th bit and so on.

// Input Format:
// the first line contains two integer n and k.

// Output Format:
// Print the decimal number after unsetiing the kth bit

// Constraints:
// 1 <= 10^5 <= n
// 0 <= k <=31
import java.util.*;

public class lect1_4_Unset_ith_bit {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int k = scn.nextInt();

        if (checkBit(n, k)) {
            System.out.println(n ^ (1 << k));
        }
    }

    public static boolean checkBit(int n, int k) {
        return (n & (1 << k)) != 0;
    }
}