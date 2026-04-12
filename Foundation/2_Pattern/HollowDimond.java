import java.util.Scanner;
public class HollowDimond {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int nst=(n/2)+1;
		int nsp=1;
		for(int i=0;i<n;i++){
			for(int j=0;j<nst;j++ ){
				System.out.print("*");
			}
			for(int k=0;k<nsp;k++){
				System.out.print(" ");
			}
			for(int l=0;l<nst;l++ ){
				System.out.print("*");
			}
			if(i<n/2){
				nst--;
				nsp=nsp+2;
			}
			else{
				nst++;
				nsp=nsp-2;
			}
			System.out.println();
		}
	}
}