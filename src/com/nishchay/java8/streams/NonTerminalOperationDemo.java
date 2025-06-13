package com.nishchay.java8.streams;

import com.nishchay.util.pojo.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NonTerminalOperationDemo {

    public static void main(String[] args) {

        createAndPrint();

        mapDemo();
        filterDemo();
        mapFilterEX();
        distinctDemo();
        sortedDemo();
        limitDemo();
        skipDemo();
        peekDemo();
        compareTwoStreams();

    }




    private static void createAndPrint() {

        Stream<String> stringStream = Stream.of("Rohit", "Shikhar", "Kohli", "Iyyar", "Rahul");
        System.out.println("########## Original List ###########");
        stringStream.forEach(System.out::println);

        // stringStream.forEach(e -> System.out.println(e));
        // Exception in thread "main" java.lang.IllegalStateException: stream has already been operated upon or closed
        // After performing a terminal operation over a stream, we can't reuse the stream

    }


    /*
    * map() - map/transform a sequence of input to sequence of output
    *   - gives same no of output as no of input
    *   - since doing a transformation, that is why taking Function<T,R> as input
    *
    * For primitive , below variant of map can be used :
    * mapToInt(), mapToDouble(), mapToLong()
    *
    *
    * */
    private static void mapDemo() {

        System.out.println("########## applying map operation over stream ###########");
        // using lambda
         /*
         Stream.of("ONE", "two", "THREE", "four", "FIVE")
                .map(value -> value.toLowerCase())
                .map(value -> value.toUpperCase())
                .forEach(s -> System.out.print(s + ", "));
         */
        // using method reference
        Stream.of("ONE", "two", "THREE", "four", "FIVE")
                .map(String::toLowerCase)
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }

    private static void filterDemo() {
        System.out.println("########## List after applying filter - filter((value) -> value.length() > 3) ###########");
        Stream.of("ONE", "two", "THREE", "four", "FIVE")
                .filter(value -> value.length() > 3)
                .forEach(System.out::println);
    }


    private static void mapFilterEX() {
        List<String> names;

        /*
        names = Dish.menu.stream()
                .filter(d -> d.getCalories() > 500)
                .map(Dish::getName)
                .collect(Collectors.toList());
        System.out.println("names = " + names);
        */

        // descriptive way to write filter() & map() - putting more statements
        // printing intermediate values - a debugging technique
       names = Dish.menu.stream()
                .filter(d -> {
                    System.out.println("filtering - " + d.getName());
                    return d.getCalories() > 500;}
                )
                .map(d -> {
                    System.out.println("mapping - " + d.getName());
                    return d.getName();}
                )
                .collect(Collectors.toList());
        System.out.println("names = " + names);

    }
    private static void distinctDemo() {

        // Printing only distinct numbers
        System.out.println("########## List after applying distinct() ###########");
        Stream.of(7, 1, 8, 4, 3, 1, 7, 1, 4, 1, 3)
                .distinct()
                .forEach(s -> System.out.print(s + ", ")); // 7, 1, 8, 4, 3
    }

    private static void sortedDemo() {

        System.out.println("########## sorted view of the stream ###########");
        Stream.of(1, 4, 2, 7, 9, 10, 3)
                .sorted()
                .forEach(s -> System.out.print(s + ", ")); // 1, 2, 3, 4, 7, 9, 10

    }

    /*
    *
    * If total 5 element are there in stream
    *   How to get first 3 element of stream    = limit(3)
    *   How to get last 4 element of stream     = skip(5-4)
    *
    * */
    private static void limitDemo() {
        System.out.println("########## Applying limit ###########");
        Stream.of("one", "two", "three", "four", "five")
                .limit(2) // limiting stream for first two element only
                .forEach(System.out::println); // one, two
    }

    private static void skipDemo() {
        System.out.println("########## Applying skip ###########");
        Stream.of("one", "two", "three", "four", "five")
                .skip(2) // skipping first two element of stream
                .forEach(System.out::println); // three, four, five
    }

    private static void peekDemo() {
        /*
        // it won't work, we need to apply a terminal operation over stream, to execute intermediate operation - peek()
        Stream.of("one", "two", "three", "four", "five")
                .peek(value -> System.out.println(value));
        */
        System.out.println("######### Applying peek ###########");
        List<String> list = Stream.of("one", "two", "three", "four", "five")
                .filter(e -> e.length() > 3) // three, four, five
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList());

        System.out.println("list = " + list);
    }


    /*
     * https://www.javaprogramto.com/2020/04/how-to-compare-two-arraylist-for-equality-in-java.html
     * */
    private static void compareTwoStreams() {

        List<Integer> list1 = Arrays.asList(23, 17, 8, 12, 5, 6, 9, 16, 2);
        List<Integer> list2 = Arrays.asList(23, 17, 8, 12, 5, 6, 9, 16, 2);


        boolean isEqualAllValues = list1.containsAll(list2);
        System.out.println("isEqualAllValues = " + isEqualAllValues);

        List<Integer> unavailable = list1.stream().filter(e -> (list2.stream().filter(d -> d.equals(e)).count()) < 1)
                .collect(Collectors.toList());

        if (unavailable.size() == 0) {
            System.out.println("list1 and list2 all values same.");
        } else {
            System.out.println("list1 and list2 all values are not  same.");
        }
    }

}
