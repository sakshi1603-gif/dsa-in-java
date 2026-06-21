// Arrays5_Flip Bits
// Success rate: 51.69%
// Given an integer array A[] consisting of 0’s and 1’s, you are allowed to perform at most one flip operation on any subarray. A flip operation changes 1 to 0 and 0 to 1. Your goal is to maximize the number of 1’s in the array after performing the flip operation. If no flip is needed to get the maximum number of 1’s, you can choose to do zero flips.

// Return the maximum number of 1’s you can get in the array after performing the flip operation.

// Input Format:
// The first line contains an integer n (the length of the array).
// The second line contains n space-separated integers representing the array A where each integer is either 0 or 1.

// Output Format:
// Output a single integer which is the maximum number of 1’s possible after at most one flip operation.

// Constraints:
// 1 ≤ N ≤ 10^6
// 0 ≤ A[i] ≤ 1
import java.util.*;

public class lect5_6_Flip_Bits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(Flip_Bits(arr , n ));
    }
	public static int Flip_Bits(int [] arr , int n ){
		int count = 0;
		for(int i=0;i<n;i++){
			if(arr[i]==0){
				arr[i]=1;
			}else{
				arr[i]=-1;
				count++;

			}
		}
		int sum = 0;
		int max = Integer.MIN_VALUE;

		for(int i=0;i<n;i++){
			if(sum>=0){
				sum=sum+arr[i];
			}else{
				sum=arr[i];
			}
			max=Math.max(max , sum);
		}
		if(max>0){
			return max+count;
		}else{
			return count;
		}
	}
}