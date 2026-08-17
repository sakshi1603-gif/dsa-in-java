// LU: Trees_Morris Preorder
// Success rate: 50.00%
// Given the root of a binary tree, return the preorder traversal of its nodes' values.

// Preorder Traversal: Visit the root node first, then recursively traverse the left subtree, followed by the right subtree.

// Input Format:
// The first line contains an integer n, representing the number of elements (including -1 for null nodes).
// The second line contains n integers, representing the elements of the binary tree.

// Output Format:
// A list of integers representing the preorder traversal of the binary tree.

// Constraints:
// The number of nodes in the tree is in the range [0, 100].
// -100 <= Node.val <= 100
import java.util.*;

public class lect4_2_Morris_Preorder {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        TreeNode curr = root;
        List<Integer> ans = new ArrayList<>();

        while (curr != null) {
            if (curr.left == null) {
                ans.add(curr.val);
                curr = curr.right;
            } else {
                TreeNode currp1 = curr.left;

                while (currp1.right != null && currp1.right != curr) {
                    currp1 = currp1.right;
                }

                if (currp1.right == null) {
                    currp1.right = curr;
                    ans.add(curr.val);
                    curr = curr.left;
                } else {
                    currp1.right = null;
                    curr = curr.right;
                }
            }
        }

        return ans;
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

            if (arr[i] != -1) {
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

        List<Integer> ans = preorderTraversal(root);

        for (int x : ans) {
            System.out.print(x + " ");
        }
    }
}