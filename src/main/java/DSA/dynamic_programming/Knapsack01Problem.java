package DSA.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Knapsack01Problem {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        String [] s_n = br.readLine().split(" ");
        int W = Integer.parseInt(s_n[0]);
        int n = Integer.parseInt(s_n[1]);
        int [] wt = new int[n];
        int [] val = new int[n];
        for (int i=0; i<n; i++) {
            String [] w_v = br.readLine().split(" ");
            wt[i] = Integer.parseInt(w_v[0]);
            val[i] = Integer.parseInt(w_v[1]);
        }
//        int [] wt = {1, 2, 3, 2, 2};
//        int [] val = {8, 4, 0, 5, 3};
        int [] dp = new int[wt.length];
        Arrays.fill(dp, -1);
//        System.out.println(knapSackSimple(wt, val, 4, 4));
        System.out.println(knapsackDP(wt, val, n - 1, W, dp));
//        Arrays.stream(dp).forEach(System.out::println);
//        System.out.println(knapSackSimple(wt, val, n - 1, W));
    }

    private static int knapSackSimple(int [] w, int [] v, int n, int W) {
        if (W == 0 || n == -1)
            return 0;
        int ans = 0;
        if (w[n] <= W)
            ans =  Math.max(knapSackSimple(w, v, n - 1, W - w[n]) + v[n], knapSackSimple(w, v, n - 1, W));
        else
            ans = knapSackSimple(w, v, n - 1, W);
        return ans;
    }

    private static int knapsackDP(int [] w, int [] v, int n, int W, int [] dp) {
        if (W == 0 || n == -1)
            return 0;
        if (dp[n] == -1) {
            if (w[n] <= W) {
                int nonIncluding = knapsackDP(w, v, n - 1, W, dp);
                int including = knapsackDP(w, v, n - 1, W - w[n], dp) + v[n];
                dp[n] = Math.max(including, nonIncluding);
            } else {
                dp[n] = knapsackDP(w, v, n - 1, W, dp);
            }
        }
        return dp[n];
    }

}

/*
* My Own Input
*
1
4 3
2 3
2 8
2 1
*
* */