// You need to find the square root of a given number N. If N is not a perfect square, then floor(√x) must be returned.

// Input Format:
// Each of the test cases have one line containing the number N.

// Output Format:
// Output a line containing the required output for above query.

// brutforce approach 
//time complexity ->O(1)-> it will fail for some inputs 

// import java.util.Scanner;
// public class floor {
// 	public static void main(String[] args) {
// 		Scanner scn = new Scanner(System.in);
// 		int n = scn.nextInt();
// 		double val = Math.floor(Math.sqrt(n));
// 		int ans = (int) val;
// 		System.out.println(ans);
// 	}
// }

//better approach but not fully optimised ->O(sqrt(n))

import java.util.Scanner;
public class floor {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int ans = sqrt(n);
		System.out.println(ans);
	}
	public static int sqrt(int n ){
		int ans = 0;
		for(int i=1 ; i*i<=n ; i++){
			ans= i ;
		}
		return ans;
	}
}
