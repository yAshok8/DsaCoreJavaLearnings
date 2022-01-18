package DSA.arrays;

/*
*
Given a string s consisting of some words separated by some number of spaces, return the length of the last word in the string.
A word is a maximal substring consisting of non-space characters only.
Example 1:
Input: s = "Hello World"
Output: 5
Explanation: The last word is "World" with length 5.
*
LeetCode
* */

class LengthOfLastWord {

    public static void main(String[] args) {
//        String str = "Blue Moon  ";
//        String str = "ashasj ";
//        String str = "ashok";
//        String str = "ashok yadav g";
//        String str = "ashok yadav g ";
        String str = "";

        System.out.println(lengthOfLastWord(str));
    }

    public static int lengthOfLastWord(String s) {
        int p1 = s.length() - 1;
        int p2 = p1;
        while(p1 >= 0) {
            if(s.charAt(p1) == ' '){
                if(s.charAt(p2) == ' '){
                    p2--;
                    p1--;
                }else{
                    return p2 - p1;
                }
            }else{
                p1--;
            }
        }
        return p2 - p1;
    }

}