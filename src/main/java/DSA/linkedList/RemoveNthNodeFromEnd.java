package DSA.linkedList;

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
class RemoveNthNodeFromEnd {

    public static void main(String[] args) {
        ListNode l1 = LinkedListOperations.getDummyList();
        System.out.println("\nbefore removing nth last node");
        l1.printVal();
        l1 = removeNthFromEnd(l1, 1);
        System.out.println("\nafter removing nth last node");
        l1.printVal();
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode ahead = dummyHead;
        ListNode behind = dummyHead;

        for(int i=0; i<n+1; i++){
            ahead = ahead.next;
        }

        while(ahead!=null){
            behind = behind.next;
            ahead = ahead.next;
        }

        behind.next = behind.next.next;
        return dummyHead.next;
    }
}