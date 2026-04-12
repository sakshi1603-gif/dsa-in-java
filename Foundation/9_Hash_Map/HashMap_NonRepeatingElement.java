// HashMap_NonRepeatingElement
// Success rate: 26.67%
// Find the first non-repeating element in a given array arr of N integers.

// Input Format:
// The first line contains size of array.
// Second line contains the elements of the array.

// Output Format:
// Output the required element

// Constraints:
// 1 <= N <= 10^7
// -10^16 <= Ai <= 10^16
// Array consists of only positive and negative integers and not zero.

import java.util.HashMap;
import java.util.Scanner;
public class HashMap_NonRepeatingElement{
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n= scn.nextInt();
		int []arr=new int[n];
		for(int i=0;i<n;i++){
			arr[i]=scn.nextInt();
		}
		int result =FirstNonRepeating(arr);
		System.out.println(result);
	}
    public static int FirstNonRepeating(int arr[]){
		int n = arr.length;
		HashMap<Integer ,Integer> hm=new HashMap<>();
		for(int i=0;i<n ;i++){
			if (!hm.containsKey(arr[i])){
				hm.put(arr[i],1);
			}else{
				int temp=hm.get(arr[i]);
				hm.put(arr[i],temp+1);
			}
		}
		for(int i=0;i<n;i++){
			if(hm.get(arr[i])==1){
				return arr[i];
			}
		}
		return -1;
	}
}