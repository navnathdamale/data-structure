package com.java.practice.array;

public class MaxProfit3 {
	public static void main(String[] args) {
		int[] prices = { 3, 3, 5, 0, 0, 3, 1, 4 };
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
