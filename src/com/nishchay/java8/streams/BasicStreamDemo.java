package com.nishchay.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class BasicStreamDemo {

    public static void main(String[] args) {

        serialParallelStreamEx();
        streamOfEx();

    }

    private static void serialParallelStreamEx() {

        List<String> stringList =  Arrays.asList("Rohit", "Shikhar", "Kohli", "Iyyar", "Rahul");

        // Obtain a stream out of List<String>
        Stream<String> strStream = stringList.stream(); //gives you serial stream
        System.out.println("########## Printing list using serial stream ###########");
        strStream.forEach(e -> System.out.println(e));

        //java.lang.IllegalStateException: stream has already been operated upon or closed
//        strStream.forEach(System.out::println);

        strStream = stringList.parallelStream();
        System.out.println("########## Printing list using parallel stream ###########");
        strStream.forEach(e -> System.out.println(e));


    }

    private static void streamOfEx() {

        String[] strArray = new String[]{"A", "B", "C", "D", "E"};
        // Creating Stream from String Array
        Stream<String> strStream = Stream.of(strArray);
        strStream.forEach(e -> System.out.println(e));

        List<Integer> listOfInt = Arrays.asList(1,2,3,4,5);
        // Creating Stream from ArrayList
        Stream<List<Integer>> intStream = Stream.of(listOfInt);
        intStream.forEach(a -> System.out.println(a));
    }

}
