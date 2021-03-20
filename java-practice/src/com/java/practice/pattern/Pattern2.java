package com.java.practice.pattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pattern2 {

    public static void main(String[] args) {
        int n = 8;

        int factor = 1;
        int blank = 0;
        int outer = 0;
        for (int i = 0; i < n + outer; i++) {
            for (int j = n - 1 - blank; j > 0; j--) {
                System.out.print("   ");
            }

            for (int j = 0; j < factor; j++) {
                System.out.print(" * ");
            }


            if (i >= n - 1) {
                outer++;
                factor -= 2;
                blank--;
            } else {
                factor += 2;
                blank++;
            }

            if (outer == n * 2 - 1) break;

            System.out.println();

        }

        FindIntersection(new String[]{"1, 3, 4, 7, 13", "1, 2, 4, 13, 15"});
    }


    public static String FindIntersection(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return null;
        }

        if (strArr[0].length() == 0) {
            return strArr[1].replace(" ", "");
        }

        if (strArr[1].length() == 0) {
            return strArr[0].replace(" ", "");
        }

        int[] arr1 = Arrays.stream(strArr[0].replace(" ", "").split(",")).mapToInt(Integer::parseInt).toArray();
        int[] arr2 = Arrays.stream(strArr[1].replace(" ", "").split(",")).mapToInt(Integer::parseInt).toArray();
        int i = 0, j = 0;

        List<String> list = new ArrayList<>();
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                i++;
            } else if (arr1[i] > arr2[j]) {
                j++;
            } else {
                list.add(String.valueOf(arr1[i]));
                i++;
                j++;
            }
        }
        System.out.println(list);

        return (list.isEmpty() ? "false" : String.join(",", list));
    }
}
