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

        serialParallelStreamEx();
        streamOfEx();

        iterableToList();
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
