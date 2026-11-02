package DSA.stack;

import java.util.*;

public class ATaleOfTwoStacks {
    public static class MyQueue<T> {
        
        Stack<T> stackNewestOnTop = new Stack<T>();
        Stack<T> stackOldestOnTop = new Stack<T>();
        public void enqueue(T value) {
            stackNewestOnTop.push(value);
        }

        public T peek() {
            transferIfNeeded();
            return stackOldestOnTop.peek();
        }

        public T dequeue() {
            transferIfNeeded();
            return stackOldestOnTop.pop();
        }

        private void transferIfNeeded() {
            if (stackOldestOnTop.isEmpty()) {
                while (!stackNewestOnTop.isEmpty()) {
                    stackOldestOnTop.push(stackNewestOnTop.pop());
                }
            }
        }
    }


    public static void main(String[] args) {

        MyQueue<Integer> queue = new MyQueue<>();

        int[][] operations = {
                {1, 10},
                {1, 20},
                {1, 30},
                {2},
                {1, 40},
                {2},
                {2},
                {3} //10
        };

        for (int[] op : operations) {
            if (op[0] == 1) { // enqueue
                queue.enqueue(op[1]);
            } else if (op[0] == 2) { // dequeue
                queue.dequeue();
            } else if (op[0] == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
    }
}