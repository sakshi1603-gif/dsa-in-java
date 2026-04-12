// Trees_Sum of Tree
// Success rate: 40.00%
// Given the root of a binary tree of size N, complete the function sumBT() that should return the sum of all the nodes in the binary tree.

// Input Format
// The input consists of a single line containing integers in level-order representation of the binary tree.
// Each integer represents a node's value. -1 denotes a null value (i.e., the absence of a node).

// Output Format
// Print a single integer, which is the sum of all nodes in the binary tree.

// Constraints:
// 1<=N<=100
import java.util.*;

// Class representing a single node of Binary Tree
class Node {
    int val;        // value stored in node
    Node left;      // reference to left child
    Node right;     // reference to right child

    // Constructor to initialize node
    Node(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class Trees_Sum_of_Tree {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        // Taking level-order input (space separated)
        String[] input = scn.nextLine().split(" ");

        // Convert String array to integer array
        int[] arr = new int[input.length];
        for(int i = 0; i < input.length; i++){
            arr[i] = Integer.parseInt(input[i]);
        }

        // Build tree from level-order array
        Node root = buildTree(arr);

        // Print sum of all nodes in tree
        System.out.println(sum_of_tree(root));
    }

    // Method to build Binary Tree using level-order traversal
    // -1 represents a NULL node
    public static Node buildTree(int[] arr){

        // If array is empty OR first element is -1 → tree is empty
        if(arr.length == 0 || arr[0] == -1){
            return null;
        }

        // Queue is used to construct tree level by level
        Queue<Node> q = new LinkedList<>();

        // Create root node using first element
        Node root = new Node(arr[0]);
        q.add(root);

        int i = 1;  // Start from index 1 (root already used)

        // Continue until queue is empty or array ends
        while(i < arr.length && !q.isEmpty()){

            Node current = q.poll();  // Get current node

            // Assign left child if value is not -1
            if(i < arr.length && arr[i] != -1){
                current.left = new Node(arr[i]);
                q.add(current.left);
            }
            i++;

            // Assign right child if value is not -1
            if(i < arr.length && arr[i] != -1){
                current.right = new Node(arr[i]);
                q.add(current.right);
            }
            i++;
        }

        return root;
    }

    // Method to calculate sum of all nodes in tree
    // Using recursion (Postorder logic)
    public static int sum_of_tree(Node root){

        // Base case: if node is null → sum is 0
        if(root == null){
            return 0;
        }

        // Recursively calculate sum of left subtree
        int leftSum = sum_of_tree(root.left);

        // Recursively calculate sum of right subtree
        int rightSum = sum_of_tree(root.right);

        // Total sum = left subtree + right subtree + current node value
        return leftSum + rightSum + root.val;
    }
}