//question no 6
// Arrays2_Count Greater
// Success rate: 26.55%
// Given n length Array, You have to count total no. of elements in the array having atleast 1 element greater than itself.

// Input Format:
// Each of the test cases have 2 lines.
// The First line contains the size of the array n.
// The second line contains the n elements of the array.

// Output Format:
// Print a single Integer representing total no. of elements in the array having atleast 1 element greater than itself.

// Constraints:
// 2 <= array length <= 10^5
// -10^4 <= array[i] <= 10^4
import java.util.Scanner;
public class Count_Greater {
	public static void main(String[] args) {
		Scanner scn = new  Scanner (System.in);
		 int n =scn.nextInt();
        int [] arr=new int [n];
		for(int i = 0 ;i<n;i++){
			arr[i]=scn.nextInt();
		}
		int count = CountGreater(arr);
		System.out.println(count);
		
	}
	public static int CountGreater(int [] arr ){
		int n=arr.length;
		int max=arr[0];
		for(int i =0 ;i<n;i++){
			if(arr[i]>max){
				max=arr[i];
			}
		}
		int countmax=0;
		for(int i =0 ;i<n;i++){
			if(arr[i]==max){
				countmax++;
			}
		}
		return (n-countmax);
	} 
}