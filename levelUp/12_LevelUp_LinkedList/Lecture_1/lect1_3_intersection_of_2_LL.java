class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class lect1_3_intersection_of_2_LL {

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int countA = 0;
        int countB = 0;

        ListNode tempA = headA;
        ListNode tempB = headB;

        while (tempA != null) {
            countA++;
            tempA = tempA.next;
        }

        while (tempB != null) {
            countB++;
            tempB = tempB.next;
        }

        int diff = Math.abs(countA - countB);

        if (countA > countB) {
            while (diff > 0) {
                headA = headA.next;
                diff--;
            }
        } else {
            while (diff > 0) {
                headB = headB.next;
                diff--;
            }
        }

        while (headA != null && headB != null) {

            if (headA == headB) {
                return headA;
            }

            headA = headA.next;
            headB = headB.next;
        }

        return null;
    }

    public static void main(String[] args) {

        // Common part
        ListNode common = new ListNode(8);
        common.next = new ListNode(10);

        // List A
        ListNode headA = new ListNode(3);
        headA.next = new ListNode(7);
        headA.next.next = common;

        // List B
        ListNode headB = new ListNode(99);
        headB.next = common;

        ListNode intersection = getIntersectionNode(headA, headB);

        if (intersection != null) {
            System.out.println("Intersection Node: " + intersection.val);
        } else {
            System.out.println("No Intersection");
        }
    }
}