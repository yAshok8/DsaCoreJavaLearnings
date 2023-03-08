package core_java_only.java8.functional_interface;

//@FunctionalInterface
interface Square {
    int calculate(int side);


// This is not allowed. Concrete implementation wins over the default one.
//    default boolean equals(Object obj) {
//        return false;
//    }
}