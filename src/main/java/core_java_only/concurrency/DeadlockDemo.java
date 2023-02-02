package core_java_only.concurrency;

public class DeadlockDemo {
    public static void main(String[] args) {
        Object res1 =  new Object();
        Object res2 =  new Object();
        Runnable r1 = () -> {
            synchronized (res1) {
                System.out.println("T1 locked res1");
                synchronized (res2) {
                    System.out.println("T1 locked res2");
                }
            }
        };
        Runnable r2 = () -> {
            synchronized (res2) {
                System.out.println("T2 locked res2");
                synchronized (res1) {
                    System.out.println("T2 locked res1");
                }
            }
        };
        new Thread(r1).start();
        new Thread(r2).start();
    }
}
