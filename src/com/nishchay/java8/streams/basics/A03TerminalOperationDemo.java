package com.nishchay.java8.streams.basics;

import java.util.*;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
 *  Terminal Operations :
 *	-	forEach()/toArray()
 *	-	min()/max()
 *	-	count()/reduce()
 *	-	findFirst()/findAny()
 *	-	anyMatch()/allMatch()/noneMatch()
 *  -   reduce()
 * 	-	collect()
 *
 *
 *      default void forEach(Consumer<? super T> action)
 * Performs the given action for each element of the Iterable until all elements have been processed or the action throws an exception.
 *
 *      Object[] toArray();
 * Returns an array containing the elements of this stream.
 *
 *      Optional<T> min(Comparator<? super T> comparator);
 * Returns the minimum element of this stream according to the provided Comparator.
 *
 *      Optional<T> max(Comparator<? super T> comparator);
 * Returns the maximum element of this stream according to the provided Comparator.
 *
 *      long count();
 * Returns the count of elements in this stream.
 *
 *      Optional<T> findFirst();
 * Returns an Optional describing the first element of this stream
 * or an empty Optional if the stream is empty
 *
 *      Optional<T> findAny();
 * Returns an Optional describing some element of the stream, or an empty Optional
 * findAny() -  but it's always giving the first element only
 *
 *      boolean anyMatch(Predicate<? super T> predicate);
 * Returns whether any elements of this stream match the provided predicate
 *
 *      boolean allMatch(Predicate<? super T> predicate);
 * Returns whether all elements of this stream match the provided predicate.
 *
 *      boolean noneMatch(Predicate<? super T> predicate);
 * Returns whether no elements of this stream match the provided predicate.
 *
 * opposite of allMatch() is noneMatch()
 *
 *  ==== SHORT-CIRCUIT EVALUATION ====
 * These functions  : anyMatch, allMatch, findFirst, findAny are short-circuiting terminal operations.
 * These operations need not be required to process the whole stream to produce the result
 * This means, if an infinite stream is presented, the functions may terminate in finite time.
 *
 * */
public class A03TerminalOperationDemo {

    public static void main(String[] args) {

        List<String> stringList = Arrays.asList("java", "python", "go", "perl", "ruby", "kafka");
        forEachEx(stringList);

        System.out.println("--------------------- toArrayEx --------------------");
        toArrayEx(stringList);

        System.out.println("----------------------- countEx --------------------");
        countEx();

        System.out.println("---------------- findAnyFindFistEx -----------------");
        findAnyFindFistEx();

        System.out.println("----------------------- minMaxEx -------------------");
        minMaxEx();

        System.out.println("------------ anyMatchAllMatchNoMatchEx -------------");
        anyMatchAllMatchNoMatchEx();

        System.out.println("------- anyMatchAllMatchNoMatchEx_intStream --------");
        anyMatchAllMatchNoMatchEx_intStream();

        System.out.println("--------------------- collectEx -------------------");
        collectEx();

        System.out.println("--------------- concatenateStreams ----------------");
        concatenateStreams();
    }

    private static void forEachEx(List<String> list) {
        System.out.print("Stream elements - ");
        list.forEach(element -> System.out.print(element + ", "));
        System.out.println();
    }

    private static void toArrayEx(List<String> list) {
        Stream<Integer> streamOfNum = Stream.of(5, 6, 7, 8, 9, 10);
        // Object[] objectArray = streamOfNum.toArray();
        Integer[] integerArray = streamOfNum.toArray(Integer[]::new);
        System.out.println("integerArray - " + Arrays.toString(integerArray));

        String[] stringArray = list.toArray(String[]::new);
        System.out.println("stringArray - " + Arrays.toString(stringArray));
    }

    private static void countEx() {
        long count = Stream.of("one", "two", "three", "four", "five", "ten")
                .filter(e -> e.startsWith("t"))
                .count();
        System.out.println("count = " + count);
    }

    /*
    * findAny() - Returns an Optional describing some element of the stream
    *           -  but it's always giving the first element only
    * findFirst() - Returns an Optional describing the first element of this stream
    *
    * */
    private static void findAnyFindFistEx() {
        Optional<String> stringOptional = Stream.of("one", "two", "three").findAny();
        System.out.println("Find any - " + stringOptional.orElse(null));    // one

        stringOptional = Stream.of("one", "two", "three").findFirst();
        System.out.println("Find first - " + stringOptional.orElse(null)); // one
    }

