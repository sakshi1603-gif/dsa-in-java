// LU: Trees_ Right View
// Success rate: 61.54%
// Given a binary tree, find the right view of it. The right view of a binary tree is the set of nodes visible when the tree is viewed from the right side. Return the right view as a list.

// Input Format:
// An integer n representing the number of nodes in the level-order traversal array.
// An array of integers representing the level-order traversal of the binary tree, where -1 denotes a null node.

// Output Format:
// A list of integers representing the right view of the binary tree.

// Constraints:
// 1 ≤ Number of nodes ≤ 10^5
// 0 ≤ Data of a node ≤ 10^5
import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class lect1_2_Right_View {

    public static Node buildTree(int[] arr) {

        if (arr.length == 0 || arr[0] == -1) {
            return null;
        }

        Node root = new Node(arr[0]);

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        int i = 1;

        while (!q.isEmpty() && i < arr.length) {

            Node current = q.poll();

            if (i < arr.length && arr[i] != -1) {
                current.left = new Node(arr[i]);
                q.add(current.left);
            }
            i++;

            if (i < arr.length && arr[i] != -1) {
                current.right = new Node(arr[i]);
                q.add(current.right);
            }
            i++;
        }

        return root;
    }

    public static void rightView(Node root) {

        if (root == null) {
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {

            int n = q.size();

            for (int i = 0; i < n; i++) {

                Node rem = q.poll();

                // Last node of every level
                if (i == n - 1) {
                    System.out.print(rem.data + " ");
                }

                if (rem.left != null) {
                    q.add(rem.left);
                }

                if (rem.right != null) {
                    q.add(rem.right);
                }
            }
        }
    }

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        Node root = buildTree(arr);

        rightView(root);
    }
}