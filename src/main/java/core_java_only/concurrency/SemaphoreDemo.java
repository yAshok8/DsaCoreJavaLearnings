package core_java_only.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;


/**
 * The semaphore provides controlled access to shared resource.
 * Suppose if you want to call an external api and you want only 3 threads to call that at the same time.
 * You can write the code similar to below one to achieve that.
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        //initialize semaphore for n permits
        Semaphore semaphore = new Semaphore(3);
        //The executor service can run 10 threads at a time.
        //But It will run just n threads as per the semaphore permits
        ExecutorService es = Executors.newFixedThreadPool(10);
        for (int i=0; i<50; i++) {
            es.execute(new CallExternalService(semaphore, i));
        }
        es.shutdown();
    }

    private static class CallExternalService implements Runnable {

        private Semaphore semaphore;
        private int num;

        public CallExternalService(Semaphore semaphore, int num) {
            this.semaphore = semaphore;
            this.num = num;
        }

        public void run() {
            semaphore.acquireUninterruptibly();
            System.out.println("calling the external api. acquired by " + num);
            try { Thread.sleep(1000); } catch (InterruptedException e) {}
            System.out.println("released by " + num);
            semaphore.release();
        }
    }
}
