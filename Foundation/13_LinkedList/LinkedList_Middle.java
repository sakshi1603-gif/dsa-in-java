// LinkedList_Middle of LinkedList
// Success rate: 27.56%
// Problem Statement
// Given the head of a singly linked list, find and return the middle node of the linked list. If the list has an even number of nodes, return the second of the two middle nodes.

// Input Format:
// The first line contains an integer n, the number of nodes in the linked list.
// The next n lines each contain an integer, representing the values of the nodes in the linked list.

// Output Format:
// Print the value of the middle node in the linked list.

// Constraints:
// The number of nodes in the list is in the range [1, 100].
// 1 <= Node.data <= 100

import java.util.Scanner;
class Node{
	int val;
	Node next;
	Node(int val){
		this.val=val;
		this.next=null;
	}
}
public class LinkedList_Middle {
	public static void main(String[] args) {
		Scanner scn= new Scanner (System.in);
		int n = scn.nextInt();
		Node head = new Node(scn.nextInt());
		Node curr = head;
		for(int i=1;i<n;i++){
			curr.next=new Node(scn.nextInt());
			curr= curr.next;
		}
		System.out.println(FindMid(head));

	}
	public static int FindMid(Node head){
		Node s = head;
		Node f = head;
		while (f.next!=null&&f.next.next!=null){
			s= s.next;
			f=f.next.next;
		}
		return s.val;
	}
}