// LU: Hashmap 3_ Insert Delete GetRandom O(1)-Duplicates
// Success rate: 15.79%
// You need to implement the RandomizedCollection class, which represents a collection of numbers that can contain duplicates (i.e., a multiset). The class should support insertion, removal of specific elements, and reporting a random element. The methods should run in average O(1) time complexity.

// Class Methods:
// RandomizedCollection(): Initializes an empty RandomizedCollection object.
// boolean insert(int val): Inserts an item val into the multiset. It returns true if the item was not already present, and false if it was.
// boolean remove(int val): Removes one occurrence of val from the multiset if it exists. Returns true if the item was present and removed, false otherwise.
// int getRandom(): Returns a random element from the current multiset. Each element's probability of being returned is proportional to its frequency in the multiset.

// Input Format:
// The input consists of method calls to the RandomizedCollection object, followed by the arguments for those methods.

// Output Format:
// The output should be the result of the method calls, printed in the order they are executed.

// Constraints:
// -2^31 <= val <= 2^31 - 1
// At most 2 * 105 calls in total will be made to insert, remove, and getRandom.
// There will be at least one element in the data structure when getRandom is called.
import java.util.*;

class RandomizedCollection {

    HashMap<Integer, HashSet<Integer>> map;
    ArrayList<Integer> list;
    Random random;

    public RandomizedCollection() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    public boolean insert(int val) {

        boolean first = false;

        if (!map.containsKey(val)) {
            map.put(val, new HashSet<>());
            first = true;
        }

        list.add(val);
        map.get(val).add(list.size() - 1);

        return first;
    }

    public boolean remove(int val) {

        if (!map.containsKey(val))
            return false;

        int removeIndex = map.get(val).iterator().next();
        map.get(val).remove(removeIndex);

        int lastIndex = list.size() - 1;
        int lastValue = list.get(lastIndex);

        if (removeIndex != lastIndex) {

            list.set(removeIndex, lastValue);

            map.get(lastValue).remove(lastIndex);
            map.get(lastValue).add(removeIndex);
        }

        list.remove(lastIndex);

        if (map.get(val).size() == 0)
            map.remove(val);

        return true;
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}

public class lect3_2_Insert_Delete_duplicate {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int q = sc.nextInt();

        RandomizedCollection rc = new RandomizedCollection();

        while (q-- > 0) {

            String op = sc.next();

            if (op.equals("insert")) {

                int x = sc.nextInt();
                System.out.println(rc.insert(x));

            } else if (op.equals("remove")) {

                int x = sc.nextInt();
                System.out.println(rc.remove(x));

            } else if (op.equals("getRandom")) {

                System.out.println(rc.getRandom());

            }
        }

        sc.close();
    }
}