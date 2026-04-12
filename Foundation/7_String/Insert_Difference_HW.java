// insert difference hw
//write the function that insert between each pair of character the difference between there ascii

import java.util.Scanner;

public class Insert_Difference_HW{
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
		String st=scn.nextLine();
		System.out.println(insert(st));
	}
    public static String insert( String st) {
        int n = st.length();
        String ans = "";
        for(int i =0;i<n-1 ;i++){
            ans=ans+st.charAt(i);
            int diff = st.charAt(i+1)-st.charAt(i);
            ans = ans+diff;
        }

        ans = ans +st.charAt(n-1);
        return ans;
    }




}



// Insert Difference_HW
// Solution Vid:  
// https://youtu.be/6u99_gdqtOU 