package com.java.practice.google;

/**
 * https://www.geeksforgeeks.org/find-length-largest-region-boolean-matrix/
 * <p>
 * Consider a matrix with rows and columns, where each cell contains either a ‘0’ or a ‘1’ and any cell containing a 1 is called a filled cell. Two cells are said to be connected if they are adjacent to each other horizontally, vertically, or diagonally. If one or more filled cells are also connected, they form a region. find the length of the largest region.
 * <p>
 * Examples:
 * <p>
 * Input : M[][5] = { 0 0 1 1 0
 * 1 0 1 1 0
 * 0 1 0 0 0
 * 0 0 0 0 1 }
 * Output : 6
 */
public class LargestConnectedRegion {

    private static int count = 0;

    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 0, 1, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0},
                {1, 1, 1, 1, 0, 0, 1},
                {0, 0, 0, 0, 1, 1, 0},
                {1, 1, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0}
        };

        int row = grid.length;
        int col = grid[0].length;

        int maxGrid = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    maxGrid = Math.max(maxGrid, dfs(grid, i, j));
                }
            }
        }

        System.out.println(maxGrid + " count:" + count);
    }

    private static int dfs(int[][] A, int i, int j) {
        if (i >= A.length || j >= A[0].length || i < 0 || j < 0 || A[i][j] == 0) {
            return 0;
        }
        count++;

        A[i][j] = 0;
        return 1 + dfs(A, i + 1, j) +  //below
                dfs(A, i - 1, j) + //above
                dfs(A, i, j - 1) +  // left
                dfs(A, i, j + 1) + //right
                dfs(A, i - 1, j - 1) + // left above corner
                dfs(A, i + 1, j - 1) +// right below corner
                dfs(A, i + 1, j + 1) +
                dfs(A, i - 1, j + 1);

    }
}
