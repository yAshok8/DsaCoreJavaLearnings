package DSA.linkedList;

public class SwapAdjescentNodes {

    public static void main(String[] args) {
        ListNode ll = LinkedListOperations.getDummyList();
        ListNode dh = new ListNode(0);
        ListNode f = ll;
        dh.next = f;
        dh.next.printVal();
        ListNode s = ll.next;
        f.next = s.next;
        s.next = f;
        f = s;
        System.out.println();
        f.printVal();
    }
}
