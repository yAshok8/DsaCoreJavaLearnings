package interviewAsked;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidFIDChecker_Peagasis {

    public static void main(String[] args) {

        String[] input = new String[]{"123-44-9876", "123 44 9876", "123449876",
                "Invalid Input", "98-1234567", "981234567", "98 1234567", "981234567ABC"};
        String[] entityType = new String[]{"P", "P", "P", "P", "B", "B", "B", "B"};

        process(input, entityType);
    }

    private static void process(String[] input, String[] entityType) {
        String  [] answers = new String[entityType.length];
        for (int i=0; i<input.length; i++) {
            answers[i] = validate(input[i], entityType[i]);
        }
        for (String ans : answers) {
            System.out.println(ans);
        }
    }

    private static String transform(String inputStr, String entityType,  Pattern p) {
        Matcher m = p.matcher(inputStr);
        StringBuilder stbr = new StringBuilder();
        if (m.find() && entityType.equals("P")) {
            stbr.append(m.group(1)).append("-").append(m.group(2)).append("-").append(m.group(3));
        } else {
            stbr.append(m.group(1)).append("-").append(m.group(2));
        }
        return stbr.toString();
    }


    private static String validate(String fid, String entityType) {
        Pattern p = Pattern.compile("([0-9]{3})[- ]*([0-9]{2})[- ]*([0-9]{4})");
        Pattern b = Pattern.compile("([0-9]{2})[- ]*([0-9]{7})");
        Matcher m = null;
        boolean ans = false;
        String transformed = null;

        switch (entityType) {

            case "P" :
                m = p.matcher(fid);
                ans = m.matches();
                if (ans) {
                    transformed = transform(fid, entityType, p);
                }
                break;
            case "B" :
                m = b.matcher(fid);
                ans = m.matches();
                if (ans) {
                    transformed = transform(fid, entityType, b);
                }
                break;

            default:
                break;
        }
        return (null == transformed) ? "Invalid Entry" : transformed;
    }

}
