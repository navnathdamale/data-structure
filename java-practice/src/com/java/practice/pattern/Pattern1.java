package com.java.practice.pattern;

/**
 * = = =  *
 * = =  * * *
 * =  * * * * *
 * = * * * * * * *
 */

public class Pattern1 {
    public static void main(String[] args) {
        int n = 4;
        int factor = 1;
        for (int i = 0; i < n; i++) {
            for (int j = n - i - 1; j > 0; j--) {
                System.out.print("   ");
            }

            for (int j = factor; j > 0; j--) {
                System.out.print(" * ");
            }
            factor += 2;
            System.out.println();
        }
    }
}