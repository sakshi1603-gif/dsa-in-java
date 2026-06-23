// BITS1_CountingBits
// Success rate: 60.56%
// Given a positive integer N, count the number of set bits (1s) in its binary representation.

// Input Format:
// The input consists of a single integer N.

// Output Format:
// Output the count of set bits in the binary representation of N

// Constraints:
// 1 ≤ N ≤ 109
import java.util.*;
public class lect1_5_CountingBits {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int count = 0 ;
        for(int i =0 ;i<32;i++){
            if ((n & (1 << i)) != 0) {
                count++;
            }
        }
		System.out.println(count);
	}
}