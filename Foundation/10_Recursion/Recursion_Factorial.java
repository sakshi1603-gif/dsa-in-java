// Recursion_Factorial
// Success rate: 55.19%
// Take as input n

// Print n!

// Input Format:
// Integer representing n

// Output Format:
// Integer representing n!

// Constraints:
// 1 <= n <= 10 ^ 9


import java.util.Scanner;
public class Recursion_Factorial {
	public static void main(String[] args) {
		Scanner scn = new Scanner (System.in);
		int n =scn.nextInt();
		System.out.println(fact(n));
	}
	public static int fact(int n ){
		if(n==1){
			return 1;
		}
		int multi = fact(n-1)*n;
		return multi ;
	}
}