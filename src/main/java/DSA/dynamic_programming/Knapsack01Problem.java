package DSA.dynamic_programming;

public class Knapsack01Problem {

    public static void main(String[] args) {
        int [] wt = {1, 5, 3, 4, 8};
        int [] val = {12, 3, 4, 7, 21};
        System.out.println(KS(wt, val, 0, 12, wt.length - 1));
    }

    private static int KS(int [] wt, int [] val, int price, int W, int index) {
        if (W == 0 || index == 0)
            return price;

        if (wt[index] <= W) {
            return Math.max(KS(wt, val, price + val[index], W-wt[index], index - 1),
                    KS(wt, val, price, W, index - 1));
        }

        return KS(wt, val, price, W, index - 1);
    }
}