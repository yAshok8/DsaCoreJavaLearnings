package DSA;

import DSA.linkedList.ListNode;

public class LinkedListSumImplementation {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);
        l1.next.next.next = new ListNode(9);

        ListNode l2 = new ListNode(8);
        l2.next = new ListNode(8);
        l2.next.next = new ListNode(8);
        l2.next.next.next = new ListNode(8);

        ListNode res = new ListNode(0);
        ListNode resHead = res;

        int cf = 0;

        while ( l1 != null && l2 != null ){
            //add 2 values and cf (if any)
            int sumVal = l1.value + l2.value + cf;
            cf = sumVal / 10;

            //take of the first digit and store as val of the res
            res.value = sumVal % 10;
            if(l1.hasNext() || cf != 0)
                res.next = new ListNode(0);

            res = res.next;
            l1 = l1.next;
            l2 = l2.next;
            //put the decimal digit in cf variable
        }

        if( cf != 0 )
            res.value = cf;

        resHead.printVal();
    }
}
