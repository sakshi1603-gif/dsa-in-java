// LinkedList_Floyd Cycle
// Success rate: 21.42%
// Given the head of a singly linked list, return the node where a cycle begins. If there is no cycle, return null.

// A cycle exists in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. The position where the cycle starts is denoted by the index of the node (0-indexed) to which the tail's next pointer is connected. If there is no cycle, the function should return null.

// You must not modify the linked list.

// Input Format:
// The first line contains an integer n, the number of nodes in the linked list.
// The second line contains n space-separated integers representing the node values of the linked list.
// The third line contains an integer pos, representing the index where the tail connects to form a cycle (-1 if there is no cycle).

// Output Format:
// Output the value of the node where the cycle begins. If no cycle exists, output null.

// Constraints:
// The number of the nodes in the list is in the range [0, 104].
// -105 <= Node.val <= 105
// pos is -1 or a valid index in the linked-list

import java.util.Scanner;

class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
        this.next = null;
    }
}

public class LinkedList_Floyd_cycle {

    // Floyd’s Cycle Detection – returns starting node of cycle
    public static Node Floyd_Cycle(Node head) {
        if (head == null) return null;

        Node slow = head;
        Node fast = head;

        // Step 1: detect cycle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                // Step 2: find start of cycle
                Node entry = head;
                while (entry != slow) {
                    entry = entry.next;
                    slow = slow.next;
                }
                return entry;
            }
        }
        return null; // no cycle
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        if (n == 0) {
            System.out.println("null");
            return;
        }

        // create linked list
        Node head = new Node(scn.nextInt());
        Node curr = head;
        Node[] nodes = new Node[n];
        nodes[0] = head;

        for (int i = 1; i < n; i++) {
            curr.next = new Node(scn.nextInt());
            curr = curr.next;
            nodes[i] = curr;
        }

        // read pos
        int pos = scn.nextInt();

        // create cycle if pos != -1
        if (pos != -1) {
            curr.next = nodes[pos];
        }

        // find cycle start
        Node result = Floyd_Cycle(head);

        if (result == null) {
            System.out.println("null");
        } else {
            System.out.println(result.val);
        }
    }
}
