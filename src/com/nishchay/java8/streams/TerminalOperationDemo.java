package com.nishchay.java8.streams;

import java.util.*;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TerminalOperationDemo {

    public static void main(String[] args) {

        forEachEx();

        System.out.println("--------------------- toArrayEx --------------------");
        toArrayEx();

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

        System.out.println("--------------------- reduceEx --------------------");
        reduceEx();
        reduceEx1();

        System.out.println("--------------- concatenateStreams ----------------");
        concatenateStreams();

    }

    private static void forEachEx() {
        Stream<String> stringStream = Stream.of("fox", "elephant", "lion", "tiger", "bear");

        System.out.print("Stream elements - ");
        stringStream.forEach(element -> System.out.print(element + ", "));
        System.out.println();
        // stream.forEach(System.out::print);
    }

    private static void toArrayEx() {

        Stream<Integer> streamOfNum = Stream.of(5, 6, 7, 8, 9, 10);
        // Object[] arrOfObject = streamOfNum.toArray();
        Integer[] arrOfObject = streamOfNum.toArray(Integer[]::new);
        System.out.println("arrOfObject - " + Arrays.toString(arrOfObject));

        Stream<String> stringStream = Stream.of("fox", "elephant", "lion", "tiger", "bear");
        String[] stringArray = stringStream.toArray(String[]::new);
        System.out.println("stringArray - " + Arrays.toString(stringArray));

        System.out.println("--------------------------------------------");
        int[] intArray = {101, 27, 305, 444, 15};

        // int[] -> Integer[]
        Integer[] wrapperArray = Arrays.stream(intArray)
                .boxed()
                .toArray(Integer[]::new);
        System.out.println("wrapperArray - " + Arrays.toString(wrapperArray));

        // Integer[] -> int[]
        intArray = Arrays.stream(wrapperArray).mapToInt(Integer::intValue).toArray();
        System.out.println("intArray - " + Arrays.toString(intArray));

        // int[] -> Set<Integer>
        Set<Integer> integerSet = Arrays.stream(intArray)
                .boxed()
                .collect(Collectors.toSet());

        System.out.println("integerSet - " + integerSet);
        // Set<Integer> -> int[]
        intArray = integerSet.stream().mapToInt(i -> i).toArray();
        System.out.println("intArray = " + Arrays.toString(intArray));
    }


    private static void countEx() {

        long count = Stream.of("one", "two", "three", "four", "five", "ten")
                .filter(e -> e.startsWith("t"))
                .count();

        System.out.println("count = " + count);
    }


    private static void findAnyFindFistEx() {

        // findAny() -  but it's always giving the first element only
        Optional<String> stringOptional =
                Stream.of("one", "two", "three", "four", "five")
                        .findAny();
        System.out.println("Find any - " + stringOptional.get());

        // findFirst() - Returns an Optional describing the first element of this stream, or an empty Optional
        stringOptional =
                Stream.of("nine", "ten")
                        .findFirst();

        System.out.println("Find first - " + stringOptional.orElse(null));
    }

    private static void minMaxEx() {
        System.out.println("########## MinMax - String ###########");
        List<String> animalList = Arrays.asList("be", "elephant", "lion", "tiger", "ant");
        System.out.println("minString - " + animalList.stream().min(Comparator.comparing(String::length)).get());
        // System.out.println("maxString - " + animalList.stream().max((s1, s2) -> s1.length() - s2.length()).get());
        System.out.println("maxString - " + animalList.stream().max(Comparator.comparingInt(String::length)).get());

        // MinMaxInteger
        System.out.println("########## MinMax - Integer ###########");
        List<Integer> numbers = Arrays.asList(14, 9, 12, 3, 10, 4, 20, 28);
        // System.out.println("min - " + numbers.stream().min((o1, o2) -> o1.compareTo(o2)).get());
        System.out.println("min - " + numbers.stream().min(Integer::compareTo).get());
        System.out.println("max - " + numbers.stream().max(Integer::compare).get());
    }

    private static void anyMatchAllMatchNoMatchEx() {

        List<String> stringList = new ArrayList<>();
        stringList.add("One and half man");
        stringList.add("One and only one");
        stringList.add("One two ka four");
        stringList.add("One & one eleven");

        boolean matchResult = stringList.stream()
                .anyMatch(value -> value.startsWith("One"));
        System.out.println("anyMatch = " + matchResult);

        matchResult = stringList.stream()
                .anyMatch(value -> value.startsWith("Two"));
        System.out.println("anyMatch = " + matchResult);

        matchResult = stringList.stream()
                .allMatch(value -> value.startsWith("One"));
        System.out.println("allMatch = " + matchResult);

        matchResult = stringList.stream()
                .noneMatch(element -> element.startsWith("Two"));
        System.out.println("noneMatch = " + matchResult);

        matchResult = stringList.stream()
                .noneMatch(element -> element.startsWith("One"));
        System.out.println("noneMatch = " + matchResult);

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


    private static void reduceEx() {

        // Applying to reduce over IntStream
        OptionalInt optionalIntSum = IntStream.of(7, 5, 9, 2, 8, 1).reduce((a, b) -> a + b);
        System.out.println("optionalIntSum = " + optionalIntSum);
        /*
         * without initial (identity) value
         * a = a + b
         * b = iterate through each element of stream
         * */
        int intSum = IntStream.of(7, 5, 9, 2, 8, 1).reduce(0, (a, b) -> a + b);
        System.out.println("intSum = " + intSum);
        /*
         * with initial (identity) value
         * a = 0(first time) / a + b(rest of the time)
         * b = iterate through each element of stream
         * */

        System.out.println(Stream.of("one", "two", "three", "four").reduce("CountDown : ", (a, b) -> a + ", " + b));


        intSum = IntStream.range(1, 11).sum();
        System.out.println("sum(1 to 10) = " + intSum);

        // Applying to reduce over Stream of Integer
        Optional<Integer> optionalSum = Stream.of(7, 5, 9, 2, 8, 1).reduce((a, b) -> a + b);
        System.out.println("optionalSum = " + optionalSum);
        // if you pass the initial value, it will give you the result instead of optional - here Integer
        Integer integerSum = Stream.of(7, 5, 9, 2, 8, 1).reduce(0, (a, b) -> a + b);
        System.out.println("integerSum = " + integerSum);

        // Applying to reduce over Stream of String
        Optional<String> reduced = Stream.of("one", "two", "three", "four", "five").
                reduce((value, combinedValue) -> value + " + " + combinedValue);
        System.out.println("reduced value - " + reduced.get());

        // Applying to reduce over Stream of String -  to get char counts
        int charCount = Stream.of("one", "two", "three", "four", "five")
                .map(String::length)
                .reduce(0, (e, sum) -> e + sum);
        System.out.println("charCount - " + charCount);

        charCount = Stream.of("one", "two", "three", "four", "five")
                .mapToInt(String::length)
                .sum();
        System.out.println("charCount - " + charCount);

    }

    private static void reduceEx1() {
        List<Integer> numbers = Arrays.asList(3, 7, 2, 9, 6, 1, 5);

        int sum = numbers.stream().mapToInt(i -> i).sum();
        System.out.println("sum = " + sum);

        Integer reduceSum = numbers.stream().reduce(0, (a, b) -> a + b);
        System.out.println("reduceSumOptional = " + reduceSum);

        Optional<Integer> reduceSumOptional = numbers.stream().reduce(Integer::sum);
        System.out.println("reduceSumOptional = " + reduceSumOptional.get());

        Integer maxValue = numbers.stream().reduce(0, (a, b) -> a > b ? a : b);
        System.out.println("maxValue = " + maxValue);

        Optional<Integer> maxValueOptional = numbers.stream().reduce(Integer::max);
        System.out.println("maxValueOptional = " + maxValueOptional.get());

        List<String> animals = Arrays.asList("fox", "elephant", "lion", "tiger", "bear");
        // get the string with the longest length
        Optional<String> longestString = animals.stream().reduce((e1, e2) -> e1.length() > e2.length() ? e1 : e2);
        System.out.println("longestString = " + longestString.get());

    }

    private static void concatenateStreams() {

        Stream<String> streamOne = Stream.of("one", "two", "three", "four", "five");
        Stream<String> streamTwo = Stream.of("six", "seven", "eight", "nine", "ten");

        Stream<String> concatStream = Stream.concat(streamOne, streamTwo);

        List<String> stringsAsUppercaseList = concatStream
                .collect(Collectors.toList());

        System.out.println(stringsAsUppercaseList);
    }

}
