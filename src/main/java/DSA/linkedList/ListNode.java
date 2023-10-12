package DSA.linkedList;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public boolean hasNext(){
        return this.next != null;
    }

    public void printVal(){
        System.out.print(this.val);
        if(hasNext()){
            System.out.print(",");
            this.next.printVal();
        }
    }

    @Override
    public String toString() {
        return val + " -> " + next;
    }
}
