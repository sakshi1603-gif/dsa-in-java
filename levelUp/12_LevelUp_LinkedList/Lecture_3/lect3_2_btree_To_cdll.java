class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class lect3_2_btree_To_cdll {

    // Convert Binary Tree to Circular Doubly Linked List
    static Node treeDLL(Node root) {

        if (root == null) {
            return null;
        }

        Node l = treeDLL(root.left);
        Node r = treeDLL(root.right);

        // Case 1: No left and no right
        if (l == null && r == null) {
            root.left = root;
            root.right = root;

            return root;
        }

        // Case 2: Only right subtree
        else if (l == null && r != null) {
            root.left = root;
            root.right = root;

            concatenate(root, r);

            return root;
        }

        // Case 3: Only left subtree
        else if (l != null && r == null) {
            root.left = root;
            root.right = root;

            concatenate(l, root);

            return l;
        }

        // Case 4: Both left and right subtree
        else {
            root.left = root;
            root.right = root;

            concatenate(l, root);
            concatenate(l, r);

            return l;
        }
    }

    // Concatenate two Circular Doubly Linked Lists
    static Node concatenate(Node H1, Node H2) {

        Node T1 = H1.left;
        Node T2 = H2.left;

        T1.right = H2;
        H2.left = T1;

        T2.right = H1;
        H1.left = T2;

        return H1;
    }

    // Print Circular Doubly Linked List
    static void printCDLL(Node head) {

        if (head == null) {
            return;
        }

        Node temp = head;

        do {
            System.out.print(temp.data + " ");
            temp = temp.right;
        } while (temp != head);

        System.out.println();
    }

    public static void main(String[] args) {

        /*
                 4
                / \
               2   6
              / \ / \
             1  3 5  7
        */

        Node root = new Node(4);

        root.left = new Node(2);
        root.right = new Node(6);

        root.left.left = new Node(1);
        root.left.right = new Node(3);

        root.right.left = new Node(5);
        root.right.right = new Node(7);

        // Convert tree to Circular Doubly Linked List
        Node head = treeDLL(root);

        // Print result
        System.out.println("Circular Doubly Linked List:");

        printCDLL(head);
    }
}