// LU: Trees_ Populate next pointer to Right
// Success rate: 6.45%
// You are given a perfect binary tree where all leaves are at the same level, and every parent node has two children. The task is to populate each node's next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL. Initially, all next pointers are set to NULL.

// Input Format:
// The first line contains an integer n denoting the total number of nodes (including null nodes represented by -1).
// The second line contains n integers representing the node values of the binary tree in level order, with -1 for null nodes.

// Output Format:
// Print the tree level-wise, but for each node, print its value followed by its next pointer value (if it exists) or null (if no next).

// Constraints:
// The number of nodes in the tree is in the range [0, 212 - 1].
// -1000 <= Node.val <= 1000
import java.util.*;

public class lect3_3_Populate_next_pointer {

    static class Node {
        int val;
        Node left;
        Node right;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    static Node buildTree(int[] arr) {
        if (arr.length == 0 || arr[0] == -1) {
            return null;
        }

        Node root = new Node(arr[0]);
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;

        while (!queue.isEmpty() && i < arr.length) {
            Node curr = queue.poll();

            if (i < arr.length && arr[i] != -1) {
                curr.left = new Node(arr[i]);
                queue.offer(curr.left);
            }
            i++;

            if (i < arr.length && arr[i] != -1) {
                curr.right = new Node(arr[i]);
                queue.offer(curr.right);
            }
            i++;
        }

        return root;
    }

    static Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Node currlevel = root;

        while (currlevel.left != null) {
            Node temp = currlevel;

            while (temp != null) {
                temp.left.next = temp.right;

                if (temp.next != null) {
                    temp.right.next = temp.next.left;
                }

                temp = temp.next;
            }

            currlevel = currlevel.left;
        }

        return root;
    }

    static void printTree(Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        boolean first = true;

        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            if (!first) {
                System.out.print(" ");
            }

            System.out.print(curr.val + "->");

            if (curr.next != null) {
                System.out.print(curr.next.val);
            } else {
                System.out.print("null");
            }

            first = false;

            if (curr.left != null) {
                queue.offer(curr.left);
            }

            if (curr.right != null) {
                queue.offer(curr.right);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Node root = buildTree(arr);
        connect(root);
        printTree(root);

        sc.close();
    }
}