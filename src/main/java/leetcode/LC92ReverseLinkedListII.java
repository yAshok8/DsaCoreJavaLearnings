package leetcode;

import DSA.linkedList.ListNode;

class LC92ReverseLinkedListII {

    public static void main(String[] args) {
        ListNode start = new ListNode(1);
        start.next = new ListNode(2);
        start.next.next = new ListNode(3);
        start.next.next.next = new ListNode(4);
        start.next.next.next.next = new ListNode(5);
        start.next.next.next.next.next = new ListNode(6);
        start.next.next.next.next.next.next = new ListNode(7);
        start.next.next.next.next.next.next.next = new ListNode(8);

        ListNode res = reverseBetween(start, 2, 3);

        while (res != null) {
            System.out.print(res.val+" > ");
            res = res.next;
        }

    }

    private static ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right)
            return head;
        ListNode beforeFirstNode = null;
        ListNode firstNode = head;
        ListNode lastNode = null;
        ListNode afterLastNode = null;
        ListNode p = head;
        int count = 1;
        while (p != null) {
            if (count < left) {
                beforeFirstNode = p;
                firstNode = p.next;
            }
            if (count == right) {
                lastNode = p;
                afterLastNode = p.next;
                lastNode.next = null;
                break;
            }
            p = p.next;
            count++;
        }
        ListNode reversed = reverseAndAppend(firstNode, afterLastNode);
        if (left == 1) {
            return reversed;
        } else {
            beforeFirstNode.next = reversed;
        }
        return head;
    }

    private static ListNode reverseAndAppend(ListNode start, ListNode afterLastNode) {
        if (start.next == null) {
            start.next = afterLastNode;
            return start;
        }
        ListNode p1 = start;
        ListNode p2 = start.next;
        ListNode temp = null;
        while (p2 != null) {
            temp = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = temp;
        }
        start.next = afterLastNode;
        return p1;
    }
}
