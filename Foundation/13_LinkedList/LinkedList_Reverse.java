// LinkedList_Reverse LinkedList
// Success rate: 13.78%
// Given the head of a singly linked list, reverse the list, and return the reversed list.

// Input Format:
// An integer n representing the number of nodes in the linked list.
// n integers representing the elements of the linked list.

// Output Format:
// Print the elements of the reversed linked list.

// Constraints:
// The number of nodes in the list is the range
// [0, 5000].
// -5000 <= Node.val <= 5000

import java.util.Scanner;

class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
        this.next = null;
    }
}

public class LinkedList_Reverse {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        // create linked list
        Node head = new Node(scn.nextInt());
        Node curr = head;

        for (int i = 1; i < n; i++) {
            curr.next = new Node(scn.nextInt());
            curr = curr.next;
        }

        // reverse and UPDATE head
        head = Reverse_linkedlist(head);

        // print reversed list
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val);
            if (temp.next != null) System.out.print(" ");
            temp = temp.next;
        }
    }

    public static Node Reverse_linkedlist(Node head) {
        Node curr = head;
        Node prev = null;

        while (curr != null) {
            Node nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev; // new head
    }
}
