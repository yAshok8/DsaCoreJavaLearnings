package DSA.dynamic_programming;

/*
* You are climbing a staircase. It takes n steps to reach the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
Example 1:
Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
* */

class ClimbStairs {
    public static void main(String[] args) {
//        System.out.println(climbStairs(1));
//        System.out.println(climbStairs(3));
        System.out.println(climbStairs(44));
//        System.out.println(climbStairs(5));
        System.out.println(climbStairsRecursionDP(44));
    }

    /**
     * This is okay but less optimal solution.
     * This can be tweaked by using DP
     * @param n the input number
     * @return the answer
     */
    public static int climbStairsRecursionDP(int n) {
        return rec(n, 0, new int[n]);
    }

    private static int rec(int n, int i, int [] dp) {
        if (i == n)
            return 1;
        int p2 = 0, p1 = 0;
        if (dp[i] == 0) {
            if (i <= n - 2) {
                p2 = rec(n, i + 2, dp);
            }
            if (i <= n - 1) {
                p1 = rec(n, i + 1, dp);
            }
            dp[i] = p1 + p2;
        }
        return dp[i];
    }

    public static int climbStairs(int n) {
        int [] dp = new int[n+1];
        dp[0] = 1; //this is how many step is required to climb 0 stair step, answer is 1
        dp[1] = 1;
        for(int i = 2; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}