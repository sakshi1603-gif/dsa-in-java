import java.util.Scanner;
public class String_Reverse {
	public static void main(String[] args) {
		Scanner scn= new Scanner(System.in);
		String s = scn.nextLine();
		char []ch=s.toCharArray();
		String_Reverse(ch);
		System.out.print(ch);
		
	}
	public static void String_Reverse(char []ch){
		int n=ch.length;
		int sp=0;
		int ep=n-1;
		for(int i=0;sp<ep;i++){
			char temp=ch[ep];
			ch[ep]=ch[sp];
			ch[sp]=temp;
			ep--;
			sp++;
		}
		
		
	}
}