
public class lect3_1_FlattenedTreeToLinkedList {

    // Binary Tree Node
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    // Flatten Binary Tree to Linked List
    public static void flatten(TreeNode root) {
        flattenhelper(root);
    }

    public static TreeNode flattenhelper(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode righttail = flattenhelper(root.right);
        TreeNode lefttail = flattenhelper(root.left);

        // Both left and right are null
        if (righttail == null && lefttail == null) {
            return root;
        }

        // Only left subtree exists
        else if (righttail == null && lefttail != null) {
            root.right = root.left;
            root.left = null;

            return lefttail;
        }

        // Only right subtree exists
        else if (righttail != null && lefttail == null) {
            return righttail;
        }

        // Both left and right subtrees exist
        else {
            TreeNode rightchild = root.right;

            root.right = root.left;
            root.left = null;

            lefttail.right = rightchild;

            return righttail;
        }
    }

    // Print flattened tree
    public static void printFlattenedTree(TreeNode root) {
        TreeNode temp = root;

        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.right;
        }

        System.out.println("NULL");
    }

    public static void main(String[] args) {

        /*
                  1
                 / \
                2   5
               / \   \
              3   4   6

            Flattened:
            1 -> 2 -> 3 -> 4 -> 5 -> 6
        */

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(5);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right.right = new TreeNode(6);

        // Flatten the tree
        flatten(root);

        // Print result
        printFlattenedTree(root);
    }
}