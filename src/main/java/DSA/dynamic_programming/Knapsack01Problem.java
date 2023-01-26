package DSA.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
        System.out.println(knapSackSimple(wt, val, n - 1, W));
    }

    private static int knapSackSimple(int [] w, int [] v, int n, int W) {
        if (W == 0 || n == -1) {
            return 0;
        }
        if (w[n] < W) {
            return Math.max(knapSackSimple(w, v, n - 1, W - w[n]) + v[n], knapSackSimple(w, v, n - 1, W));
        }
        return knapSackSimple(w, v, n - 1, W);
    }

}