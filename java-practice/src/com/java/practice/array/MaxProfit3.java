package com.java.practice.array;

/**
 * You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
 * <p>
 * Design an algorithm to find the maximum profit. You may complete at most k transactions.
 * <p>
 * Notice that you may not engage in multiple transactions simultaneously (i.e., you must sell
 * the stock before you buy again).
 * Example 1:
 * <p>
 * Input: k = 2, prices = [2,4,1]
 * Output: 2
 * Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
 * Example 2:
 * <p>
 * Input: k = 2, prices = [3,2,6,5,0,3]
 * Output: 7
 * Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4.
 * Then buy on day 5 (price = 0)
 * and sell on day 6 (price = 3), profit = 3-0 = 3.
 */
public class MaxProfit3 {
    public static void main(String[] args) {
        int[] prices = {3, 2, 6, 5, 0, 3};
        int N = prices.length;
        int[] left = new int[N];
        int[] right = new int[N];
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < N; i++) {
            if (minPrice > prices[i]) {
                minPrice = prices[i];
            } else {
                maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            }

            left[i] = maxProfit;
        }

        int maxPrice = 0;
        maxProfit = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (maxPrice < prices[i]) {
                maxPrice = prices[i];
            } else {
                maxProfit = Math.max(maxProfit, maxPrice - prices[i]);
            }
            right[i] = maxProfit;
        }

        maxProfit = 0;
        for (int i = 0; i < N; i++) {
            maxProfit = Math.max(maxProfit, right[i] + left[i]);
        }

        System.out.println(maxProfit);
    }
}
