package DSA.strings;

public class MaxLenUniqueCharString {

    public static void main(String[] args) {
//        String str = "   | ()|";
        String str = "dvdf";

        System.out.println(lengthOfLongestSubstring(str));
    }

    public static int lengthOfLongestSubstring(String str) {
        int[] charArr = new int[96];
        StringBuffer maxUniqueChars = new StringBuffer();
        int max_count = 0;
        int largest_len = 0;
        for (int i=0; i<str.length(); i++){
            int c = str.charAt(i);
            if(charArr[c-32] == 1){
                max_count = 1;
                emptyCharArr(charArr, maxUniqueChars, c);
                maxUniqueChars.setLength(0); //clears the string buffer
                maxUniqueChars.append((char)c);
            }else{
                charArr[c-32] = 1;
                maxUniqueChars.append((char)c);
                max_count++;
            }
            largest_len = Math.max(largest_len, max_count);
        }
        return largest_len;
    }

    private static void emptyCharArr(int[] charArr, StringBuffer maxUniqueChars, int c) {
        for(int i=0; i<maxUniqueChars.length(); i++){
            charArr[maxUniqueChars.charAt(i)-32] = 0;
        }
        charArr[c-32] = 1;
    }


}