    private static void minMaxEx() {
        System.out.println("########## MinMax - String ###########");
        List<String> animalList = Arrays.asList("deer", "elephant", "panther", "tiger", "fox");
        System.out.println("minString - " + animalList.stream().min(Comparator.comparing(String::length)).get());       //fox
        // System.out.println("maxString - " + animalList.stream().max((s1, s2) -> s1.length() - s2.length()).get());
        System.out.println("maxString - " + animalList.stream().max(Comparator.comparingInt(String::length)).get());    //elephant

        // MinMaxInteger
        System.out.println("########## MinMax - Integer ###########");
        List<Integer> numbers = Arrays.asList(14, 9, 12, 3, 10, 4, 20, 28);
        // System.out.println("min - " + numbers.stream().min((o1, o2) -> o1.compareTo(o2)).get());
        System.out.println("min - " + numbers.stream().min(Integer::compareTo).get());
        System.out.println("max - " + numbers.stream().max(Integer::compare).get());
    }

    /*
     *
     *	anyMatch() - Returns whether any elements of this stream match the provided predicate
     *	allMatch() - Returns whether all elements of this stream match the provided predicate.
     *	noneMatch() - Returns whether no elements of this stream match the provided predicate.
     *
     * opposite of allMatch() is noneMatch()
     *
     * What if the stream is empty? anyMatch - false, allMatch - true
     *
     * ==== SHORT-CIRCUIT EVALUATION ====
     * These functions  : anyMatch,allMatch, findFirst, findAny  are short-circuiting terminal operations.
     * This means, if an infinite stream is presented, the functions may terminate in finite time.
     * These operations need not required to process whole stream to produce the result
     *
     * */
    private static void anyMatchAllMatchNoMatchEx() {
        List<String> stringList = new ArrayList<>();
        stringList.add("One and half man");
        stringList.add("One and only one");
        stringList.add("One two ka four");
        stringList.add("One & one eleven");

        boolean matchResult =
                stringList.stream()
                        .anyMatch(value -> value.startsWith("One"));
        System.out.println("anyMatch(value -> value.startsWith(\"One\")) = " + matchResult);

        matchResult =
                stringList.stream()
                        .anyMatch(value -> value.startsWith("Two"));
        System.out.println("anyMatch(value -> value.startsWith(\"Two\")) = " + matchResult);

        matchResult =
                stringList.stream()
                        .allMatch(value -> value.startsWith("One"));
        System.out.println("allMatch(value -> value.startsWith(\"One\")) = " + matchResult);

        matchResult =
                stringList.stream()
                        .noneMatch(element -> element.startsWith("Two"));
        System.out.println("noneMatch(element -> element.startsWith(\"Two\")) = " + matchResult);

        matchResult =
                stringList.stream()
                        .noneMatch(element -> element.startsWith("One"));
        System.out.println("noneMatch(element -> element.startsWith(\"One\")) = " + matchResult);
    }

    private static void anyMatchAllMatchNoMatchEx_intStream() {

        int[] arr = new int[]{3, 18, 15, 30, 60};

        IntPredicate isDivisibleByThree = e -> (e % 3 == 0);
        IntPredicate isDivisibleByFive = e -> (e % 5 == 0);

        IntPredicate isDivisibleByThreeAndFive = isDivisibleByThree
                .and(isDivisibleByFive);

        boolean matchResult = Arrays.stream(arr)
                .allMatch(isDivisibleByThree);
        System.out.println("divisible by three : " + matchResult);

        matchResult = Arrays.stream(arr)
                .allMatch(isDivisibleByFive);
        System.out.println("divisible by five : " + matchResult);

        matchResult = Arrays.stream(arr)
                .allMatch(isDivisibleByThreeAndFive);
        System.out.println("divisible by three and five : " + matchResult);

        matchResult = Arrays.stream(arr)
                .anyMatch(isDivisibleByThree);
        System.out.println("divisible by three : " + matchResult);

        matchResult = Arrays.stream(arr)
                .anyMatch(isDivisibleByFive);
        System.out.println("divisible by five : " + matchResult);

        matchResult = Arrays.stream(arr)
                .anyMatch(isDivisibleByThreeAndFive);
        System.out.println("divisible by three and five : " + matchResult);
    }

    private static void collectEx() {
        List<String> strUpperCaseList =
                Stream.of("one", "two", "three", "four", "five")
                        .map(value -> value.toUpperCase())
                        .collect(Collectors.toList());
        System.out.println(strUpperCaseList);
    }

    private static void concatenateStreams() {
        Stream<String> streamOne = Stream.of("one", "two", "three", "four", "five");
        Stream<String> streamTwo = Stream.of("six", "seven", "eight", "nine", "ten");
        Stream<String> streamConcat = Stream.concat(streamOne, streamTwo);

        List<String> streamConcatList = streamConcat.toList();
        System.out.println("streamConcatList - " + streamConcatList);
    }
}
