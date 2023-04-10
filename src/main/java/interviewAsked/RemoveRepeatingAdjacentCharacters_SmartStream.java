package interviewAsked;

import java.util.Stack;


/**
 * If you have a string "abbap"
 * if you are provided with num as 2.
 * You have to find 2 adjacent similar characters and remove them.
 * Explanation: You remove bb from given string. After removing them
 * you have "aa" as same adjacent chars.
 * You remove "aa" as well.
 * The final string would be "p"
 */
public class RemoveRepeatingAdjacentCharacters_SmartStream {
    public static void main(String[] args) {
        String str = "abbaxybbbz";
        int num = 3;
        int i = 0;
        int currSize = 1;
        Stack<Character> stack = new Stack<>();
        while (i<str.length()) {
            char c = str.charAt(i);
            if (!stack.isEmpty() && c == stack.peek()) {
                stack.push(c);
                currSize++;
                if (currSize == num) {
                    for (int k=0; k<num; k++) stack.pop();
                    currSize = 1;
                }
            } else {
                currSize = 1;
                stack.push(c);
            }
            i++;
        }
        System.out.println(stack);
    }
}
