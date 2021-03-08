package com.java.practice.array;

import java.util.*;

/**
 * https://www.hackerrank.com/challenges/manasa-and-stones/problemo
 */
public class TreasureStones {

    public static void main(String[] args) {
        Arrays.stream(stones(2, 10, 100)).forEach(System.out::println);
    }

    public static int[] stones(int n, int a, int b) {
        Set<Integer> stones = new LinkedHashSet<>(n);
        for (int i = (n - 1); i >= 0; i--) {
            stones.add(i * a + (n - 1 - i) * b);
        }
        return stones.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int[] stones1(int n, int a, int b) {
        int[] stones = new int[n];
        if (n < 1) {
            return stones;
        }
        int lower = Math.min(a, b);
        int upper = Math.max(a, b);
        int base = lower * (n - 1);
        for (int i = 0; i < n; i++) {
            stones[i] = base;
            base += (upper - lower);
        }

        return Arrays.stream(stones).distinct().toArray();
    }
}
