package com.java.practice.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an unsorted array of nonnegative integers, find a continuous subarray which adds to a given number.
 * Examples :
 * <p>
 * Input: arr[] = {1, 4, 20, 3, 10, 5}, sum = 33
 * Ouptut: Sum found between indexes 2 and 4
 * Sum of elements between indices
 * 2 and 4 is 20 + 3 + 10 = 33
 * <p>
 * Input: arr[] = {1, 4, 0, 0, 3, 10, 5}, sum = 7
 * Ouptut: Sum found between indexes 1 and 4
 * Sum of elements between indices
 * 1 and 4 is 4 + 0 + 0 + 3 = 7
 * <p>
 * Input: arr[] = {1, 4}, sum = 0
 * Output: No subarray found
 * There is no subarray with 0 sum
 */
public class SubArraySum {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 2, 4, 4, 1, 1, 4, 6};
        int givenSum = 5;
        printSumSubArray(nums, givenSum);
    }

    private static void printSumSubArray(int[] nums, int k) {
        int sum = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        boolean isFound = false;
        countMap.put(0, 0);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (countMap.containsKey(sum - k)) {
                isFound = true;
                System.out.println("start index :" + countMap.get(sum - k) + " end index :" + i);
            }
            countMap.put(sum, i + 1);
        }

        if (!isFound) {
            System.out.println("There is no subarray with: " + k + " sum");
        }
    }
}
