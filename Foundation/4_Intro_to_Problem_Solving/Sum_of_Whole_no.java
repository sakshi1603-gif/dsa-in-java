//You need to find the sum of first N natural numbers.
import java.util.Scanner;
public class Sum_of_Whole_no {
	public static void main(String[] args) {
		Scanner scn= new Scanner(System.in);
		long n = scn.nextLong();
		long sum=((n-1)*n)/ 2;
		System.out.println(sum+n);

	}
}
/*if 
1000
s =  1   + 2   +.............+ 999  + 1000
s = 1000 + 999 +.............+ 2    + 1 
2s= 1001 +1001 +.............+ 1001 + 1001
s = (1001*1000)/2
s = (n+1)*n/2

for whole number 
0,1,2,3,4.........n-1

*/
