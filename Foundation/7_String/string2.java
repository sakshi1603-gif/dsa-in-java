import java.util.Scanner;
public class string2 {
	public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

    String st = scn.nextLine();

    st="m"+st+"e";
    System.out.println(st);



    }
}
//strings are immutable 
// if we add the character to it it will not change but make the another string -> this is the O(n) operation 