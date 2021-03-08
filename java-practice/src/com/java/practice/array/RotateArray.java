package com.java.practice.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/rotate-array/submissions/
 */
public class RotateArray {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        rotate(nums, k);
        Arrays.stream(nums).forEach(n -> System.out.print(n + " "));

       List<Integer> yy = Arrays.stream(nums).mapToObj(Integer::valueOf).collect(Collectors.toList());

    }

    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        int rotation = k % n;
        for (int i = 0; i < rotation; i++) {
            int temp = nums[n - 1];
            for (int j = n - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = temp;
        }
    }
}
