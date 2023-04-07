package interviewAsked;

import java.util.Arrays;
import java.util.List;

public class PrintFirstCharAllString_Altres {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Ashok", "Ved", "Babita");
        int index = 0;
        int innerCounter = 0;
        do {
            innerCounter = 0;
            for (String str: list) {
                if (index > str.length() - 1) {
                    innerCounter++;
                } else {
                    System.out.print(str.charAt(index));
                }
            }
            index++;
        } while (innerCounter != list.size());
    }
}
