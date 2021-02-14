package com.java.practice.array;

import java.util.LinkedList;

public class SlidingWindowMax {

    public static void main(String[] args) {
        int[] testArr = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        maxWindowUsingDeque(testArr, k);
    }

    public static void maxWindow(int[] arr, int k) {
        for (int i = k; i <= arr.length; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i - k; j < i; j++) {
                max = Math.max(max, arr[j]);
            }
            System.out.print(max + " ");
        }
    }

    private static void maxWindowUsingDeque(int[] arr, int k) {

        LinkedList<Integer> deque = new LinkedList<>();

        for (int i = 0; i < arr.length; i++) {

            /* keep removing the elements from deque
             * which are smaller than the current element,
             * because we need to keep our deque sorted in dec order
             */
            while (!deque.isEmpty() && arr[deque.getLast()] <= arr[i]) {
                deque.removeLast();
            }

            /* removing the i-k element, because that element does not belong
             * to the subarray we are currently working on.
             */
            while (!deque.isEmpty() && deque.getFirst() <= i - k) {
                deque.removeFirst();
            }

            deque.addLast(i);

            if (i >= k - 1) {
                /* only print when we have processed atleast k elements
                 * to make the very first subarray
                 */
                System.out.print(" " + arr[deque.getFirst()]);
            }

        }
    }
}