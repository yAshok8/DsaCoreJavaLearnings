package leetcode;

import java.util.*;

public class LC187RepeatedDNASequences {
    public static void main(String[] args) {
        String s = "ACGTPACGT";
//        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
//        String s = "AAAAAAAAAAAAA";
        System.out.println(findRepeatedDnaSequences(s));
    }
    public static List<String> findRepeatedDnaSequences(String s) {
        Set<Character> dnaNucleotides = getNucleotides();
        Set<String> tempSet = new HashSet<>();
        Set<String> ansSet = new HashSet<>();
        StringBuilder stbr = new StringBuilder();
        stbr.append(s.charAt(0));
        for (int i=1; i<s.length(); i++) {
            //check if curr char in nucleotides
            if (dnaNucleotides.contains(s.charAt(i))) {
                stbr.append(s.charAt(i));
                //check if stbr size has reached 10
                if (stbr.length() == 10) {
                    //check if tempSet contains curr stbt string
                    if (tempSet.contains(stbr.toString())) {
                        ansSet.add(stbr.toString());
                    } else {
                        tempSet.add(stbr.toString());
                    }
                    stbr.deleteCharAt(0);
                }
            } else {
                stbr.setLength(0);
            }
        }
        return new ArrayList<>(ansSet);
    }
    private static Set<Character> getNucleotides() {
        Set<Character> dnaNucleotides = new HashSet<>();
        dnaNucleotides.add('A');
        dnaNucleotides.add('C');
        dnaNucleotides.add('G');
        dnaNucleotides.add('T');
        return dnaNucleotides;
    }
}
