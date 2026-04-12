// LinkedList_Modified Deletion
// Success rate: 16.91%
// Given a node from a singly linked list, delete this node. You do not have access to the head of the linked list, but you are guaranteed that the given node is not the last node in the list. All the values of the linked list are unique.

// Deleting a node means that the value of the given nodeshould be removed from the list, and the number of nodes should decrease by one while maintaining the order of the other nodes.

// Input Format
// The first line contains an integer n, the number of nodes in the linked list.
// The next n lines each contain an integer, representing the values of the nodes in the linked list.
// The last line contains an integer x, the value of the node to be deleted.

// Output Format
// Print the values of the nodes in the modified linked list, separated by spaces.

// Constraints:
// The number of the nodes in the given list is in the range [2, 1000].
// -1000 <= Node.val <= 1000
// The value of each node in the list is unique.
// The node to be deleted is in the list and is not a tail node.

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedList_Modified_Deletion {

    static void deleteNode(Node node) {
        node.data = node.next.data;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Node head = new Node(sc.nextInt());
        Node curr = head;

        for (int i = 1; i < n; i++) {
            curr.next = new Node(sc.nextInt());
            curr = curr.next;
        }

        int x = sc.nextInt();

        Node temp = head;
        while (temp != null && temp.data != x) {
            temp = temp.next;
        }

        if (temp != null && temp.next != null) {
            deleteNode(temp);
        }

        curr = head;
        while (curr != null) {
            System.out.print(curr.data);
            if (curr.next != null) {
                System.out.print(" ");
            }
            curr = curr.next;
        }
    }
}
