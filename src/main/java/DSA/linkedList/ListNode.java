package DSA.linkedList;

public class ListNode {
    public int value;
    public ListNode next;

    public ListNode(int value) {
        this.value = value;
    }

    public boolean hasNext(){
        return this.next != null;
    }

    public void printVal(){
        if(hasNext())
            this.next.printVal();
        System.out.print(this.value+" ");
    }
}
