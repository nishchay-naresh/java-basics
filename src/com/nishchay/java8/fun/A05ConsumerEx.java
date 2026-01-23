package com.nishchay.java8.fun;

import java.util.Arrays;
import java.util.Date;
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
 *  primitive Consumer: DoubleConsumer, IntConsumer and LongConsumer, BooleanConsumer
 *  receive primitive values as arguments
 *
 *  https://javabydeveloper.com/java-8-consumer-with-examples/
 *
 * */

public class A05ConsumerEx {
    public static void main(String[] args) {
        consumerEx();
        forEachConsumerEx();
        andThenEx();
        primitiveConsumerEx();
    }

    /*
     *  java.util.function.Consumer<T>	:    T -> void  :	void accept(T t);
     *
     *   accept() - Performs this operation on the given argument.
     * */
    private static void consumerEx() {
        Consumer<String> strConsumer = x -> System.out.println(x + "-8");
        Consumer<String> consumerString = s -> System.out.println(s.toUpperCase());
        Consumer<Integer> intConsumer = i -> System.out.println(5 * i);

        strConsumer.accept("java"); // java-8
        consumerString.accept("Functional Programming");// FUNCTIONAL PROGRAMMING
        intConsumer.accept(4); // 20
    }

    // Same forEach method to accept Consumer as an argument
    private static void forEachConsumerEx() {
        Consumer<Integer> consumerPrintElement = e -> System.out.print(" " + e);
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        numbers.forEach(consumerPrintElement);

        Map<String, Integer> ages = new HashMap<>();
        ages.put("John", 25);
        ages.put("Freddy", 24);
        ages.put("Samuel", 30);
        System.out.println();
        ages.forEach((key, value) -> System.out.println(key + " is " + value + " years old"));
    }

    /*
     * andThen(Consumer<? super T> after) - Returns a composed Consumer that performs, in sequence, this operation followed by the after operation.
     *
     * */
    private static void andThenEx() {
        Consumer<Integer> fiveTimes = i -> System.out.println(5 * i);
        Consumer<Integer> addFive = i -> System.out.println(5 + i);

        fiveTimes.andThen(addFive).accept(4); // 20, 9
        System.out.println("");
        addFive.andThen(fiveTimes).accept(5); //10, 25
        System.out.println("");
        fiveTimes.andThen(i -> System.out.println(3 * i)).accept(4); // 20, 12
    }

    /*
     *  primitive Consumer : DoubleConsumer, IntConsumer and LongConsumer, BooleanConsumer
     *  receive primitive values as arguments
     *
     *      IntConsumer  – Consumer operation accepts single int-valued.  void accept(int value)
     *      LongConsumer – Consumer operation accepts single long-valued void accept(long value)
     *      DoubleConsumer – Represents a Consumer operation accepts single double-valued void accept(double value)
     *      BooleanConsumer  – Represents a Consumer operation accepts single  boolean-valued void accept(boolean value)
     *
     * */
    private static void primitiveConsumerEx() {
        Consumer<Integer> c1 = i -> System.out.println(5 * i);
        Consumer<Long> c2 = i -> System.out.println(i);
        Consumer<Double> c3 = i -> System.out.println(i + 20.0);
        Consumer<Boolean> c4 = i -> System.out.println(i);

        c1.accept(10);
        c2.accept(new Date().getTime());
        c3.accept(50.20);
        c4.accept(10 % 2 == 0);
    }
}
