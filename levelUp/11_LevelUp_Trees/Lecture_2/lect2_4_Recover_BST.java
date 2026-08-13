// LU: Trees_ Recover BST
// Success rate: 31.82%
// You are given the root of a binary search tree (BST), where exactly two nodes in the tree have been swapped by mistake. Your task is to recover the tree without changing its structure.

// Input Format:
// The first line contains an integer n, representing the number of elements in the binary search tree (including -1 for null nodes).
// The second line contains n integers representing the elements of the BST in level order, where -1 denotes a null node.

// Output Format:
// The output is the level order traversal of the BST after it has been recovered.

// Constraints:
// The number of nodes in the tree is in the range [2, 1000].
// 0 <= Node.val <= 2^31 - 1
import java.util.*;

public class lect2_4_Recover_BST {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static TreeNode first = null;
    static TreeNode second = null;
    static TreeNode prev = null;

    static void recoverTree(TreeNode root) {
        inorder(root);

        // Swap the two incorrect nodes
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    static void inorder(TreeNode curr) {

        if (curr == null) {
            return;
        }

        inorder(curr.left);

        if (prev != null && prev.val > curr.val) {

            if (first == null) {
                first = prev;
            }

            second = curr;
        }

        prev = curr;

        inorder(curr.right);
    }

    // Build tree from level-order input
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

    // Print level-order
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

        TreeNode root = buildTree(arr);

        recoverTree(root);

        printLevelOrder(root);

        sc.close();
    }
}