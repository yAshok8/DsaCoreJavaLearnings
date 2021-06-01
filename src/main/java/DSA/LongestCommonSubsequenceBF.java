package DSA;

public class LongestCommonSubsequenceBF {
    public static void main(String[] args) {
//        String seq1 = "abcdef";
//        String seq2 = "bcefp";
        String seq1 = "SHINCHAN";
        String seq2 = "NOHARAAA";
/*        if(seq1.length() > seq2.length())
            printLCS(seq1.toCharArray(), seq2.toCharArray());
        else
            printLCS(seq2.toCharArray(), seq1.toCharArray());*/
        System.out.println("andn");
        int n = lcsDP(seq1, seq2);
    }

    public static int lcsDP(String seq1, String seq2){
        char[] seq1_char = seq1.toCharArray();
        char[] seq2_char = seq2.toCharArray();
        int dpArr[][] = new int[seq1_char.length+1][seq2_char.length+1];
        System.out.println(lcs(seq1_char, seq2_char, dpArr, 1,1));
        return 0;
    }

    public static int lcs(char[] s1, char[] s2, int[][] dpArr, int i, int j){
        if(s1[i-1] == s1[j-1]){
            dpArr[i][j] = 1 + dpArr[i-1][j-1];
        } else {
            dpArr[i][j] = Math.max(lcs(s1,s2,dpArr,i+1, j), lcs(s1,s2,dpArr,i, j+1));
        }
        return dpArr[i][j];
    }

    public static void printLCS(char[] seq1, char[] seq2){
        int len1 = seq1.length;
        int len2 = seq2.length;
        String lcs = "";
        StringBuilder lcsTemp = new StringBuilder();
        int t=0;
        for(int i=0; i<len2; i++){
            for(int j=t; j<len1; j++){
                if (seq2[i] == seq1[j]){
                    t = j;
                    lcsTemp.append(seq2[i]);
                    break;
                }
            }
        }
        if(lcs.length() < lcsTemp.toString().length()){
            lcs = lcsTemp.toString();
        }
        System.out.println(lcs);
    }

    //I am adding some comments here.
}
