// LU: Trees_ Left View
// Success rate: 27.38%
// Given a binary tree, return its left view. The left view of a binary tree is a set of nodes visible when the tree is viewed from the left side. If no left view is possible, return an empty list.

// Input Format:
// The root node of the binary tree.

// Output Format:
// A list of integers representing the nodes visible from the left side of the tree.

// Constraints:
// 0 <= Number of nodes <= 10^5
// 0 <= Data of a node <= 10^5
import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class lect1_1_Left_View {

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
		LeftView(root );
    }
	public static void LeftView(Node root) {
		if (root == null) {
		    return;
		}		
		Queue<Node> q = new LinkedList<>();
		q.add(root);		
		while (!q.isEmpty()) {
		    int n = q.size();
		    for (int i = 0; i < n; i++) {
		        Node rem = q.poll();
		        if (i == 0) {
		            System.out.print(rem.data + " ");
		        }
		        if (rem.left != null) {
		            q.add(rem.left);
		        }
		        if (rem.right != null) {
		            q.add(rem.right);
		        }
		    }
		}
	}
}