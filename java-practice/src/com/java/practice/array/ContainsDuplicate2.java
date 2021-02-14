package com.java.practice.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, find out whether there are two distinct indices i and j
 * in the array such that the absolute difference between nums[i] and nums[j] is at most
 * t and the absolute difference between i and j is at most k.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,1], k = 3, t = 0
 * Output: true
 * Example 2:
 * <p>
 * Input: nums = [1,0,1,1], k = 1, t = 2
 * Output: true
 * Example 3:
 * <p>
 * Input: nums = [1,5,9,1,5,9], k = 2, t = 3
 * Output: false
 */
public class ContainsDuplicate2 {
    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 1};
        int k = 1;
        int t = 2;
        boolean flag = false;
        Map<Integer, Integer> dups = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (dups.containsKey(nums[i] - t) && (i - dups.get(nums[i])) == k) {
                flag = true;
                break;
            }
            dups.put(nums[i], i);
        }

        System.out.println(flag);
    }
}
