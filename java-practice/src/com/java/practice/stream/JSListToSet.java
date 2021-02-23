package com.java.practice.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class JSListToSet {
    public static void main(String[] args) {
        List<Person> persons = Arrays.asList(
                new Person(1, "Ram", 22),
                new Person(2, "Steve", 23),
                new Person(3, "Balu", 29),
                new Person(4, "Ram", 18),
                new Person(5, "Steve", 25),
                new Person(6, "Balu", 20)
        );

        Set<Integer> personSet = persons.stream().filter(p -> p.getAge() > 21).map(Person::getAge).collect(Collectors.toSet());
        System.out.println(personSet);

        //Get unnique name in upper case of the first two person older than 20
        List<String> names = persons.stream()
                .filter(p -> p.getAge() >= 20)
                .map(Person::getName)
                .map(String::toUpperCase)
                .distinct()
                .limit(3)
                .collect(Collectors.toList());
        System.out.println(names);
    }
}
