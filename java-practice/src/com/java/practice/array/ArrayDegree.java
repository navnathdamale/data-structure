package com.java.practice.array;

import java.util.HashMap;
import java.util.Map;

public class ArrayDegree {
	public static void main(String[] args) {

		int[] nums = { 1, 2, 2, 3, 1 };

		Map<Integer, Integer> numCount = new HashMap<>();
		int degree = 0;

		Map<Integer, Integer> firstSeen = new HashMap<>();
		int minLength = 0;
		for (int i = 0; i < nums.length; i++) {
			firstSeen.putIfAbsent(nums[i], i);
			numCount.put(nums[i], numCount.getOrDefault(nums[i], 0) + 1);
			if (numCount.get(nums[i]) > degree) {
				degree = numCount.get(nums[i]);
				minLength = i - firstSeen.get(nums[i]) + 1;
			} else if (numCount.get(nums[i]) == degree) {
				minLength = Math.min(minLength, i - firstSeen.get(nums[i]) + 1);
			}
		}

		System.out.println(minLength);
	}
}
