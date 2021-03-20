package com.java.practice.pattern;


import java.util.Stack;

public class StringOccurance {
    public static void main(String[] args) {
        System.out.println(countOccurence("aBBccccaaAAAddeeEE"));
    }

    private static String countOccurence(String target) {
        if (target == null) {
            return null;
        }

        Stack<Character> stack = new Stack();
        StringBuilder sb = new StringBuilder();
        for (Character ch : target.toCharArray()) {
            if (stack.isEmpty() || stack.peek() == ch) {
                stack.push(ch);
            }

            if (!stack.isEmpty() && stack.peek() != ch) {
                int count = 0;
                char top = stack.peek();
                while (!stack.isEmpty()) {
                    stack.pop();
                    count++;
                }
                sb.append(top).append(count);
                stack.push(ch);
            }
        }

        return sb.toString();
    }
}
