import java.util.Scanner;
public class function{
    public static void main(String[] argv){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int ans =fact(n);
        System.out.println(ans);   
    }
    public static int fact(int n ){
        int fact=1;
        for(int i=1; i<=n;i++){
            fact=fact*i;
        }
        return fact;
    }
}