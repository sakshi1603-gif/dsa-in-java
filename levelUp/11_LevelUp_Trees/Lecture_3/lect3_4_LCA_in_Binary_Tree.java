// LU: Trees_LCA in Binary Tree
// Success rate: 42.86%
// You are given a Binary Tree with all unique values and two node values, n1 and n2. The task is to find the lowest common ancestor (LCA) of these two nodes. We assume that both n1 and n2 are either present in the tree or neither of them are present.

// LCA Definition: The lowest common ancestor is the deepest node in the tree that has both n1 and n2 as descendants (where we allow a node to be a descendant of itself).

// Input Format:
// An integer n representing the number of nodes, including -1 for null nodes.
// n integers representing the elements of the binary tree in level-order traversal (with -1 representing null nodes).
// Two integers, n1 and n2, representing the values of the nodes for which the LCA is to be found.

// Output Format:
// Return the data value of the lowest common ancestor of the two nodes n1 and n2.

// Constraints:
// 1 ≤ Number of nodes ≤ 10^5
// 1 ≤ Data of a node ≤ 10^5
import java.util.*;

public class lect3_4_LCA_in_Binary_Tree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

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

            if (i < arr.length && arr[i] != -1) {
                current.left = new TreeNode(arr[i]);
                queue.offer(current.left);
            }
            i++;

            if (i < arr.length && arr[i] != -1) {
                current.right = new TreeNode(arr[i]);
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }

    static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (root.val == p.val || root.val == q.val) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        if (left != null) {
            return left;
        }

        if (right != null) {
            return right;
        }

        return null;
    }

    static TreeNode findNode(TreeNode root, int value) {
        if (root == null) {
            return null;
        }

        if (root.val == value) {
            return root;
        }

        TreeNode left = findNode(root.left, value);

        if (left != null) {
            return left;
        }

        return findNode(root.right, value);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int pValue = sc.nextInt();
        int qValue = sc.nextInt();

        TreeNode root = buildTree(arr);

        TreeNode p = findNode(root, pValue);
        TreeNode q = findNode(root, qValue);

        TreeNode lca = lowestCommonAncestor(root, p, q);

        System.out.println(lca.val);

        sc.close();
    }
}