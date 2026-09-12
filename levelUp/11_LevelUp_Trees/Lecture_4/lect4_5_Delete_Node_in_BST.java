// LU: Trees_Delete Node in a BST
// Success rate: 12.50%
// Given a root node reference of a Binary Search Tree (BST) and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.

// The deletion process consists of two main stages:
// Search for the node to remove.
// If the node is found, delete the node from the tree.

// Input Format:
// An integer n representing the number of nodes, including -1 for null nodes.
// n integers representing the elements of the binary tree in level-order traversal (with -1 representing null nodes).
// An integer key representing the value of the node to be deleted.

// Output Format:
// Level-order traversal of the updated tree after deleting the node with the given key.

// Constraints:
// The number of nodes in the tree is in the range [0, 10^4].
// -10^5 <= Node.val <= 10^5
// Each node has a unique value.
// root is a valid binary search tree.
// -10^5 <= key <= 10^5
import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {

    public TreeNode deleteNode(TreeNode root, int key) {

        if (root == null) {
            return null;
        }

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } 
        else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } 
        else {

            // No child
            if (root.left == null && root.right == null) {
                return null;
            }

            // Only right child
            if (root.left == null) {
                return root.right;
            }

            // Only left child
            if (root.right == null) {
                return root.left;
            }

            // Two children
            TreeNode max = findMaxNode(root.left);

            root.val = max.val;

            root.left = deleteNode(root.left, max.val);
        }

        return root;
    }

    public TreeNode findMaxNode(TreeNode root) {

        while (root.right != null) {
            root = root.right;
        }

        return root;
    }
}

public class lect4_5_Delete_Node_in_BST {

    // Build tree from level-order input
    public static TreeNode buildTree(int[] arr) {

        if (arr.length == 0 || arr[0] == -1) {
            return null;
        }

        TreeNode root = new TreeNode(arr[0]);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;

        while (!queue.isEmpty() && i < arr.length) {

            TreeNode current = queue.poll();

            // Left child
            if (arr[i] != -1) {
                current.left = new TreeNode(arr[i]);
                queue.add(current.left);
            }

            i++;

            if (i >= arr.length) {
                break;
            }

            // Right child
            if (arr[i] != -1) {
                current.right = new TreeNode(arr[i]);
                queue.add(current.right);
            }

            i++;
        }

        return root;
    }

    // Print tree in level-order including -1 for null
    public static void printTree(TreeNode root) {

        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            TreeNode current = queue.poll();

            if (current == null) {
                System.out.print("-1 ");
                continue;
            }

            System.out.print(current.val + " ");

            queue.add(current.left);
            queue.add(current.right);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int key = sc.nextInt();

        TreeNode root = buildTree(arr);

        Solution sol = new Solution();

        root = sol.deleteNode(root, key);

        printTree(root);

        sc.close();
    }
}