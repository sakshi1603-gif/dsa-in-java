// LU: Trees_Diameter of Binary Tree
// Success rate: 13.64%
// You are given a binary tree, and your task is to find its diameter. The diameter of a tree is defined as the number of nodes on the longest path between two end nodes (also called leaf nodes). The function should return the diameter of the tree.

// Input Format:
// The first line contains an integer n, representing the total number of nodes in the tree including -1 for null nodes.
// The second line contains n integers representing the elements of the binary tree in level-order traversal (with -1 representing null nodes).

// Output Format:
// The function should return a single integer representing the diameter of the binary tree.

// Constraints:
// 1 <= Number of nodes <= 10000
// 1 <= Data of a node <= 1000
import java.util.*;

public class lect4_4_Diameter_of_Binary_Tree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static int ans = 0;

    public static int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return ans;
    }

    public static int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = helper(root.left);
        int right = helper(root.right);

        ans = Math.max(ans, left + right + 1);

        return Math.max(left, right) + 1;
    }

    public static TreeNode buildTree(int[] arr) {
        if (arr.length == 0 || arr[0] == -1) {
            return null;
        }

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;

        while (!queue.isEmpty() && i < arr.length) {
            TreeNode curr = queue.poll();

            if (i < arr.length && arr[i] != -1) {
                curr.left = new TreeNode(arr[i]);
                queue.add(curr.left);
            }
            i++;

            if (i < arr.length && arr[i] != -1) {
                curr.right = new TreeNode(arr[i]);
                queue.add(curr.right);
            }
            i++;
        }

        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        TreeNode root = buildTree(arr);

        System.out.println(diameterOfBinaryTree(root));
    }
}