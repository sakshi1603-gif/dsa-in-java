//optimised 
import java.util.Scanner;
public class Factor2 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int count=0;
		for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                if (i == n / i) { // perfect square case
                    count += 1;
                } else {
                    count += 2;
                }
            }
        }
		System.out.println(count);
	}
}

/* logic->
            N = 24

            i     n/i     compare      count
            --------------------------------
            1      24       <           +2
            2      12       <           +2
            3      8        <           +2     i < n/i
            4      6        <           +2     i^2 < n
            5      4.8      >           stop   i < √n

            --------------------------------
            Total count = 8
--------------------------------*/
