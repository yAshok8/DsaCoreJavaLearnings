package leetcode;

import java.util.Stack;

class LC316RemoveDuplicateLetters {

    public static void main(String[] args) {
        LC316RemoveDuplicateLetters obj = new LC316RemoveDuplicateLetters();
        System.out.println(obj.removeDuplicateLetters("bcabc"));
        System.out.println(obj.removeDuplicateLetters("cbacdcbc"));
        System.out.println(obj.removeDuplicateLetters("bbcaac"));
        System.out.println(obj.removeDuplicateLetters("abacb"));
        System.out.println(obj.removeDuplicateLetters("acbac"));
    }

    public String removeDuplicateLetters(String s) {
        int [] lastOccurrance = new int[26];
        boolean [] seen = new boolean[26];
        Stack<Character> stack = new Stack<>();
        int index = 0;
        for (char c: s.toCharArray()) {
            lastOccurrance[c-'a'] = index++;
        }
        index = 0;
        while (index < s.length()) {
            char c = s.charAt(index);
            if (!seen[c-'a']) {
                //check if stack top can be removed from the stack
                while (!stack.isEmpty() && c < stack.peek() && lastOccurrance[stack.peek()-'a'] > index) {
                    seen[stack.pop()-'a'] = false;
                }
                stack.push(c);
                seen[c-'a'] = true;
            }
            index++;
        }

        StringBuilder stbr = new StringBuilder();
        while (!stack.isEmpty()) {
            stbr.append(stack.pop());
        }
        return stbr.reverse().toString();
    }

}
