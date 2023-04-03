package interviewAsked;

public class MinimumSubstring_Netcore {
    public static void main(String[] args) {
        System.out.println(solve("AKBAB"));
    }
    static int solve(String inputString) {
        String a = "AB";
//        String a = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int dp[][] = new int[a.length() + 1][inputString.length() + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (j == 0) {
                    dp[i][j] = Integer.MAX_VALUE;
                } else if (a.charAt(i - 1) == inputString.charAt(j - 1)) {
                    if (dp[i - 1][j - 1] == Integer.MAX_VALUE) {
                        dp[i][j] = Integer.MAX_VALUE;
                    } else {
                        dp[i][j] = 1 + dp[i - 1][j - 1];
                    }
                } else {
                    if (dp[i][j - 1] == Integer.MAX_VALUE) {
                        dp[i][j] = Integer.MAX_VALUE;
                    } else {
                        dp[i][j] = 1 + dp[i][j - 1];
                    }
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < dp[0].length; i++) {
            if (dp[dp.length - 1][i] < min) {
                min = dp[dp.length - 1][i];
            }
        }
        return min;
    }


}
