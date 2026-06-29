// LU: Sorting_Count of Smaller after self
// Success rate: 27.54%
// Given an integer array nums, return an integer array counts where counts[i] is the number of elements smaller than nums[i] that are to the right of nums[i] in the array.

// Input Format:
// The first line contains an integer N, the size of the array.
// The second line contains N space-separated integers representing the elements of the array nums.

// Output Format:
// Print a space-separated list of integers where each integer represents the count of smaller elements to the right of the corresponding element in the input array.

// Constraints:
// 1 <= nums.length <= 10^5
// -10^4 <= nums[i] <= 10^4
import java.util.*;
public class lect1_6_countSmallerAfterSelf {
	static class Pair {
        int val;
        int index;

        Pair(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int [] ip  = new int[n];

        for (int i = 0; i < n; i++) {
            ip[i] = scn.nextInt();
        }
		Pair [] arr = new Pair[n];
		for(int i =0;i<n;i++){
			arr[i]= new Pair(ip[i], i);
		}
        CountSmallerAfterSelf(arr, n );
        
    }
	public static void  CountSmallerAfterSelf(Pair []arr , int n ){
		int []ans = new int[n]; 
		mergeSort(arr, 0, n - 1 , ans);
		for(int i =0;i<n;i++){
			System.out.print(ans[i]+" ");
		}
	}
	public static  void mergeSort(Pair [] arr , int low , int high , int[]ans){
		if(low>=high){
			return ;
		}
		int mid = low +(high-low)/2;
		mergeSort(arr , low , mid,ans);
		mergeSort(arr , mid+1,high,ans);
		merge(arr, low, mid, high, ans);
	}
	public static void merge(Pair [] arr , int low , int mid , int high , int[] ans){
		int i = low ;
		int j = mid+1;
		int k =0;
		int rightMoved = 0 ;
		Pair[] temp = new Pair[high - low + 1];
		while(i<=mid&&j<=high){
			if(arr[i].val<=arr[j].val){
				ans[arr[i].index]+=rightMoved;
				temp[k++]=arr[i++];
			}else{
				rightMoved++;
				temp[k++]=arr[j++];
			}
		}
		while(i<=mid){
			ans[arr[i].index]+=rightMoved;
			temp[k++]=arr[i++];
		}
		while(j<=high){
			temp[k++]=arr[j++];
		}
		for (int x = 0; x < temp.length; x++) {
            arr[low + x] = temp[x];
        }

	}

}