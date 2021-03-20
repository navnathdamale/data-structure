package com.java.practice.pattern;

import java.util.HashMap;
import java.util.Map;

public class ShoePairs {
    public static void main(String[] args) {
        int[] nums = {10, 20, 20, 10, 10, 30, 50, 10, 20};
        System.out.println(sockMerchant(9, nums));
    }

    static int sockMerchant(int n, int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int pairs = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            countMap.put(arr[i], countMap.getOrDefault(arr[i], 0) + 1);
            int count = countMap.get(arr[i]);
            if (count > 0) {
                pairs += (count % 2 == 0) ? 1 : 0;
            }
        }

        return pairs;
    }

}
