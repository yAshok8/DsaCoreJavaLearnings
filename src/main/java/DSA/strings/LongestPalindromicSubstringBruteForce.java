package DSA.strings;

public class LongestPalindromicSubstringBruteForce {
    public static void main(String[] args) {
        String str = "machiihcka";
//        System.out.println(isPalindrome("kk"));
        System.out.println(longestPalindrome(str));
    }

    private static String longestPalindrome(String str){
        int strLen = str.length();
        if (strLen <= 1)
            return str;
        int maxLen = 0;
        String midStr = null;
        String largestPalindromeSubstring = null;
        for(int i=0; i<strLen; i++){
            for(int j=i; j<strLen; j++){
                midStr = str.substring(i, j+1);
//                System.out.println(midStr);
                if(isPalindrome(midStr)){
                    //check the size of midstr
                    int cSize = midStr.length();
                    if(cSize > maxLen){
                        maxLen = cSize;
                        largestPalindromeSubstring = midStr;
                    }
                }
            }
        }
        return largestPalindromeSubstring;
    }

    private static boolean isPalindrome(String midStr) {
        int stringLen = midStr.length();
        if(stringLen <= 1)
            return true;
        for(int i=0; i<=stringLen/2; i++){
            if(midStr.charAt(i) != midStr.charAt(stringLen-i-1))
                return false;
        }
        return true;
    }
}
