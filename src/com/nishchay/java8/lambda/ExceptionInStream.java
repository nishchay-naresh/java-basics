package com.nishchay.java8.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;


/*
 * Dealing with checked exceptions in Stream
 * You have three primary approaches:
 *	1. Add a try/catch block to the lambda expression
 *	2. Create an extracted method, as in the unchecked example
 *	3. Write a wrapper method that catches checked exceptions and rethrows them as unchecked
 *
 * https://www.oreilly.com/content/handling-checked-exceptions-in-java-streams/
 * */

public class ExceptionInStream {

    private static final List<Integer> items = Arrays.asList(1, 2, 3, 4, 0);

    public static void main(String[] args) {

//        uncheckedExceptionEx();

        checkedExceptionEx_tryCatch();
        checkedExceptionEx_wrapperMethod();
        checkedExceptionEx_java8Wrapper();

    }

    private static void uncheckedExceptionEx() {

        // no exception handling required for unchecked exception
        items.stream().map(e -> dummyMethod(e)).forEach(System.out::println);
    }

    public static Integer dummyMethod(Integer value) throws RuntimeException {
        if (value == 0) {
            throw new RuntimeException();
        } else {
            return value + value;
        }
    }

    private static void checkedExceptionEx_tryCatch() {

        // exception handling required for checked exception - try/catch approach
        items.stream().map(e -> {
            try {
                return dummyMethod1(e);
            } catch (Exception ex) {
                System.out.println("Got exception " + ex);
            }
            return -1; // default
        }).forEach(System.out::println);

    }

    private static void checkedExceptionEx_wrapperMethod() {

        // exception handling required for checked exception - wrapper method approach
        items.stream().map(e -> wrapperMethod(e)).forEach(System.out::println);
    }

    private static Integer wrapperMethod(Integer input) {
        try {
            return dummyMethod1(input);
        } catch (Exception ex) {
            System.out.println("Got exception " + ex);
        }
        return -1; // default
    }


    private static void checkedExceptionEx_java8Wrapper() {

        Function<Integer, Integer> dummyMethodWrapper = item -> {
            try {
                return dummyMethod1(item);
            } catch (Exception e) {
                System.out.println("Got exception " + e);
            }
            return 100; // default
        };

        items.stream().map(dummyMethodWrapper).forEach(System.out::println);
    }

    public static Integer dummyMethod1(Integer value) throws Exception {
        if (value == 0) {
            throw new Exception("invalid value");
        } else {
            return value + value;
        }
    }

}
