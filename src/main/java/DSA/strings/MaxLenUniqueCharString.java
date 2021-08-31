package DSA.strings;

public class MaxLenUniqueCharString {

    public static void main(String[] args) {
//        String str = "   | ()|";
        String str = "dfdk";

        System.out.println(lengthOfLongestSubstring(str));
    }

    public static int lengthOfLongestSubstring(String str) {
        int[] charArr = new int[96];
        int largest_len = 0;
        int p1=0, p2=0;
        int stringLen = str.length();
        while(p2<stringLen){
            int c = str.charAt(p2);
            if(charArr[c-32] == 1){
                charArr[str.charAt(p1)-32] = 0;
                p1++;
            }else{
                charArr[c-32] = 1;
                p2++;
            }
            largest_len = Math.max((p2-p1), largest_len);
        }
        return largest_len;
    }

}
