package core_java_only;

import java.util.HashSet;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadObjectLockDemo {

    private static final HashSet<String> names = new HashSet<>();

    private final static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        new Thread(() -> {
            mk1("Thread-1");
        }).start();
        new Thread(() -> {
            mk1("Thread-2");
        }).start();
        new Thread(() -> {
            mk1("Thread-3");
        }).start();
        new Thread(() -> {
            mk1("Thread-1");
        }).start();
        new Thread(() -> {
            mk1("Thread-1");
        }).start();
        new Thread(() -> {
            mk1("Thread-1");
        }).start();
        new Thread(() -> {
            mk1("Thread-1");
        }).start();
        new Thread(() -> {
            mk1("Thread-1");
        }).start();
        new Thread(() -> {
            mk1("Thread-1");
        }).start();
        new Thread(() -> {
            mk1("Thread-1");
        }).start();
    }

    public static void mk1(String str){
        synchronized (MapUtility.getObject(str)){
            printOnly(str+" start");
            //sleepSomeTime();
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            printOnly(str+" end");
            //sleepSomeTime();

        }
    }

    public static void m1(String str){
        synchronized (str){
            printOnly(str+" start");
            sleepSomeTime();
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            printOnly(str+" end");
            sleepSomeTime();
        }
    }

    public static void printOnly(String var1){
        System.out.println(var1);
    }

    public static void sleepSomeTime(){
        try {
            System.out.println("Sleeping for 2 sec");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
