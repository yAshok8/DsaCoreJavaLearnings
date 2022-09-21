package DSA.heaps;

import java.util.ArrayList;
import java.util.List;

public class MaxHeap {

    private List<Integer> array = new ArrayList<>();

    public void push(int data) {
        array.add(data);
        //shuffle the data with its parent
        int currIndex = array.size() - 1;
        while (currIndex >= 0) {
            int parentIndex = (currIndex - 1) / 2;
            //swap the elem with parent if parent < elem
            if (array.get(parentIndex) < array.get(currIndex)) {
                int parent = array.get(parentIndex);
                array.set(parentIndex, array.get(currIndex));
                array.set(currIndex, parent);
                currIndex = parentIndex;
            } else {
                currIndex = -1;
            }
        }
        System.out.println(array);
    }

    public int pop() {
        return 0;
    }
}
