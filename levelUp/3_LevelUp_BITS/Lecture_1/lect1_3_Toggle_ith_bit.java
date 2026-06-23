// BITS 1_Toggle ith bit
// Success rate: 75.71%
// Given numbers n and k, toggle kth bit of number n. Rightmost bit is considered 0th bit and so on.

// Input Format:
// the first line contains two integer n and k.

// Output Format:
// Print the decimal number after toggling the kth bit

// Constraints:
// 1 <= 10^5 <= n
// 0 <= k <=31
import java.util.*;
public class lect1_3_Toggle_ith_bit {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int k = scn.nextInt();
		int ans = n ^ (1 << k);
		System.out.println(ans);
	}
}