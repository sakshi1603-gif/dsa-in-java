// LU: Trees_ Search in BST
// Success rate: 20.83%
// You are given the root of a binary search tree (BST) and an integer val. Find the node in the BST where the node's value equals val and return the subtree rooted with that node. If such a node does not exist, return null.

// Input format:
// First line contains the number of nodes in the tree.
// Second line contains the elements of the tree in level-order, where -1 represents a null node.
// Third line contains the integer val to search in the BST.

// Output format:
// If the node is found, print the elements of the subtree rooted at that node in level-order traversal. If the node is not found, return null.

// Constraints:
// The number of nodes in the tree is in the range [1, 5000].
// 1 <= Node.data <= 10^7
// root is a binary search tree.
// 1 <= val <= 10^7
import java.util.*;

class Node {
    int val;
    Node left;
    Node right;

    Node(int val) {
        this.val = val;
    }
}

public class lect2_1_Search_in_BST {

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

    static Node searchBST(Node root, int val) {

        while (root != null) {

            if (root.val == val) {
                return root;
            }

            if (val < root.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }

        return null;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int val = sc.nextInt();

        Node root = buildTree(arr);

        Node result = searchBST(root, val);

        if (result != null) {
            System.out.print(result.val + " ");
        }

        sc.close();
    }
}