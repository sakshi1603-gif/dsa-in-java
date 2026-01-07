// HashMap_PairSum Optimal
// Success rate: 28.54%
// Given an array Arr of N positive integers and another number X. Determine whether or not there exist two elements in Arr whose sum is exactly X.

// Input Format:
// The first line contains size of array and required sum
// Second line contains the elements of the array.

// Output Format:
// Output Y for Yes or N for No

// Constraints:
// 1 ≤ N ≤ 10^5
// 1 ≤ Arr[i] ≤ 10^5

import java.util.HashMap;
import java.util.Scanner;

public class HashMap_PairSum_Optimal {
	public static void main(String[] args) {

		// Scanner to take input from user
		Scanner scn = new Scanner(System.in);

		// n = number of elements in array
		int n = scn.nextInt();

		// k = target sum
		int k = scn.nextInt();

		// Declare array of size n
		int[] arr = new int[n];

		// Read array elements
		for(int i = 0; i < n; i++){
			arr[i] = scn.nextInt();
		}

		// Call function to check if any pair sums to k
		char result = pairSum(arr, k);

		// Print result ('Y' or 'N')
		System.out.println(result); 
	}

	// Function to check if there exists a pair with sum = k
	public static char pairSum(int arr[], int k ){

		// Length of array
		int n = arr.length;

		// HashMap to store element frequencies
		// Key   -> element value
		// Value -> count of that element
		HashMap<Integer, Integer> hm = new HashMap<>();

		// Store frequency of each element in HashMap
		for(int i = 0; i < n; i++){
			if(!hm.containsKey(arr[i])){
				hm.put(arr[i], 1);
			}else{
				int temp = hm.get(arr[i]);
				hm.put(arr[i], temp + 1);
			}
		}

		// Check for pair whose sum is equal to k
		for(int i = 0; i < n; i++){

			// Current element
			int a = arr[i];

			// Required element to make sum = k
			int b = k - a;

			// Case 1: a and b are different values
			if(a != b && hm.containsKey(b)){
				return 'Y';
			}
			// Case 2: a and b are same, need at least two occurrences
			else if(a == b && hm.get(b) >= 2){
				return 'Y';
			}
		}

		// No valid pair found
		return 'N';
	}
}
