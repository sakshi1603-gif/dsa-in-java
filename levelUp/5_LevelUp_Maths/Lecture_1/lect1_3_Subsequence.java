// LU: Maths(GCD)_ Subsequence With GCD 1
// Success rate: 69.23%
// Given N integers, Check if there exists a subsequence with gcd == 1.

// Input Format:
// The first line contains the length of array N
// The second line contains N element representing the element of Array

// Output Format:
// Output true if there exists a subsequence with GCD 1 else Output false.

// Constraints:
// 1 <= N <= 10^4
// 1 <= arr[i] <= 10^9
import java.util.Scanner;

public class lect1_3_Subsequence {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int [] arr = new int[n];
		for(int i =0;i<n;i++){
			arr[i]=scn.nextInt();
		}
		boolean ans = GCDofArray(arr);
		System.out.println(ans);
		
	}
	public static boolean GCDofArray(int [] arr){
		int n = arr.length;
		int ans =Math.abs(arr[0]);
		for(int i = 1 ;i<n;i++){
			ans =GCD(ans ,Math.abs(arr[i]));
		}
		if(ans == 1 ){
			return true;
		}else{
			return false;
		}
	}
	public static int GCD(int a , int b ){
		if(a==0){
			return b ;
		}
		int temp = GCD(b%a , a);
		return temp;
	}
}