package com.java.practice.google;

/**
 * https://leetcode.com/problems/maximal-square/
 */
public class MaximalSquare {
    public static void main(String[] args) {

        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        //char[][] matrix = {{'0', '1'}, {'1', '0'}};
        //char[][] matrix = {{'0'}};
        System.out.println(maximalSquare(matrix));

    }

    public static int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }


        int maxSquare = 0;
        int[][] temp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 0) {
                    if (matrix[i][j] == '1') {
                        maxSquare = 1;
                    }
                    temp[i][j] = Integer.parseInt(String.valueOf(matrix[i][j]));
                } else if (i > 0 && j == 0) {
                    temp[i][j] = Integer.parseInt(String.valueOf(matrix[i][j]));
                } else if (matrix[i][j] == '0') {
                    temp[i][j] = 0;
                } else if (matrix[i][j] == '1') {
                    temp[i][j] = Math.min(temp[i - 1][j - 1], Math.min(temp[i - 1][j], temp[i][j - 1])) + 1;
                }

                maxSquare = Math.max(maxSquare, temp[i][j]);
            }
        }

        return maxSquare * maxSquare;
    }
}
