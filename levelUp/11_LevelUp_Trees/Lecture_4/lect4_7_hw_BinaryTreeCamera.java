
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    int camera = 0;

    public int minCameraCover(TreeNode root) {
        camera = 0;

        int val = Traversal(root);

        if (val == 0) {
            camera++;
        }

        return camera;
    }

    public int Traversal(TreeNode root) {
        if (root == null) {
            return 2;
        }

        int left = Traversal(root.left);
        int right = Traversal(root.right);

        if (left == 0 || right == 0) {
            camera++;
            return 1;
        }

        if (left == 1 || right == 1) {
            return 2;
        }

        return 0;
    }
}

public class lect4_7_hw_BinaryTreeCamera {
    public static void main(String[] args) {

        /*
                 0
                / \
               0   0
              / \
             0   0
        */

        TreeNode root = new TreeNode(0);

        root.left = new TreeNode(0);
        root.right = new TreeNode(0);

        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(0);

        Solution sol = new Solution();

        int result = sol.minCameraCover(root);

        System.out.println("Minimum cameras required: " + result);
    }
}