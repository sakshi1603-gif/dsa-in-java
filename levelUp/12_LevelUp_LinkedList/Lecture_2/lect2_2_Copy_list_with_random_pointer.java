
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class lect2_2_Copy_list_with_random_pointer {

    public static Node copyRandomList(Node head) {

        if (head == null) {
            return null;
        }

        // 1. Insert copied nodes between original nodes
        Node temp = head;

        while (temp != null) {

            Node n1 = new Node(temp.val);

            Node nextNode = temp.next;

            temp.next = n1;
            n1.next = nextNode;

            temp = nextNode;
        }

        // 2. Copy random pointers
        Node t = head;

        while (t != null) {

            if (t.random != null) {
                t.next.random = t.random.next;
            }

            t = t.next.next;
        }

        // 3. Separate original and copied list
        Node h1 = head;
        Node h2 = head.next;

        Node ans = h2;

        while (h1 != null) {

            h1.next = h1.next.next;

            if (h2.next != null) {
                h2.next = h2.next.next;
            }

            h1 = h1.next;
            h2 = h2.next;
        }

        return ans;
    }

    // Print list
    public static void printList(Node head) {

        Node temp = head;

        while (temp != null) {

            System.out.print(
                "[" + temp.val + ", "
                + (temp.random != null ? temp.random.val : "null")
                + "] "
            );

            temp = temp.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        // Create nodes
        Node n1 = new Node(7);
        Node n2 = new Node(13);
        Node n3 = new Node(11);
        Node n4 = new Node(10);
        Node n5 = new Node(1);

        // next pointers
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        // random pointers
        n1.random = null;
        n2.random = n1;
        n3.random = n5;
        n4.random = n3;
        n5.random = n1;

        // Copy list
        Node copiedHead = copyRandomList(n1);

        // Print copied list
        System.out.println("Copied List:");
        printList(copiedHead);
    }
}