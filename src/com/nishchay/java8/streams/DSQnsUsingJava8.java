package com.nishchay.java8.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DSQnsUsingJava8 {

    public static void main(String[] args) {

        noStartsWith();
        arrayReverseUsingStream();
        charFrequency();

        findCharOccurrence();
        findDuplicate();
        firstNonRepeatElement();
//        secondHighest();
//        longestString();

        stringToInteger();

    }


    /*
     * int arr[] = { 2, 1, 15, 10, 25, 101, 35, 19 }; (Start with 1 ) print
     * output :: 1, 15, 10, 101, 19
     * Do we have any Method like startWith(1) in Java 1.8 -> No
     *
     * */
    private static void noStartsWith() {

        int[] intArray = {2, 1, 15, 10, 25, 101, 35, 19};

        // Arrays.stream(intArray).boxed().map(e -> e.toString()).filter(e -> e.startsWith("1")).forEach(e -> System.out.print(e + ", "));

        List<String> nosStartWith1 = Arrays.stream(intArray)
                .boxed()
                .map(String::valueOf)
                .filter(e -> e.startsWith("1"))
                .collect(Collectors.toList());
        System.out.println("nosStartWith1 = " + nosStartWith1);

    }


    /*
     *    Hi I have one array of integer
     *    int[] intArray = {1, 3, 8, 4, 6};
     *    How to reverse the array using stream
     *
     * */
    private static void arrayReverseUsingStream() {

        int[] intArray = {1, 3, 8, 4, 6};

        int[] reversed = IntStream.of(intArray).boxed().sorted(Comparator.reverseOrder()).mapToInt(i -> i).toArray();

        System.out.println("intArray = " + Arrays.toString(intArray));
        System.out.println("reversed = " + Arrays.toString(reversed));
    }

    /*
     * Find the frequency of each char in string array using stream api
     *
     * String[] strArray = {"i", "love", "java"};
     * freqMap = {a=2, e=1, v=2, i=1, j=1, l=1, o=1}
     * */
    private static void charFrequency() {

        String[] strArray = {"i", "love", "java"};

/*
        Map<Character, Long> freqMap =
                Arrays.stream(strArray)
                        .flatMap(s -> s.chars().boxed())
                        .collect(Collectors.groupingBy(x -> (char) (int) x, Collectors.counting()));
*/

        Map<Character, Long> freqMap =
                Arrays.stream(strArray)
                        .flatMap(s -> s.chars().mapToObj(c -> (char) c))
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println("freqMap = " + freqMap);
    }

    /*
     *	1. Java program to count the occurrence of each character in a string
     *	input -  ilovejava8
     *	output - {a=2, e=1, v=2, 8=1, i=1, j=1, l=1, o=1}
     *
    * */
    private static void findCharOccurrence() {
//        String input = "ilovejava8" ;
        String input = "ilovejavaprogramming" ;

        Map<String, Long> map = Arrays.stream(input.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("map = " + map);
    }

    /*
     *	2. Java program to find all duplicate element from a given string
     *   input = "ilovejavaprogramming"
     *	 frqMap = {p=1, a=3, r=2, e=1, v=2, g=2, i=2, j=1, l=1, m=2, n=1, o=2}
     *   duplicates are = {a, r, v, g, i, m, o}
     *
     * */
    private static void findDuplicate() {
        String input = "ilovejavaprogramming" ;

        List<String> duplicates = Arrays.stream(input.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println("duplicates = " + duplicates);
    }

    /*
     *	3. Java program to find first non—repeat element front a given string
     *	input = "ilovejavaprogramming"
     *	frqMap = {p=1, a=3, r=2, e=1, v=2, g=2, i=2, j=1, l=1, m=2, n=1, o=2}
     *  first non—repeat element = p
     * */
    private static void firstNonRepeatElement() {
        String input = "ilovejavaprogramming" ;

        String firstNonRepeat = Arrays.stream(input.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .findFirst()
                        .get().getKey();

        System.out.println("firstNonRepeat = " + firstNonRepeat);
    }

    /*
     * One list of string is there, like below
     * List<String> strList = Arrays.asList("15Shades", "5Th Cross", "98.3FM", "1,233.00$ USD", "java8")
     * List<Double> intList = {6, 5, 98.3, 1233.00, 8};
     * extract the numbers from string list and add to the Double list
     *
     * https://www.baeldung.com/java-string-retain-digits-decimal
     * */
    private static void stringToInteger() {
        List<String> strList = Arrays.asList("Delhi6", "5Th Cross", "98.3FM", "1,233.00$ USD", "text", "java8");

        List<Double> doubleList = strList.stream()
                .map(s -> s.replaceAll("[^\\d.]", ""))
                .filter(( s -> !s.isEmpty()))
                .map(Double::parseDouble)
                .collect(Collectors.toList());
        System.out.println("doubleList = " + doubleList);
    }

}














