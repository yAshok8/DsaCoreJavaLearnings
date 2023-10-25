package leetcode;

import java.util.Arrays;

class LC1143LongestCommonSubsequence {

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("aa", "bb"));
        System.out.println(longestCommonSubsequence("abcde", "ace"));
        System.out.println(longestCommonSubsequence("pmjghexybyrgzczy", "hafcdqbgncrcbihkd"));
    }
    public static int longestCommonSubsequence(String text1, String text2) {
        int [][] dp = new int [text1.length()+1][text2.length()+1];
        for (int [] arr: dp) {
            Arrays.fill(arr, -1);
        }
        return LCSRec(text1, text2, 0, 0, dp);
    }

    private static int LCSRec(String s1, String s2, int i, int j, int [][] dp) {
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (i == s1.length() || j == s2.length()) return 0;
        int ans = 0;
        if (Character.compare(s1.charAt(i), s2.charAt(j)) == 0) {
            ans =  1 + LCSRec(s1, s2, i+1, j+1, dp);
        } else {
            ans = Math.max(LCSRec(s1, s2, i, j+1, dp), LCSRec(s1, s2, i+1, j, dp));
        }
        dp[i][j] = ans;
        return ans;
    }
}
