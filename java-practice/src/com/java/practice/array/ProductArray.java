package com.java.practice.array;

public class ProductArray {
	public static void main(String[] args) {
		int[] A = { 1, 2, 3, 4 };
		product(A);
		int size = A.length;
		int start = 0;
		int end = 0;
		int[] product = new int[size];
		for (int i = 0; i < size; i++) {
			if (i == 0) {
				start = 1;
				end = size - 1;
			} else if (i == size - 1) {
				start = 0;
				end = size - 2;
			} else {
				start = i + 1;
				end = size - 1;
				int prod = product(A, start, end);

				start = 0;
				end = i - 1;
				product[i] = prod * product(A, start, end);
				continue;
			}

			product[i] = product(A, start, end);
		}

	}

	public static int product(int[] A, int start, int end) {
		int prod = 1;
		for (int j = start; j <= end; j++) {
			prod = prod * A[j];
		}
		return prod;
	}

	public static int[] product(int[] A) {
		int[] product = new int[A.length];
		product[0] = 1;
		int N = A.length;
		for (int i = 1; i < N; i++) {
			product[i] = product[i - 1] * A[i - 1];
		}

		int R = 1;
		for (int i = N - 1; i >= 0; i--) {
			product[i] = product[i] * R;
			R = R * A[i];
		}

		for (int prod : product) {
			System.out.print(prod + " ");
		}

		return product;
	}
}
