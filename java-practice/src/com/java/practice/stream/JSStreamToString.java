package com.java.practice.stream;

import java.util.Arrays;
import java.util.List;

public class JSStreamToString {

    public static void main(String[] args) {
        List<Person> persons = Arrays.asList(new Person(1, "Ram", 25),
                new Person(1, "Steve", 25),
                new Person(1, "Balu", 25));

        String name = persons.stream()
                .filter(p -> "Ram".equals(p.getName()))
                .map(p -> p.getName()).findAny().orElse(null);

        System.out.println(name);


        String[] names = {"a", "b", "c", "d"};
        System.out.println(Arrays.stream(names).reduce("", String::concat));
    }
}
