// LU: Sorting_Wiggle Sort
// Success rate: 46.97%
// Given an unsorted array nums, reorder it in-place so that the elements follow the pattern:

// nums[0] <= nums[1] >= nums[2] <= nums[3] ...

// There may be multiple correct answers; you only need to find one valid solution.

// Input Format:
// The first line contains an integer n, representing the size of the array.
// The second line contains n space-separated integers representing the elements of the array.

// Output Format:
// Output the modified array, reordered according to the specified pattern.

// Constraints:
// 1 ≤ N ≤ 10^5
import java.util.*;
public class lect3_2_Sorting_Wiggle_Sort {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int [] arr = new int[n];
		for(int i =0;i<n;i++){
			arr[i]=scn.nextInt();
		}
		WiggleSort(arr , n);
		for(int i =0;i<n;i++){
			System.out.print(arr[i]+" ");
		}
		
	}
	public static void WiggleSort(int[] arr , int n  ){
		for(int i =0;i<n-1;i++){
			if(i%2==0){
				if(arr[i]>arr[i+1]){
					int temp = arr[i];
					arr[i]= arr[i+1];
					arr[i+1]=temp;
				}
			}else{
				if(arr[i]<arr[i+1]){
					int temp = arr[i];
					arr[i]= arr[i+1];
					arr[i+1]=temp;
				}
			}
		}
	}
	
}