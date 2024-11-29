package custom_annotations;

public class Calculate {
    public static void main(String[] args) {
        ICalculator calculator = CacheProxy.createProxy(new Calculator());
        System.out.println(calculator.add(1, 2));
        System.out.println(calculator.add(1, 2));
        System.out.println(calculator.add(2, 2));
        System.out.println(calculator.add(2, 2));
        System.out.println(calculator.sub(2, 2));
        System.out.println(calculator.sub(2, 2));
        System.out.println(calculator.mul(2, 2));
        System.out.println(calculator.mul(2, 2));
        System.out.println(calculator.div(8, 4));
        System.out.println(calculator.div(8, 4));
    }
}
