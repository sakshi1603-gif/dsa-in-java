// LU: Maths 2_Sieve of Eratosthenes
// Success rate: 34.67%
// Given a number N, calculate all the prime numbers up to N using the Sieve of Eratosthenes algorithm.

// Input Format:
// An integer N representing the upper limit up to which prime numbers need to be calculated.
// Output Format:
// A list of integers representing all the prime numbers up to N.
// Constraints:
// 1<= N <= 10^4
import java.util.*;

public class lect2_1_SieveOfEratosthenes {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        boolean[] ans = sieveOfEratosthenes(n);
        for (int i = 0; i < n; i++) {
            if (ans[i] == true) {
                System.out.print(i + " ");
            }
        }

        sc.close();
    }

    public static boolean[] sieveOfEratosthenes(int n) {
        boolean[] ans = new boolean[n + 1];
        Arrays.fill(ans, true);
        ans[0] = false;
        ans[1] = false;
        for (int i = 2; i * i <= n; i++) {
            if (ans[i] == true) {
                for (int j = i * i; j <= n; j += i) {
                    ans[j] = false;
                }
            }
        }
        return ans;
    }
}
