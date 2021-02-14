package com.java.practice.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a binary array, find the maximum length of a contiguous
 * subarray with equal number of 0 and 1.
 * <p>
 * Example 1:
 * Input: [0,1]
 * Output: 2
 * Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
 * Example 2:
 * Input: [0,1,0]
 * Output: 2
 * Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with
 * equal number of 0 and 1.
 */
public class LongestSubArray {
    public static void main(String[] args) {
        int sum = 0;
        int[] nums = {1, 1, 0, 0, 1, 1, 0, 1, 1};
        int longestSubArray = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] == 0 ? -1 : 1;
            if (sum == 0) {
                if (longestSubArray < i + 1) {
                    longestSubArray = i + 1;
                }
            } else if (countMap.containsKey(sum)) {
                longestSubArray = Math.max(longestSubArray, i - countMap.get(sum));
            } else
                countMap.put(sum, i);

        }

        System.out.println(longestSubArray);
    }
}