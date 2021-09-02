package DSA.strings;

public class LongestPalindromicSubstringOptimized {
    public static void main(String[] args) {
        String s = "ashok";
        System.out.println(longestPalindromicSubstring(s));
    }
    private static String longestPalindromicSubstring(String s){
        int size = s.length();
        int [][] dynamicPalindromeMap = new int [size][size];
        for(int i=0; i<size; i++){
            int innerI = i;
            for(int j=0; j<=size-i; j++){
                int left = j;
                int right = innerI++;
                if(i==0){
                    dynamicPalindromeMap[left][right] = 1;
                }else {
                    boolean b = s.charAt(left) == s.charAt(right);
                    if(i==1){
                        dynamicPalindromeMap[left][right] = b ? 1 : 0;
                    }else{
                        dynamicPalindromeMap[left][right] = (b && dynamicPalindromeMap[left+1][right-1] == 1 ) ? 1 : 0;
                    }
                }
                System.out.println(dynamicPalindromeMap[left][right]);
            }
            System.out.println();
        }
        return null;
    }
}
