package com.java.practice.google;

import java.util.Stack;

/**
 * https://leetcode.com/problems/largest-rectangle-in-histogram/
 */
public class MaxHistogramArea {

    public static void main(String[] args) {
        int[] histogram = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(largestRectangleArea(histogram));
    }

    public static int largestRectangleArea(int[] H) {

        if (H == null || H.length == 0) {
            return 0;
        }

        int i = 0;
        int maxArea = 0;
        int maxAreaWithTop = 0;
        //maintain the stack for incremental height element: peek element represent the latest minimal height
        Stack<Integer> stack = new Stack<>();
        while (i < H.length) {
            //case-01: check if stack is empty or current element is higher than element at top of the stack
            if (stack.isEmpty() || H[stack.peek()] <= H[i]) {
                stack.push(i++);
            } else {
                int top = stack.peek();
                stack.pop();
                maxAreaWithTop = H[top] * (stack.isEmpty() ? i : i - stack.peek() - 1);
                maxArea = Math.max(maxArea, maxAreaWithTop);
            }
        }

        while (!stack.isEmpty()) {
            int top = stack.peek();
            stack.pop();
            maxAreaWithTop = H[top] * (stack.isEmpty() ? i : i - stack.peek() - 1);
            maxArea = Math.max(maxArea, maxAreaWithTop);
        }


        return maxArea;
    }
}
