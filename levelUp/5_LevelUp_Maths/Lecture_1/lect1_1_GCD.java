// LU: Maths(GCD)_GCD
// Success rate: 56.52%
// Given two positive integers a and b, find the Greatest Common Divisor (GCD) of a and b without using the inbuilt GCD function.

// Input Format:
// Two space-separated positive integers a and b.

// Output Format:
// A single integer representing the GCD of the two given integers.

// Constraints:
// 1 ≤ a, b ≤ 10^9
import java.util.Scanner;

public class lect1_1_GCD {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int a = scn.nextInt();
		int b =scn.nextInt();
		int ans = GCD(a , b);
		System.out.println(ans);
	}
	public static int GCD(int a , int b ){
		if(a==0){
			return b ;
		}
		int temp = GCD(b%a , a);
		return temp;
	}
}