package DSA.strings;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {
    public static void main(String[] args) {
//        String roman_number = "XII";
        String roman_number = "CIV";
        System.out.println(romanToInt(roman_number));
    }
    public static int romanToInt(String s) {
        Map<Character, Integer> roman_to_int = new HashMap<>();
        roman_to_int.put('I', 1 );
        roman_to_int.put('V', 5 );
        roman_to_int.put('X', 10 );
        roman_to_int.put('L', 50 );
        roman_to_int.put('C', 100 );
        roman_to_int.put('D', 500 );
        roman_to_int.put('M', 1000 );
        int index = 0;
        int int_num = 0;
        int str_len = s.length();
        while(index<s.length()){
            char c = s.charAt(index);
            switch (c) {
                case 'I' :
                    if(index!=str_len-1 && (s.charAt(index+1)=='V' || s.charAt(index+1)=='X')){
                        int_num = int_num + (roman_to_int.get(s.charAt(index+1)) - 1);
                        index++;
                    }else{
                        int_num = int_num + roman_to_int.get(c);
                    }
                    break;
                case 'X' :
                    if(index!=str_len-1 && (s.charAt(index+1)=='L' || s.charAt(index+1)=='C')){
                        int_num = int_num + (roman_to_int.get(s.charAt(index+1)) - 10);
                        index++;
                    }else{
                        int_num = int_num + roman_to_int.get(c);
                    }
                    break;
                case 'C' :
                    if(index!=str_len-1 && (s.charAt(index+1)=='D' || s.charAt(index+1)=='M')){
                        int_num = int_num + (roman_to_int.get(s.charAt(index+1)) - 100);
                        index++;
                    }else{
                        int_num = int_num + roman_to_int.get(c);
                    }
                    break;
                default:
                    int_num = int_num + roman_to_int.get(c);
            }
            index++;
        }
        return int_num;
    }
}
