package com.nishchay.ds.string.freq;

import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MostFrequentWord {

    public static void main(String[] args) {

//        mostFrequentStrEx();

        nMostFrequentCharEx();

    }



    private static void nMostFrequentCharEx() {

        System.out.println("nMostFrequentChar(\"bananassss\", 3) - " + nMostFrequentChar("bananassss", 3));
        System.out.println("nMostFrequentChar(\"bananassss\", 2) - " + nMostFrequentChar("bananassss", 2));
        System.out.println("nMostFrequentChar(\"java perl rep\", 1) - " + nMostFrequentChar("java perl rep", 1));

    }

    private static void mostFrequentStrEx() {
        String[] strArray = {"geeks", "for", "geeks", "a",
                "portal", "to", "learn", "can", "be",
                "computer", "science", "zoom", "yup",
                "fire", "in", "be", "data", "geeks"};

        System.out.println("Most frequent word is - " + mostFrequentChar(strArray));

    }


//    Time Complexity: O(n)
//    Space Complexity: O(n)
    private static String mostFrequentChar(String[] strArray) {

        Map<String, Integer> feqMap = StringFrequencyUtility.getFrequencyMap(strArray);

        String result = "";
        int value = 0;
        for (Map.Entry<String, Integer> currEntry : feqMap.entrySet()) {
            // Check for word having highest frequency
            if (currEntry.getValue() > value) {
                value = currEntry.getValue();
                result = currEntry.getKey();
            }
        }
        return result;
    }

    private static char nMostFrequentChar(String str, int n) {

        Map<Character, Long> counter = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        if (counter.size() < n) {
            throw new IllegalArgumentException("Not enough different characters.");
        }

/*
        System.out.println("str = " + str);
        counter.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder()))
                .forEach(System.out::println);
*/

        return counter.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList())
                .get(n - 1);

    }

}
