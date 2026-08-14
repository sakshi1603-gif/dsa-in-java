// LU: Trees_ Inorder Successor in BST
// Success rate: 44.44%
// Given a Binary Search Tree (BST) and a reference to a node x in the BST, find the inorder successor of the given node in the BST. The inorder successor of a node in a BST is the node with the smallest value greater than the given node's value.

// Input Format:
// First line contains an integer n, representing the number of elements (including -1 for null nodes).
// Second line contains n integers representing the elements of the BST.
// Third line contains an integer x, the value of the node for which the inorder successor is to be found.

// Output Format:
// Return the value of the inorder successor of node x. If there is no successor, return -1.

// Constraints:
// 1 <= N <= 10^5, where N is number of nodes
import java.util.*;

public class lect3_2_Inorder_Successor_in_BST {

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
        queue.add(root);

        int i = 1;

        while (!queue.isEmpty() && i < arr.length) {

            TreeNode current = queue.poll();

            // Left child
            if (i < arr.length && arr[i] != -1) {
                current.left = new TreeNode(arr[i]);
                queue.add(current.left);
            }
            i++;

            // Right child
            if (i < arr.length && arr[i] != -1) {
                current.right = new TreeNode(arr[i]);
                queue.add(current.right);
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
		int k = sc.nextInt();
        TreeNode root = buildTree(arr);
        TreeNode ans = SuccessorBST(root, k);

        if (ans != null) {
            System.out.println(ans.val);
        } else {
            System.out.println(-1);
        }
        sc.close();
    }
	public static TreeNode SuccessorBST(TreeNode root, int k) {
        TreeNode successor = null;
    
        while (root != null) {
        
            if (k < root.val) {
                successor = root;
                root = root.left;
    
            } else if (k > root.val) {
                root = root.right;
    
            } else {
                break;
            }
        }
        if (root == null) {
            return null;
        }
    
        if (root.right != null) {
        
            TreeNode current = root.right;
    
            while (current.left != null) {
                current = current.left;
            }
    
            return current;
        }
    
        return successor;
    }
}