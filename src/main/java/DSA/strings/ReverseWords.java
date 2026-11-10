package DSA.strings;

public class ReverseWords {

    public static void main(String[] args) {
//        String input = "Hello World 12/10/2024 ABC xyz, Test;";
        String input = ".*Hello }}))(({{ World 12/10/2024 ABC xyz, Test";

        String result = reverseWords(input);

        System.out.println("Original : " + input);
        System.out.println("Processed: " + result);
    }

    private static String reverseWords(String sentence) {
        StringBuilder holder = new StringBuilder(sentence.length());
        int length = sentence.length();
        int breakIndex = 0;
        for (int i=0; i<=length; i++) {
            if (i == length || !isAlphabet(sentence.charAt(i))) {
                for (int j=i-1; j >= breakIndex; j--) {
                    holder.append(sentence.charAt(j));
                }
                breakIndex = i+1;
                if (i < length) holder.append(sentence.charAt(i));
            }
        }
        return holder.toString();
    }

    private static boolean isAlphabet(final char c) {
        return (c <= 'z' && c >= 'a') || (c <= 'Z' && c >= 'A');
    }

    /* No need of it */
    private static String reverse(char [] input) {
        char [] res = new char[input.length];
        int len = input.length;
        int index = 0;
        while(index <= len / 2) {
            res[index] = input[len - 1 - index];
            res[len - 1 - index] = input[index];
            index++;
        }
        return new String(res);
    }

}