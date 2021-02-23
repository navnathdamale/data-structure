package com.java.practice.array;

/**
 * Write a function that reverses a string. The input string is given as an array of characters char[].
 * <p>
 * Do not allocate extra space for another array, you must do this by
 * modifying the input array in-place with O(1) extra memory.
 * <p>
 * You may assume all the characters consist of printable ascii characters.
 * Example 1:
 * <p>
 * Input: ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 * Example 2:
 * <p>
 * Input: ["H","a","n","n","a","h"]
 * Output: ["h","a","n","n","a","H"]
 */
public class ReverseString1 {
    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        new ReverseString1().reverseString(s);
    }

    public void reverseString(char[] s) {
        int l = 0;
        int r = s.length - 1;
        while (l < r) {
            char temp = s[r];
            s[r] = s[l];
            s[l] = temp;

            l++;
            r--;
        }
    }
}
