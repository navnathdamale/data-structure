package com.java.practice.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a chocolate bar, two children, Lily and Ron, are determining how to share it. Each of the squares has an integer on it.
 * <p>
 * Lily decides to share a contiguous segment of the bar selected such that:
 * <p>
 * The length of the segment matches Ron's birth month, and,
 * The sum of the integers on the squares is equal to his birth day.
 * You must determine how many ways she can divide the chocolate.
 * <p>
 * Consider the chocolate bar as an array of squares, . She wants to find segments summing to Ron's birth day,
 * with a length equalling his birth month,
 * . In this case, there are two segments meeting her criteria:  and .
 */
public class SubArraySum3 {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 3, 4, 2, 2, 2, 2, 4, 2, 3, 4, 5, 1, 2, 5, 2);
        int month = 4;
        int day = 10;
        System.out.println(subArraySum(nums, month, day));

    }

    private static int subArraySum(List<Integer> nums, int month, int day) {
        int sum = 0;
        int selectionChoices = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        countMap.put(0, -1);
        for (int i = 0; i < nums.size(); i++) {
            sum += nums.get(i);
            if (countMap.containsKey(sum - day) && (i - countMap.get(sum - day)) == month) {
                selectionChoices++;
            }

            countMap.put(sum, i);
        }

        return selectionChoices;
    }
}
