package rough_work;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class RoughWork {


    public static void main(String[] args) {
//        String [] strs = {"a", "asolhi", "astol", "ak"};
//        System.out.print("Prefix String is " + longestCommonPrefix(strs));
//        int num1 = (~0<<5);
//        int num2 = ((1<<2) - 1);
//        System.out.println(Integer.toBinaryString(num1 | num2));
        printMatInZigZag();
    }

    public static boolean isValidParanthesisOptimized(String s){
        if(s.length() == 0 ||
                s.length() % 2 != 0 ||
                s.charAt(0) == ']' ||
                s.charAt(0) == ')' ||
                s.charAt(0) == '}'){
            return false;
        }
        Stack<Character> st = new Stack<>();
        int index = 0;
        while (index < s.length()){
            char indexChar = s.charAt(index);
            if (indexChar == '[' || indexChar == '(' || indexChar == '{'){
                st.push(indexChar);
            }else{
                if(indexChar == '}'){
                    if(st.isEmpty() || st.pop() != '{')
                        return false;
                }else if(indexChar == ']'){
                    if(st.isEmpty() || st.pop() != '[')
                        return false;
                }else {
                    if(st.isEmpty() || st.pop() != '(')
                        return false;
                }
            }
            index++;
        }
        return st.isEmpty();
    }

    public static boolean isValidParenthesis(String s){
        Map<Character, Character> inverse = new HashMap<>();
        inverse.put('}', '{');
        inverse.put(']', '[');
        inverse.put(')', '(');
        Map<Character, Integer> bracketFrequency = new HashMap<>();
        bracketFrequency.put('[', 0);
        bracketFrequency.put('{', 0);
        bracketFrequency.put('(', 0);
        Stack<Character> currentTopBracket = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char bracket = s.charAt(i);
            if(bracket == ']' || bracket == ')' || bracket == '}' ){
                if(currentTopBracket.size() == 0)
                    return false;
                if(currentTopBracket.peek() != inverse.get(bracket))
                    return false;
                int bracF = bracketFrequency.get(inverse.get(bracket));
                currentTopBracket.pop();
                bracketFrequency.put(inverse.get(bracket), bracF-1);
            }else{
                bracketFrequency.put(bracket,bracketFrequency.get(bracket)+1);
                currentTopBracket.push(bracket);
            }
        }
        for(Map.Entry<Character, Integer> entry : bracketFrequency.entrySet()){
            if(entry.getValue() != 0)
                return false;
        }
        return true;
    }

    public static String longestCommonPrefix(String[] strs) {
        int index = 0;
        StringBuffer prefix = new StringBuffer();
        while(charCheck(index, strs)){
            prefix.append(strs[0].charAt(index));
            index++;
        }
        return prefix.toString();
    }

    private static boolean charCheck(int index, String [] strs){
        boolean flag = true;
        char c  = (strs[0].length() > index) ? strs[0].charAt(index) : '\0';
        if(c == '\0')
            return false;
        for(String s : strs){
            //check if string has character at the index place
            if(index >= s.length() || s.charAt(index) != c)
                return false;
        }
        return flag;
    }

    private static boolean areOccurrencesEqual(String s){
        int [] charArray = new int[300];
        char [] c_arr = s.toCharArray();
        for(char c : c_arr)
            ++charArray[c];
        int common_freq = 0, freq = charArray[c_arr[0]];
        for(char c : c_arr){
            common_freq = charArray[c];
            if(freq != common_freq)
                return false;
        }
        return true;
    }

    private static void printMatInZigZag(){
        int size = 9;
        for(int i=0; i<=size; i++){
            int innerI = i;
            for(int j=0; j<=size-i; j++){
                System.out.print("("+j+","+(innerI++)+") ");
            }
            System.out.println();
        }
    }
}
