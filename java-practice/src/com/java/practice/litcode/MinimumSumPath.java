package com.java.practice.litcode;

import java.util.ArrayList;
import java.util.List;

public class MinimumSumPath {

    public static void main(String[] args) {
        int[][] grid = {
                {6, 4, 63},
                {14, 95, 20},
                {31, 85, 6}
        };

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        list.add(0, new ArrayList());
        list.get(0).add(6);
        list.get(0).add(4);
        list.get(0).add(63);

        list.add(1, new ArrayList());
        list.get(1).add(14);
        list.get(1).add(95);
        list.get(1).add(20);

        list.add(2, new ArrayList());
        list.get(2).add(31);
        list.get(2).add(85);
        list.get(2).add(6);


        //System.out.println(minPathSum(grid));
        System.out.println(minPathSum(list));
    }

    public static int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int[][] table = new int[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                table[i][j] += grid[i][j];
                if (i > 0 && j > 0) {
                    table[i][j] += Math.min(table[i - 1][j], table[i][j - 1]);
                } else if (i > 0) {
                    table[i][j] += table[i - 1][j];
                } else if (j > 0) {
                    table[i][j] += table[i][j - 1];
                }
            }
        }

        return table[grid.length - 1][grid[0].length - 1];
    }

    public static int minPathSum(ArrayList<ArrayList<Integer>> A) {
        if (A == null || A.size() == 0) {
            return 0;
        }

        List<List<Integer>> DP = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            DP.add(i, new ArrayList(A.get(i).size()));
            for (int j = 0; j < A.get(i).size(); j++) {
                if (DP.get(i).size() == 0) {
                    DP.get(i).add(j, A.get(i).get(j));
                }
                DP.get(i).add(j, DP.get(i).get(j) + A.get(i).get(j));
                DP.remove(j);

                if (i > 0 && j > 0) {
                    int min = Math.min(DP.get(i - 1).get(j), DP.get(i).get(j - 1));
                    DP.get(i).add(min + DP.get(i).get(j));
                } else if (i > 0) {
                    DP.get(i).add(DP.get(i - 1).get(j) + DP.get(i).get(j));
                } else if (j > 0) {
                    DP.get(i).add(DP.get(i).get(j - 1) + DP.get(i).get(j));
                }
            }
        }


        return DP.get(A.size() - 1).get(A.get(0).size() - 1);
    }
}
