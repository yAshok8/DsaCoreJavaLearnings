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
        int [][] dynamicPalindromeMat = new int [size][size];
        int maxLen = 0;
        int tempMax = 0;
        String longestString = null;
        //Note: This is not simple 2d array traversal. We are traversing it in zigzag fashion, starting from diagonal top-bottom and left-right
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
