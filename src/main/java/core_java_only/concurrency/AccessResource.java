package core_java_only.concurrency;

import java.util.concurrent.locks.ReentrantLock;

public class AccessResource {

    public static ReentrantLock lock = new ReentrantLock();

    public static void resourceMethod(int tNum) {
        lock.lock();
        System.out.println("Thread " + tNum + " entered");
        System.out.println("Thread " + tNum + " left");
        lock.unlock();
    }
}
