package com.java.practice.array;

public class Anagram {

    public static void main(String[] args) {

        System.out.println(isAnagram1("aa", "aa"));
    }

    private static boolean isAnagram(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return false;
        }
        if (str1.length() == str2.length()) {

            char[] arr1 = str1.toLowerCase().toCharArray();
            char[] arr2 = str2.toLowerCase().toCharArray();
            int xor = 0;

            for (int i = 0; i < arr1.length; i++) {
                xor ^= arr1[i] ^ arr2[i];
            }

            return xor == 0 ? true : false;

        }

        return false;
    }

    private static boolean isAnagram1(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return false;
        }
        if (str1.length() == str2.length()) {

            char[] arr1 = str1.toLowerCase().toCharArray();
            char[] arr2 = str2.toLowerCase().toCharArray();
            int[] value = new int[26];
            for (int i = 0; i < arr1.length; i++) {
                value[arr1[i] - 97]++;
                value[arr2[i] - 97]--;
            }
            for (int i = 0; i < 26; i++)
                if (value[i] != 0)
                    return false;
            return true;

        }

        return false;
    }

}
