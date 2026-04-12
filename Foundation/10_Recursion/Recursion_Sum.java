// Recursion_Sum
// Success rate: 46.13%
// Take as input n

// Print sum of n natural numbers using recursion

// Input Format:
// Integer representing n

// Output Format:
// Integer representing sum of N Natural numbers

// Constraints:
// 1 <= n <= 10 ^ 9


import java.util.Scanner;

public class Recursion_Sum {
	public static void main(String[] args) {
		Scanner scn  =new Scanner(System.in);
		int n =scn.nextInt();
		System.out.println(add(n));
	}
	public static int add(int n ){
		if(n==1){
			return 1;
		}
		int ans = add(n-1)+n;
		return  ans;
	}
}