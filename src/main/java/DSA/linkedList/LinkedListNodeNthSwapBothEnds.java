package DSA.linkedList;

/*
* You are given the head of a linked list, and an integer k.
* Return the head of the linked list after swapping the values of the kth node
* from the beginning and the kth node from the end (the list is 1-indexed).
*
* Example:
* Input: head = [7,9,6,6,7,8,3,0,9,5], k = 5
* Output: [7,9,6,6,8,7,3,0,9,5]
*
* Input: head = [1,2,3], k = 2
* Output: [1,2,3]
* */

public class LinkedListNodeNthSwapBothEnds {

    public static void main(String[] args) {
        ListNode l1 = LinkedListOperations.getDummyList();
        int k = 4;
        System.out.println("\nbefore swapping node "+k);
        l1.printVal();
        l1 = swapNodes(l1, k);
        System.out.println("\nafter swapping node "+k);
        l1.printVal();
    }

    public static ListNode swapNodes(ListNode head, int k) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode firstNode = dummyHead;
        ListNode secondNode = dummyHead;
        ListNode fast = dummyHead;

        for (int i=0; i<k; i++){
            firstNode = firstNode.next;
            fast = fast.next;
        }

        while(fast != null){
            secondNode = secondNode.next;
            fast = fast.next;
        }

        if (firstNode.val != secondNode.val){
            int temp = firstNode.val;
            firstNode.val = secondNode.val;
            secondNode.val = temp;
        }

        return dummyHead.next;
    }
}
