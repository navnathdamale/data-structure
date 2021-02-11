package com.java.practice.array;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate {

	public static void main(String[] args) {
		int[] nums = { 1,2,3,1,2,3 };
		int k = 2;
		Map<Integer, Integer> dup = new HashMap<Integer, Integer>();
		boolean flag = false;
		for (int i = 0; i < nums.length; i++) {
			if (dup.containsKey(nums[i]) && (i - dup.get(nums[i])) == k) {
				flag = true;
			} else {
				dup.put(nums[i], i);
			}

		}

		System.out.println(flag);
	}

}
