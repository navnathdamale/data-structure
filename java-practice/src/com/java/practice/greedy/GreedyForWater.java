package com.java.practice.greedy;

import java.util.Scanner;

/**
 * You are given container full of water. Container can have limited amount of water.
 * You also have N bottles to fill. You need to find the maximum numbers of bottles you can fill.
 * <p>
 * Input:
 * First line contains one integer, T, number of test cases.
 * First line of each test case contains two integer, N and X, number of bottles and capacity of the container.
 * Second line of each test case contains N space separated integers, capacities of bottles.
 * <p>
 * Output:
 * For each test case print the maximum number of bottles you can fill.
 */
public class GreedyForWater {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for (int i = 0; i < T; i++) {
            int N = s.nextInt();
            int X = s.nextInt();
            int[] bottles = new int[N];

            for (int j = 0; j < N; j++) {
                bottles[j] = s.nextInt();
            }

            System.out.println(maxBottles(bottles, N, X));
        }
    }

    private static int maxBottles(int[] bottles, int N, int X) {
        int maxBottle = 0;
        for (int i = 0; i < N; i++) {
            int tempMax = 1;
            int tempSum = bottles[i];
            for (int j = 0; j < N; j++) {
                if (i == j) continue;
                tempSum += bottles[j];
                if (tempSum > X) {
                    tempSum -= bottles[j];
                    tempMax--;
                }
                tempMax++;
                if (tempSum == X) {
                    if (maxBottle < tempMax) {
                        maxBottle = tempMax;
                    }
                }
            }
        }
        return maxBottle;
    }
}