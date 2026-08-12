// LU: Trees_Construct Binary Tree from Preorder and Inorder Traversal
// Success rate: 35.29%
// Given two integer arrays preorder and inorder, where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree. After constructing the tree, print its nodes in level-order to verify correctness.

// Input Format:
// First line contains an integer n representing the number of nodes in the tree.
// Second line contains n integers representing the preorder traversal.
// Third line contains n integers representing the inorder traversal.

// Output Format:
// Print the level-order traversal of the constructed binary tree.

// Constraints:
// 1 <= preorder.length <= 3000
// inorder.length == preorder.length
// -3000 <= preorder[i], inorder[i] <= 3000
// preorder and inorder consist of unique values.
// Each value of inorder also appears in preorder.
// preorder is guaranteed to be the preorder traversal of the tree.
// inorder is guaranteed to be the inorder traversal of the tree.
import java.util.*;

public class lect1_6_Construct_Binary_Tree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static HashMap<Integer, Integer> map = new HashMap<>();

    public static TreeNode buildTree(int[] preorder, int[] inorder) {

        // Store: value -> index in inorder
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return constructTree(
            preorder,
            0,
            preorder.length - 1,
            0,
            inorder.length - 1
        );
    }

    private static TreeNode constructTree(
            int[] preorder,
            int preStart,
            int preEnd,
            int inStart,
            int inEnd) {

        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        // First element of preorder is root
        int rootValue = preorder[preStart];

        TreeNode root = new TreeNode(rootValue);

        // Find root in inorder
        int rootIndex = map.get(rootValue);

        // Number of nodes in left subtree
        int leftSize = rootIndex - inStart;

        // Construct left subtree
        root.left = constructTree(
            preorder,
            preStart + 1,
            preStart + leftSize,
            inStart,
            rootIndex - 1
        );

        root.right = constructTree(
            preorder,
            preStart + leftSize + 1,
            preEnd,
            rootIndex + 1,
            inEnd
        );

        return root;
    }
    static void printLevelOrder(TreeNode root) {

        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            TreeNode current = queue.poll();

            System.out.print(current.val + " ");

            if (current.left != null) {
                queue.add(current.left);
            }

            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] preorder = new int[n];
        int[] inorder = new int[n];

        for (int i = 0; i < n; i++) {
            preorder[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            inorder[i] = sc.nextInt();
        }

        TreeNode root = buildTree(preorder, inorder);

        printLevelOrder(root);

        sc.close();
    }
}