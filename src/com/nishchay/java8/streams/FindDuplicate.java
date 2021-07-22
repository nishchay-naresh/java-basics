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
        findDuplicateAndUnique();
        findDuplicateFromStream();
        findDuplicateBySortingBoth();

    }

    private static void removeDupFromStream() {

        List<Integer> numbers = Arrays.asList(7, 1, 4, 3, 4, 3, 2, 1, 7, 2, 1, 3);
        System.out.println("original list = " + numbers);
        // Printing only distinct numbers from list of number
        System.out.print("list without dups = ");
        numbers.stream()
                .distinct()
                .forEach(e -> System.out.print(e + ", "));

    }

    // Using no frequency to find the unique & duplicates in alist
    private static void findDuplicateAndUnique() {

        List<Integer> numbers = Arrays.asList(5, 3, 4, 1, 3, 7, 2, 9, 9, 4);
        System.out.println("original list = " + numbers);

        Map<Integer, Long> freqMap = numbers.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println("freqMap = " + freqMap);

        List<Integer> uniqueElementList = numbers.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() == 1)
                .map(e -> e.getKey())
                .collect(Collectors.toList());

        System.out.println("uniqueElementList = " + uniqueElementList); // 1, 2, 5, 7

        List<Integer> duplicates = numbers.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() > 1)
                .map(e -> e.getKey())
                .collect(Collectors.toList());

        System.out.println("duplicates = " + duplicates);  // 3, 4, 9

    }

    // data collection is available here
    private static void findDuplicateFromStream() {

        List<Integer> numbers = Arrays.asList(5, 3, 4, 1, 3, 7, 2, 9, 9, 4);
        System.out.println("original list = " + numbers);

        System.out.print("duplicates = ");
        numbers.stream().filter(i -> Collections.frequency(numbers, i) > 1)
                .collect(Collectors.toSet()).forEach(e -> System.out.print(e + ", "));

    }

    // here soring both uniques & duplicates
    private static void findDuplicateBySortingBoth() {

        // 3, 4, 9
        List<Integer> numbers = Arrays.asList(5, 3, 4, 1, 3, 7, 2, 9, 9, 4);

        Set<Integer> uniques = new HashSet<>();
        Set<Integer> duplicates = numbers.stream()
                .filter(n -> !uniques.add(n)) // Set.add() returns false if the element was already in the set.
                .collect(Collectors.toSet());

        System.out.println("\n---------------------------------------");
        System.out.println("original list = " + numbers);
        System.out.println("      uniques = " + uniques);
        System.out.println("   duplicates = " + duplicates);
    }


}
