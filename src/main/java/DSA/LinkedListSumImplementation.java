package DSA;

import DSA.LinkedList.LLNode;

public class LinkedListSumImplementation {
    public static void main(String[] args) {
        LLNode list1 = new LLNode(9);
        list1.next = new LLNode(2);
        list1.next.next = new LLNode(3);

        LLNode list2 = new LLNode(2);
        list1.next = new LLNode(1);
        list1.next.next = new LLNode(1);

        LLNode res = new LLNode(0);

        int cf = 0;

        while ( list1.hasNext() && list2.hasNext()){
            //add 2 values and cf (if any)
            int sumVal = list1.value + list2.value + cf;
            cf = sumVal / 10;
            //take of the first digit and store as val of the res
            res.value = sumVal % 10;
            res.next = new LLNode(0);
            res = res.next;
            list1 = list1.next;
            list2 = list2.next;
            //put the decimal digit in cf variable
        }

        System.out.println(res.printVal());
    }
}
