//question no 7 
// Arrays2_Two Sum Brute
// Success rate: 32.31%
// Given n length array "arr" and an integer k, Check if there exists a pair(i,j) such that arr[i]+arr[j] == k and i!=j

// Input Format:
// Each of the test cases have 3 lines.
// The First line contains the size of the array n.
// The second line contains the n elements of the array.
// The third line contains an integer k

// Output Format:
// Print true if there is a valid pair present else print false.

// Constraints:
// 2 <= array length <= 10^5
// -10^4 <= array[i] <= 10^4

import java.util.Scanner;
public class Two_Sum_Brute {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n =scn.nextInt();
        int [] arr=new int [n];
        for(int i=0 ;i<n;i++){
            arr[i]= scn.nextInt();
        }
		int k =scn.nextInt();
		boolean ans = twosum(arr,k);
		System.out.println(ans);
    }
	public static boolean twosum(int[]arr ,int k){
		int n =arr.length;
		for(int i=0;i<n-1;i++){
			for(int j=i+1;j<n;j++){
				if(arr[i]+arr[j]==k){
					return true;
				}
			}
		}
		return false;
	}
}