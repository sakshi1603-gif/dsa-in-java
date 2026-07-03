// LU: Sorting_Count Sort
// Success rate: 21.43%
// Given a string arr consisting of lowercase English letters, arrange all its letters in lexicographical order using the Counting Sort algorithm.

// Input Format:
// A single line containing the string arr.

// Output Format:
// A single line containing the string with its characters arranged in lexicographical order.

// Constraints:
// 1 ≤ N ≤ 10^5
import java.util.*;
public class lect3_1_Sorting_Count_Sort {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.nextLine();
		String ans = Countsort(str);
		System.out.println(ans);
	}
	public static String Countsort(String str ){
		char [] arr = str.toCharArray();
		int  max = 0 ;
		for(int i = 0;i<arr.length;i++){
			max = Math.max(arr[i], max);
		}
		int []count =new int[max+1];
		for(int i =0;i<arr.length;i++){
			int val = arr[i];
			count[val]++;
		} 
		int  k =0;
		for(int i =0;i<count.length;i++){
			int c = count[i];
			for(int j = 0;j<c;j++){
				arr[k]=(char)i ;k++;
			}
		}
		return new String(arr);
	}
}