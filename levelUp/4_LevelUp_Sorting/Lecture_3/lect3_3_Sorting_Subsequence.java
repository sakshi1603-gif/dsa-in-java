// LU: Sorting_Subsequence
// Success rate: 33.33%
// Given an integer array nums containing unique elements, return all possible subsets (the power set). The solution set must not contain duplicate subsets. The subsets can be returned in any order.

// Input Format:
// An integer array nums where each element is unique.

// Output Format:
// A list of lists where each list represents a subset of nums.

// Constraints:
// 1 <= nums.length <= 10
// -10 <= nums[i] <= 10
// All the numbers of nums are unique.
import java.util.*;
public class lect3_3_Sorting_Subsequence {
	public static void main(String[] args) {
		Scanner scn = new Scanner (System.in);
		int n = scn.nextInt();
		int [] arr = new int[n];
		for(int i =0;i<n;i++){
			arr[i]=scn.nextInt();
		}
		List<List<Integer>> ans=SubSequence(arr , n );
		for (List<Integer> list : ans) {
		    System.out.println(list);
		}
	}
	public static List<List<Integer>> SubSequence(int [] arr , int n ){
		int totalrange= (1<<n);
		List<List<Integer>>ans = new ArrayList<>();
		for(int i =0;i<totalrange;i++){
			List<Integer>temp= new ArrayList<>();
			for(int j =0;j<n;j++){
				if(checkbit(i,j)==true){
					temp.add(arr[j]);
				}
			}
			ans.add(temp);
		}
		return ans;
	}
	public static boolean checkbit(int i , int j){
		return (i & (1 << j)) != 0;
	}
}