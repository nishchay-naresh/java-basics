package com.nishchay.java8;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java9Onward {

    public static void main(String[] args) {

        java9Addition();
        java12Addition();
    }


    private static void java9Addition() {
        streamApi();
        optionalClazz();
    }

    private static void java12Addition() {
        switchExprEx();
    }

    // Stream API: takeWhile(), dropWhile(), and an improved iterate() method.
    private static void streamApi() {
        List<Integer> list = List.of(2, 4, 6, 1, 5, 8);
        List<Integer> result = list.stream()
                .takeWhile(i -> i % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("result = " + result);   // Output: [2, 4, 6]

        result = list.stream()
                .dropWhile(i -> i % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("result = " + result);  // Output: [1, 5, 8]

        //  Stream.iterate() that allows bounded iteration.
        Stream.iterate(1, i -> i <= 100, i -> i * 2)
                .forEach(e -> System.out.print(e + ","));      // Output: 1, 2, 4, 8, 16, 32, 64
    }

    // Optional class: ifPresentOrElse(), or(), and stream().
    private static void optionalClazz() {

        Optional<String> name = Optional.of("java9");
        name.ifPresentOrElse(
                value -> System.out.println("Found: " + value),
                () -> System.out.println("Not found")
        );                                              // Output: Found: java9

        Optional<String> primary = Optional.empty();
        Optional<String> fallback = primary.or(() -> Optional.of("Default"));
        System.out.println(fallback.get());         // Output: Default

        name = Optional.of("java9");
        name.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);      // Output: JAVA9
    }

    enum Days {
        MONDAY,
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY,
        SUNDAY
    }


    /*
    * Java 12 introduced Switch Expressions
    *  Allowing switch to be used as an expression that returns a value.
    *  This makes code more concise, less error-prone, and easier to maintain.
    *
    * */
    private static void switchExprEx() {

        Days day = Days.FRIDAY;
        // Switch Expression with yield
        String result = switch (day) {
            case MONDAY, TUESDAY:
                yield "Workday";
            case SUNDAY:
                yield "Weekend";
            default:
                yield "Unknown";
        };
        System.out.println("result = " + result);

        day = Days.SUNDAY;
        // Switch Expression with Arrow Syntax
        result = switch (day) {
            case MONDAY, TUESDAY -> "Workday";
            case SUNDAY -> "Weekend";
            default -> "Unknown";
        };
        System.out.println("result = " + result);
    }
}
