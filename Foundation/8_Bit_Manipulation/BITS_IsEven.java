// Take as input a number n. Determine whether it is even or odd. If it is even,
// print "even" otherwise print "odd".

// Note: Using any mathematical operator is not allowed.

// Input Format:
// The only line contains an Integer N.

// Output Format:
// Print "even" if number is even else print "odd"

import java.util.Scanner;
public class BITS_IsEven {
	public static void main(String[] args) {
		Scanner scn = new Scanner (System.in);
		int N = scn.nextInt();
		checkEven(N);
	}
	public static void checkEven(int N ){
		if((N & 1)==0){
			System.out.println("even");
		}else{
			System.out.println("even");
		}
	}
}