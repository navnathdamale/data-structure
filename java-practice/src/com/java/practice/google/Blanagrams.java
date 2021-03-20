package com.java.practice.google;

import java.util.HashMap;
import java.util.Map;

public class Blanagrams {

    //// # YES: quax, xuza

    // # YES: paka, maka = p -> m
// # NO: foo, bar
// # NO: hello, hello
    public static void main(String[] args) {
        System.out.println(checkBlanagrams("quax", "quua"));
        System.out.println(checkBlanagrams("quua", "quax"));
        //f-1 0-2  // b-1 a 1 r 1
        //

        // x-1 u 2  a 1  // q-1 u-1 a 1 x 1
        //count 2
    }

    private static boolean checkBlanagrams(String s1, String s2) {

        if (s1.length() != s2.length()) {
            return false;
        }
        Map<Character, Integer> mapCount1 = new HashMap<>();
        for (Character ch1 : s1.toCharArray()) {
            mapCount1.put(ch1, mapCount1.getOrDefault(ch1, 0) + 1);
        }

        Map<Character, Integer> mapCount2 = new HashMap<>();
        for (Character ch2 : s2.toCharArray()) {
            mapCount2.put(ch2, mapCount1.getOrDefault(ch2, 0) + 1);
        }


        //Set<Character> allKey = new HashSet<>(mapCount1.keySet());
        //allKey.addAll(mapCount2.keySet());
        int count = 0;
        for (Character key :
                mapCount1.keySet()) {
            Integer countMap1 = mapCount1.getOrDefault(key, 0);
            Integer countMap2 = mapCount2.getOrDefault(key, 0);
            Integer diff = countMap1 - countMap2;
            if (countMap1 != countMap2 && (diff > 1 || diff < -1)) {
                return false;
            }
        }

        return count == 1 ? true : false;
    }


}
