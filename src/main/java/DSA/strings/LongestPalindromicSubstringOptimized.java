package DSA.strings;

public class LongestPalindromicSubstringOptimized {
    public static void main(String[] args) {
        String s = "valdenedlakhuva";
        System.out.println(longestPalindromicSubstring(s));
/*        int size = s.length()-1;
        for(int i=0; i<=size; i++) {
            int innerI = i;
            for (int j = 0; j <= size - i; j++) {
                System.out.print("("+j+","+(innerI++)+") ");
            }
            System.out.println();
        }*/

   }
    private static String longestPalindromicSubstring(String s){
        int size = s.length();
        if(size==1)
            return s;
        int [][] dynamicPalindromeMap = new int [size][size];
        int maxLen = 0;
        int tempMax = 0;
        String longestString = "";
        for(int i=0; i<=size-1; i++){
            int innerI = i;
            for(int j=0; j<=size-1-i; j++){
                int right = innerI++;
                if(i==0){
                    dynamicPalindromeMap[j][right] = 1;
                }else {
                    boolean b = s.charAt(j) == s.charAt(right);
                    if(i==1){
                        dynamicPalindromeMap[j][right] = b ? 1 : 0;
                    }else{
                        dynamicPalindromeMap[j][right] = (b && dynamicPalindromeMap[j+1][right-1] == 1 ) ? 1 : 0;
                    }
                    //here check j and right diff
                    if(dynamicPalindromeMap[j][right] == 1){
                        tempMax = right - j;
                        if(tempMax > maxLen){
                            longestString = s.substring(j, right+1);
                            maxLen = tempMax;
                        }
                    }
                }
            }
        }
        return longestString;
    }
}
