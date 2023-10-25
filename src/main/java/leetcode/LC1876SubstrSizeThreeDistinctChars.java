package leetcode;

public class LC1876SubstrSizeThreeDistinctChars {
    public static void main(String[] args) {
        String [] inputs = new String[] {"jedeh", "xyzzazaaa", "xyzz", "aaabcapapo", "aababcabc"};
        int [] answers = new int[] {2, 1, 1, 4, 4};
        boolean allSuccess = true;
        int index = 0;
        for (String s : inputs) {
            if (getSubStrSize(s) != answers[index++]) {
                allSuccess = false;
                break;
            }
        }
        System.out.println((allSuccess) ? "passed" : "failed for " + (index-1) + "");
    }

    private static int getSubStrSize(String s) {
        int minLen = 3;
        int l = 0;
        int [] charArray = new int[26];
        charArray[getIndex(s, 0)]=1;
        int w = 1;
        int ans = 0;
        for (int r=1; r<s.length(); r++) {
            //array does not contain current character
            if (charArray[getIndex(s,r)] == 0) {
                w = r - l;
                charArray[getIndex(s,r)] = 1;
            } else {
                //array contains current character
                //remove all elements till you see the array does not contain curr char
                while (charArray[getIndex(s,r)] == 1) {
                    charArray[getIndex(s,l)] = 0;
                    l++;
                }
                charArray[getIndex(s,r)] = 1;
                w = r - l;

            }
            //reached window size
            if (w == minLen - 1) {
                ans++;
                charArray[getIndex(s,l)] = 0;
                l++;
            }
        }
        return ans;
    }

    private static int getIndex(String s, int charIndex) {
        return s.charAt(charIndex)-97;
    }
}
