package com.java.practice.array;

/**
 * Given an array of integers, find the subset of non-adjacent elements with the maximum sum.
 * Calculate the sum of that subset. It is possible that the maximum sum is , the case when all elements are negative.
 * <p>
 * For example, given an array  we have the following possible subsets.
 * These exclude the empty subset and single element subsets which are also valid.
 * <p>
 * Subset      Sum
 * [-2, 3, 5]   6
 * [-2, 3]      1
 * [-2, -4]    -6
 * [-2, 5]      3
 * [1, -4]     -3
 * [1, 5]       6
 * [3, 5]       8
 * Our maximum subset sum is . Note that any individual element is a subset as well.
 * <p>
 * As another example, . In this case, it is best to choose no element: return .
 */
public class SubArraySum4 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(maxSubsetSum(nums));
    }

    public static int maxSubsetSum(int[] arr) {
        if (arr.length == 0) return 0;
        arr[0] = Math.max(0, arr[0]);
        if (arr.length == 1) return arr[0];
        arr[1] = Math.max(arr[0], arr[1]);
        for (int i = 2; i < arr.length; i++)
            arr[i] = Math.max(arr[i - 1], arr[i] + arr[i - 2]);
        return arr[arr.length - 1];
    }
}
