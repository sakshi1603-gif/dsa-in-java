//question no 8
// Arrays1_Max of Array
// Success rate: 44.50%
// Given n length Array, You have to return max out of all the elements.

// Input Format:
// Each of the test cases has 2 lines.
// First Line contains the size of the array n, while the second contains the n elements of the array.

// Output Format:
// Return an integer which is the max of all the array elements.

// Constraints:
// 2 <= array length <= 10^5
// -10^4 <= array[i] <= 10^4
import java.util.Scanner;
public class Max_element{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n =scn.nextInt();
        int [] arr=new int [n];
        for(int i=0 ;i<n;i++){
            arr[i]= scn.nextInt();
        }
		int maxelem = max(arr);
		System.out.println(maxelem);
    }
	public static int max(int[]arr ){
		int n = arr.length;
		int max=arr[0];
		for(int i=1;i<n;i++){
			if(max<arr[i]){
				max=arr[i];
			}
		}
		return max;
	}
}