package DSA.strings;

import java.util.HashMap;
import java.util.Map;


//leetcode url : https://leetcode.com/problems/word-pattern/
class WordPattern {
    public static void main(String[] args) {
        String pattern = "abba";
        String s = "dog dog dog dog";
        System.out.println(wordPattern(pattern, s));
    }
    private static boolean wordPattern(String pattern, String s) {
        String [] words = s.split(" ");
        if (words.length != pattern.length()) 
            return false;
        Map<Character, String> charToWordMap = new HashMap<>();
        Map<String, Character> wordToCharMap = new HashMap<>();
        int index = 0;
        while (index < words.length) {
            char c = pattern.charAt(index);
            if ((charToWordMap.containsKey(c) && !charToWordMap.get(c).equals(words[index]))
            || (wordToCharMap.containsKey(words[index]) && wordToCharMap.get(words[index]) != c)) {
                return false;
            } else {
                charToWordMap.put(c, words[index]);
                wordToCharMap.put(words[index], c);
            }
            index++;
        }
        return true;
    }
}