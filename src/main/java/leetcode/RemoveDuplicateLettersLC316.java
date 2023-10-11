package leetcode;

import java.util.Stack;

class RemoveDuplicateLettersLC316 {

    public static void main(String[] args) {
        RemoveDuplicateLettersLC316 obj = new RemoveDuplicateLettersLC316();
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
            lastOccurrance[c-97] = index++;
        }
        stack.push(s.charAt(0));
        seen[s.charAt(0)-97] = true;
        index = 1;
        while (index < s.length()) {
            char c = s.charAt(index);
            if (c < stack.peek() && !seen[c-97]) {
                //check if stack top can be removed from the stack
                while (!stack.isEmpty() && c < stack.peek() && lastOccurrance[stack.peek()-97] > index) {
                    seen[stack.pop()-97] = false;
                }
            }
            if (!seen[c-97]) {
                stack.push(c);
                seen[c-97] = true;
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
