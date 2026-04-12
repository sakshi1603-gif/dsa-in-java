//Take a number n as input representing marks of a student. Print "pass" if the mark is greater than equal to 35 else Print "fail".
import java.util.Scanner;
public class Q2 {
	public static void main(String[] args) {
		Scanner scn =new Scanner(System.in);
		int n = scn.nextInt();
		if(n>=35){
			System.out.println("pass");
		}
		else{
			System.out.println("fail");
		}
		
	}
}