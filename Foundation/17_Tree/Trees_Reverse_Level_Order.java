// Trees_Reverse Level Order
// Success rate: 1.43%
// Given a binary tree of size n, find its reverse level order traversal. The traversal should begin from the last level and proceed to the root level.

// Input Format:
// The input is a list of integers representing the binary tree in level order. -1 denotes a null value, which indicates no node at that position. The values are provided in a space-separated format.

// Output Format:
// Return a list of integers representing the nodes' values in reverse level order.

// Constraints:
// 1 ≤ n ≤ 10^4

import java.util.*;

class Node {
    int val;
    Node left;
    Node right;

    Node(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class Trees_Reverse_Level_Order {

    public static void main(String[] args) {

        // Take input as level order
        Scanner scn = new Scanner(System.in);
        String[] input = scn.nextLine().split(" ");

        int[] arr = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        // Build tree
        Node root = buildTree(arr);

        // Print reverse level order
        Reverse_Level_Order(root);
    }

    // Build binary tree from level order array
    public static Node buildTree(int[] arr) {

        // If tree is empty
        if (arr.length == 0 || arr[0] == -1) {
            return null;
        }

        Queue<Node> q = new LinkedList<>();

        Node root = new Node(arr[0]);
        q.add(root);

        int i = 1;

        // Process nodes level by level
        while (!q.isEmpty() && i < arr.length) {

            Node current = q.poll();

            // Add left child
            if (i < arr.length && arr[i] != -1) {
                current.left = new Node(arr[i]);
                q.add(current.left);
            }
            i++;

            // Add right child
            if (i < arr.length && arr[i] != -1) {
                current.right = new Node(arr[i]);
                q.add(current.right);
            }
            i++;
        }

        return root;
    }

    // Reverse Level Order Traversal
    public static void Reverse_Level_Order(Node root) {

        if (root == null) {
            return;
        }

        Queue<Node> q = new LinkedList<>();
        Stack<Integer> st = new Stack<>();

        q.add(root);

        // Normal level order, but store in stack
        while (!q.isEmpty()) {

            Node current = q.poll();

            st.push(current.val);

            if (current.left != null) {
                q.add(current.left);
            }

            if (current.right != null) {
                q.add(current.right);
            }
        }

        // Print values in reverse order
        while (!st.isEmpty()) {
            System.out.print(st.pop() + " ");
        }
    }
}