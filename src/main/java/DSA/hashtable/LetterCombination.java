package DSA.hashtable;

import java.util.ArrayList;
import java.util.List;

public class LetterCombination {
    public static void main(String[] args) {
        String digits = "789";
        String [] map = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> res = new ArrayList<>();
        BT(digits, 0, map, "", res);
        System.out.println(res);
    }

    public static void BT(String digits, int index, String [] map, String currentStr, List<String> res) {
        if (index == digits.length()) {
            res.add(currentStr);
            return;
        }

        int thisDigit = Integer.parseInt(String.valueOf(digits.charAt(index)));
        String [] splittedCharacters = map[thisDigit].split("");

        index++;

        for (String splittedCharacter: splittedCharacters) {
            BT(digits, index, map, currentStr+splittedCharacter, res);
        }

    }
}
