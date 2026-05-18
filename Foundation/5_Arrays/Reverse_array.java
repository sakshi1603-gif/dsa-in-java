//question no 3 
// Arrays2_Reverse Array
// Success rate: 31.08%
// Given n length Array, You have to Reverse the entire array and print it.

// Input Format:
// Each of the test cases have 2 lines.
// The First line contains the size of the array n.
// The second line contains the n elements of the array.

// Output Format:
// Print all the array element in a line separated by space after reversing it

// Constraints:
// 2 <= array length <= 10^5
// -10^4 <= array[i] <= 10^4

import java.util.Scanner;
public class Reverse_array {
	public static void main(String[] args) {
		Scanner scn = new  Scanner (System.in);
		 int n =scn.nextInt();
        int [] arr=new int [n];
		for(int i = 0 ;i<n;i++){
			arr[i]=scn.nextInt();
		}
		
		reverse(arr);
		for(int i = 0 ;i<n;i++){
			System.out.print(arr[i]+" ");
		}
	}
	public static void reverse(int [] arr){
		int n = arr.length;
		int sp = 0;
		int ep = n-1;
		for(int i=0;sp<ep;i++){
			int temp =arr[sp];
			arr[sp]=arr[ep];
			arr[ep]=temp;
			sp++;
			ep--;
		}
		
		
	} 
}