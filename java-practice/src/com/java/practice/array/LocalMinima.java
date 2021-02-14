package com.java.practice.array;

/**
 * Given an array arr[0 .. n-1] of distinct integers, the task is to find a local minima in it. We say that an element arr[x] is a local minimum if it is less than or equal to both its neighbors.
 * <p>
 * For corner elements, we need to consider only one neighbor for comparison.
 * There can be more than one local minima in an array, we need to find any one of them.
 * Examples:
 * <p>
 * Input: arr[] = {9, 6, 3, 14, 5, 7, 4};
 * Output: Index of local minima is 2
 * The output prints index of 3 because it is
 * smaller than both of its neighbors.
 * Note that indexes of elements 5 and 4 are
 * also valid outputs.
 * <p>
 * Input: arr[] = {23, 8, 15, 2, 3};
 * Output: Index of local minima is 1
 * <p>
 * Input: arr[] = {1, 2, 3};
 * Output: Index of local minima is 0
 * <p>
 * Input: arr[] = {3, 2, 1};
 * Output: Index of local minima is 2
 */
public class LocalMinima {

    public static int findLocalMinima(int[] arr, int start, int end) {
        int mid = (start + end) / 2;
        int size = arr.length;
        if ((mid == 0 || arr[mid - 1] > arr[mid]) && (mid == size - 1 || arr[mid] < arr[mid + 1])) {
            return arr[mid];
        } else if (mid > 0 && arr[mid - 1] < arr[mid]) {
            return findLocalMinima(arr, start, mid);
        } else {
            return findLocalMinima(arr, mid + 1, end);
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 5, 3, 6, 13, 16, 7};
        System.out.println("Local Minima is: " + findLocalMinima(arr, 0, arr.length));
    }
}
