package com.java.practice.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JSTerminal {

    public static void main(String[] args) {
        List<Person> persons = Arrays.asList(
                new Person(1, "Ram", 22),
                new Person(2, "Steve", 23),
                new Person(3, "Balu", 29),
                new Person(4, "Ram", 18),
                new Person(5, "Steve", 25),
                new Person(6, "Balu", 20)
        );

        persons.stream()
                .filter(p -> p.getAge() > 15)
                .map(Person::getName).sorted().forEach(System.out::println);
    }
}
