//Loops_ReverseNumber
// Success rate: 10.65%
// Take as input n. Print the number in reverse.

import java.util.Scanner;
public class Q9 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n=scn.nextInt();
		int revnumber=0;
		while(n!=0){
			int digit= n%10;
			revnumber= revnumber*10+digit;
			n = n/10;
		}
		System.out.print(revnumber);
	}
}

//but does not work for 1200 ->0021 it gives ->21
//to resolve that we need to use stack 