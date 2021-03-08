package com.java.practice.array;

import java.util.Scanner;

public class NumberOfIslands2 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        String[] rowCol = scan.nextLine().split(" ");

        int row = Integer.parseInt(rowCol[0]);
        int col = Integer.parseInt(rowCol[1]);

        int islands = 0;
        int arr[][] = new int[row][col];
        for (int i = 0; i < arr.length; i++) {
            String[] containerRowItems = scan.nextLine().split(" ");
            for (int j = 0; j < arr[i].length; j++) {
                int containerItem = Integer.parseInt(containerRowItems[j]);
                arr[i][j] = containerItem;
            }
        }


        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 1) {
                    islands += dfs(arr, i, j);
                }
            }
        }

        System.out.print(islands);
        scan.close();
    }

    public static int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
        return 1;
    }
}
