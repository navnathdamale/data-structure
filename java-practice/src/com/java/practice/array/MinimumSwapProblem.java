package com.java.practice.array;

public class MinimumSwapProblem {
	public static void main(String[] args) {
		int[] A = { 9, 7, 5, 4, 11, 12, 13, 3, 1, 2, 6, 8, 10 };
		int cnt = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] != i + 1) {
				// place the element at their respective positions.
				int t = A[i];
				A[i] = A[t - 1];
				A[t - 1] = t;
				cnt++;

			}
		}
		
		System.out.print("Minimum swap :{" + cnt + "} needed for array : [ ");
		for (int i : A) {
			System.out.print(i + " ");
		}
		System.out.print("]");
	}

}
