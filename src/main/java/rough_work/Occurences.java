package rough_work;

import java.util.*;

public class Occurences {
    public static void main(String[] args) {
//        String str = "Hello!!WelcometoHereTechnologies,Mumbai";
        String str = "eacececbebddedd";
        findOccurences(str);
    }
    private static void findOccurences(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        Map<Integer, List<Character>> freqMap = new HashMap<>();
        for (Map.Entry<Character, Integer> entryObj: map.entrySet()) {
            int freq = entryObj.getValue();
            if (freqMap.containsKey(freq)) {
                List<Character> charList = freqMap.get(freq);
                charList.add(entryObj.getKey());
            } else {
                List<Character> charList = new ArrayList<>();
                charList.add(entryObj.getKey());
                freqMap.put(entryObj.getValue(), charList);
            }
        }
        System.out.println(freqMap);
        int n = 2;
        int nth_largest = freqMap.keySet().stream()
                .sorted(Comparator.reverseOrder())
                .skip(n-1)
                .findFirst()
                .get();
        if (freqMap.containsKey(nth_largest)) {
            System.out.println(freqMap.get(nth_largest).get(0));
        }
    }
}
