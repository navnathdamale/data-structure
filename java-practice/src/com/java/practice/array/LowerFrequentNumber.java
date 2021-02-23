package com.java.practice.array;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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
        System.out.println(migratoryBirds(arr));
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
}
