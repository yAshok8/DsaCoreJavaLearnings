package DSA.strings;

public class LongestPalindromicSubstringOptimized {
    public static void main(String[] args) {
        String s = "apasa";
        System.out.println(longestPalindromeDP(s));
   }

    private static String longestPalindromeDP(String s) {
        int size = s.length();
        int [][] dp = new int[size][size];
        int l = 0;
        int r = 0;
        int maxLen = 1;
        for (int i=0; i < size; i++) {
            for (int k = 0; k+i < size; k++) {
                if (0 == i) {
                    dp[k][k+i] = 1;
                } else {
                    if (s.charAt(k) == s.charAt(k+i)) {
                        if (i>1) {
                            dp[k][k+i] = (dp[k+1][k+i-1] == 0) ? 0 : dp[k+1][k+i-1] + 2;
                        } else {
                            dp[k][k+i] = 2;
                        }
                        if (maxLen < dp[k][k+i]) {
                            l = k;
                            r = k+i;
                            maxLen = dp[k][k+i];
                        }
                    } else {
                        dp[k][k+i] = 0;
                    }
                }
            }
        }
        return s.substring(l, r+1);
    }
    private static String longestPalindromicSubstring(String s){
        int size = s.length();
        if(size==1)
            return s;
        int [][] dynamicPalindromeMat = new int [size][size];
        int maxLen = 0;
        int tempMax = 0;
        String longestString = null;
        //Note: This is not simple 2d array traversal.
        // We are traversing it in zigzag fashion,
        // starting from diagonal top-bottom and left-right
        for(int i=0; i<=size-1; i++){
            int innerI = i;
            for(int j=0; j<=size-1-i; j++){
                int right = innerI++;
                if(i==0){
                    dynamicPalindromeMat[j][right] = 1;
                }else {
                    boolean edgeCharsSame = s.charAt(j) == s.charAt(right);
                    if(i==1){
                        dynamicPalindromeMat[j][right] = edgeCharsSame ? 1 : 0;
                    }else{
                        //Check if the corners chars are same and then inner string is palindrome by referring the matrix
                        dynamicPalindromeMat[j][right] = (edgeCharsSame && dynamicPalindromeMat[j+1][right-1] == 1 ) ? 1 : 0;
                    }
                }
                //Check if current palindrome is the largest so far and then store it in a string
                if(dynamicPalindromeMat[j][right] == 1){
                    tempMax = right + 1 - j;
                    if(tempMax > maxLen){
                        longestString = s.substring(j, right+1); //+1 is for offset for the string
                        maxLen = tempMax;
                    }
                }
            }
        }
        return longestString;
    }
}
