// LU: Sorting_Sort partially sorted array
// Success rate: 52.54%
// Given N elements, first N-1 elements are sorted, Sort entire array and Print it.

// Input Format:
// The first line contains integer n representing the size of array
// The second line contains n elements of array.

// Output Format:
// Print the sorted array in a line separated by space

// Constraints:
// 1<= N <= 10 ^ 6
// 1<= A[i] <=10 ^ 9
import java.util.*;
public class lect2_7_Sorting_Sort_partially_sorted_array {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int [] arr  = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        SortPArray(arr , n );
		for(int i =0;i<n;i++){
			System.out.print(arr[i]+" ");
		}
    }
	public static void SortPArray(int [] arr , int n){
		for(int i =n-2;i>=0;i--){
			if(arr[i]>arr[i+1]){
				int temp = arr[i];
				arr[i]=arr[i+1];
				arr[i+1]=temp;
			}else{
				break;
			}
		}
	}
}