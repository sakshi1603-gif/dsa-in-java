// LU: Dequeue_ Generate the Binary Numbers
// Success rate: 51.61%
// Given an integer N, the task is to generate and print all binary numbers with decimal values from 1 to N.

// Input format:
// An integer N representing the number up to which binary numbers should be generated.

// Output format:
// A list of binary numbers from 1 to N, each on a new line.

// Constraints:
// 1 ≤ N ≤ 10^6
import java.util.*;
public class lect1_1_Generate_the_Binary_Numbers {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		BinaryNumbers(n);
	}
	public static void BinaryNumbers(int n ){
		Queue<String>q = new LinkedList<>();
		q.add("1");
		int count = 1 ;
		while(count<=n){
			String rem = q.remove();
			System.out.println(rem);
			q.add(rem+"0");
			q.add(rem+"1");
			count++;
		}
	}
}