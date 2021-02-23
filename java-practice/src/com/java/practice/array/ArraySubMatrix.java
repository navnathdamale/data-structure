package com.java.practice.array;

import java.util.Stack;

/**
 * Given a rows * columns matrix mat of ones and zeros, return how many submatrices have all ones.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: mat = [[1,0,1],
 * [1,1,0],
 * [1,1,0]]
 * Output: 13
 * Explanation:
 * There are 6 rectangles of side 1x1.
 * There are 2 rectangles of side 1x2.
 * There are 3 rectangles of side 2x1.
 * There is 1 rectangle of side 2x2.
 * There is 1 rectangle of side 3x1.
 * Total number of rectangles = 6 + 2 + 3 + 1 + 1 = 13.
 * Example 2:
 * <p>
 * Input: mat = [[0,1,1,0],
 * [0,1,1,1],
 * [1,1,1,0]]
 * Output: 24
 * Explanation:
 * There are 8 rectangles of side 1x1.
 * There are 5 rectangles of side 1x2.
 * There are 2 rectangles of side 1x3.
 * There are 4 rectangles of side 2x1.
 * There are 2 rectangles of side 2x2.
 * There are 2 rectangles of side 3x1.
 * There is 1 rectangle of side 3x2.
 * Total number of rectangles = 8 + 5 + 2 + 4 + 2 + 2 + 1 = 24.
 * Example 3:
 * <p>
 * Input: mat = [[1,1,1,1,1,1]]
 * Output: 21
 * Example 4:
 * <p>
 * Input: mat = [[1,0,1],[0,1,0],[1,0,1]]
 * Output: 5
 */
public class ArraySubMatrix {

    public static void main(String[] args) {
        int[][] mat = {
                {1, 0, 1},
                {1, 1, 0},
                {1, 1, 0}
        };
    }

    public int numSubmat(int[][] mat) {
        int m = mat.length, n = mat[0].length, height[] = new int[n], res = 0;
        for (int i = 0; i < m; i++) {
            Stack<int[]> st = new Stack<>();
            for (int j = 0; j < n; j++) {
                height[j] = mat[i][j] == 0 ? 0 : (height[j] + 1);   //  height of histogram;
                int sum = 0;
                while (!st.isEmpty() && height[st.peek()[0]] >= height[j]) st.pop();
                if (!st.isEmpty()) sum += height[j] * (j - st.peek()[0]) + st.peek()[1];
                else sum += height[j] * (j + 1);
                st.push(new int[]{j, sum});
                res += sum;
            }
        }
        return res;
    }
}
