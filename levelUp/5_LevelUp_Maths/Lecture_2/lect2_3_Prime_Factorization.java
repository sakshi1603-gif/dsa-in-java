// LU: Maths 2_Prime Factorization for multiple queries
// Success rate: 41.30%
// Given N and multiple queries of integers in the range 1 to N, you have to prime factorize for every query.

// Input Format:
// The first line contains an integer n and number of queries q.
// The second line contains q integers representing the queries.

// Output Format:
// Output the prime factors of 1 query in a line.

// Constraints:
// 1 <= n <= 10^5
import java.util.*;

public class lect2_3_Prime_Factorization {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
		int q = sc.nextInt();
		int [] query = new int[q];
		for(int i =0;i<q;i++){
			query[i]=sc.nextInt();
		}
	    PrimeFactorization(n , query);
        sc.close();
    }
	public static void PrimeFactorization(int n, int[] query) {
		int[] spf = SPF(n);

		for (int i = 0; i < query.length; i++) {
		    int x = query[i];
		    while (x > 1) {
		        System.out.print(spf[x] + " ");
		        x = x / spf[x];
		    }
		    System.out.println();
		}
		
}
	public static int [] SPF(int n ){
		int [] spf = new int[n+1];
		for(int i =0;i<=n;i++){
			spf[i]=i;
		}
		for(int i = 2;i*i<=n;i++){
			if(spf[i]==i){
				for(int j = i*i;j<=n;j=j+i){
						spf[j]=Math.min(spf[j],i);
				}
			}
		}
		return spf ;
	}
}