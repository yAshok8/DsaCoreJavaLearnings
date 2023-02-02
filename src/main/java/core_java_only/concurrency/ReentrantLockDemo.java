package core_java_only.concurrency;

public class ReentrantLockDemo {
    public static void main(String[] args) {

        Thread t1 = new Thread(() -> AccessResource.resourceMethod(2));
        Thread t2 = new Thread(() -> AccessResource.resourceMethod(1));
        Thread t3 = new Thread(() -> AccessResource.resourceMethod(4));
        Thread t4 = new Thread(() -> AccessResource.resourceMethod(3));

        t4.start();
        t3.start();
        t2.start();
        t1.start();
    }
}
