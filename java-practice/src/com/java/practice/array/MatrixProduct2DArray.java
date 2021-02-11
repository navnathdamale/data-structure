package com.java.practice.array;

public class MatrixProduct2DArray {

	public static void main(String[] args) {
		int[][] A = { { -1, 2, 3 }, { 4, 5, -6 }, { 7, -8, 9 } };
		int[][] minCache = new int[A.length][A[0].length];
		int[][] maxCache = new int[A.length][A[0].length];
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[0].length; j++) {
				if (i == 0 && j == 0) {
					minCache[i][j] = A[i][j];
					maxCache[i][j] = A[i][j];
					continue;
				}
				int maxVal = Integer.MIN_VALUE;
				int minVal = Integer.MAX_VALUE;
				if (i > 0) {
					int tempMax = Math.max(A[i][j] * maxCache[i - 1][j], A[i][j] * minCache[i - 1][j]);
					maxVal = Math.max(maxVal, tempMax);

					int tempMin = Math.min(A[i][j] * maxCache[i - 1][j], A[i][j] * minCache[i - 1][j]);
					minVal = Math.min(minVal, tempMin);
				}

				if (j > 0) {
					int tempMax = Math.max(A[i][j] * maxCache[i][j - 1], A[i][j] * minCache[i][j - 1]);
					maxVal = Math.max(maxVal, tempMax);

					int tempMin = Math.min(A[i][j] * maxCache[i][j - 1], A[i][j] * minCache[i][j - 1]);
					minVal = Math.min(minVal, tempMin);
				}
				maxCache[i][j] = maxVal;
				minCache[i][j] = minVal;
				System.out.println();
				System.out.print("min: " + minVal + " max: " + maxVal + " [" + i + "] [" + j + "] :" + A[i][j]);
			}
		}
		System.out.println(" MAX VALUE : " + maxCache[A.length - 1][A[0].length - 1]);
	}
}
