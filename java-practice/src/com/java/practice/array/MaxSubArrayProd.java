package com.java.practice.array;

public class MaxSubArrayProd {
	public static void main(String[] args) {
		int[] nums = { 2, 3, -2, 4, -1 };

		int max = nums[0];
		int min = nums[0];
		int product = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] < 0) {
				int temp = max;
				max = min;
				min = temp;
			}

			max = Math.max(nums[i], max * nums[i]);
			min = Math.min(nums[i], min * nums[i]);

			product = Math.max(product, max);
		}

		System.out.println(product);
	}
}
