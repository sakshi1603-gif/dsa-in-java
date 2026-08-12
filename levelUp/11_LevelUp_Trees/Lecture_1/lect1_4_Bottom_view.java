// LU: Trees_ Bottom view
// Success rate: 55.56%
// Given a binary tree, return an array representing the bottom view of the binary tree when viewed from left to right.

// Note:
// If there are multiple bottom-most nodes for a horizontal distance from the root, the latter one in the level order traversal is considered. For example, in the tree below:
// 20
// /
// 8 22
// / \ /
// 5 3 4 25
// /
// 10 14

// The bottom view of the tree is [5, 10, 4, 14, 25].

// Input Format:
// The first line contains the number of nodes in the binary tree.
// The second line contains the node values in level-order, where -1 represents a null node.

// Output Format:
// The output is a list of integers representing the bottom view of the binary tree.

// Constraints:
// 1 <= Number of nodes <= 10^5
// 1 <= Data of a node <= 10^5
import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}
class Pair {
	Node n ;
	int vtlevel;
	Pair(Node n , int vtlevel){
		this.n = n ;
		this.vtlevel = vtlevel;
	}
}
public class lect1_4_Bottom_view {

    public static Node buildTree(int[] arr) {

        if (arr.length == 0 || arr[0] == -1) {
            return null;
        }

        Node root = new Node(arr[0]);

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        int i = 1;

        while (!q.isEmpty() && i < arr.length) {

            Node current = q.poll();

            if (i < arr.length && arr[i] != -1) {
                current.left = new Node(arr[i]);
                q.add(current.left);
            }
            i++;

            if (i < arr.length && arr[i] != -1) {
                current.right = new Node(arr[i]);
                q.add(current.right);
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

        TopView(root);
    }
    public static void TopView(Node root) {
    	if (root == null) {
    	    return;
    	}
    	Queue<Pair> q = new LinkedList<>();
    	TreeMap<Integer, Integer> map = new TreeMap<>();
	
    	q.add(new Pair(root, 0));
	
    	while (!q.isEmpty()) {
    	    Pair rem = q.poll();
    	    Node remnode = rem.n;
    	    int remvtlevel = rem.vtlevel;
			map.put(remvtlevel, remnode.data);
    	    if (remnode.left != null) {
    	        q.add(new Pair(remnode.left, remvtlevel - 1));
    	    }
    	    if (remnode.right != null) {
    	        q.add(new Pair(remnode.right, remvtlevel + 1));
    	    }
    	}
    	for (int value : map.values()) {
    	    System.out.print(value + " ");
    	}
	}	
}