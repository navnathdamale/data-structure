package com.java.practice.array;

/**
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate
 * (i, ai). n vertical lines are drawn such that the two endpoints of the line i is at (i, ai)
 * and (i, 0). Find two lines, which, together with the x-axis forms a container,
 * such that the container contains the most water.
 * <p>
 * Notice that you may not slant the container.
 * <p>
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by
 * array [1,8,6,2,5,4,8,3,7]. In this case, the max area of
 * water (blue section) the container can contain is 49.
 * Example 2:
 * <p>
 * Input: height = [1,1]
 * Output: 1
 * Example 3:
 * <p>
 * Input: height = [4,3,2,1,4]
 * Output: 16
 * Example 4:
 * <p>
 * Input: height = [1,2,1]
 * Output: 2
 */
public class MaxWaterContainer {
    public static void main(String[] args) {
        int[] nums = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int left = 0;
        int right = nums.length - 1;
        int max = Integer.MIN_VALUE;

        while (left < right) {
            int min = Math.min(nums[left], nums[right]);
            max = Math.max(max, min * (right - left));
            if (nums[left] <= nums[right]) {
                left++;
            } else {
                right--;
            }
        }

        System.out.println(max);

    }
}
