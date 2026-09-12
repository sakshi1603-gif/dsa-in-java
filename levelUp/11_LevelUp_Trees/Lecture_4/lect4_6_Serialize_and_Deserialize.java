// LU: Trees_ Serialize and Deserialize a Binary Tree
// Success rate: 11.11%
// Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network to be reconstructed later. You are required to design an algorithm to serialize and deserialize a binary tree. The algorithm must ensure that the tree can be serialized into a string and later deserialized to its original structure.

// You are free to use any approach for serialization and deserialization as long as the tree's structure is correctly preserved.

// Input Format:
// A string representing the serialized binary tree.

// Output Format:
// The serialized tree after deserialization, printed as a string.

// Constraints:
// The number of nodes in the tree is in the range [0, 10^4].
// -1000 <= Node.val <= 1000
import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Codec {

    // Serialize
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        helperfn1(root, sb);
        return sb.toString();
    }

    private void helperfn1(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("# ");
            return;
        }

        sb.append(root.val).append(" ");

        helperfn1(root.left, sb);
        helperfn1(root.right, sb);
    }

    // Deserialize
    int i;

    public TreeNode deserialize(String data) {
        String[] ch = data.trim().split("\\s+");
        i = 0;

        return helperfn2(ch);
    }

    private TreeNode helperfn2(String[] ch) {

        if (ch[i].equals("#")) {
            i++;
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(ch[i]));
        i++;

        root.left = helperfn2(ch);
        root.right = helperfn2(ch);

        return root;
    }
}

public class lect4_6_Serialize_and_Deserialize {

    public static void main(String[] args) {

        String data = "1 2 3 4 5 # # # # 6 7 # # # #";

        Codec codec = new Codec();

        // Deserialize
        TreeNode root = codec.deserialize(data);

        // Serialize again
        String result = codec.serialize(root);

        System.out.println(result);
    }
}