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

public class lect1_1_Merge_Two_Sorted_Lists {

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode h1 = list1;
        ListNode h2 = list2;

        if (h1 == null) return h2;
        if (h2 == null) return h1;

        ListNode sortedlist;

        if (h1.val <= h2.val) {
            sortedlist = h1;
            h1 = h1.next;
        } else {
            sortedlist = h2;
            h2 = h2.next;
        }

        ListNode curr = sortedlist;

        while (h1 != null && h2 != null) {

            if (h1.val <= h2.val) {
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

        return sortedlist;
    }

    // Create linked list
    public static ListNode createList(int[] arr) {
        if (arr.length == 0) return null;

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

        int[] arr1 = {1, 2, 4};
        int[] arr2 = {1, 3, 4};

        ListNode list1 = createList(arr1);
        ListNode list2 = createList(arr2);

        ListNode result = mergeTwoLists(list1, list2);

        System.out.println("Merged List:");
        printList(result);
    }
}