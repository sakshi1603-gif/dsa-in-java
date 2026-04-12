// Trees_Inorder Traversal
// Success rate: 2.01%
// Given the root of a binary tree, return the inorder traversal of its nodes' values.

// Inorder traversal visits nodes in the following order:
// Visit the left subtree.
// Visit the root node.
// Visit the right subtree.

// Input Format:
// The next values represent the tree nodes in a level-order manner. Use -1 to denote a null node.

// Output Format:
// Output a list of integers representing the inorder traversal of the binary tree.

// Constraints:
// The number of nodes in the tree is in the range [0, 100].
// -100 <= Node.data <= 100

import java.util.*;

class Node {
    int val;
    Node left;
    Node right;

    Node(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class Trees_Inorder_Traversal {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = scn.nextInt();
        }

        Node root = buildtree(arr);
        Inorder(root);
    }

    public static Node buildtree(int[] arr){
        int n = arr.length;

        if(n == 0 || arr[0] == -1){
            return null;
        }

        Queue<Node> q = new LinkedList<>();
        Node root = new Node(arr[0]);
        q.add(root);

        int i = 1;

        while(!q.isEmpty() && i < n){
            Node current = q.poll();

            if(i < n && arr[i] != -1){
                current.left = new Node(arr[i]);
                q.add(current.left);
            }
            i++;

            if(i < n && arr[i] != -1){
                current.right = new Node(arr[i]);
                q.add(current.right);
            }
            i++;
        }

        return root;
    }

    public static void Inorder(Node root){
        if(root == null){
            return;
        }
        Inorder(root.left);
        System.out.print(root.val + " ");
        Inorder(root.right);
    }
}

// Time Complexity → O(n)
// Space Complexity → O(n)

// Queue → O(n)

// Recursion stack → O(n) worst case