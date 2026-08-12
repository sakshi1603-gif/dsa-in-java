// LU: Trees_ Top view
// Success rate: 51.52%
// Given a binary tree, print its top view. The top view of a binary tree is the set of nodes visible when the tree is viewed from the top. The nodes should be returned from the leftmost to the rightmost position. If two nodes are at the same horizontal position, the node closer to the root should be included.

// Input Format:
// An integer n representing the number of nodes in the level-order traversal array.
// An array of integers representing the level-order traversal of the binary tree, where -1 denotes a null node.

// Output Format:
// A list of integers representing the top view of the binary tree from left to right.

// Constraints:
// 1 ≤ N ≤ 10^5
// 1 ≤ Node Data ≤ 10^5
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
public class Main {

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
	
    	    if (!map.containsKey(remvtlevel)) {
    	        map.put(remvtlevel, remnode.data);
    	    }
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