package com.java.practice.array;

public class SubArraySum {
	public static void main(String[] args) {
		int[] nums = { 2, 3, 6, 4, 9, 0, 11, 5, 4, 9 };
		int givenSum = 9;

		int N = nums.length;
		int start = 0;
		int end = 0;
		int sum = 0;


		while (start < N && end <= N) {
			if (sum == givenSum) {
				 System.out.println("start index :" + start + " end index :" + (end - 1));
				if (end <= N - 1) {
					sum += nums[end];
					end++;
				} else if (end == N) {
					break;
				}
			} else {
				if (sum > givenSum) {
					sum -= nums[start];
					start++;
				} else if (end <= N - 1) {
					sum += nums[end];
					end++;
				}
			}

		}

	}
}
