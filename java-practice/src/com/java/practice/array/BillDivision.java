package com.java.practice.array;

import java.util.Arrays;
import java.util.List;

/**
 * https://www.hackerrank.com/challenges/bon-appetit/problem
 */
public class BillDivision {

    public static void main(String[] args) {
        List<Integer> bill = Arrays.asList(3, 10, 2, 9);
        bonAppetit(bill, 1, 12);
    }

    public static void bonAppetit(List<Integer> bill, int k, int b) {
        int bActual = ((int) bill.stream().reduce(0, Integer::sum) - bill.get(k)) / 2;
        System.out.println(b - bActual == 0 ? "Bon Appetit" : (b - bActual));
    }
}
