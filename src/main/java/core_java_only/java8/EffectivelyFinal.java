package core_java_only.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class EffectivelyFinal {
    public static void main(String[] args) {
        final int someVariable = 20;
        IntStream.range(0, 5).forEach(i -> {
            System.out.println("I can use someVariable here." + someVariable);
            //someVariable++; //this will result in compilation as someVariable is effectively final
        });
        List<Integer> someList = new ArrayList<>();
        IntStream.range(0, 5).forEach(someList::add);
        System.out.println(someList);
    }
}
