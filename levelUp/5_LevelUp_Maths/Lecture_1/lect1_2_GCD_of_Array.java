// LU: Maths(GCD)_GCD of Array
// Success rate: 43.24%
// Given N integers, Calculate the GCD of all the numbers

// Input Format:
// The first line contains the length of array N
// The second line contains N element representing the element of Array

// Output Format:
// Output the final GCD of Number

// Constraints:
// 1 <= N <= 10^4
// 1 <= arr[i] <= 10^9

// Sample test cases
import java.util.Scanner;

public class lect1_2_GCD_of_Array {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int [] arr = new int[n];
		for(int i =0;i<n;i++){
			arr[i]=scn.nextInt();
		}
		GCDofArray(arr);
		
	}
	public static void GCDofArray(int [] arr){
		int n = arr.length;
		int ans =Math.abs(arr[0]);
		for(int i = 1 ;i<n;i++){
			ans =GCD(ans ,Math.abs(arr[i]));
		}
		System.out.println(ans);
	}
	public static int GCD(int a , int b ){
		if(a==0){
			return b ;
		}
		int temp = GCD(b%a , a);
		return temp;
	}
}