package com.java.practice.google;

import java.util.*;

public class HashMapNetflix {
    public static void main(String[] args) {
        // Driver code
        String titles[] = {"duel", "dule", "speed", "spede", "deul", "cars"};

        List<List<String>> gt = groupTitles(titles);
        String query = "dule";

        // Searching for all titles
        for (List<String> g : gt) {
            if (g.contains(query))
                System.out.println(g);
        }
    }

    public static List<List<String>> groupTitles(String[] strs) {
        // write your code here
        if (strs == null || strs.length == 0) {
            return new ArrayList<List<String>>();
        }

        int[] chars = new int[26];
        Map<String, List<String>> result = new HashMap<>();
        for (String s : strs) {
            Arrays.fill(chars, 0);

            for (char c : s.toCharArray()) {
                int index = c - 'a';
                chars[index]++;
            }

            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                sb.append("#");
                sb.append(chars[i]);
            }

            String key = sb.toString();
            if (!result.containsKey(key)) {
                result.put(key, new ArrayList<>());
            }

            result.get(key).add(s);

        }
        return new ArrayList<>(result.values());
    }
}
