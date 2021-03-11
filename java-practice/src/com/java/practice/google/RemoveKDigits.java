package com.java.practice.google;

import java.util.Stack;

/**
 * Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.
 * <p>
 * Note:
 * The length of num is less than 10002 and will be ≥ k.
 * The given num does not contain any leading zero.
 * Example 1:
 * <p>
 * Input: num = "1432219", k = 3
 * Output: "1219"
 * Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
 * Example 2:
 * <p>
 * Input: num = "10200", k = 1
 * Output: "200"
 * Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
 * Example 3:
 * <p>
 * Input: num = "10", k = 2
 * Output: "0"
 * Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 * <p>
 * https://leetcode.com/problems/remove-k-digits/
 */
public class RemoveKDigits {
    public static void main(String[] args) {
        String num = "1432219";
        int k = 3;
        System.out.println(removeKdigits(num, k));

    }

    public static String removeKdigits(String num, int k) {
        if (num.length() <= k) {
            return "0";
        }

        Stack<Character> stack = new Stack<>();
        for (char c : num.toCharArray()) {
            while (!stack.isEmpty() && stack.peek() > c && k > 0) {
                stack.pop();
                k--;
            }

            if (!stack.isEmpty() || c != '0') {
                stack.push(c);
            }
        }

        while (!stack.isEmpty() && k-- > 0) {
            stack.pop();
        }

        if (stack.isEmpty()) return "0";

        int stackSize = stack.size();
        char[] ch = new char[stackSize];
        while (!stack.isEmpty()) {
            ch[--stackSize] = stack.peek();
            stack.pop();
        }

        return String.valueOf(ch);
    }
}
