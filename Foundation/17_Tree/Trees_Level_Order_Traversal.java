// Trees_Level Order Traversal
// Success rate: 23.21%
// Given the root of a binary tree with n nodes, find its level order traversal. Level order traversal of a tree is the breadth-first traversal of the tree, where nodes are visited level by level from left to right.

// Input Format:
// The input will be provided as a level-order representation of the binary tree where each node's value is separated by a space.
// A value of -1 represents a null node.
// The input is read from standard input.

// Output Format:
// The output should be a list of lists, where each inner list contains the values of nodes at a particular level of the tree.

// Constraints:
// 1 ≤ n ≤ 10^5
// 0 ≤ Node.data ≤ 10^9
import java.util.*;

class Node{
    int val;
    Node left;
    Node right;

    Node(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class Trees_Level_Order_Traversal{
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        String[] input = scn.nextLine().split(" ");

        int[] arr = new int[input.length];
        for(int i = 0; i < input.length; i++){
            arr[i] = Integer.parseInt(input[i]);
        }

        Node root = buildtree(arr);
        level_order_traversal(root);
    }

    // Build tree using level order input (-1 means null)
    public static Node buildtree(int[] arr){

        if(arr.length == 0 || arr[0] == -1){
            return null;
        }

        Queue<Node> q = new LinkedList<>();
        Node root = new Node(arr[0]);
        q.add(root);

        int i = 1;

        while(i < arr.length && !q.isEmpty()){

            Node current = q.poll();

            // Left child
            if(i < arr.length && arr[i] != -1){
                current.left = new Node(arr[i]);
                q.add(current.left);
            }
            i++;

            // Right child
            if(i < arr.length && arr[i] != -1){
                current.right = new Node(arr[i]);
                q.add(current.right);
            }
            i++;
        }

        return root;
    }

    // Print level order in format:
    // [1]
    // [2, 3]
    // [4, 5, 6]
    public static void level_order_traversal(Node root){

        if(root == null){
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){

            int size = q.size();   // number of nodes in current level
            System.out.print("[");

            for(int i = 0; i < size; i++){

                Node current = q.poll();
                System.out.print(current.val);

                // Avoid comma after last element
                if(i < size - 1){
                    System.out.print(", ");
                }

                if(current.left != null){
                    q.add(current.left);
                }

                if(current.right != null){
                    q.add(current.right);
                }
            }

            System.out.println("]");
        }
    }
}