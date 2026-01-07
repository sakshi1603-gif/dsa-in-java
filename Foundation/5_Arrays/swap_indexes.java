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