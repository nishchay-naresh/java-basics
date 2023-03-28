package com.nishchay.java8.fun;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;


/*
 *	java.util.function.Consumer<T>	:    T -> void  :	void accept(T t);
 *	T – Type of input argument
 *  As opposed to the Supplier, the Consumer accepts a generified argument and returns nothing
 *
 *
 *  For primitive : DoubleConsumer, IntConsumer and LongConsumer, BooleanConsumer
 *  receive primitive values as arguments
 *
 *  https://javabydeveloper.com/java-8-consumer-with-examples/
 *
 * */

public class ConsumerEx {

    public static void main(String[] args) {

        consumerEx();
        forEachConsumerEx();
        consumerToPrint();

    }



    /*
    *  java.util.function.Consumer<T>	:    T -> void  :	void accept(T t);
    *
    *   accept() - Performs this operation on the given argument.
    * */
    private static void consumerEx() {

        Consumer<String> strConsumer = x ->  System.out.println(x + "-8");
        Consumer<String> consumerString = s -> System.out.println(s.toUpperCase());
        Consumer<Integer> intConsumer = i -> System.out.println(5*i);

        strConsumer.accept("java"); // java-8
        consumerString.accept("Functional Programming");// FUNCTIONAL PROGRAMMING
        intConsumer.accept(4); // 20
    }

    // Same forEach method to accept Consumer as an argument
    private static void forEachConsumerEx() {
        Consumer<Integer> consumerPrintElement = e -> System.out.print(" " + e);

        List<Integer> list = Arrays.asList(1, 3, 5, 8, 2);
        System.out.print("list data - ");
        list.stream().forEach(consumerPrintElement);
    }

    private static void consumerToPrint() {
        Map<String, Integer> ages = new HashMap<>();
        ages.put("John", 25);
        ages.put("Freddy", 24);
        ages.put("Samuel", 30);
        System.out.println();
        ages.forEach((key, value) -> System.out.println(key + " is " + value + " years old"));
    }

}
