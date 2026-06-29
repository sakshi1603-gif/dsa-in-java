// LU: Sorting_Insertion sort
// Success rate: 50.65%
// The task is to implement the insert() function, which is part of the Insertion Sort algorithm. This function ensures that the elements up to the i-th index in the array are sorted. The insertionSort() function sorts the entire array using the Insertion Sort algorithm.

// Input Format:
// The first line contains an integer N, the size of the array.
// The second line contains N space-separated integers representing the elements of the array.

// Output Format:
// Print the sorted array as a single line of space-separated integers.

// Constraints:
// 1 <= N <= 1000
// 1 <= arr[i] <= 1000
import java.util.*;
public class lect2_8_Sorting_Insertion_sort {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int [] arr  = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        InsertionSort(arr , n );
		for(int i =0;i<n;i++){
			System.out.print(arr[i]+" ");
		}
    }
	public static void InsertionSort(int [] arr , int n){
		for(int i =1;i<n;i++){
			for(int j =i-1;j>=0;j--){
				if(arr[j]>arr[j+1]){
					int temp = arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}else{
					break;
				}
		}
		}
		
	}
}