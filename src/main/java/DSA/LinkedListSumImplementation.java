package DSA;

import DSA.linkedList.ListNode;

public class LinkedListSumImplementation {
    public static void main(String[] args) {
        LLNode list1 = new LLNode(9);
        list1.next = new LLNode(9);
        list1.next.next = new LLNode(9);
        list1.next.next.next = new LLNode(9);

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

        while ( l1 != null ){
            int sumVal = l1.val + cf;
            res.val = sumVal % 10;
            cf = sumVal / 10;
            if(l1.next != null || cf != 0) {
                res.next = new ListNode(0);
            }
            res = res.next;
            l1 = l1.next;
        }

        while ( l2 != null ){
            int sumVal = l2.val + cf;
            res.val = sumVal % 10;
            cf = sumVal / 10;
            if(l2.next != null || cf != 0) {
                res.next = new ListNode(0);
            }
            res = res.next;
            l2 = l2.next;
        }


        if( cf != 0 )
            res.val = cf;

        System.out.print("[");
        resHead.printVal();
        System.out.print("]");
    }

}
