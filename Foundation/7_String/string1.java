import java.util.Scanner;
public class string1 {
	public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

    String st = scn.nextLine();
    System.out.println(st);

    // int[] arr ={1,2,3};
    // System.out.println(arr);
    
    // char[] arr2 ={'H','e','l','l','o'};
    // System.out.println(arr2);

    System.out.println(st.length());

    System.out.println(st.substring(2,3));//2-2 -> one char
    System.out.println(st.substring(2,2));// 2-1 =0 -> empty 
    // System.out.println(st.substring(2,1));// error
    System.out.println(st.substring(2));


    }
}