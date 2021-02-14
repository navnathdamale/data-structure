package com.java.practice.array;

import java.util.HashMap;
import java.util.Map;

public class SubArraySum2 {
    public static void main(String[] args) {

        int[] nums = {1, 2, 2, 2, 4, 4, 5, 6};
        int k = 4;
        System.out.println(subarraySum(nums, k));
    }

    public static int subarraySum(int[] nums, int k) {
        int sum = 0;
        int result = 0;
        Map<Integer, Integer> countSum = new HashMap<>(nums.length);
        countSum.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (countSum.containsKey(sum - k)) {
                result += countSum.get(sum - k);
            }
            countSum.put(sum, countSum.getOrDefault(sum, 0) + 1);
        }
        return result;
    }
}
