package com.java.practice.array;

/**
 * You are in charge of the cake for a child's birthday.
 * You have decided the cake will have one candle for each year of their total age.
 * They will only be able to blow out the tallest of the candles. Count how many candles are tallest.
 * <p>
 * Example
 * <p>
 * <p>
 * The maximum height candles are  units high. There are  of them, so return .
 */
public class TallestCandle {

    public static void main(String[] args) {
        int[] arr = {2, 2, 1, 1, 2, 4, 4, 4, 3};
        System.out.println(birthdayCakeCandles(arr));
    }

    public static int birthdayCakeCandles(int[] ar) {
        int tallest = ar[0];
        //assume atleast there is 1 tallest candle
        int cnt = 1;
        for (int i = 1; i < ar.length; i++) {

            //If encounter next tallest then reset counter
            if (tallest < ar[i]) {
                tallest = ar[i];
                cnt = 0;
            }

            //check if there is multiple tallest
            if (tallest == ar[i]) {
                cnt++;
            }
        }

        return cnt;
    }
}

