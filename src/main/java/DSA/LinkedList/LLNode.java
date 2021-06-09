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

    public int printVal(){
        if(hasNext())
            return this.next.printVal();
        return this.value;
    }
}
