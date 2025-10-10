//Take three numbers a,b and c as input. Print the max out of 3 Integers.
import java.util.Scanner;
public class Q5 {
	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int a =scn.nextInt();
		int b =scn.nextInt();
		int c =scn.nextInt();
		if(a>=b&&a>=c){
			System.out.println(a);
		}
		else if(b>=a&&b>=c){
			System.out.println(b);
		}
		else{
			System.out.println(c);
		}
	}
}