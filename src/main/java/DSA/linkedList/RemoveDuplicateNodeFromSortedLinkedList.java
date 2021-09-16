package DSA.linkedList;

public class RemoveDuplicateNodeFromSortedLinkedList {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(1);
        l1.next.next = new ListNode(2);
        l1.next.next.next = new ListNode(3);
        l1.next.next.next.next = new ListNode(3);
//        l1.next.next.next.next.next = new ListNode(3);
//        l1.next.next.next.next.next.next = new ListNode(4);
        System.out.println("\nbefore removing duplicates");
        l1.printVal();
        deleteDuplicates(l1); //this is pass by reference
        System.out.println("\nafter removing duplicates");
        l1.printVal();
    }

    public static void deleteDuplicates(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;

        while(p1!=null){
            if(p1.val != p2.val){
                p2.next = p1;
                p2 = p2.next;
            }
            p1 = p1.next;
        }

        p2.next = p1;
    }
}
