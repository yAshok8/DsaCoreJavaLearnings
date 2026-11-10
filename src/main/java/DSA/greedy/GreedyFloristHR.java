package DSA.greedy;

import java.util.Arrays;

public class GreedyFloristHR {

    public static void main(String[] args) {
        int k = 1;
        int [] c = new int []{1, 2};
        System.out.println("Minimum cost: " + getMinimumCost(k, c));
        System.out.println("Minimum cost: " + getMinimumCostOptimal(k, c));
    }

    static int getMinimumCostOptimal(int k, int[] c) {
        Arrays.sort(c);
        int fb = 0;
        int ans = 0;
        for (int i=c.length-1; i>=0; i--) {
            ans += ((fb++ / k) + 1) * c[i];
        }
        return ans;
    }

    static int getMinimumCost(int k, int[] c) {
        return calcMinCost(k, c, new int[c.length], 0, 0);
    }

    private static int calcMinCost(int k, int [] c, int [] flowersSold, int currPrice, int fs) {
        //terminal condition
        if (fs == c.length)
            return currPrice;

        int lenOfFlowers = flowersSold.length;
        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i < lenOfFlowers; i++) {
            if (flowersSold[i] == 0) {
                int thisPrice = ((fs / k) + 1) * c[i];
                thisPrice += currPrice;
                flowersSold[i] = 1; //flower sold
                int res = calcMinCost(k, c, flowersSold, thisPrice, fs + 1);
                minCost = Math.min(minCost, res);
                flowersSold[i] = 0; //flower unsold
            }
        }
        return minCost;
    }

}
