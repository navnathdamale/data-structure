package com.java.practice.array;

public class MaxProfit {
	public static void main(String[] args) {
		int[] nums = { 7, 1, 5, 3, 6, 4 };
		int buyIndex = 0;
		int maxProfit = 0;
		for (int i = 1; i < nums.length; i++) {
			int profit = nums[i] - nums[buyIndex];
			if (profit < 0) {
				buyIndex = i;
			} else if (profit > maxProfit) {
				maxProfit = profit;
			}
		}

		System.out.println(maxProfit);
	}
}
