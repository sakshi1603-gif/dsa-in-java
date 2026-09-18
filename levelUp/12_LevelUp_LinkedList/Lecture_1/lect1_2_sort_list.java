class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class lect1_2_sort_list {

    public static ListNode sortList(ListNode head) {
        ListNode finalsortedList = MergeSort(head);
        return finalsortedList;
    }

    public static ListNode MergeSort(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode m = mid(head);

        ListNode h1 = head;
        ListNode h2 = m.next;

        m.next = null;

        ListNode sortedhalf1 = MergeSort(h1);
        ListNode sortedhalf2 = MergeSort(h2);

        ListNode merge = Merge(sortedhalf1, sortedhalf2);

        return merge;
    }

    public static ListNode Merge(ListNode h1, ListNode h2) {

        ListNode curr = null;

        if (h1.val < h2.val) {
            curr = h1;
            h1 = h1.next;
        } else {
            curr = h2;
            h2 = h2.next;
        }

        ListNode ans = curr;

        while (h1 != null && h2 != null) {

            if (h1.val < h2.val) {
                curr.next = h1;
                h1 = h1.next;
            } else {
                curr.next = h2;
                h2 = h2.next;
            }

            curr = curr.next;
        }

        if (h1 != null) {
            curr.next = h1;
        } else {
            curr.next = h2;
        }

        return ans;
    }

    public static ListNode mid(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // Create linked list
    public static ListNode createList(int[] arr) {

        if (arr.length == 0) {
            return null;
        }

        ListNode head = new ListNode(arr[0]);
        ListNode curr = head;

        for (int i = 1; i < arr.length; i++) {
            curr.next = new ListNode(arr[i]);
            curr = curr.next;
        }

        return head;
    }

    // Print linked list
    public static void printList(ListNode head) {

        ListNode curr = head;

        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        int[] arr = {4, 2, 1, 3, 5};

        ListNode head = createList(arr);

        System.out.println("Original List:");
        printList(head);

        ListNode sorted = sortList(head);

        System.out.println("Sorted List:");
        printList(sorted);
    }
}