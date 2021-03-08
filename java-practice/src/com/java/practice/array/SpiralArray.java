package com.java.practice.array;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/spiral-matrix/
 */
public class SpiralArray {
    public static void main(String[] args) {
        int[][] spiral1 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        int[][] spiral2 = {
                {3}, {2}
        };

        int[][] spiral = {
                {1, 2, 3}
        };

        spiralOrder(spiral).stream().forEach(x -> System.out.print(x + " "));
    }

    public static List<Integer> spiralOrder(int[][] spiral) {

        List<Integer> list = new ArrayList<>();
        if (spiral == null || spiral.length == 0) {
            return list;
        }

        int rotation = spiral[0].length + spiral.length;
        int ctr = spiral[0].length * spiral.length;
        int left = 0;
        int right = spiral[0].length - 1;
        int top = 0;
        int bottom = spiral.length - 1;

        for (int i = 0; i < rotation; i++) {
            //print left to right
            for (int j = left; j <= right && ctr > 0; j++) {
                list.add(spiral[left][j]);
                ctr--;
            }

            //print top to bottom
            for (int k = top + 1; k <= bottom && ctr > 0; k++) {
                list.add(spiral[k][right]);
                ctr--;
            }

            //print right to left
            for (int l = right - 1; l >= left + 1 && ctr > 0; l--) {
                list.add(spiral[bottom][l]);
                ctr--;
            }

            //print bottom to top
            for (int m = bottom; m >= top + 1 && ctr > 0; m--) {
                list.add(spiral[m][top]);
                ctr--;
            }

            if (ctr <= 0) break;

            top++;
            left++;
            right--;
            bottom--;

        }
        return list;
    }
}
