package DSA.strings;

public class LongestPalindromicSubstringOptimized {
    public static void main(String[] args) {
        String s = "dfdkdf";
        System.out.println(longestPalindromicSubstring(s));
   }
    private static String longestPalindromicSubstring(String s){
        int size = s.length();
        if(size==1)
            return s;
        int [][] dynamicPalindromeMap = new int [size][size];
        int maxLen = 0;
        int tempMax = 0;
        String longestString = null;
        //Note: This is not simple 2d array traversal. We are traversing it in zigzag fashion
        for(int i=0; i<=size-1; i++){
            int innerI = i;
            for(int j=0; j<=size-1-i; j++){
                int right = innerI++;
                if(i==0){
                    dynamicPalindromeMap[j][right] = 1;
                }else {
                    boolean edgeCharsSame = s.charAt(j) == s.charAt(right);
                    if(i==1){
                        dynamicPalindromeMap[j][right] = edgeCharsSame ? 1 : 0;
                    }else{
                        //Check first the corners are same and then inner string is palindrome referring the matrix
                        dynamicPalindromeMap[j][right] = (edgeCharsSame && dynamicPalindromeMap[j+1][right-1] == 1 ) ? 1 : 0;
                    }
                }
                //here check j and right diff
                if(dynamicPalindromeMap[j][right] == 1){
                    tempMax = right - j + 1;
                    if(tempMax > maxLen){
                        longestString = s.substring(j, right+1);
                        maxLen = tempMax;
                    }
                }
            }
        }
        return longestString;
    }
}
