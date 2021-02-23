package com.java.practice.stream;

import java.util.Arrays;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.stream.Collectors;

public class JSMapMethod {
    public static void main(String[] args) {
        List<Person> persons = Arrays.asList(
                new Person(1, "Ram", 22),
                new Person(2, "Steve", 23),
                new Person(3, "Balu", 29));

        List<String> names = persons.stream().filter(p -> p.getAge() < 30)
                .map(p -> p.getName())
                .collect(Collectors.toList());
        names.forEach(System.out::println);

        System.out.println(persons.stream().count());

        System.out.println(persons.stream().map(Person::getAge).reduce(0, (sum, age) -> sum + age));

        LongSummaryStatistics longSummaryStatistics = persons.stream().collect(Collectors.summarizingLong(Person::getAge));

        System.out.println(longSummaryStatistics.getMax());
        System.out.println(longSummaryStatistics.getAverage());
        System.out.println(longSummaryStatistics.getCount());
        System.out.println(longSummaryStatistics.getSum());
        System.out.println(longSummaryStatistics.getMin());

        System.out.println(persons.stream().min((p1, p2) -> p1.getAge() > p2.getAge() ? 1 : -1).get());
    }
}