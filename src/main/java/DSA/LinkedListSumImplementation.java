package DSA;

import DSA.LinkedList.LLNode;

public class LinkedListSumImplementation {
    public static void main(String[] args) {
        LLNode list1 = new LLNode(9);
        list1.next = new LLNode(9);
        list1.next.next = new LLNode(9);
        list1.next.next.next = new LLNode(9);

        LLNode list2 = new LLNode(8);
        list2.next = new LLNode(8);
        list2.next.next = new LLNode(8);
        list2.next.next.next = new LLNode(8);

        LLNode res = new LLNode(0);
        LLNode resHead = res;

        int cf = 0;

        while ( list1 != null && list2 != null ){
            //add 2 values and cf (if any)
            int sumVal = list1.value + list2.value + cf;
            cf = sumVal / 10;

            //take of the first digit and store as val of the res
            res.value = sumVal % 10;
            if(list1.hasNext() || cf != 0)
                res.next = new LLNode(0);

            res = res.next;
            list1 = list1.next;
            list2 = list2.next;
            //put the decimal digit in cf variable
        }

        if( cf != 0 )
            res.value = cf;

        resHead.printVal();
    }
}
