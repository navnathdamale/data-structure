package com.java.practice.bytebybyte;

public class KnapSack {
    public static int count = 0;

    public static void main(String[] args) {
        int[] profit = {1,    2,  3,  4,  5,  6,  7,   8,   9};
        int[] weights = {40, 50, 60, 70, 80, 90, 100, 110, 120};
        int maxWeight = 75;

        System.out.println(knapSack(profit, weights, maxWeight, profit.length - 1, new int[profit.length][maxWeight]));

    }

    private static int knapSack(int[] profit, int[] weights, int maxWeight, int index, int[][] mem) {

        System.out.println("Call recursive " + count++);
        if (maxWeight == 0 || index == 0) {
            return 0;
        }


        if (mem[index - 1][maxWeight - 1] != 0) {
            return mem[index - 1][maxWeight - 1];
        }
        int result;

        if (weights[index] > maxWeight) {
            return knapSack(profit, weights, maxWeight, index - 1, mem);
        }

        result = Math.max(
                knapSack(profit, weights, maxWeight, index - 1, mem),
                profit[index] + knapSack(profit, weights, maxWeight - weights[index], index - 1, mem)
        );
        mem[index - 1][maxWeight - 1] = result;
        return result;
    }
}
