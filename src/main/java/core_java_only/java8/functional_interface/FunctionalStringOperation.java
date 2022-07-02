package core_java_only.java8.functional_interface;

import java.util.Locale;

public class FunctionalStringOperation {
    public static void main(String[] args) {
        StringOperation<String, String> lowerString = s1 -> s1.toLowerCase(Locale.ROOT);
        System.out.println(lowerString.execute("Ashok"));
        StringOperation<String, Integer> stringLen = String::length;
        System.out.println(stringLen.execute("Chekoslovakia"));
    }
}
