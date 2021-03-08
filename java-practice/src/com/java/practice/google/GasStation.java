package com.java.practice.google;

/**
 * https://leetcode.com/problems/gas-station/
 */
public class GasStation {
    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};

        System.out.println(canCompleteCircuit(gas, cost));

    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas.length == 0 || cost.length == 0) {
            return -1;
        }

        int positiveIndex = 0;
        int positiveTotal = 0;
        int negativeTotal = 0;

        for (int i = 0; i < gas.length; i++) {
            positiveTotal += (gas[i] - cost[i]);
            if (positiveTotal < 0) {
                negativeTotal += positiveTotal;
                positiveTotal = 0;
                positiveIndex = i + 1;
            }
        }

        return (positiveTotal + negativeTotal) < 0 ? -1 : positiveIndex;

    }
}
