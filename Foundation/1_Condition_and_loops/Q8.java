//Take a number n as input. Print "divisible" if the number is divisible by 2 and 3 else Print "not divisible".
import java.util.Scanner;
public class Q8 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n =scn.nextInt();
		System.out.println((n%2==0 && n%3==0)? "divisible": "not divisible");
	}
}