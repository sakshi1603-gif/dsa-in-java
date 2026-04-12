//Take as input a number n. Determine whether it is prime or not. If it is prime,
//print "Prime" otherwise print "Not Prime".
import java.util.Scanner;
public class Q6 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		long n = scn.nextLong();
		
		if(n<=1){
			System.out.println("Not Prime");
		}else{
			boolean isprime= true;
			for(long i = 2; i * i <= n; i++) { 
				if(n%i==0){
					isprime=false;
					break;
				}
			}
			if(isprime==true){
				System.out.println("Prime");
			}
			else{
				System.out.println("Not Prime");
			}
		}
		scn.close();
	}
	
}