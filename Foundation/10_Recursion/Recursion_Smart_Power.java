// Recursion_Smart Power
// Success rate: 29.04%
// Given two Integer a and n, find a^n (a raise to power n).

// Note: Use Recursion and Expected Time complexity is O(logN).

// Input Format:
// Single line contains 2 integers a and n

// Output Format:
// Return the answer a^n

// Constraints:
// 1<= a <= 10
// 1<= n <= 18

import java.util.Scanner;
public class Recursion_Smart_Power {
	public static void main(String[] args) {
		Scanner scn = new Scanner (System.in);
		int a = scn.nextInt();
		int n = scn.nextInt();
		long result = pow(a,n);
		System.out.println(result);
	}
	public static long pow(int a,int n ){
		if(n==0){
			return 1;
		}
		long temp=pow(a,n/2);
		if(n%2==0){
		return temp*temp;
		}else{
			return temp*temp*a;
		}
	}
}