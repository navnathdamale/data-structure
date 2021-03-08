package com.java.practice.google;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/majority-element/
 */

public class MajorityElement {

    public int majorityElement(final int[] A) {

        if (A == null || A.length == 0) {
            return 0;
        }
        int size = A.length;
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < size; i++) {
            countMap.put(A[i], countMap.getOrDefault(A[i], 0) + 1);
        }

        for (Integer items : countMap.keySet()) {
            if (countMap.get(items) > Math.floor(size / 2)) {
                return items;
            }
        }

        return 0;
    }
}
