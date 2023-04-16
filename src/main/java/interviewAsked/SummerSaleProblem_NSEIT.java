package interviewAsked;

import java.util.Arrays;

/**
 * Its almost summer sale.
 * You work for a shop that wishes to give a discount to the most
 * expensive item purchased by a given customer during the sales period.
 * Only one product can benefit from the discount.
 *
 * You are tasked by the shop owner to implement the method
 * calculateTotalPrice(prices, discount) which takes the list of prices
 * of the product purchased by a customer and the percentage discount as
 * parameter and returns the total purchase price as an
 * integer (rounded down if the total is a float number).
 */
public class SummerSaleProblem_NSEIT {
    public static void main(String[] args) {
//        int[] prices = {100, 50, 75, 121};
//        int discount = 35;
//
//        double total = calculateTotalPriceMine(prices, discount);
//        System.out.println(total);  // Output: 295
//        System.out.println(Math.round(total));  // Output: 295

        //This is the other problem from the same test
        double sum = Double.parseDouble("99.35") + Double.parseDouble("1.10");
        System.out.println(Math.round(sum * 100.0) / 100.0);
    }

    private static double calculateTotalPriceMine(int[] prices, int discount) {
        // Sort the prices in descending order
        int mostExpensive = largestPrice(prices);
        int n = prices.length;
        // Apply the discount to the most expensive item
        double mostExpensiveEffPrice = mostExpensive * (100 - discount) / 100.0;
        boolean flag = true;
        double total = 0;
        for (int price: prices) {
            if (flag && price == mostExpensive) {
                total += (mostExpensiveEffPrice + 0.0);
                flag = false;
            } else {
                total += (price + 0.0);
            }
        }
        return total;
    }

    private static int largestPrice(int [] prices) {
        int max = Integer.MIN_VALUE;
        for (int price: prices) {
            max = Math.max(max, price);
        }
        return max;
    }

}
