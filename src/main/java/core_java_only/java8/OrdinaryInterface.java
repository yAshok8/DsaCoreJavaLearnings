package core_java_only.java8;

//@FunctionalInterface => this will cause compilation error. Because there are 2 abstract methods.
public interface OrdinaryInterface {
    public int method1(int a);

    public int method2(int b);

    //writing a default method in an ordinary interface.
    public default int defaultMethod1() {
        return 2*3;
    }
}
