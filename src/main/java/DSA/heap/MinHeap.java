package DSA.heap;

import java.util.Arrays;

public class MinHeap {

    private int capacity;
    private int size;
    int [] items;

    public MinHeap(int capacity) {
        this.capacity = capacity;
        this.items = new int[capacity];
    }


    public int getLeftChildIndex(int parentIndex) { return 2 * parentIndex + 1; }
    public int getRightChildIndex(int parentIndex) {return 2 * parentIndex + 2; }
    public int getParentIndex(int childIndex) {return (childIndex - 1) / 2; }

    public boolean hasLeftChild(int parentIndex) { return getLeftChildIndex(parentIndex) < size; }
    public boolean hasRightChild(int parentIndex) { return getRightChildIndex(parentIndex) < size; }
    public boolean hasParent(int childIndex) {return getParentIndex(childIndex) < size && getParentIndex(childIndex) >= 0; } //check this with root element

    public int getParent(int itemIndex) { return items[getParentIndex(itemIndex)]; };
    public int getLeftChild(int itemIndex) { return items[getLeftChild(itemIndex)]; };
    public int getRightChild(int itemIndex) { return items[getRightChild(itemIndex)]; };

    private void swap(int index1, int index2){
        int temp = items[index1];
        items[index1] = items[index2];
        items[index2] = temp;
    }

    private void ensureCapacity(){
        if(size == capacity){
            items = Arrays.copyOf(items, capacity * 2);
            capacity*=2;
        }
    }

    public void add(int item) {
        ensureCapacity();
        items[size] = item;
        size++;
        heapfyUp();
    }

    public int poll(){
        int item = items[0];
        items[0] = items[size-1];
        size--;
        heapfyDown();
        return item;
    }

    private void heapfyUp(){
        int index = size - 1;
        while(hasParent(index) && getParent(index) > items[index]) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    private void heapfyDown(){
        int index = 0;
        try{
            while(hasLeftChild(index)){
                int smallestChildIndex = getLeftChildIndex(index);
                if (hasRightChild(index) && getRightChild(index) < getLeftChild(index)) {
                    smallestChildIndex = getRightChildIndex(index);
                }
                if(items[index] < items[smallestChildIndex])
                    break;
                else
                    swap(index, smallestChildIndex);
                index = smallestChildIndex;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void printHeap() {
        System.out.println(Arrays.toString(items));
    }
}
