package com.java.practice.google;

/**
 * https://leetcode.com/problems/circular-array-loop/
 */
public class ArrayLoop {


    public static void main(String[] args) {
        int[] nums = {-2, 1, -1, -2, -2};
        System.out.println(isCycle(nums));

    }

    public static boolean isCycle(int[] nums) {
        if (nums.length <= 1) return false;

        for (int i = 0; i < nums.length; i++) {
            int slow = i;
            int fast = i;

            boolean isForward = nums[i] > 0;
            while (true) {
                slow = getNextIndex(nums, slow, isForward);
                if (slow == -1) break;

                fast = getNextIndex(nums, fast, isForward);
                if (fast == -1) break;

                fast = getNextIndex(nums, fast, isForward);
                if (fast == -1) break;

                if (slow == fast) return true;
            }
        }

        return false;
    }

    private static int getNextIndex(int[] nums, int index, boolean isForward) {
        boolean direction = nums[index] > 0;

        if (direction != isForward) return -1;

        int nextIndex = (index + nums[index]) % nums.length;
        if (nextIndex < 0) nextIndex += nums.length;

        if (nextIndex == index) return -1;

        return nextIndex;

    }
}
