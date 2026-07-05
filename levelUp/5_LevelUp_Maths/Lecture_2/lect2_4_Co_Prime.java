// LU: Maths 2_Co Prime pairs
// Success rate: 31.58%
// Given N which is even, your task is to create N/2 pairs using numbers {1,2....,N} such that each pair is a co-prime. if not possible return -1.

// Input Format:
// The first and only line contains an integer N

// Constraints:
// 1 <= N <= 10^5

// Output Format:
// Output N/2 pairs. Print 1 pair in a line.
import java.util.*;

public class lect2_4_Co_Prime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int count = 1;

        for (int i = 0; i*i<=n; i++) {
            System.out.println(count + " " + (count + 1));
            count += 2;
        }

        sc.close();
    }
}
//fact gcd(i , i+1) =1