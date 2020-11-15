package com.nishchay.java8.streams.intstream;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IntStreamDemo {

    public static void main(String[] args) {


//        streamFromArgumentsValues();
        streamFromRange();

//        intStreamTerminalUtility();
//        intStreamStatistics();

    }


    private static void streamFromArgumentsValues(){

        // returning a stream for list of values it accepts
        IntStream stream = IntStream.of(-9, -18, 54, 8, 7, 14, 3);
        stream.forEach(System.out::println);
    }

    private static void streamFromRange() {
        IntStream.range(1, 11).forEach(System.out::println);
        int[] intArray =  IntStream.range(1, 11).toArray();
        System.out.println("intArray = " + Arrays.toString(intArray));
        List<Integer> listOfInt =  IntStream.range(1, 11).boxed().collect(Collectors.toList());
        System.out.println("listOfInt = " + listOfInt);
    }

    private static void intStreamTerminalUtility() {
        int numbers[] = {1, 9, 3, 10, 4, 20, 2};

        System.out.println("min : " + IntStream.of(numbers).min().getAsInt());
        System.out.println("max : " + IntStream.of(numbers).max().getAsInt());
        System.out.println("sum : " + IntStream.of(numbers).sum());
        System.out.println("avg : " + IntStream.of(numbers).average().getAsDouble());
        System.out.println("count : " + IntStream.of(numbers).count());
    }



    private static void intStreamStatistics() {
        int numbers[] = {1, 9, 3, 10, 4, 20, 2};

        System.out.println("---------------------IntSummaryStatistics----------------------");
        IntSummaryStatistics stats = IntStream.of(numbers).summaryStatistics();
        System.out.println("min : " + stats.getMin());
        System.out.println("max : " + stats.getMax());
        System.out.println("avg : " + stats.getAverage());
        System.out.println("count : " + stats.getCount());
        System.out.println("sum : " + stats.getSum());
    }


}
