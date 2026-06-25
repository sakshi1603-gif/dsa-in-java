// BITS 1_Elements repeating four times 2
// Success rate: 83.78%
// Given an array arr[] of N positive elements in which every element is repeating 4 times but 1 element is repeating 2 times. Find the element repeating 2 times.

// Input Format:
// The first line contains size of array.
// Second line contains the elements of the array.

// Output Format:
// Output the required number.

// Constraints:
// 1 <= N <= 10^5
// 1 <= arr[i] <= 10^5
import java.util.*;

public class lect1_9_Elements_repeating_4_times_2 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int ans = SingleElement(n, arr);
        System.out.println(ans);
    }

    public static int SingleElement(int n, int[] arr) {
        int ans  =0;
		for(int i =0 ;i<32;i++){
			int count = 0;
			for(int j = 0;j<n;j++){
				if((arr[j]&(1<<i))!=0){
					count ++;
				}
			}
			if(count % 4==2){
				ans = ans|(1<<i);
			}
		}
		return ans;
    }
}