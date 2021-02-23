package com.java.practice.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class JSFilter {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Peter", "Sam", "Ryan");
        List<String> lis1 = names.stream().filter(name -> "Sam".equals(name)).collect(Collectors.toList());
        lis1.forEach(System.out::println);
    }

}