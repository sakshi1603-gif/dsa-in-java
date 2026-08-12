// LU: Tress_Vertical Order Traversal of a Binary Tree
// Success rate: 35.48%
// Given the root of a binary tree, calculate its vertical order traversal. The root node is positioned at (0, 0). For each node at position (row, col), its left child will be at position (row + 1, col - 1), and its right child will be at position (row + 1, col + 1). The vertical order traversal is a list of top-to-bottom orderings for each column index, starting from the leftmost column and ending at the rightmost column. If multiple nodes share the same row and column, they should be sorted by their values.

// Input format:
// First line: The number of elements in the binary tree.
// Next lines: The level-order traversal of the binary tree, where -1 denotes a null node.

// Output format:
// A list of lists where each list contains nodes in the vertical order traversal, starting from the leftmost column to the rightmost column.

// Constraints:

// The number of nodes in the tree is in the range [1, 1000].
// 0 <= Node.data <= 1000
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
    }
}

class Pair {
    Node n;
    int vlevel;
    int row;

    Pair(Node n, int vlevel, int row) {
        this.n = n;
        this.vlevel = vlevel;
        this.row = row;
    }
}

class NodeInfo {
    int row;
    int value;

    NodeInfo(int row, int value) {
        this.row = row;
        this.value = value;
    }
}

public class lect1_5_Vertical_Order {

    public static Node buildTree(int[] arr) {

        if (arr.length == 0 || arr[0] == -1) {
            return null;
        }

        Node root = new Node(arr[0]);

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        int i = 1;

        while (!q.isEmpty() && i < arr.length) {

            Node rem = q.poll();

            if (i < arr.length && arr[i] != -1) {
                rem.left = new Node(arr[i]);
                q.add(rem.left);
            }
            i++;

            if (i < arr.length && arr[i] != -1) {
                rem.right = new Node(arr[i]);
                q.add(rem.right);
            }
            i++;
        }

        return root;
    }

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        Node root = buildTree(arr);

        verticalTraversal(root);
    }

    public static void verticalTraversal(Node root) {

        if (root == null) {
            return;
        }

        Queue<Pair> q = new LinkedList<>();

        TreeMap<Integer, List<NodeInfo>> map = new TreeMap<>();

        q.add(new Pair(root, 0, 0));

        while (!q.isEmpty()) {

            Pair rem = q.poll();

            Node remnode = rem.n;
            int remvlevel = rem.vlevel;
            int remrow = rem.row;

            map.putIfAbsent(remvlevel, new ArrayList<>());

            map.get(remvlevel).add(
                new NodeInfo(remrow, remnode.data)
            );

            if (remnode.left != null) {
                q.add(new Pair(
                    remnode.left,
                    remvlevel - 1,
                    remrow + 1
                ));
            }

            if (remnode.right != null) {
                q.add(new Pair(
                    remnode.right,
                    remvlevel + 1,
                    remrow + 1
                ));
            }
        }

        for (List<NodeInfo> list : map.values()) {

            list.sort((a, b) -> {

                if (a.row != b.row) {
                    return a.row - b.row;
                }

                return a.value - b.value;
            });

            System.out.print("[");

            for (int i = 0; i < list.size(); i++) {

                System.out.print(list.get(i).value);

                if (i < list.size() - 1) {
                    System.out.print(",");
                }
            }

            System.out.print("] ");
        }
    }
}