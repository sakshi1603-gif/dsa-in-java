// Sorting_Bubble Sort
// Success rate: 31.23%
// Given N array Integers, Sort the array using Bubble sort technique

// Input Format:
// Integer representing N representing length of array
// N numbers of Array

// Output Format:
// Print the sorted array in a line separated by space

// Constraints:
// 1<= N <= 10 ^ 6
// 1<= A[i] <=10 ^ 9

import java.util.Scanner;
public class Sorting_Bubble_Sort {
	public static void main(String[] args) {
		Scanner scn= new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr= new int[n];
		for(int i=0;i<n;i++){
			arr[i]=scn.nextInt();
		}
		Bubble_Sort(arr,n);
	}
	public static void Bubble_Sort(int arr[],int n){
		for(int i=0;i<=n-2;i++){
			for(int j=0;j<=n-2-i;j++){
				if(arr[j]>arr[j+1]){
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
		for(int i=0;i<n;i++){
			System.out.print(arr[i]+" ");
		}
		
	}
}