// LU: Hashmap 3_ Insert Delete GetRandom O(1)
// Success rate: 11.88%
// Implement the RandomizedSet class:

// RandomizedSet(): Initializes the RandomizedSet object.
// boolean insert(int val): Inserts an item val into the set if not present. Returns true if the item was not present, false otherwise.
// boolean remove(int val): Removes an item val from the set if present. Returns true if the item was present, false otherwise.
// int getRandom(): Returns a random element from the current set of elements (it's guaranteed that at least one element exists when this method is called). Each element must have the same probability of being returned.
// You must implement the functions of the class such that each function works in average O(1) time complexity.

// Input Format:
// The first line contains an integer q, the number of operations.
// Each of the following q lines contains a string representing the operation name (insert, remove, or getRandom) followed by an integer value if required.

// Output Format:
// For each operation that returns a value (insert and remove return boolean, getRandom returns an integer), print the result on a new line.

// Constraints:
// The functions insert, remove, and getRandom should all run in average O(1) time complexity.
import java.util.*;

class RandomizedSet {

    HashMap<Integer, Integer> map;
    ArrayList<Integer> list;
    Random random;

    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val))
            return false;

        map.put(val, list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val))
            return false;

        int idx = map.get(val);
        int lastVal = list.get(list.size() - 1);

        list.set(idx, lastVal);
        map.put(lastVal, idx);

        list.remove(list.size() - 1);
        map.remove(val);

        return true;
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}

public class lect3_1_Insert_Delete{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int q = sc.nextInt();

        RandomizedSet rs = new RandomizedSet();

        while (q-- > 0) {

            String op = sc.next();

            if (op.equals("insert")) {
                int x = sc.nextInt();
                System.out.println(rs.insert(x));
            }

            else if (op.equals("remove")) {
                int x = sc.nextInt();
                System.out.println(rs.remove(x));
            }

            else if (op.equals("getRandom")) {
                System.out.println(rs.getRandom());
            }
        }

        sc.close();
    }
}