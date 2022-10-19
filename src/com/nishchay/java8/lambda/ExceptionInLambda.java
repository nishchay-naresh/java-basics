package com.nishchay.java8.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;


/*
 * Dealing with checked exceptions in Stream
 * You have three primary approaches:
 *	1. Add a try-catch block to the lambda expression
 *	2. Create a wrapper method, which extract out the above try-catch block
 *  2.5 Assign thr above extracted method to a Function<Integer, Integer>
 *  3. Write a wrapper method that catches checked exceptions and rethrows them as unchecked
// *
 * https://www.oreilly.com/content/handling-checked-exceptions-in-java-streams/
 * https://dzone.com/articles/how-to-handle-checked-exception-in-lambda-expressi
 * */

public class ExceptionInLambda {

    private static final List<Integer> items = Arrays.asList(1, 2, 3, 4, 0);

    public static void main(String[] args) {

//        uncheckedExceptionEx();

//        checkedExceptionEx_tryCatch();
//        checkedExceptionEx_wrapperMethod();
//        checkedExceptionEx_Function();
        checkedExceptionEx_Casting();

    }


    private static void uncheckedExceptionEx() {

        // no exception handling required for unchecked exception
        items.stream().map(e -> methodThrowsUnchecked(e)).forEach(System.out::println);
    }

    public static Integer methodThrowsUnchecked(Integer value) throws RuntimeException {
        if (value == 0) {
            throw new RuntimeException();
        } else {
            return value + value;
        }
    }

    public static Integer methodThrowsChecked(Integer value) throws Exception {
        if (value == 0) {
            throw new Exception("invalid value");
        } else {
            return value + value;
        }
    }

    /*
    *  exception handling required for checked exception - try/catch approach
    *
    * This works, but makes the code harder to read and understand.
    * Ideally when writing pipeline code, you would like to keep each intermediate operation as a single line.
    * */
    private static void checkedExceptionEx_tryCatch() {

        items.stream().map(e -> {
            try {
                return methodThrowsChecked(e);
            } catch (Exception ex) {
                System.out.println("Got exception " + ex);
            }
            return -1; // default
        }).forEach(System.out::println);

    }

    /*
    *  exception handling required for checked exception - wrapper method approach
    *
    *  create a wrapper method, which extract out the above try-catch block
    * */
    private static void checkedExceptionEx_wrapperMethod() {

        items.stream().map(e -> wrapperMethod(e)).forEach(System.out::println);
    }

    private static Integer wrapperMethod(Integer input) {
        try {
            return methodThrowsChecked(input);
        } catch (Exception ex) {
            System.out.println("Got exception " + ex);
        }
        return -1; // default
    }


    private static void checkedExceptionEx_Function() {

        Function<Integer, Integer> wrapperMethodFun = input -> {
            try {
                return methodThrowsChecked(input);
            } catch (Exception e) {
                System.out.println("Got exception " + e);
            }
            return 100; // default
        };

        items.stream().map(e -> wrapperMethodFun.apply(e)).forEach(System.out::println);
    }


    /*
    * Write a wrapper method that catches checked exceptions and rethrows them as unchecked
    *
    * This casting saves us from all the try-catch handling of the checked exception
    * You program will have a non-gracefully terminate with exception stack stace will be spite on console
    *
    * */
    private static void checkedExceptionEx_Casting() {

        Function<Integer, Integer> funCastException = input -> {
            try {
                return methodThrowsChecked(input);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };

        items.stream().map(e -> funCastException.apply(e)).forEach(System.out::println);

    }


}
