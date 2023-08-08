package com.nishchay.test.blueyonder;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
* 1. Given a String, find the first non-repeated character in it using Java 8
* 2. How to find duplicate elements in a given integers list in java 8
* */
public class TestJava8 {

    public static void main(String[] args) {
        firstNonRepeatedChar();
        System.out.println(" ======================================== ");
        findDuplicates();
    }


    //  Given a String, find the first non-repeated character in it using Java 8
    private static void firstNonRepeatedChar() {
        String input = "java";
        Map<Character, Long> freqLinkedHashMap = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

        Character result = freqLinkedHashMap
                .entrySet().stream()
                .filter(entry -> entry.getValue() == 1L)
                .map(entry -> entry.getKey())
                .findFirst().get();

        System.out.println("firstNonRepeatedChar = " + result);
    }

    // How to find duplicate elements in a given integers list in java 8
    private static void findDuplicates() {
        List<Integer> numbers = Arrays.asList(5, 3, 4, 1, 3, 7, 2, 9, 9, 4);
        Set<Integer> uniques = new HashSet<>();
        Set<Integer> duplicates = numbers.stream()
                .filter(n -> !uniques.add(n)) // Set.add() returns false if the element was already in the set.
                .collect(Collectors.toSet());

        System.out.println("original list = " + numbers);
        System.out.println("      uniques = " + uniques);
        System.out.println("   duplicates = " + duplicates);
    }
}
