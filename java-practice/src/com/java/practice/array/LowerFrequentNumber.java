package com.java.practice.array;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Given an array of bird sightings where every element represents a bird type id,
 * determine the id of the most frequently sighted type. If more than 1 type has been spotted that maximum amount, return the smallest of their ids.
 * <p>
 * Example
 * <p>
 * There are two each of types  and , and one sighting of type . Pick the lower of the two types seen twice: type .
 * <p>
 * Function Description
 * <p>
 * Complete the migratoryBirds function in the editor below.
 * <p>
 * migratoryBirds has the following parameter(s):
 * <p>
 * int arr[n]: the types of birds sighted
 * Returns
 * <p>
 * int: the lowest type id of the most frequently sighted birds
 */
public class LowerFrequentNumber {
    public static void main(String[] args) {
        //List<Integer> arr = Arrays.asList(1, 2, 3, 4, 5, 4, 3, 2, 1, 3, 4);
        List<Integer> arr = Arrays.asList(1, 3, 2, 5, 6);
        //System.out.println(migratoryBirds(arr));

        int[] tt = {3, 0, 1, 0};
        // System.out.println(Arrays.toString(topKFrequent(tt, 1)));

        System.out.println(lessFrequent("AaCACacacc"));
    }

    public static int migratoryBirds(List<Integer> arr) {

        if (arr.size() == 0) {
            return 0;
        }

        int lowerMax = 0;
        int lowerFrequency = 0;
        Map<Integer, Integer> countMap = new TreeMap<>();
        for (int i = 0; i < arr.size(); i++) {
            countMap.put(arr.get(i), countMap.getOrDefault(arr.get(i), 0) + 1);
        }

        for (Integer j :
                countMap.keySet()) {
            if (lowerMax < countMap.get(j)) {
                lowerMax = countMap.get(j);
                lowerFrequency = j;
            }
        }


        return lowerFrequency;
    }

    public static Character lessFrequent(String target) {
        if (target == null || target == "") {
            return null;
        }

        Map<Character, Integer> countMap = new LinkedHashMap<>();
        for (Character ch : target.toCharArray()) {
            countMap.put(ch, countMap.getOrDefault(ch, 0) + 1);
        }

        return countMap.entrySet().stream().filter(e -> e.getValue() == 1).map(k -> k.getKey()).limit(1).collect(Collectors.toList()).get(0);
    }

    public static int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> countMap = new TreeMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            countMap.put(nums[i], countMap.getOrDefault(nums[i], 0) + 1);
        }

        List<Integer> keys = countMap.entrySet().stream().sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed()).map(x -> x.getKey()).limit(k).collect(Collectors.toList());

        return keys.stream().mapToInt(Integer::intValue).toArray();

    }
}
