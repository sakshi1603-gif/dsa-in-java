// LinkedList_Delete Node
// Success rate: 8.64%
// Given a singly linked list and an integer x, delete the x-th node from the singly linked list. Assume the nodes are 1-indexed.

// Input Format:
// An integer n representing the number of nodes in the linked list.
// n integers representing the elements of the linked list.
// An integer x representing the position of the node to be deleted.

// Output Format:
// Print the modified linked list after deleting the x-th node.

// Constraints:
// 2 <= N <= 10^5
// 1 <= x <= N

import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedList_Delete_Node {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Node head = null, tail = null;

        // Create linked list
        for (int i = 0; i < n; i++) {
            Node node = new Node(sc.nextInt());
            if (head == null) {
                head = tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
        }

        int x = sc.nextInt();

        head = deleteXthNode(head, x);
        printList(head);
    }

    // Delete x-th node (1-indexed)
    public static Node deleteXthNode(Node head, int x) {
        if (head == null) return null;

        if (x == 1) {
            return head.next;
        }

        Node curr = head;
        for (int i = 1; i < x - 1 && curr.next != null; i++) {
            curr = curr.next;
        }

        if (curr.next != null) {
            curr.next = curr.next.next;
        }

        return head;
    }

    // Print WITHOUT trailing space
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            if (temp.next != null) System.out.print(" ");
            temp = temp.next;
        }
    }
}
