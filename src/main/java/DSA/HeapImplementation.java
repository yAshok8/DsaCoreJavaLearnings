package DSA;

import DSA.heap.MinHeap;

public class HeapImplementation {

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(10);
        minHeap.add(60);
        minHeap.add(20);
        minHeap.add(40);
        minHeap.add(42);
        minHeap.add(45);
        minHeap.add(21);
        minHeap.add(22);
        minHeap.add(5);
        minHeap.add(4);

        minHeap.printHeap();
    }
}
