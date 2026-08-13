// LU: Trees_ InsertinBST
// Success rate: 38.46%
// You are given the root node of a binary search tree (BST) and a value to insert into the tree. Return the root node of the BST after the insertion. It is guaranteed that the new value does not exist in the original BST.

// Notice that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion. You can return any of them.

// Input format:
// First line contains an integer n representing the number of elements (including -1 for null nodes).
// Second line contains n integers representing the elements of the BST.
// Third line contains an integer val representing the value to be inserted into the BST.

// Output format:
// Return the root node of the BST after insertion.
// Print the level-order traversal of the BST after the insertion.

// Constraints:
// The number of nodes in the tree will be in the range [0, 104].
// -108 <= Node.val <= 108
// All the values Node.val are unique.
// -108 <= val <= 108
// It's guaranteed that val does not exist in the original BST.
import java.util.*;

public class lect2_3_InsertinBST {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Construct tree from level-order input
    static TreeNode buildTree(int[] arr) {
        if (arr.length == 0 || arr[0] == -1) {
            return null;
        }

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;

        while (!queue.isEmpty() && i < arr.length) {
            TreeNode current = queue.poll();

            // Left child
            if (i < arr.length && arr[i] != -1) {
                current.left = new TreeNode(arr[i]);
                queue.offer(current.left);
            }
            i++;

            // Right child
            if (i < arr.length && arr[i] != -1) {
                current.right = new TreeNode(arr[i]);
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }

    static TreeNode insertIntoBST(TreeNode root, int val) {

        if (root == null) {
            return new TreeNode(val);
        }

        TreeNode current = root;

        while (true) {

            if (val < current.val) {

                if (current.left == null) {
                    current.left = new TreeNode(val);
                    break;
                }

                current = current.left;

            } else {

                if (current.right == null) {
                    current.right = new TreeNode(val);
                    break;
                }

                current = current.right;
            }
        }

        return root;
    }

    // Print tree in level-order
    static void printLevelOrder(TreeNode root) {

        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            TreeNode current = queue.poll();

            System.out.print(current.val + " ");

            if (current.left != null) {
                queue.offer(current.left);
            }

            if (current.right != null) {
                queue.offer(current.right);
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

        int val = sc.nextInt();

        // Build the EXISTING tree
        TreeNode root = buildTree(arr);

        // Insert value
        root = insertIntoBST(root, val);

        // Print resulting tree
        printLevelOrder(root);

        sc.close();
    }
}