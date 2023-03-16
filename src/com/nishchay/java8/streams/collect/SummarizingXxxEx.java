package com.nishchay.java8.streams.collect;

import java.util.*;
import java.util.stream.Collectors;

/*
 * ================  summarizingInt(), summarizingLong(), summarizingDouble() ====================
 *
 * summarizingInt() - return the summary statistics of the results obtained from applying the passed ToIntFunction implementation to a set of input elements.
 *	The following statistics are provided on the elements of the stream:
 *
 *	1. Count of all the elements
 *	2. Cumulative sum of the elements
 *	3. Minimum element
 *	4. Maximum element
 *	5. Average of all the elements
 *
 *
 *
 *
 * https://www.educative.io/answers/what-is-collectorssummarizingint-in-java
 * https://www.educative.io/answers/what-is-collectorssummarizinglong-in-java
 * https://www.educative.io/answers/what-is-collectorssummarizingdouble-in-java
 *
 * */
public class SummarizingXxxEx {

    public static void main(String[] args) {

        forInteger();
        forDouble();
        forLong();

    }

    private static void forInteger() {
        List<Integer> integerList = Arrays.asList(23, 23, 8);
        System.out.println("Contents of the list - " + integerList);

        IntSummaryStatistics intSummaryStatistics = integerList.stream()
                .collect(Collectors.summarizingInt(e -> e));
        System.out.println("intSummaryStatistics = " + intSummaryStatistics);
    }

    private static void forDouble() {
        List<Double> doubleList = Arrays.asList(23.43, 23.32, 8.76567);
        System.out.println("Contents of the list - " + doubleList);

        DoubleSummaryStatistics doubleSummaryStatistics = doubleList.stream()
                .collect(Collectors.summarizingDouble(e -> e));
        System.out.println("doubleSummaryStatistics = " + doubleSummaryStatistics);
    }

    private static void forLong() {
        List<Long> longList = Arrays.asList(2343L, 2332L, 876567L);
        System.out.println("Contents of the list - " + longList);

        LongSummaryStatistics longSummaryStatistics = longList.stream()
                .collect(Collectors.summarizingLong(e -> e));
        System.out.println("longSummaryStatistics = " + longSummaryStatistics);
    }

}