import java.util.Scanner;
public class Fibonacci_Number_HW {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
        if(n == 0){
            System.out.println(0);
            return;
        }
        if(n == 1){
            System.out.println(1);
            return;
        }
		int a=0;
        int b =1;
		for(int i =2;i<=n;i++){
            int c=a+b;//1,2
            a=b;//1
            b=c;//1
        }
		    System.out.println(b);
	}
}

// Fibonacci Number_HW
// Solution Video: 
// https://youtu.be/xpDqrTKmHdM 