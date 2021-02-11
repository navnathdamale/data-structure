package com.java.practice.array;

public class SlidingWindowMax {

	public static void main(String[] args) {

		/*
		 * Scanner scn = new Scanner(System.in); int[] arr = new int[scn.nextInt()];
		 * 
		 * for (int i = 0; i < arr.length; i++) { arr[i] = scn.nextInt(); }
		 * 
		 * int windowSize = scn.nextInt();
		 */

		int[] testArr = { 2, 6, -1, 2, 4, 1, -6, 5 };
		int k = 3;

		solve(testArr, k);

		// solve(arr, windowSize);
	}

	public static void solve(int[] arr, int k) {
		for (int i = k; i <= arr.length; i++) {
			int max = Integer.MIN_VALUE;
			for (int j = i - k; j < i; j++) {
				if (max < arr[j]) {
					max = arr[j];
				}
			}
			System.out.print(max + " ");
		}
	}
}
