package com.nishchay.java8.streams.intstream;

import com.nishchay.util.pojo.Dish;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntStreamDemo {

    public static void main(String[] args) {


        streamFromArgumentsValues();
        streamFromRange();
        streamFromRangeToArray();
        intStreamTerminalUtility();
        intStreamStatistics();

        needOfStream();
        streamToIntStream();

    }

    private static void streamFromArgumentsValues(){

        // returning a stream for list of values it accepts
        IntStream stream = IntStream.of(-9, -18, 54, 8, 7, 14, 3);
        stream.forEach(System.out::println);
    }

    private static void streamFromRange() {
        System.out.print("\n IntStream.range(1, 10) = ");
        IntStream.range(1, 10).forEach(e -> System.out.print(e + ", "));
        System.out.print("\n IntStream.rangeClosed(1, 10) = ");
        IntStream.rangeClosed(1, 10).forEach(e -> System.out.print(e + ", "));

        System.out.println("\n ------------------------------------------");
        int[] intArray =  IntStream.range(1, 11).toArray();
        System.out.println("intArray = " + Arrays.toString(intArray));
        List<Integer> listOfInt =  IntStream.rangeClosed(1, 10).boxed().collect(Collectors.toList());
        System.out.println("listOfInt = " + listOfInt);
    }

    private static void streamFromRangeToArray() {
        // IntStream -> int[]
        int[] intArray = IntStream.rangeClosed(1, 5).toArray();
        System.out.println("intArray - " + Arrays.toString(intArray));

        // Stream<Integer> -> int[]
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);
        intArray = integerStream.mapToInt(x -> x).toArray();
        System.out.println("intArray - " + Arrays.toString(intArray));
    }

    private static void intStreamTerminalUtility() {
        int[] numbers = {1, 9, 3, 10, 4, 20, 2};

        System.out.println("min : " + IntStream.of(numbers).min().getAsInt());
        System.out.println("max : " + IntStream.of(numbers).max().getAsInt());
        System.out.println("sum : " + IntStream.of(numbers).sum());
        System.out.println("avg : " + IntStream.of(numbers).average().getAsDouble());
        System.out.println("count : " + IntStream.of(numbers).count());
    }

    private static void intStreamStatistics() {
        int[] numbers = {1, 9, 3, 10, 4, 20, 2};

        System.out.println("---------------------IntSummaryStatistics----------------------");
        IntSummaryStatistics stats = IntStream.of(numbers).summaryStatistics();
        System.out.println("min : " + stats.getMin());
        System.out.println("max : " + stats.getMax());
        System.out.println("avg : " + stats.getAverage());
        System.out.println("count : " + stats.getCount());
        System.out.println("sum : " + stats.getSum());
    }

    private static void needOfStream() {
        // below code is having - insidious boxing cost
        int calories = Dish.menu.stream()
                .map(Dish::getCalories)
                .reduce(0, Integer::sum);

        System.out.println("calories = " + calories);

        // we don't have sum() method for Stream<T>
        // No boxing cost involved
        calories = Dish.menu.stream()
                .mapToInt(Dish::getCalories)
                .sum();

        System.out.println("calories = " + calories);
    }
    private static void streamToIntStream() {
        List<Integer> list = Dish.menu.stream()
                .mapToInt(Dish::getCalories)
                .boxed()
                .collect(Collectors.toList());

        System.out.println("list = " + list);
    }
}
