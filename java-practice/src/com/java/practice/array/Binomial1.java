package com.java.practice.array;

/**
 * A binomial coefficient C(n, k) can be defined as the coefficient of X^k in the expansion of (1 + X)^n.
 * A binomial coefficient C(n, k) also gives the number of ways, disregarding order,
 * that k objects can be chosen from among n objects; more formally, the number of k-element subsets
 * (or k-combinations) of an n-element set.
 * Given two numbers n and r, find value of nCr
 * <p>
 * Examples :
 * <p>
 * Input :  n = 5, r = 2
 * Output : 10
 * The value of 5C2 is 10
 * <p>
 * Input : n = 3, r = 1
 * Output : 3
 */
public class Binomial1 {
    public static void main(String[] args) {
            long n = 9999999;
        long r = 33;
        long start = System.currentTimeMillis();
       // System.out.println(nCr(n, r));
        System.out.println("time using recursion :" + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        System.out.println(nCrEfficient(n, r));
        System.out.println("time using efficient approach :" + (System.currentTimeMillis() - start));
    }

    private static long nCr(long n, long r) {
        //return factorialRecursion(n) / (factorialRecursion(r) * factorialRecursion(n - r));
        return factorialIteration(n) / (factorialIteration(r) * factorialIteration(n - r));
    }

    private static long factorialRecursion(long n) {
        if (n == 0) {
            return 1;
        }

        return n * factorialRecursion(n - 1);
    }

    private static long factorialIteration(long n) {
        if (n == 0) {
            return 1;
        }
        long fact = 1;
        for (int i = 2; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    private static long nCrEfficient(long n, long k) {
        if (k > n - k) {
            k = n - k;
        }
        long res = 1;
        for (int i = 0; i < k; i++) {
            res *= (n - i);
            res /= (i + 1);
        }
        return res;
    }
}