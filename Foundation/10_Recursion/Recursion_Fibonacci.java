// Recursion_Fibonacci number
// Success rate: 57.78%
// Take as input a number n.
// Print the nth number of Fibonacci sequence where
// 0th Fibonacci is 0 and 1st Fibonacci is 1. Here is a sample
// 0 1 1 2 3 5 8 13 21 34 55

// Input Format:
// Integer

// Output Format:
// Integer

// Constraints:
// n <= 10 ^ 9
import java.util.Scanner;
public class Recursion_Fibonacci {
	public static void main(String[] args) {
		Scanner scn = new Scanner (System.in);
		int n = scn.nextInt();
		System.out.println(fib(n));
	}
	public static int fib(int n ){
		if(n==1||n==0 ){
			return n;
		}
		
		int temp = fib(n-1)+fib(n-2);
		return temp;
	}
}