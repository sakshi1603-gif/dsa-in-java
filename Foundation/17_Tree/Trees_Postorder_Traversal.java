// Trees_Postorder Traversal
// Success rate: 1.61%
// Given the root of a binary tree, return the inorder traversal of its nodes' values.

// Input Format:
// The input consists of a sequence of integers where the first integer represents the root of the binary tree.
// Subsequent integers represent the level-order traversal of the tree, where -1 denotes a null node.
// The input is space-separated.

// Output Format:
// Output the inorder traversal of the binary tree as space-separated integers.

// Constraints:
// The number of the nodes in the tree is in the range [0, 100].
// -100 <= Node.data <= 100

import java.util.*;

class Node {
    int val;
    Node left;
    Node right;

    Node(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class Trees_Postorder_Traversal {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        String[] input = scn.nextLine().split(" ");
        int[] arr = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        Node root = buildTree(arr);
        postOrder(root);
    }

    // Build tree from level order
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

            // Left child
            if (i < arr.length && arr[i] != -1) {
                current.left = new Node(arr[i]);
                q.add(current.left);
            }
            i++;

            // Right child
            if (i < arr.length && arr[i] != -1) {
                current.right = new Node(arr[i]);
                q.add(current.right);
            }
            i++;
        }

        return root;
    }

    // Postorder Traversal: Left → Right → Root
    public static void postOrder(Node root) {
        if (root == null) {
            return;
        }

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }
}