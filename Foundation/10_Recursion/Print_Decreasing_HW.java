import java.util.*;

public class Print_Decreasing_HW {

    public static void main(String[] args) {
        
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        dec(n);
        
    }
    
    public static void dec(int n){
        if(n == 1){
            System.out.println(1);
            return;
        }
        
        
        System.out.println(n);
        dec(n-1);
    }
}
