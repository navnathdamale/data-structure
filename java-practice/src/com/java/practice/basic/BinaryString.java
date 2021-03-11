package com.java.practice.basic;

import java.util.Arrays;

public class BinaryString {
    private static int[] A = new int[2];

    public static void main(String[] args) {
        //new BinaryString().binary(A.length);

        //new BinaryString().generateStrings(A.length, 2);
        int[] A = {1, 2, 3, 4};
        new BinaryString().printSubArray(A, 0);
    }

    /**
     * n = 3
     * Output:
     * [0, 0, 0]    [1, 0, 0]    [0, 1, 0]    [1, 1, 0]
     * <p>
     * [0, 0, 1]     [1, 0, 1]     [0, 1, 1]    [1, 1, 1]
     *
     * @param N
     */
    private void binary(int N) {
        if (N < 1) {
            System.out.println(Arrays.toString(A));
            return;
        } else {
            A[N - 1] = 0;
            binary(N - 1);
            A[N - 1] = 1;
            binary(N - 1);
        }
    }

    /**
     * k = 2, n = 2
     * Output:  0 0      0 1         1 0         1 1
     * <p>
     * k = 3, n = 2
     * Output:
     * 0 0          1 0        2 0        0 1         1 1         2 1
     * 0 2          1 2        2 2
     *
     * @param N
     * @param K
     */
    private void generateStrings(int N, int K) {
        if (N < 1) {
            System.out.println(Arrays.toString(A));
            return;
        }
        //now generate all other strings
        for (int i = 0; i < K; i++) {
            A[N - 1] = i;
            generateStrings(N - 1, K);
        }
    }

    /**
     * Input [] = {1, 2, 3, 4}
     * Output: [ 1 ] [ 1 2 ] [ 1 2 3 ] [ 1 2 3 4 ] [ 2 ] [ 2 3 ] [ 2 3 4 ] [ 3 ] [ 3 4 ] [ 4 ]
     * <p>
     * Input [] = {4, 6, 8}
     * Output: [ 4 ] [ 4 6 ] [ 4 6 8 ] [ 6 ] [ 6 8 ] [ 8 ]
     */
    private void printSubArray(int[] A, int index) {
        if (A.length == index) {
            return;
        }
        String result = "";
        for (int i = index; i < A.length; i++) {
            result += " " + A[i] + " ";

            System.out.print("[" + result + "]");
        }


        printSubArray(A, index + 1);
    }
}