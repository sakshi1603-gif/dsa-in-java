//Take a number n as input. Print "even" if the number is even else Print "odd".
import java.util.Scanner;
public class Q4 {
	public static void main(String[] args) {
		Scanner scn =new Scanner (System.in);
		int n = scn.nextInt();
		if(n%2==0){
			System.out.println("even");
		}else{
			System.out.println("odd");
		}
	}
}