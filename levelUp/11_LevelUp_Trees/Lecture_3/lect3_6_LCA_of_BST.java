// LU: Trees_LCA of a Binary Search Tree
// Success rate: 71.43%
// Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.

// The lowest common ancestor is defined as the lowest node in the tree that has both the given nodes as descendants (a node can be a descendant of itself).

// Input format:
// The first line contains an integer n representing the number of nodes in the BST, including -1 for null nodes.
// The second line contains n integers representing the elements of the BST in level-order traversal (-1 represents null nodes).
// The third line contains two integers p and q, representing the values of the nodes whose LCA needs to be found.

// Output format:
// The value of the lowest common ancestor node.

// Constraints:
// The number of nodes in the tree is in the range [2, 10^5].
// -10^9 <= Node.val <= 10^9
// All Node.val are unique.
// p != q
// p and q will exist in the BST.
import java.util.*;

public class lect3_6_LCA_of_BST {

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
        while (true) {
            if (root.val > p.val && root.val > q.val) {
                root = root.left;
            } else if (root.val < p.val && root.val < q.val) {
                root = root.right;
            } else {
                break;
            }
        }

        return root;
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