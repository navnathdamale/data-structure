package com.java.practice.array;

/**
 * Given an array of n distinct elements, find the minimum number of swaps required to sort the array.
 * <p>
 * Examples:
 * <p>
 * Input : {4, 3, 2, 1}
 * Output : 2
 * Explanation : Swap index 0 with 3 and 1 with 2 to
 * form the sorted array {1, 2, 3, 4}.
 * <p>
 * Input : {1, 5, 4, 3, 2}
 * Output : 2
 */
public class MinimumSwapProblem {
    public static void main(String[] args) {
        int[] A = {4, 3, 2, 1};
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
