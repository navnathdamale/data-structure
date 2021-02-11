package com.java.practice.array;

public class Ladder {

	public static void main(String[] args) {
		// int[] A = { 2, 3, 1, 1, 4 };
		int[] A = { 2, 0, 0, 1, 4 };
		//int[] A = { 1, 4, 3, 7, 1, 2, 6, 7, 6, 10 };
		int noOfJump = jump(A);
		System.out.println((noOfJump > 0 ? noOfJump : "Not Possible"));
	}

	public static int jump(int[] A) {

		if (A.length <= 1) {
			return 0;
		}

		int ladder = A[0]; // consider largest ladder
		int stair = A[0]; // consider largest ladder stairs
		int jump = 1; // consider initial 1 jump required
		for (int level = 1; level < A.length; level++) {
			// condition-1: if all level consumed
			if (level == A.length - 1) {
				return jump;
			}
			// condition-2 : if found largest ladder on level, then keep it for future
			if (ladder < level + A[level]) {
				ladder = level + A[level];
			}
			// exhaust the stair by each level
			stair--;

			// condition-3 : if all stair are exhausted then assign remaining stair from
			// ladder
			if (stair == 0) {
				jump++;
				stair = ladder - level;

				// condition-4 : special case if ladder stair are also exhausted before reaching
				// to the end
				if (stair == 0) {
					return 0;
				}
			}
		}
		return jump;
	}
}
