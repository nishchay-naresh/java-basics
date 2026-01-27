package com.nishchay.java8.streams.basics;

import com.nishchay.util.pojo.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/*
 *
 * A Stream in Java is a sequence of elements from a source that supports data processing operations.
 *   It presents in java.util.stream
 *   Data source of a stream is usually a Collection or an Array.
 *
 *	Java Stream Usage
 *	Using a Java Stream follows these steps:
 *	1.	Get a Stream
 *	2.	Call zero or more non-terminal operations on the Stream
 *	3.	Call a terminal operation on the Stream
 *
 * */
public class A01BasicStreamDemo {

    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("java", "python", "go", "spring", "kafka");
        streamTypesEx();
        streamCloseEx(stringList);
        serialParallelStreamEx(stringList);
        streamOfEx();
    }

    /*
     *	A Stream of Elements may be
     *		-	Obtained from a Collection (Collection.stream)
     *		-	Obtained from an array (Arrays.stream)
     *		-	Obtained from a file (BufferedReader.lines)
     *		-	Generated (LongStream.range)
     *		-	Constructed using a Spliterator (StreamSupport)
     *		-	Obtained from a 3rd-party source (DatasetReader.records)
     *
     *
     * Stream types
     * 	Reference
     * 	    -	java.util.stream.Stream<T>
     * 	Primitive (unboxed)
     * 	    -	java.util.stream.DoubleStream
     * 	    -	java.util.stream.IntStream
     * 	    -	java.util.stream.LongStream
     * */
    private static void streamTypesEx() {
        Dish.menu.forEach(e -> System.out.print(e + ", "));
        System.out.println();

        IntStream.range(1, 11).forEach(e -> System.out.print(e + ", "));
        System.out.print("\n----------------------------------\n");
        IntStream.rangeClosed(1, 11).forEach(e -> System.out.print(e + ", "));
        System.out.println();
        DoubleStream.of(-9, -18, 54, 8, 7, 14, 3).forEach(e -> System.out.print(e + ", "));
        System.out.println();
        LongStream.rangeClosed(1, 10).forEach(e -> System.out.print(e + ", "));
    }

    /*
     * Error - java.lang.IllegalStateException: stream has already been operated upon or closed
     * */
    private static void streamCloseEx(List<String> strList) {
        // Once a Stream processed, you can't perform anything again. One needs to get the stream again
        Stream<String> stringStream = strList.stream();
        // Stream<String> pipelineOne = stringStream.filter(e -> !e.isEmpty());
        // Stream<String> pipelineTwo = stringStream.filter(e-> !e.isEmpty());

        // Once consumed or closed, a stream cannot be used again
        long count = stringStream.filter(e -> e.startsWith("R")).count();
        System.out.println("count = " + count);
        // count = stringStream.filter(e -> e.startsWith("S")).count();

        stringStream = strList.stream();
        stringStream.close();
        // count = stringStream.filter(e -> e.startsWith("S")).count();
    }

    private static void serialParallelStreamEx(List<String> strList) {
        Stream<String> strStream = strList.stream(); //Get a serial stream
        System.out.println("########## Printing list using serial stream ###########");
        strStream.forEach(e -> System.out.print(e + ", "));

        strStream = strList.parallelStream();        //Get a parallel stream
        System.out.println("\n########## Printing list using parallel stream ###########");
        strStream.forEach(e -> System.out.print(e + ", "));
    }

    private static void streamOfEx() {
        String[] strArray = new String[]{"A", "B", "C", "D", "E"};
        // Creating Stream from String Array
        Stream<String> strStream = Stream.of(strArray);
        strStream.forEach(e -> System.out.print(e + ", "));

        Integer[] integerArray = new Integer[]{1, 2, 3, 4, 5};
        // Creating Stream from intArray
        Stream<Integer> intStream = Stream.of(integerArray);
        intStream.forEach(e -> System.out.print(e + ", "));

    }

}
