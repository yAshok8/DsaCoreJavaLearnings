package leetcode;

import java.util.Arrays;

public class LC97InterleavingStrings {
    public static void main(String[] args) {
        String [] firstStrs = new String[] {"abababababababababababababababababababababababababababababababababababababababababababababababababbb", "MOC", "AAB", "A", "", "aa", "A", "AA", "", "aabcc"};
        String [] secondStrs = new String[] {"babababababababababababababababababababababababababababababababababababababababababababababababaaaba","PKR", "AP", "B", "", "ab", "N", "AA", "B", "dbbca"};
        String [] res = new String[] {"abababababababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "babababababababababababababababababababababababababababababababababababababababababababababbb", "MOPKCR", "AAPAB", "A", "", "abaa", "NA", "AAAA", "B", "aadbbcbcac"};
        boolean [] expected = new boolean[] {false, true, true, false, true, true, true, true, true, true};
        for (int i=firstStrs.length-1; i>=0; i--) {
            int [][] mat = new int[firstStrs[i].length()+1][secondStrs[i].length()+1];
            for (int j=0; j<=firstStrs[i].length(); j++) {
                Arrays.fill(mat[j], -1);
            }
            if (expected[i] != checkInterleavingOptimized(firstStrs[i], secondStrs[i], res[i], 0, 0, 0, mat)) {
                System.out.println("TC No. " + (i+1) + " Failed");
            } else {
                System.out.println("TC No. " + (i+1) + " Passed");
            }
        }
    }

    private static boolean checkInterleavingOptimized(String s1, String s2, String s3, int i, int j, int k, int[][] mat) {
        //check if i, j and k has reached their end.\
        if (i == s1.length() && j == s2.length() && k == s3.length()) {
            return true;
        }
        if (mat[i][j] != -1) {
            return mat[i][j] == 1;
        }
        if (s3.length() != s1.length() + s2.length())
            return false;
        boolean checkLeft = false;
        boolean checkRight = false;
        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            checkLeft = checkInterleavingOptimized(s1, s2, s3, i+1, j, k+1, mat);
        }
        if (j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            checkRight = checkInterleavingOptimized(s1, s2, s3, i, j+1, k+1, mat);
        }
        mat[i][j] = (checkLeft || checkRight) ? 1 : 0;
        return mat[i][j] == 1;
    }


    private static boolean checkInterleavingBF(String s1, String s2, String res, int i1, int i2, int i3) {
        if (res.length() != s1.length() + s2.length())
            return false;
        while (i3 < res.length()) {
            if ((i2<s2.length() && res.charAt(i3) == s2.charAt(i2))
                    && (i1<s1.length() && res.charAt(i3) == s1.charAt(i1))) {
                boolean checkLeft = checkInterleavingBF(s1, s2, res, i1+1, i2, i3+1);
                boolean checkRight = checkInterleavingBF(s1, s2, res, i1, i2+1, i3+1);
                return checkLeft || checkRight;
            } else if (i1<s1.length() && res.charAt(i3) == s1.charAt(i1)) {
                i1++;
                i3++;
            } else if (i2<s2.length() && res.charAt(i3) == s2.charAt(i2)) {
                i2++;
                i3++;
            } else {
                return false;
            }
        }
        return true;
    }
}
