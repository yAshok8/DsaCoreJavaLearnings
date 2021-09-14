package DSA.arrays.gen;

class MaxStockProfitI {
    public static void main(String[] args) {
        int [] prices = {7,1,6,9,1,3,8};
//        int [] prices = {7,1,5,3,6,4};
//        int [] prices = {7,6,4,3,1};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1)
            return 0;
        int maxP = 0;
        int minPrice = prices[0];
        for (int i=0; i<prices.length; i++){
            maxP = Math.max(maxP, prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }
        return maxP;
    }

}