
import java.util.HashMap;

public class lect2_1_LRU_Cache {

    static class LRUCache {

        class Node {
            int key;
            int val;
            Node next;
            Node prev;
        }

        HashMap<Integer, Node> hm;
        Node head;
        Node tail;
        int cap;

        public LRUCache(int capacity) {

            hm = new HashMap<>();

            head = new Node();
            tail = new Node();

            head.next = tail;
            tail.prev = head;

            cap = capacity;
        }

        public int get(int key) {

            if (hm.containsKey(key) == false) {
                return -1;
            }

            Node rem = delete(hm.get(key));
            add(tail, rem);

            return rem.val;
        }

        public void put(int key, int value) {

            Node result = hm.get(key);

            // Key already exists
            if (result != null) {

                result.val = value;

                Node rem = delete(result);
                add(tail, rem);
            }

            // Key does not exist
            else {

                Node newApp = new Node();

                newApp.key = key;
                newApp.val = value;

                // Cache is not full
                if (hm.size() != cap) {

                    Node added = add(tail, newApp);
                    hm.put(key, added);
                }

                // Cache is full
                else {

                    // Delete LRU node
                    Node delnode = delete(head.next);
                    hm.remove(delnode.key);

                    // Add new node as MRU
                    Node added = add(tail, newApp);
                    hm.put(key, added);
                }
            }
        }

        // Delete a node
        public Node delete(Node n) {

            Node nm1 = n.prev;
            Node np1 = n.next;

            nm1.next = np1;
            np1.prev = nm1;

            n.next = null;
            n.prev = null;

            return n;
        }

        // Add node just before tail
        public Node add(Node t, Node n) {

            n.prev = t.prev;
            t.prev = n;

            n.next = t;
            n.prev.next = n;

            return n;
        }

        // Optional: display cache
        public void display() {

            Node temp = head.next;

            while (temp != tail) {
                System.out.print("(" + temp.key + "," + temp.val + ") ");

                temp = temp.next;
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {

        LRUCache cache = new LRUCache(2);

        cache.put(1, 10);
        cache.put(2, 20);

        System.out.println(cache.get(1));  // 10

        cache.put(3, 30);

        System.out.println(cache.get(2));  // -1
        System.out.println(cache.get(3));  // 30
        System.out.println(cache.get(1));  // 10

        cache.display();
    }
}