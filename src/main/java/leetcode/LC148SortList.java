package leetcode;

import DSA.linkedList.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class LC148SortList {

    public static void main(String[] args) {
        LC148SortList obj = new LC148SortList();
        ListNode start = new ListNode(3);
        start.next = new ListNode(2);
        start.next.next = new ListNode(1);
        start.next.next.next = new ListNode(4);
        start.next.next.next.next = new ListNode(-1);
        start.next.next.next.next.next = new ListNode(9);
        start.next.next.next.next.next.next = new ListNode(8);
        start.next.next.next.next.next.next.next = new ListNode(7);
        System.out.println(obj.sortList(start));
    }
    public ListNode sortList(ListNode head) {
        if (head.next == null) return head;
        ListNode left = head;
        ListNode mid = getMiddle(head);
        ListNode right = null;
        if (mid.next == null) {
            right = mid;
            head.next = null;
        } else {
            right = mid.next;
            mid.next = null;
        }
        ListNode sortedLeft = sortList(left);
        ListNode sortedRight = sortList(right);
        //merge the two sorted Lists
        ListNode temp = null;
        if (sortedLeft.val < sortedRight.val) {
            temp = sortedLeft;
            sortedLeft = sortedLeft.next;
        } else {
            temp = sortedRight;
            sortedRight = sortedRight.next;
        }
        ListNode tempHead = temp;
        while (sortedLeft != null && sortedRight != null) {
            if (sortedLeft.val < sortedRight.val) {
                tempHead.next = sortedLeft;
                sortedLeft = sortedLeft.next;
            } else {
                tempHead.next = sortedRight;
                sortedRight = sortedRight.next;
            }
            tempHead = tempHead.next;
        }
        if (sortedLeft != null) {
            tempHead.next = sortedLeft;
        } else {
            tempHead.next = sortedRight;
        }
        return temp;
    }

    private ListNode getMiddle(ListNode head) {
        ListNode ptr1 = head;
        ListNode ptr2 = head;
        while (ptr2 != null && ptr2.next != null) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next.next;
        }
        return ptr1;
    }
}
