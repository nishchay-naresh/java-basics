package com.nishchay.java8.streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
* Find duplicate from a stream
* */
public class FindDuplicate {

    public static void main(String[] args) {


//        removeDupFromStream();
        findDuplicateFromStream();
//        findDuplicateFromCollection();
//        findDuplicateBySotringBoth();

    }

    private static void removeDupFromStream() {

        List<Integer> numbers = Arrays.asList(7, 1, 4, 3, 4, 3, 2, 1, 7, 2, 1, 3);
        // Printing only distinct numbers from list of number
        numbers.stream()
                .distinct()
                .forEach(System.out::println);

    }

    // Using hash map and with count
    private static void findDuplicateFromStream() {

        List<Integer> numbers = Arrays.asList(5, 3, 4, 1, 3, 7, 2, 9, 9, 4);;
        List duplicates =
                numbers.stream().collect(Collectors.groupingBy(Function.identity()))
                        .entrySet()
                        .stream()
                        .filter(e -> e.getValue().size() > 1)
                        .map(Map.Entry::getKey)
                        .collect(Collectors.toList());

        System.out.println("duplicates = " + duplicates);  // 3, 4, 9
    }

    // data collection is available here
    private static void findDuplicateFromCollection() {

        List<Integer> numbers = Arrays.asList(1, 2, 8, 1, 3, 4, 7, 4);
        System.out.println("numbers -" + numbers);

        numbers.stream().filter(i -> Collections.frequency(numbers, i) > 1)
                .collect(Collectors.toSet()).forEach(System.out::println);

    }

    // here soring both uniques & duplicates
    private static void findDuplicateBySotringBoth() {

        // 3, 4, 9
        List<Integer> numbers = Arrays.asList(5, 3, 4, 1, 3, 7, 2, 9, 9, 4);

        Set<Integer> uniques = new HashSet<>();
        Set<Integer> duplicates = numbers.stream()
                .filter(n -> !uniques.add(n)) // Set.add() returns false if the element was already in the set.
                .collect(Collectors.toSet());

        System.out.println("uniques = " + uniques);
        System.out.println("duplicates = " + duplicates);
    }


}
