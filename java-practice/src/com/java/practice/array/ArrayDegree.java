package com.java.practice.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a non-empty array of non-negative integers nums,
 * the degree of this array is defined as the maximum frequency of any one of its elements.
 * <p>
 * Your task is to find the smallest possible length of a
 * (contiguous) subarray of nums, that has the same degree as nums.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,2,3,1]
 * Output: 2
 * Explanation:
 * The input array has a degree of 2 because both elements 1 and 2 appear twice.
 * Of the subarrays that have the same degree:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * The shortest length is 2. So return 2.
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [1,2,2,3,1,4,2]
 * Output: 6
 * Explanation:
 * The degree is 3 because the element 2 is repeated 3 times.
 * So [2,2,3,1,4,2] is the shortest subarray, therefore returning 6.
 */
public class ArrayDegree {
    public static void main(String[] args) {

        int[] nums = {1, 2, 2, 3, 1, 2, 2};

        int degree = 0;
        Map<Integer, Integer> numCount = new HashMap<>();
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
