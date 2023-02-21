package com.nishchay.java8.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DSQnsUsingJava8 {

    public static void main(String[] args) {


        noStartsWith();
        arrayReverseUsingStream();

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

        List<String> result = Arrays.stream(intArray)
                .boxed()
                .map(e -> e.toString())
                .filter(e -> e.startsWith("1"))
                .collect(Collectors.toList());
        System.out.println("result = " + result);

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

}














