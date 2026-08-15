// LU: Trees_Print Path from root to given Node
// Success rate: 35.00%
// You are given a binary tree with distinct node values (no two nodes have the same value). The task is to print the path from the root to a given node x. If the node x is not present in the tree, print "No Path".

// Input Format:
// First line contains an integer n representing the number of elements in the binary tree, including -1 to denote null nodes.
// Second line contains n integers representing the elements of the binary tree.
// Third line contains an integer x, the value of the node for which the path from the root is required.

// Output Format:
// Print the path from the root to node x in the form of a->b->c, or "No Path" if node x is not present in the tree.
import java.util.*;

public class lect3_5_Print_Path {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static TreeNode buildTree(int[] arr) {
        if (arr.length == 0 || arr[0] == -1) {
            return null;
        }

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int i = 1;

        while (i < arr.length) {
            TreeNode current = q.poll();

            if (i < arr.length && arr[i] != -1) {
                current.left = new TreeNode(arr[i]);
                q.add(current.left);
            }
            i++;

            if (i < arr.length && arr[i] != -1) {
                current.right = new TreeNode(arr[i]);
                q.add(current.right);
            }
            i++;
        }

        return root;
    }

    static boolean findPath(TreeNode root, int x, List<Integer> path) {
        if (root == null) {
            return false;
        }

        path.add(root.val);

        if (root.val == x) {
            return true;
        }

        if (findPath(root.left, x, path) || findPath(root.right, x, path)) {
            return true;
        }

        path.remove(path.size() - 1);
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int x = sc.nextInt();

        TreeNode root = buildTree(arr);

        List<Integer> path = new ArrayList<>();

        if (findPath(root, x, path)) {
            for (int i = 0; i < path.size(); i++) {
                if (i > 0) {
                    System.out.print("->");
                }
                System.out.print(path.get(i));
            }
        } else {
            System.out.print("No Path");
        }
    }
}