package core_java_only;

import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityQueueDemo {
    public static void main(String[] args) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.add(3);
        maxHeap.add(9);
        maxHeap.add(0);
        maxHeap.add(1);
        maxHeap.add(5);
        while(!maxHeap.isEmpty()) {
            System.out.print(maxHeap.remove() + " ");
        }
    }
}
