package com.ds.intro;

public class BasicArraySearch {

	public static void main(String[] args) {
		int[] A = { 1, 2, 3, 5, 10 };
		int[] B = { 6, 7, 5, 9, 12 };

		System.out.println(new BasicArraySearch().isCommonElementExistsRecursion(A, B, 0, 0));

	}

	public boolean isCommonElementExistsRecursion(int[] A, int[] B, int indexA, int indexB) {
		if (A.length > indexA && B.length > indexB) {
			if (A[indexA] == B[indexB]) {
				return true;
			} else {
				return isCommonElementExistsRecursion(A, B, indexA + 1, indexB)
						|| isCommonElementExistsRecursion(A, B, indexA, indexB + 1);
			}
		} else {
			return false;
		}
	}
}
