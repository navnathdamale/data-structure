package com.java.practice.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JSListToMap {
    public static void main(String[] args) {
        List<Person> persons = Arrays.asList(
                new Person(1, "Ram", 22),
                new Person(2, "Steve", 23),
                new Person(3, "Balu", 29));

        Map<String, Integer> personMap = persons.stream().filter(p -> p.getAge() > 21)
                .collect(Collectors.toMap(Person::getName, Person::getAge));
        System.out.println(personMap);
    }
}
