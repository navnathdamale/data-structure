package com.java.practice.bytebybyte;

import java.util.Arrays;

/**
 * Making change : Given an input x, write a function to
 * determine the minimum number of coins required to make that
 * exact amount of change
 * <p>
 * [1,5,10,25] - Coin system 1
 * [1,3,4] - Coin system 2
 */
public class SmallestChange {

    public static void main(String[] args) {
        int[] coins = {3, 5};  //

// x = 2   Min( rec(arr, i , (x-i)), rec(arr, i+1, x);

        //1 == 1
        //2- 1 ==> 1
        // 1- 1 ==> 0

        int x = 7;

        //System.out.println(coinChange(coins, x));
        System.out.println(change(x, coins));
    }

    public static int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        int min = amount;
        for (int i = coins.length - 1; i >= 0; i--) {
            if (amount - coins[i] >= 0) {
                min = Math.min(min, 1 + coinChange(coins, amount - coins[i]));
            }
        }

        return min;
    }

    private static int change(int x, int[] coins) {
        int[] cache = new int[x];
        Arrays.fill(cache, -1);
        return change(x, coins, cache);
    }

    private static int change(int x, int[] coins, int[] cache) {
        if (x == 0) return 0;
        int min = x;
        for (int coin : coins) {
            if (x - coin >= 0) {
                int c;
                if (cache[x - coin] >= 0) {
                    c = cache[x - coin];
                } else {
                    c = change(x - coin, coins, cache);
                    cache[x - coin] = c;
                }

                if (min > c + 1) min = c + 1;
            }
        }
        return min;
    }

    public int coinChange1(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (coins == null || coins.length == 0) {
            return -1;
        }

        int max = amount + 1;
        int[] dp = new int[max];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}