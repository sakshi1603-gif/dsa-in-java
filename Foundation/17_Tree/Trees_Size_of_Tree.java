// Trees_Size of Tree
// Success rate: 29.56%
// Given the root of a binary tree, determine the total number of nodes in the tree. Each node is counted exactly once.

// Input Format
// The input consists of a sequence of integers where:
// Each integer represents a node in the binary tree.
// The input uses level-order traversal to describe the tree.
// A value of -1 denotes a null node.

// Output Format
// The output is an integer representing the number of nodes in the binary tree.

// Constraints:
// 1 <= n <= 10^5
// 1 <= values of nodes <= 10^6

import java.util.*;

// Node class representing each node of the Binary Tree
class Node {
    int val;        // value stored in the node
    Node right;     // right child reference
    Node left;      // left child reference

    Node(int val){
        this.val = val;
        this.right = null;
        this.left = null;
    }
}

public class Trees_Size_of_Tree {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // Taking level-order input as space separated values
        String[] input = scn.nextLine().split(" ");
        int[] arr = new int[input.length];

        // Converting String input to integer array
        for(int i = 0; i < input.length; i++){
            arr[i] = Integer.parseInt(input[i]);
        }

        // Building tree from level-order array
        Node root = BuildTree(arr);

        // Printing size of tree
        System.out.println(Size_Of_Tree(root));
    }

    // Method to build binary tree using level-order traversal
    // -1 represents a null node
    public static Node BuildTree(int[] arr){

        // If array is empty or first element is -1 → tree is empty
        if(arr.length == 0 || arr[0] == -1){
            return null;
        }

        Queue<Node> q = new LinkedList<>();

        // Create root node from first element
        Node root = new Node(arr[0]);
        q.add(root);

        int i = 1;  // Start from index 1 (root already used)

        // Process nodes level by level
        while(!q.isEmpty() && i < arr.length){

            Node current = q.poll();  // Remove front node

            // Assign left child
            if(i < arr.length && arr[i] != -1){
                current.left = new Node(arr[i]);
                q.add(current.left);
            }
            i++;

            // Assign right child
            if(i < arr.length && arr[i] != -1){
                current.right = new Node(arr[i]);
                q.add(current.right);
            }
            i++;
        }

        return root;
    }

    // Method to calculate size (number of nodes) of the tree
    public static int Size_Of_Tree(Node root){

        // Base case: empty subtree
        if(root == null){
            return 0;
        }

        // Recursively calculate size of left and right subtrees
        int leftSize = Size_Of_Tree(root.left);
        int rightSize = Size_Of_Tree(root.right);

        // Total size = left subtree + right subtree + current node
        return leftSize + rightSize + 1;
    }
}