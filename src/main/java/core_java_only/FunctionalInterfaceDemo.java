package core_java_only;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;

public class FunctionalInterfaceDemo {
    public static void main(String[] args) {
        Square s = (int i) -> i*i;
        int ans = s.calculate(10);
        System.out.println(ans);

        //Binary Operator Demo
        //Takes 2 arguments of a type and returns the same type value
        BinaryOperator<List<String>> commonNames = (nameList1, nameList2) -> {
            nameList1.retainAll(nameList2);
            return nameList1;
        };
        List<String> homeFriends = new ArrayList<>(Arrays.asList("Mukesh", "Jayesh", "Vinod", "Meghana", "Kapil"));
        List<String> officeFriends = new ArrayList<>(Arrays.asList("Meghana", "Kapil", "Nishant", "Mukesh"));
        System.out.println("Common Friends : "+commonNames.apply(homeFriends, officeFriends));

        //Predicate
        Predicate<String> nameStartWithM = (name) -> name.startsWith("M");
        System.out.println("\nCommon Friends Whose names start with M");
        for (String name: commonNames.apply(homeFriends, officeFriends)) {
            if (nameStartWithM.test(name))
                System.out.print(name+", ");
        }
    }
}