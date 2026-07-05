// LU: Maths 2_Least Prime Factors
// Success rate: 20.00%
// Given a number N, find the least prime factors for all numbers from 1 to N. The least prime factor of an integer X is the smallest prime number that divides it.

// Note: For the number 1, the least prime factor is 1.
// The solution should return an array (or list) of size N+1 using 1-based indexing, where each index i contains the least prime factor of i.

// Input Format:
// The input contains a single integer N.

// Output Format:
// The output is an array of integers of size N+1, where the value at each index represents the least prime factor of that index.

// Constraints:
// 2<= n <=10^5
import java.util.*;

public class lect2_2_Least_Prime_Factors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
	    int [] spf = LeastPrimeFactors(n);
		System.out.print("[");
		for(int i =0;i<n;i++){
				System.out.print(spf[i]+", ");
		}
		System.out.println(spf[n]+"]");
        sc.close();
    }
	public static int [] LeastPrimeFactors(int n ){
		int [] spf = new int[n+1];
		for(int i =0;i<=n;i++){
			spf[i]=i;
		}
		for(int i = 2;i*i<=n;i++){
			if(spf[i]==i){
				for(int j = i*i;j<=n;j=j+i){
					if(spf[j]>i){
						spf[j]=i;
					}
				}
			}
		}
		return spf ;
	}
}