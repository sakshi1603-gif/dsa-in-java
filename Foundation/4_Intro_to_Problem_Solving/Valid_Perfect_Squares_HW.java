
import java.util.Scanner;
public class Valid_Perfect_Squares_HW {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
        int ans=0;
        for(int i=0;i*i<=n;i++){
            ans=i;
        }
        System.out.println(ans);
        if(ans*ans==n){
            System.out.println("valid perfect square");            
        }
        else{
            System.out.println("not valid perfect square");
        }
	}
}

// Valid Perfect Squares_HW
// Solution Video: 
// https://youtu.be/Jhqw9lRv1Uc 
