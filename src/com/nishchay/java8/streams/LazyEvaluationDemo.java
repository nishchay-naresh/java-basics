package com.nishchay.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;


public class LazyEvaluationDemo {

    public static void main(String[] args) {

        eagerEvaluation_logicalOp();
        lazyEvaluationUsingSupplier();

        eagerEvaluation_collection();
        lazyEvaluationInStream();

    }

    /*
    * irrespective of short-circuiting resulting(any value of x), we are always evaluating temp
    * */
    private static void eagerEvaluation_logicalOp() {
        int x = 4;
        int temp = compute(x);
        if (x > 5 && temp > 5) {
            System.out.println("result");
        } else {
            System.out.println("no result");
        }
    }

    public static int compute(int number) {
        System.out.println("compute...");
        return number;
    }

    /*
     * now based short-circuiting resulting, we are evaluating temp
     * if we need temp value then ony we are evaluating Supplier, so lazily calling compute
     * */
    private static void lazyEvaluationUsingSupplier() {
        int x = 4;
        Supplier<Integer> temp = () -> compute(x);
        if (x > 5 && temp.get() > 5) {
            System.out.println("result");
        } else {
            System.out.println("no result");
        }
    }


    private static void eagerEvaluation_collection() {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 5, 4, 6, 7, 8, 9, 10);
        //given an ordered list find the double of the first even number greater than 3.

        int result = 0;
        for(int e : numbers) {
            if(e > 3 && e % 2 == 0) {
                result = e * 2;
                break;
            }
        }
        System.out.println("result - " + result);

        result = numbers.stream()
                .filter(e -> e > 3)
                .filter(e -> e % 2 == 0)
                .map(e -> e * 2)
                .findFirst()
                .orElse(0);

        System.out.println("result - " + result);
    }
    /*
     *
     * applying one operation over entire collection
     * vs
     * applying all the operation over each element of collection
     * slicing it differently
     *
     * */
    private static void lazyEvaluationInStream() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 5, 4, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20);

        //given an ordered list find the double of the first even number greater than 3.

        int result = 0;
        for(int e : numbers) {
            if(isGT3(e) && isEven(e)) {
                result = doubleIt(e);
                break;
            }
        }
        System.out.println(result);
        /*
        * does not execute a function on a coz collection of data
        * instead it executes a collection of function on each piece of data, but only as much as necessary
        *
        * */
        //how much work? -  8 units of work/ computations
        System.out.println(
                numbers.stream()
                        .filter(LazyEvaluationDemo::isGT3)      // 1,2,3,4
                        .filter(LazyEvaluationDemo::isEven)     // -> 1,2,3
                        .map(LazyEvaluationDemo::doubleIt)      // -> 5
                        .findFirst());
        // here it's a single pass through
        // if we are not applying terminal operation then this pipeline will never get evaluated
        // you are more efficient, not when you work faster, but when you don't work at all.
        // lazy evaluation is possible only if the functions don't have side effect (like sysout)
    }

    public static boolean isGT3(int number) {
        System.out.println("isGT3 " + number);
        return number > 3;
    }
    public static boolean isEven(int number) {
        System.out.println("isEven " + number);
        return number % 2 == 0;
    }
    public static int doubleIt(int number) {
        System.out.println("doubleIt " + number);
        return number * 2;
    }

}
