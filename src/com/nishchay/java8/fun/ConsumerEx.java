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
 *  For primitive : DoubleConsumer, IntConsumer and LongConsumer
 *  receive primitive values as arguments
 *
 * */

public class ConsumerEx {

    public static void main(String[] args) {

        forEachConsumerEx();
        consumerToPrint();
    }

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

        ages.forEach((name, age) -> System.out.println(name + " is " + age + " years old"));
    }
}
