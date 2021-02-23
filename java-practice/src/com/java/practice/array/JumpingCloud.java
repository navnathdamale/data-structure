package com.java.practice.array;

/**
 * https://www.hackerrank.com/challenges/jumping-on-the-clouds-revisited/problem
 */
public class JumpingCloud {
    public static void main(String[] args) {

        int[] clouds = {0, 0, 1, 0, 0, 1, 1, 0};
        int k = 2;
        System.out.println(jumpingOnClouds(clouds, k));
    }

    public static int jumpingOnClouds(int[] c, int k) {
        int enrg = 100; // initial energy
        int clouds = c.length;  // number of clouds
        int index = k % clouds;  // check if we are on original position
        enrg -= (c[index] * 2 + 1);
        while (index != 0) {
            index = (index + k) % clouds;
            enrg -= (c[index] * 2 + 1);
        }
        return enrg;
    }
}
