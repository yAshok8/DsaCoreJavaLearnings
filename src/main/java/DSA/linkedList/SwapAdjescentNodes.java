package DSA.linkedList;

public class SwapAdjescentNodes {

    public static void main(String[] args) {
        ListNode ll = LinkedListOperations.getDummyList();
        ListNode dh = new ListNode(0);
        ll.printVal();
        System.out.println();
        swapAdjescent(ll, ll.next).printVal();
    }

    private static ListNode swapAdjescent(ListNode firstNode, ListNode secondNode){
        if(secondNode == null)
            return firstNode;

        firstNode.next = secondNode.next;
        secondNode.next = firstNode;
        firstNode = secondNode;
        secondNode = secondNode.next;

        if (secondNode.next != null)
            secondNode.next = swapAdjescent(secondNode.next, secondNode.next.next);

        return firstNode;
    }
}
