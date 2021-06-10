package com.java.practice.litcode;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeating {
    public static void main(String[] args) {
        String s = "abacabaabacaba";
        System.out.println(getFirstNonRepeating(s));
    }

    private static char getFirstNonRepeating(String s) {
        if (s == null || s.isEmpty()) {
            return '-';
        }
        Map<Character, Integer> countMap = new LinkedHashMap<>();
        for (Character c : s.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }

        for (Character c : countMap.keySet()) {
            if (countMap.get(c) == 1) {
                return c;
            }
        }
        return '-';
    }
}

