package core_java_only.java8.functional_interface;

@FunctionalInterface
public interface StringOperation<T, R> {
    R execute(T t);
}
