package DSA.dynamic_programming;
public class InterleavingStringsLC97 {
    public static void main(String[] args) {
        String [] firstStrs = new String[] {"abababababababababababababababababababababababababababababababababababababababababababababababababbb", "MOC", "AAB", "A", ""};
        String [] secondStrs = new String[] {"babababababababababababababababababababababababababababababababababababababababababababababababaaaba","PKR", "AP", "B", ""};
        String [] res = new String[] {"abababababababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "babababababababababababababababababababababababababababababababababababababababababababababbb", "MOPKCR", "AAPAB", "A", ""};
        boolean [] expected = new boolean[] {true, true, true, false, true};
        for (int i=firstStrs.length-1; i>=0; i--) {
            if (expected[i] != checkInterleavingBF(firstStrs[i], secondStrs[i], res[i], 0, 0, 0)) {
                System.out.println("TC No. " + (i+1) + " Failed");
            } else {
                System.out.println("TC No. " + (i+1) + " Passed");
            }
        }
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
