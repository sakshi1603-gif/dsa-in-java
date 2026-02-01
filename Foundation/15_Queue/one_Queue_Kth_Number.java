// Queue_Kth Number
// Success rate: 35.71%
// Given K, Print the Kth Number in the increasing series of number using digits 1 and 2 only.

// Input Format:
// The only line contains number K

// Output Format:
// Return the kth number of the series

// Constraints:
// 1<= K <=20

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class one_Queue_Kth_Number {
	public static void main(String[] args) {
		Scanner scn=new Scanner (System.in);
		int k =scn.nextInt();
		System.out.println(Queue_Kth_num(k));
	}
	public static String Queue_Kth_num(int k){
		Queue<String>q=new LinkedList<>();
		q.add("1");
		q.add("2");
		String ans="";
		for(int i=1;i<=k;i++){
			String temp=q.remove();
			if(i==k){
				ans=temp;
			}
			q.add(temp+"1");
			q.add(temp+"2");
		}
		return ans;

	}
}