package DSA.LinkedList;

public class LLNode {
    public int value;
    public LLNode next;

    public LLNode(int value) {
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
