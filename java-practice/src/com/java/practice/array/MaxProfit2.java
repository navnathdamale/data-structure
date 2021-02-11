package com.java.practice.array;

public class MaxProfit2 {
	public static void main(String[] args) {
		int[] nums = { 3, 3, 5, 0, 0, 3, 1, 4 };
		int buyIndex = 0;
		int maxProfit = 0;
		for (int i = 1; i < nums.length; i++) {
			int profit = nums[i] - nums[buyIndex];
			if (profit < 0) {
				buyIndex = i;
			} else {
				maxProfit = maxProfit + profit;
				buyIndex = i;
			}
		}

		System.out.println(maxProfit);
	}
}
