// Recursion_Print Increasing
// Success rate: 39.29%
// Take as input N

// Print numbers from 1 to N in N lines

// Input Format:
// Integer representing n

// Output Format:
// Print numbers from 1 to N

// Constraints:
// 1 <= n <= 10 ^ 9

import java.util.Scanner;
public class Recursion_Print_Increasing {
	public static void main(String[] args) {
		Scanner scn = new Scanner (System.in);
		int n = scn.nextInt();
		printInc(n);
	}
	public static void printInc(int n ){
		if(n==1){
			System.out.println(n);
			return;
		}
		printInc(n-1);
		System.out.println(n);
		
	}
}