package core_java_only;

public class FunctionalInterfaceDemo {
    public static void main(String[] args) {
        Square s = (int i) -> i*i;
        int ans = s.calculate(10);
        System.out.println(ans);
    }
}