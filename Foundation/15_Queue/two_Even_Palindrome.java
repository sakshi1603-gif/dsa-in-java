// Queue_Even Palindrome Kth Number
// Success rate: 31.65%
// Given K, Print the Kth Palindrome Number in the increasing series of even digit numbers using digits 1 and 2 only.

// Input Format:
// The only line contains number K

// Output Format:
// Return the kth number of the series

// Constraints:

// 1<= K <=20
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class two_Even_Palindrome{
	public static void main(String[] args) {
		Scanner scn= new Scanner(System.in);
		int k = scn.nextInt();
		System.out.println(kthPalindrom(k));
	}
	public static String kthPalindrom(int k){
		Queue<String>q=new LinkedList <>();
		q.add("11");
		q.add("22");
		String ans="";
		for(int i=1;i<=k;i++){
			String temp=q.remove();
			if(i==k){
				ans=temp;
			}
			String left=temp.substring(0,temp.length()/2);
			String right=temp.substring(temp.length()/2,temp.length());
			q.add(left+"11"+right);
			q.add(left+"22"+right);
		}
		return ans;
	}
}