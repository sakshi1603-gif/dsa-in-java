//Take a number n as input representing age of a person. 
//Print "eligible" if the person is Eligible for driving 
//license else Print "not eligible".

import java.util.Scanner;
public class Q1 {
	public static void main(String[] args) {
		Scanner scn= new Scanner(System.in);
		int age = scn.nextInt();
		if(age>=18){
			System.out.println("eligible");
		}else{
			System.out.println("not eligible");
		}
	}
}