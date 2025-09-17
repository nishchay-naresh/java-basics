package com.nishchay.test.blueyonder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/*
* 1. Given a String, find the first non-repeated character in it using Java 8
* 2. How to find duplicate elements in a given integers list in java 8
*
* 3.
*       We have an input structured as customerName -> {emails} , like below
*       We need to list the customerName for which there is no duplicate email
*
*  Like :
*           c1: [a@b,c@d,h@i]
*           c2:[o@p,g@5]
*           c3:[a@b,x@z]
*           c4:[k@l]
*
*       customer with unique emails  :           [c1,c2,c4] / [c2,c3,c4]
*
*
* */
public class TestJava8 {

    public static void main(String[] args) {

        // System.out.println("customer with unique emails - " + customerWithUniqueEmail());
        // System.out.println(" ======================================== ");

        // firstNonRepeatedChar();
        // System.out.println(" ======================================== ");
        findDuplicatesAndUniques();
        System.out.println(" ======================================== ");
        findDuplicatesFrequency();

    }

    private static List<String> customerWithUniqueEmail() {

        Map<String, String[]> customerDirectory = new HashMap<>();
        customerDirectory.put("c1", new String[]{"a@b", "c@d", "h@i"});
        customerDirectory.put("c2", new String[]{"o@p", "g@5"});
        customerDirectory.put("c3", new String[]{"a@b", "x@z"});
        customerDirectory.put("c4", new String[]{"k@l"});

        // imperative way
        Set<String> emailSet = new HashSet<>();
        List<String> customers = new ArrayList<>();

        for (Map.Entry<String, String[]> entry : customerDirectory.entrySet()) {
            boolean dupEmail = false;
            for (String emails : entry.getValue()) {
                if (!emailSet.add(emails)) {
                    dupEmail = true;
                    break;
                }
            }
            if (!dupEmail) {
                customers.add(entry.getKey());
            }
        }

        /*
        // declarative way
        Set<String> uniqueEmails = new HashSet<>();
        List<String> customers = customerDirectory.entrySet().stream()
                .filter(entry ->
                        Arrays.stream(entry.getValue())
                                .noneMatch(email -> !uniqueEmails.add(email))
                )
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
         */
        return customers;
    }

    //  Given a String, find the first non-repeated character in it using Java 8
    private static void firstNonRepeatedChar() {
        String input = "the quick brown fox jumps over the lazy dog quick";
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

    private static List<Integer> getNumbersOnCondition(Map<Integer, Long> freqMap , Predicate<Long> condition) {
        return freqMap.entrySet().stream()
                .filter(entry -> condition.test(entry.getValue()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    private static void findDuplicatesFrequency() {
        List<Integer> numbers = Arrays.asList(5, 3, 4, 1, 3, 7, 2, 9, 9, 4);
        List<Integer> uniques = getNumbersOnCondition(numbers, f -> (f == 1));
        List<Integer> duplicates = getNumbersOnCondition(numbers, f -> (f > 1));

        System.out.println("original list = " + numbers);
        System.out.println("      uniques = " + uniques);
        System.out.println("   duplicates = " + duplicates);
    }

    // Bad solution, we are doing 2 iteration, better store the frequency in a map
    private static List<Integer> getNumbersOnCondition(List<Integer> numbers, Predicate<Long> condition) {
        return numbers.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> condition.test(entry.getValue()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}
