//question no 4
// Arrays2_Reverse Part of Array
// Success rate: 34.42%
// Given n length Array and two valid index [s,e], You have to Reverse the array from s to e and print the final array.

// Input Format:
// Each of the test cases have 3 lines.
// The First line contains the size of the array n.
// The second line contains the n elements of the array.
// The third line contains two index s and e

// Output Format:
// Print all the array element in a line separated by space after reversing part of array [s,e]

// Constraints:
// 2 <= array length <= 10^5
// -10^4 <= array[i] <= 10^4
import java.util.Scanner;
public class Reverse_Part_of_Array {
	public static void main(String[] args) {
		Scanner scn = new  Scanner (System.in);
		 int n =scn.nextInt();
        int [] arr=new int [n];
		for(int i = 0 ;i<n;i++){
			arr[i]=scn.nextInt();
		}
		int start= scn.nextInt();
		int end= scn.nextInt();
		reverse(arr,start,end);
		for(int i = 0 ;i<n;i++){
			System.out.print(arr[i]+" ");
		}
	}
	public static void reverse(int [] arr,int sp,int ep){
		int n = arr.length;
		for(int i=0;sp<ep;i++){
			int temp =arr[sp];
			arr[sp]=arr[ep];
			arr[ep]=temp;
			sp++;
			ep--;
		}
		
		
	} 
}