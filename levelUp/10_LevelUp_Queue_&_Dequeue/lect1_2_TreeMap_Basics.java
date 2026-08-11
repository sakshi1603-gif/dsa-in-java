// LU: Dequeue_ TreeMap Basics
// Success rate: 38.18%
// You are required to implement different operations on a TreeMap. The operations will be performed based on different types of queries. The queries can be of the following types:

// a x y: Add an entry with key x and value y to the TreeMap.
// b x: Print the value associated with key x if it exists in the TreeMap; otherwise, print -1.
// c: Print the size of the TreeMap.
// d x: Remove the entry with key x from the TreeMap.
// e: Print the keys of the TreeMap sorted in ascending order.

// Input Format:
// The first line contains an integer q, the number of queries.
// The next q lines contain one of the five types of queries described above.

// Output Format:
// The output will vary based on the type of query:
// For query b x, print the value associated with x or -1 if x does not exist.
// For query c, print the size of the TreeMap.
// For query e, print the keys of the TreeMap in ascending order.

// Constraints:
// 1 ≤ q ≤ 10^4 (Number of queries)
// 1 ≤ x, y ≤ 10^9 (Values of keys and values)
// The queries will be valid, and operations will be performed on integers only.
// All keys will be unique in the TreeMap.
import java.util.*;

public class lect1_2_TreeMap_Basics {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int q = sc.nextInt();

        TreeMap<Integer, Integer> map = new TreeMap<>();

        while (q-- > 0) {
            char type = sc.next().charAt(0);

            if (type == 'a') {
                int x = sc.nextInt();
                int y = sc.nextInt();
                map.put(x, y);
            }
            else if (type == 'b') {
                int x = sc.nextInt();
                System.out.println(map.getOrDefault(x, -1));
            }
            else if (type == 'c') {
                System.out.println(map.size());
            }
            else if (type == 'd') {
                int x = sc.nextInt();
                map.remove(x);
            }
            else if (type == 'e') {
                for (int key : map.keySet()) {
                    System.out.print(key + " ");
                }
                System.out.println();
            }
        }
    }
}