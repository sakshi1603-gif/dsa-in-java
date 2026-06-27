// BITS 2_Sum Of XOR
// Success rate: 44.64%
// Given an array of N integers, calculate the sum of XOR for all unique pairs (i, j) where 0 ≤ i < j < N. Specifically, find the sum of arr[i] XOR arr[j] for all pairs (i, j).

// Input Format:
// An integer N, the number of elements in the array.
// An array of N integers.

// Output Format:
// A single integer representing the sum of XOR for all unique pairs in the array.

// Constraints:
// 2 ≤ n ≤ 10^5
// 1 ≤ arr[i] ≤ 10^5
import java.util.*;

public class lect2_4_Sum_Of_XOR_HW {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
		int [] arr = new int[n];
		for(int i = 0;i<n;i++){
			arr[i]=scn.nextInt();
		}
        long ans = SumOfXOR(n , arr);
        System.out.println(ans);
    }

    public static long SumOfXOR(int n, int[] arr) {

    long ans = 0;

    	for (int i = 31; i >= 0; i--) {
		
    	    int count = 0;
	
    	    for (int j = 0; j < n; j++) {
			
    	        if ((arr[j] & (1 << i)) != 0) {
    	            count++;
    	        }
    	    }
	
    	    long contribution = (long) count * (n - count);
	
    	    ans += contribution * (1L << i);
    	}
	
    return ans;
}
}