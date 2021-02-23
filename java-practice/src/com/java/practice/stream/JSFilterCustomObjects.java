package com.java.practice.stream;

import java.util.Arrays;
import java.util.List;

public class JSFilterCustomObjects {
    public static void main(String[] args) {
        List<Person> persons = Arrays.asList(new Person(1, "Ram", 25),
                new Person(1, "Steve", 25),
                new Person(1, "Balu", 25));

        Person person = persons.stream().filter(p -> "Ram".equals(p.getName()) && 32 > p.getAge())
                .findAny().orElse(null);

        System.out.println(person);
    }
}