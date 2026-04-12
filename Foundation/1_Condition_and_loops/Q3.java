//Take a number n as input representing Budget of trip. Print "goa" if the budget is greater than equal to 10000 else Print "murthal".
import java.util.Scanner;
public class Q3 {
	public static void main(String[] args) {
		// write your code here
		Scanner scn=new Scanner(System.in);
		int n=scn.nextInt();

		if(n>=10000){
			System.out.println("goa");
		}
		else{
			System.out.println("murthal");
		}
		
		
	}
}