import java.util.Scanner;

public class Dimond_num_HW{
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		

        //starting point 
		int nst = 1;//star
		int nsp = n/2;//space 
        int count=0;
		for(int i=1 ;i<=n;i++){
            for(int j=1;j<=nsp;j++){
                System.out.print(" ");
            }
            //starting point of count
            if (i<n/2+1) {
                count=i;
            }else{
                count=n-i+1;
            }

            for(int k =1;k<=nst;k++){
                System.out.print(count);
                if(k<=nst/2){
                    count++;
                }else{
                    count--;
                }
            }

            if(i<n/2+1){
                nsp--;
                nst=nst+2;
            }else{
                nsp++;
                nst=nst-2;
            }
            System.out.println();
        }
	}
}

//   1
//  232
// 34543
//  232
//   1


// Pattern 5_HW
// Solution Video: https://youtu.be/u1cYgwIc62E 