package com.nishchay.java8.streams;

import com.nishchay.util.pojo.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NonTerminalOperationDemo {

    public static void main(String[] args) {
        createAndPrint();
        distinctDemo();
        sortedDemo();
        filterDemo();
        limitAndSkipDemo();
        peekDemo();
        mapDemo();
        mapFilterEX();
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
     * distinct() - removing duplicates, keeping only one copy i.e., distinct numbers
     * */
    private static void distinctDemo() {
        System.out.println("########## List after applying distinct() ###########");
        List<Integer> numbers = Arrays.asList(3, 2, 3, 5, 2, 9, 4, 9, 3);
        List<Integer> uniques = numbers.stream().distinct().collect(Collectors.toList());
        System.out.println("uniques = " + uniques); // [3, 2, 5, 9, 4]
    }

    /*
     *  sorted() - sorted according to natural order
     * */
    private static void sortedDemo() {
        System.out.println("########## sorted view of the stream ###########");
        Stream.of(1, 4, 2, 7, 9, 10, 3)
                .sorted()
                .forEach(s -> System.out.print(s + ", ")); // 1, 2, 3, 4, 7, 9, 10
    }

    /*
     *   filter() - Returns a stream of elements that match the given predicate.
     *            - elements that meet the predicate will through
     * */
    private static void filterDemo() {
        System.out.println("\n########## applying filter operation over stream ###########");
        List<Integer> numbers = Arrays.asList(3, 2, 3, 5, 2, 9, 4, 9, 3);
        List<Integer> evens = numbers.stream().filter(e -> e % 2 == 0).collect(Collectors.toList());
        System.out.println("evens = " + evens); // [2, 2, 4]

        Stream.of("ONE", "two", "THREE", "four", "FIVE")
                .filter(value -> value.length() > 3)
                .forEach(e -> System.out.print(e + ", "));
    }


    /*
     *
     *   limit(n)   -   cutting a stream from left/start
     *              -   limiting(shrinking) a stream to first n elements
     *
     *   skip(n)    -   cutting a stream from right/end
     *              -   skipping(eliminating) first n elements of a stream
     *
     * If total 5 elements are there in stream
     *   How to get the first 3 elements of stream      = limit(3)
     *   How to get last 4 elements of stream           = skip(5-4)
     *
     * */
    private static void limitAndSkipDemo() {
        System.out.println("\n########## Applying limit ###########");
        Stream.of("one", "two", "three", "four", "five")
                .limit(2) // limiting stream for first two elements only
                .forEach(System.out::println); // one, two

        System.out.println("########## Applying skip ###########");
        Stream.of("one", "two", "three", "four", "five")
                .skip(2) // skipping first two element of stream
                .forEach(System.out::println); // three, four, five
    }

    /*
     * Stream<T> peek(Consumer<T> action) - return the same stream, just applying the given consumer over them
     *   -   peek() lets you look at elements flowing through the stream and perform an action on them without changing the element.
     *   -   Think of it as a debug hook in the stream pipeline, Mainly used for debugging, logging
     *   -   It is an intermediate operation
     *   -   It is lazy (runs only when a terminal operation is called)
     *   -   It does NOT transform elements
     *   -   It should NOT be used for business logic
     *   -   WRONG Use: Mutating Objects (Common Mistake)
     *           .peek(s -> s.setStatus("ACTIVE"))
     *   -   If you are changing data, use map() — not peek()
     *
     *  below code won't execute until we apply a terminal operator
     *       Stream.of("one", "two", "three", "four", "five").peek(value -> System.out.println(value));
     *
     * */
    private static void peekDemo() {

        System.out.println("######### Applying peek ###########");
        List<String> list = Stream.of("one", "two", "three", "four", "five")
                .filter(e -> e.length() > 3) // three, four, five
                .peek(e -> System.out.print("Filtered value: " + e + ", "))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList());

        System.out.println("list = " + list);
    }

    /*
     * map() - map/transform a sequence of input to sequence of output
     *   - gives same no of output as no of input
     *   - since doing a transformation, that is why taking Function<T, R> as input
     *
     * For primitive, below variant of map() can be used :
     *  mapToInt(), mapToDouble(), mapToLong()
     *
     * */
    private static void mapDemo() {
        System.out.println("########## applying map operation over stream ###########");
        Stream.of("ONE", "two", "THREE", "four", "FIVE")
                .map(String::toLowerCase)
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }


    private static void mapFilterEX() {
        List<String> names;

        names = Dish.menu.stream()
                .filter(d -> d.getCalories() > 500)
                .map(Dish::getName)
                .collect(Collectors.toList());
        System.out.println("names = " + names);

        /*
        // descriptive way to write filter() & map() - putting more statements
        // printing intermediate values - a debugging technique
        names = Dish.menu.stream()
                .filter(d -> {
                            System.out.println("filtering - " + d.getName());
                            return d.getCalories() > 500;
                        }
                )
                .map(d -> {
                            System.out.println("mapping - " + d.getName());
                            return d.getName();
                        }
                )
                .collect(Collectors.toList());
        System.out.println("names = " + names);
        */
    }
}
