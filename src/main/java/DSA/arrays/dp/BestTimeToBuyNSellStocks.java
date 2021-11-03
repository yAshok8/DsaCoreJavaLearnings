package DSA.arrays.dp;

public class BestTimeToBuyNSellStocks {
    public static void main(String[] args) {
        int [] prices = {7,3,5,1,4,7,2,11};
        int maxProfit = maxProfit(prices);
        System.out.println(maxProfit);
    }

    private static int maxProfit(int[] prices) {
        int currMin = prices[0];
        int maxDiff = 0;
        for (int price: prices){
            currMin = Math.min(currMin, price);
            maxDiff = Math.max(maxDiff, price - currMin);
        }
        return maxDiff;
    }
}
