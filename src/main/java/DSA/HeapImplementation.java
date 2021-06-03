package DSA;

import DSA.heap.MinHeap;

public class HeapImplementation {

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(5);
//        System.out.println(minHeap.peek());
        minHeap.add(94);
        minHeap.add(60);
        minHeap.add(74);
        minHeap.add(47);
        minHeap.add(42);
        minHeap.add(40);
        minHeap.add(45);
        minHeap.add(22);
        minHeap.add(21);
        minHeap.add(20);
        minHeap.add(5);
        minHeap.add(4);
        minHeap.add(3);
        minHeap.add(1);
        minHeap.printHeap();

        System.out.println("Peek Element : "+minHeap.peek());
        System.out.println("Polling Element : "+minHeap.poll());
        System.out.println("Peek Element : "+minHeap.peek());

        minHeap.printHeap();

    }
}
