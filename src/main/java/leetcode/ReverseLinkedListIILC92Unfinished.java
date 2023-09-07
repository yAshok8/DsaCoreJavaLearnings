package leetcode;

class ReverseLinkedListIILC92Unfinished {

    public static void main(String[] args) {
        ListNode start = new ListNode(1);
        start.next = new ListNode(2);
        start.next.next = new ListNode(3);
        start.next.next.next = new ListNode(4);
        start.next.next.next.next = new ListNode(5);
        reverseBetween(start, 2, 4);
    }
    private static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode first = null;
        ListNode second = null;
        ListNode last = null;
        ListNode temp = null;
        ListNode ptr = head;
        int l = 1;
        while (ptr != null) {
            if (l==left) {
                first = ptr;
                second = ptr;
                ptr = ptr.next;
                while (l<right) {
                    temp = ptr.next;
                    ptr.next = second;
                    second = ptr;
                    ptr = temp;
                    l++;
                }
                last = ptr;
                last.next = head;
                first.next = ptr;
                break;
            }
            ptr = ptr.next;
            l++;
        }
        return head;
    }
}
