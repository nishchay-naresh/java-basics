package com.nishchay.java8.streams.qns;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/*
 * Find duplicate in a list using stream
 * */
public class FindDuplicate {

    public static void main(String[] args) {
        applyingDistinct();
        System.out.println(" ======================================== ");
        findDuplicatesAndUniques();
        System.out.println(" ======================================== ");
        findDuplicateFromStream();
        System.out.println(" ======================================== ");
        findDuplicateBySortingBoth();
    }

    private static void applyingDistinct() {

        List<Integer> numbers = Arrays.asList(5, 3, 4, 3, 1, 4, 4, 5);
        System.out.println("original list       = " + numbers);
        // applying - distinct() : removing duplicates, keeping only one copy
        System.out.print("without duplicates    = ");
        numbers.stream()
                .distinct()
                .forEach(e -> System.out.print(e + ", "));
        System.out.println();
    }

    /*
     * Find duplicate and unique elements in a given integers list using java 8
     * original list   : [5, 3, 4, 1, 3, 7, 2, 9, 9, 4]
     * Uniques         : [1, 2, 5, 7]
     * Duplicates      : [3, 4, 9]
     *
     * duplicate elements - appear more than once
     * unique elements - appear exactly once
     * */
    private static void findDuplicatesAndUniques() {
        List<Integer> numbers = Arrays.asList(5, 3, 4, 1, 3, 7, 2, 9, 9, 4);
        Map<Integer, Long> freqMap = numbers.stream()
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));

        // Extract duplicates (freq > 1)
        List<Integer> duplicates = getNumbersOnCondition(freqMap, freq -> (freq > 1));
        // Extract uniques (freq == 1)
        List<Integer> uniques = getNumbersOnCondition(freqMap, freq -> (freq == 1));
        System.out.println("original list   : " + numbers);
        System.out.println("Uniques         : " + uniques);
        System.out.println("Duplicates      : " + duplicates);
    }

    private static List<Integer> getNumbersOnCondition(Map<Integer, Long> freqMap, Predicate<Long> condition) {
        return freqMap.entrySet().stream()
                .filter(entry -> condition.test(entry.getValue()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    // here storing both uniques & duplicates
    private static void findDuplicateBySortingBoth() {
        List<Integer> numbers = Arrays.asList(5, 3, 4, 3, 1, 4, 4, 5);
        Set<Integer> uniques = new HashSet<>();
        Set<Integer> duplicates = numbers.stream()
                .filter(n -> !uniques.add(n)) // Set.add() returns false if the element was already in the set.
                .collect(Collectors.toSet());

        System.out.println("\n---------------------------------------");
        System.out.println("original list = " + numbers);
        System.out.println("      uniques = " + uniques);
        System.out.println("   duplicates = " + duplicates);
    }

    private static void findDuplicateFromStream() {

        List<Integer> numbers = Arrays.asList(5, 3, 4, 3, 1, 4, 4, 5);

        // using Collections.frequency(Collection<?> c, Object o) method to get the frequency
        System.out.println("Collections.frequency(numbers, 3) = " + Collections.frequency(numbers, 3));
        System.out.println("Collections.frequency(numbers, 4) = " + Collections.frequency(numbers, 4));
        System.out.println("Collections.frequency(numbers, 1) = " + Collections.frequency(numbers, 1));

        Set<Integer> duplicates = numbers.stream()
                .filter(i -> Collections.frequency(numbers, i) > 1)
                .collect(Collectors.toSet()); // set to eliminate the duplicates
        System.out.print("duplicates = " + duplicates);
    }
}
