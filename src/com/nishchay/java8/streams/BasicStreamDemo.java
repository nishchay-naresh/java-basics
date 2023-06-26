package com.nishchay.java8.streams;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class BasicStreamDemo {

    public static void main(String[] args) {

        streamEx();
        serialParallelStreamEx();
        streamOfEx();

        iterableToList();
    }

    /*
     *
     * Error - java.lang.IllegalStateException: stream has already been operated upon or closed
     *
     * */
    private static void streamEx() {
        // A Stream instance cannot have more than one pipeline defined against it
        Stream<String> stringStream = Stream.of("Rohit", "Shikhar", "Kohli", "Iyyar", "Rahul");
        Stream<String> pipelineOne = stringStream.filter(e -> !e.isEmpty());
        // Stream<String> pipelineTwo = stringStream.filter(e-> !e.isEmpty());

        // Once consumed or closed, a stream cannot be used again
        stringStream = Stream.of("Rohit", "Shikhar", "Kohli", "Iyyar", "Rahul");
        long count = stringStream.filter(e -> e.startsWith("R")).count();
        // count = stringStream.filter(e -> e.startsWith("S")).count();

        stringStream = Stream.of("Rohit", "Shikhar", "Kohli", "Iyyar", "Rahul");
        stringStream.close();
        // count = stringStream.filter(e -> e.startsWith("S")).count();
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

    private static void iterableToList() {
        Set<String> missingKeys = new HashSet<>(Arrays.asList("two", "three"));
        Function<Set<Number>, Iterable<CharSequence>> mappingFunction =
               keys -> Arrays.asList("updated-one", "two", "three");
        Iterable<CharSequence> iterable = mappingFunction.apply(new HashSet<>(Arrays.asList(1, 2, 3)));

        List<CharSequence> array = StreamSupport
                .stream(iterable.spliterator(), false)
                .filter(e -> missingKeys.contains(e))
                .collect(Collectors.toList());
        System.out.println("array = " + array);
    }
}
