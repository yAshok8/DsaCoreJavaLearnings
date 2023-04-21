package interviewAsked;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class Test_Nomura {
    private static class AddNum implements Runnable {
        int [] arr;
        int index;
        CountDownLatch latch = null;
        public AddNum(int [] arr, int index,CountDownLatch latch) {
            this.arr = arr;
            this.index = index;
            this.latch = latch;
        }
        public void run() {
            arr[index] += 1;
            latch.countDown();
        }
    }
    public static void main(String[] args) throws InterruptedException {
        int [] arr = {1,2,3,4,5};
        CountDownLatch latch = new CountDownLatch(arr.length);
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (int i=0; i<arr.length; i++) {
            executorService.execute(new AddNum(arr, i, latch));
        }
        latch.await();
        for (int elem: arr) {
            System.out.println(elem);
        }
        executorService.shutdown();
    }
}