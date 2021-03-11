package com.java.practice.basic;

public class SortingCheck {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(new SortingCheck().isSorted(A, A.length));
    }

    private boolean isSorted(int[] A, int N) {
        if (N == 1) {
            return true;
        }
        return A[N - 1] < A[N - 2] ? false : isSorted(A, N - 1);
    }
}