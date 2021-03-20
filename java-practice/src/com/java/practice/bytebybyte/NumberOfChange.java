package com.java.practice.bytebybyte;

public class NumberOfChange {

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int x = 7;

        System.out.println(changeCoins(coins, x));
    }

    private static int changeCoins(int[] coins, int x) {
        int[] dp = new int[x + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int i = coin; i <= x; i++) {
                dp[i] = dp[i] + dp[i - coin];
            }
        }

        return dp[x];
    }
}
