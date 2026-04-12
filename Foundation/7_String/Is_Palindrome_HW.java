
//problem statement : given a string check if the string is  palindrome or not 
//note ; uppercase ans lowercase are considered as same 
import java.util.Scanner;

public class Is_Palindrome_HW {

    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        String st=scn.nextLine();
        int n = st.length();
        
        char[] arr = new char[n];
        for(int i=0;i<n;i++){
            if(st.charAt(i)>='A' && st.charAt(i)<='Z'){
                arr[i] = (char)(st.charAt(i) + 32);
            }else{
                arr[i] = st.charAt(i);
            }
        }
        
        int sp = 0;
        int ep = n-1;
        
        while(sp<ep){
            if(arr[sp]!= arr[ep]){
                System.out.println("false");
                return;
            }
            
            sp++;
            ep--;
        }
        
        System.out.println("true");
    }
}



// Is Palindrome_HW
// Solution Vid:  
// https://youtu.be/QBsaSTN48kA 