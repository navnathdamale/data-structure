package com.java.practice.array;

public class MaxSubArraySum {
	public static void main(String[] args) {
		int[] nums = { 2, 3, -2, 4 };
		int max = nums[0];
		int maxEnd = nums[0];
		for (int i = 1; i < nums.length; i++) {
			maxEnd = Math.max(nums[i], maxEnd + nums[i]);
			max = Math.max(maxEnd, max);
		}

		System.out.println(maxEnd);
	}
}
