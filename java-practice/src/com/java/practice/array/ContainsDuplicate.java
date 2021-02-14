package com.java.practice.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers and an integer k,
 * find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j]
 * and the absolute difference between i and j is at most k.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,1], k = 3
 * Output: true
 * Example 2:
 * <p>
 * Input: nums = [1,0,1,1], k = 1
 * Output: true
 * Example 3:
 * <p>
 * Input: nums = [1,2,3,1,2,3], k = 2
 * Output: false
 */
public class ContainsDuplicate {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1, 2, 3};
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
