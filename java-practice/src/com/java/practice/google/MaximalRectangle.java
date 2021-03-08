package com.java.practice.google;

import java.util.Stack;

/**
 * https://leetcode.com/problems/maximal-rectangle/
 */
public class MaximalRectangle {

    public static void main(String[] args) {
        char[][] matrix = {{'0', '1'}, {'1', '0'}};

        System.out.println(maximalRectangle(matrix));
    }

    public static int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        int maxArea = Integer.MIN_VALUE;
        int[][] temp = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == '1') {
                    temp[i][j] = 1;
                } else {
                    temp[i][j] = 0;
                }

                if (i > 0 && matrix[i][j] == '1') {
                    temp[i][j] += temp[i - 1][j];
                }
            }

            maxArea = Math.max(maxArea, maxHistArea(temp[i]));
        }

        return maxArea;
    }

    private static int maxHistArea(int[] H) {
        if (H == null || H.length == 0) {
            return 0;
        }

        int maxArea = 0;
        int maxAreaWithTop = 0;
        int i = 0;
        Stack<Integer> stack = new Stack<>();
        while (i < H.length) {
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
