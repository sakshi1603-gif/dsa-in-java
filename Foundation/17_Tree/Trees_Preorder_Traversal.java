// Trees_Preorder Traversal
// Success rate: 0.00%
// Given the root of a binary tree, return the preorder traversal of its nodes' values. Preorder traversal visits nodes in the following order: root, left subtree, right subtree.

// Input Format:
// The next values represent the tree nodes in a level-order manner. Use -1 to denote a null node.

// Output Format:
// The output should be a list of integers representing the preorder traversal of the binary tree.

// Constraints:
// The number of nodes in the tree is in the range [0, 100].
// -100 <= Node.data <= 100

// For the binary tree represented as:

//  1
// / \
// 2 3
// /
// 4 5

// The preorder traversal would be: [1, 2, 3, 4, 5].

import java.util.*;
// Tree building uses Queue (BFS style)
// Traversal uses Recursion (DFS style)
class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class Trees_Preorder_Traversal {

    // Function to build tree from level order
    public static Node buildTree(int[] arr) {
        if (arr.length == 0 || arr[0] == -1)
            return null;

        Node root = new Node(arr[0]);
        Queue<Node> q = new LinkedList<>(); // Queue is an interface, LinkedList implements Queue
        q.add(root);

        int i = 1;

        while (!q.isEmpty() && i < arr.length) {
            Node current = q.poll();// poll() removes and returns front element (returns null if empty) safe than q.remove()-> in remove if queue is empty it will give error 

            // Left child
            if (i < arr.length && arr[i] != -1) {
                current.left = new Node(arr[i]);// arr[i] is an int, we must create a Node object to attach it in tree
                q.add(current.left); // Add child to queue so its children can be assigned later
            }
            i++;

            // Right child
            if (i < arr.length && arr[i] != -1) {
                current.right = new Node(arr[i]);
                q.add(current.right);
            }
            i++;
        }

        return root;
    }

    // Preorder traversal
    public static void preorder(Node root) {
        if (root == null)
            return;

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read entire line input
        String[] input = sc.nextLine().split(" ");
        int[] arr = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            arr[i] = Integer.parseInt(input[i]);// Convert String input to integer
        }

        Node root = buildTree(arr);

        preorder(root);
    }
}
//for buildTree method
// Time Complexity: O(n)
// Each node is created and processed once.

// Space Complexity: O(n)
// In worst case, queue can store up to n/2 nodes (complete binary tree).
// We measure peak memory usage, not final size.

//prrorder method
// Time Complexity: O(n)
// Each node is visited exactly once.

// Space Complexity: O(n) worst case (skewed tree)
// Recursion stack depth can go up to n.
// For balanced tree, recursion depth = O(log n).
// Space complexity measures peak call stack usage.


// Queue stores nodes whose children are not assigned yet.
// After array finishes, remaining nodes in queue are leaf nodes.