//Question no 2 
// Arrays1_Swap Indexes
// Success rate: 24.07%
// Given n length Array and 2 indexes, You have to swap the elements of 2 indexes and print the array.

// Input Format:
// Each of the test cases have 3 lines.
// The First line contains the size of the array n.
// The second line contains the n elements of the array.
// The third line contains two index.

// Output Format:
// Print all the array element in a line separated by space after swapping

// Constraints:
// 2 <= array length <= 10^5
// -10^4 <= array[i] <= 10^4
// 0 <= indexs < array length
//Given n length Array and 2 indexes, 
//You have to swap the elements of 2 indexes and print the array.
import java.util.Scanner;
public class swap_indexes {
	public static void main(String[] args) {
		Scanner scn = new  Scanner (System.in);
		 int n =scn.nextInt();
        int [] arr=new int [n];
		for(int i = 0 ;i<n;i++){
			arr[i]=scn.nextInt();
		}
		int a =scn.nextInt();
		int b =scn.nextInt();
		swap(arr,a,b);
		for(int i = 0 ;i<n;i++){
			System.out.print(arr[i]+" ");
		}
	}
	public static void swap(int [] arr , int a , int b ){
		int temp =arr[a];
		arr[a]=arr[b];
		arr[b]=temp;
		
	} 
}