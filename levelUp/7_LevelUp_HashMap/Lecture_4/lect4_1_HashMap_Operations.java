// LU: Hashmap 4_HashMap Operations
// Success rate: 22.58%
// You need to implement various operations on a HashMap. You will be given a series of queries to perform different operations.

// The queries can be of the following four types:

// a x y - Adds an entry with key x and value y to the HashMap.
// b x - Prints the value associated with key x if present in the HashMap, otherwise prints -1.
// c - Prints the current size of the HashMap.
// d x - Removes the entry with key x from the HashMap.

// Input format:
// The first line contains an integer q, the number of queries.
// The next q lines contain one of the four types of queries.

// Output format:
// For each query of type b x, print the value associated with x or -1.
// For each query of type c, print the size of the HashMap.

// Constraints:
// 1 <= Q <= 100
import java.io.*;
import java.util.*;

public class lect4_1_HashMap_Operations {

    public static class HashMap<K, V> {

        private class HMNode {
            K key;
            V value;

            HMNode(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int size;
        private LinkedList<HMNode>[] buckets;

        public HashMap() {
            initbuckets(4);
            size = 0;
        }

        public void put(K key, V value) throws Exception {
            int bi = hashFunction(key);
            int di = findInBucket(bi, key);

            if (di == -1) {
                HMNode node = new HMNode(key, value);
                buckets[bi].addLast(node);
                size++;
            } else {
                HMNode node = buckets[bi].get(di);
                node.value = value;
            }

            double lambda = size * 1.0 / buckets.length;

            if (lambda > 2.0) {
                rehash();
            }
        }

        public V get(K key) throws Exception {
            int bi = hashFunction(key);
            int di = findInBucket(bi, key);

            if (di == -1) {
                return null;
            } else {
                HMNode node = buckets[bi].get(di);
                return node.value;
            }
        }

        public boolean containsKey(K key) {
            int bi = hashFunction(key);
            int di = findInBucket(bi, key);

            return di != -1;
        }

        public V remove(K key) throws Exception {
            int bi = hashFunction(key);
            int di = findInBucket(bi, key);

            if (di == -1) {
                return null;
            } else {
                HMNode node = buckets[bi].remove(di);
                size--;
                return node.value;
            }
        }

        public ArrayList<K> keyset() {
            ArrayList<K> set = new ArrayList<>();

            for (int bi = 0; bi < buckets.length; bi++) {
                for (HMNode node : buckets[bi]) {
                    set.add(node.key);
                }
            }

            return set;
        }

        public int size() {
            return size;
        }

        public void display() {
            System.out.println("Display Begins");

            for (int bi = 0; bi < buckets.length; bi++) {
                System.out.print("Bucket " + bi + " ");

                for (HMNode node : buckets[bi]) {
                    System.out.print(node.key + "@" + node.value + " ");
                }

                System.out.println(".");
            }

            System.out.println("Display Ends");
        }

        private int hashFunction(K key) {
            int hc = key.hashCode();
            return Math.abs(hc) % buckets.length;
        }

        private int findInBucket(int bi, K key) {
            int di = 0;

            for (HMNode node : buckets[bi]) {
                if (node.key.equals(key)) {
                    return di;
                }
                di++;
            }

            return -1;
        }

        private void rehash() throws Exception {
            LinkedList<HMNode>[] oldBuckets = buckets;

            initbuckets(2 * oldBuckets.length);
            size = 0;

            for (int bi = 0; bi < oldBuckets.length; bi++) {
                for (HMNode node : oldBuckets[bi]) {
                    put(node.key, node.value);
                }
            }
        }

        private void initbuckets(int N) {
            buckets = new LinkedList[N];

            for (int i = 0; i < N; i++) {
                buckets[i] = new LinkedList<>();
            }
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<Integer, Integer> map = new HashMap<>();

        int q = Integer.parseInt(br.readLine());

        while (q-- > 0) {

            String[] parts = br.readLine().split(" ");

            char ch = parts[0].charAt(0);

            if (ch == 'a') {

                int key = Integer.parseInt(parts[1]);
                int value = Integer.parseInt(parts[2]);

                map.put(key, value);

            } else if (ch == 'b') {

                int key = Integer.parseInt(parts[1]);

                Integer ans = map.get(key);

                if (ans == null) {
                    System.out.println(-1);
                } else {
                    System.out.println(ans);
                }

            } else if (ch == 'c') {

                System.out.println(map.size());

            } else if (ch == 'd') {

                int key = Integer.parseInt(parts[1]);

                map.remove(key);
            }
        }
    }
}