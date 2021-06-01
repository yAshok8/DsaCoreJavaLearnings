package DSA.heap;

public class MinHeap {

    private int capacity;
    private int size;

    int [] items = new int[capacity];

    public int getLeftChildIndex(int parentIndex) { return 2 * parentIndex + 1; }
    public int getRightChildIndex(int parentIndex) {return 2 * parentIndex + 2; }
    public int getParentIndex(int childIndex) {return (childIndex - 1) / 2; }

    public boolean hasLeftChild(int parentIndex) { return getLeftChildIndex(parentIndex) < size; }
    public boolean hasRightChild(int parentIndex) { return getRightChildIndex(parentIndex) < size; }
    public boolean hasParent(int childIndex) {return getParentIndex(childIndex) < size; }

    



}
