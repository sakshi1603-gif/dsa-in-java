import java.util.Scanner;
public class Combination{
    public static void main(String[] argv){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int r = scn.nextInt();
        int ans1=1;
        for(int i=1; i<=n;i++){
            ans1=ans1*i;
        }
        
        int ans2=1;
        for(int i=1; i<=r;i++){
            ans2=ans2*i;
        }

        int ans3=1;
        for(int i=1; i<=(n-r);i++){
            ans3=ans3*i;
        }
        int combination=ans1/(ans2*ans3);
        System.out.println(combination);
    }
}