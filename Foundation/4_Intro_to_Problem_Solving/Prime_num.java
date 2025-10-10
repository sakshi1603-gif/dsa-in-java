
import java.util.Scanner;
public class Prime_num {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int count=0;
		for(int i=1;i<=Math.sqrt(n);i++){
			if(n%i==0){
				if(i==n/i){
					count++;
				}else{
					count=count+2;
				}
			}
		}
		if(count==2){
			System.out.println("Yay");
		}else{
			System.out.println("Nay");
		}
	}
}