
import java.util.Scanner;

public class Hourglass_HW{
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		

        //starting point 
		int nst = 2*n-1;//star
		int nsp = 0;//space 
        int count=0;
		for(int i=1 ;i<=n;i++){
            for(int j=0;j<nsp;j++){
                System.out.print(" ");
            }
             count =n-i+1;
            for(int k =0;k<nst;k++){
                System.out.print(count);
                if(k< nst/2){
                    count--;
                }else{
                    count++;
                }
            }
            nsp++;
            nst=nst-2;
            System.out.println();
        }
        nsp =n-2;
        nst=3;
        for(int i=1;i<n;i++){
            for(int j=0;j<nsp;j++){
                System.out.print(" ");
            }
            count =i+1;
            for(int k =0;k<nst;k++){
                System.out.print(count);
                if(k<nst/2){
                    count--;
                }else{
                    count++;
                }
            }
            nsp--;
            nst=nst+2;
            System.out.println();
        }
	}
}

// Print the Palindromic Hourglass Pattern (Numbers)

// Input: n = 5
// 543212345   n-i+1 =5-1+1=5
//  4321234          =5-2+1=4
//   32123           =5-3+1=3
//    212            =5-4+1=2
//     1             =5-5+1=1
//    212       
//   32123
//  4321234
// 543212345
