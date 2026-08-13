// LU: Trees_ isBST
// Success rate: 36.36%
// Given the root of a binary tree, determine if it is a valid binary search tree (BST).

// A valid BST is defined as follows:

// The left subtree of a node contains only nodes with keys less than the node's key.
// The right subtree of a node contains only nodes with keys greater than the node's key.
// Both the left and right subtrees must also be binary search trees.

// Input Format:
// The first line contains an integer n, the number of nodes in the binary tree.
// The second line contains n space-separated integers representing the level-order traversal of the binary tree where -1 denotes a null node.

// Output Format:
// Return true if the tree is a valid BST, otherwise false.

// Constraints:
// The number of nodes in the tree is in the range [1, 104].
// -2^31 <= Node.val <= 2^31 - 1
import java.util.*;

class Node {
    int val;
    Node left;
    Node right;

    Node(int val) {
        this.val = val;
    }
}

public class lect2_2_isBST {

    static Node buildTree(int[] arr) {
        if (arr.length == 0 || arr[0] == -1) {
            return null;
        }

        Node root = new Node(arr[0]);

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;

        while (!queue.isEmpty() && i < arr.length) {
            Node current = queue.poll();

            if (i < arr.length && arr[i] != -1) {
                current.left = new Node(arr[i]);
                queue.add(current.left);
            }
            i++;

            if (i < arr.length && arr[i] != -1) {
                current.right = new Node(arr[i]);
                queue.add(current.right);
            }
            i++;
        }

        return root;
    }

    static boolean isValidBST(Node root) {
        return isBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    static boolean isBST(Node root, long min, long max) {

        if (root == null) {
            return true;
        }

        if (root.val <= min || root.val >= max) {
            return false;
        }

        boolean left = isBST(root.left, min, root.val);
        boolean right = isBST(root.right, root.val, max);

        return left && right;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Node root = buildTree(arr);

        boolean result = isValidBST(root);

        System.out.print(result ? "true" : "false");

        sc.close();
    }
}