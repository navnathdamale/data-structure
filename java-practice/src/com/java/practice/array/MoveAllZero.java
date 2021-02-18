package com.java.practice.array;

/**
 * Given an array nums, write a function to move
 * all 0's to the end of it while maintaining
 * the relative order of the non-zero elements.
 * <p>
 * Example:
 * <p>
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 */
public class MoveAllZero {
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12};
        int pos = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[pos++] = arr[i];
            }
        }
        for (int i = pos; i < arr.length; i++) {
            arr[i] = 0;
        }
    }
}
