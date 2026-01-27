package com.nishchay.java8.streams.basics;


import com.nishchay.util.pojo.Dish;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
 * reduce() - combines multiple elements of a stream into a single result using an accumulator function
 * Think reduce()  many-to-one    Stream<T> ===> V v
 *
 * Suitable for a use-case like:
 * 	-	sum of numbers
 * 	-	max / min element
 * 	-	merge objects
 * 	-	aggregate values
 *
 * There are 3 overloaded versions:
 *	Optional<T> reduce(BinaryOperator<T> accumulator)
 *		-	No initial value
 *		-	Returns Optional
 *		-	Empty stream → Optional.empty()
 *
 *	T reduce(T identity, BinaryOperator<T> accumulator)
 *		-	identity = starting value
 *		-	Safe for empty streams
 *		-	No Optional
 *
 *  U reduce(U identity, BiFunction<U, T, U> accumulator, BinaryOperator<U> combiner) - mainly for parallel streams
 *
 * --------------------------------------------------
 *
 *  map()     one-to-one     Stream<T> ===> Stream<Y>
 *  map()     one-to-many    Stream<T> ===> Stream<List<Y>>
 *  flatMap() many-to-one    Stream<List<E>> ===> Stream<E>
 *               .flatMap(e -> e.stream()) => Stream<collection/array of E> ===> Stream<E>
 *  reduce()  many-to-one    Stream<T> ===> V v
 *
 * */
public class A04ReduceDemo {

    public static void main(String[] args) {
        intStreamReduceEx();
        System.out.println(".............................................");
        stringWithMaxLengthUsingReduce();
        System.out.println(".............................................");
        reduceEx();
    }

    private static void intStreamReduceEx() {

        // Applying to reduce over IntStream
        int sum = IntStream.range(1, 6).sum();
        System.out.println("sum(1 to 5) = " + sum);

        sum = IntStream.of(1, 2, 3, 4, 5).reduce((a, b) -> a + b).orElse(0);
        System.out.println("sum = " + sum);

        sum = IntStream.of(1, 2, 3, 4, 5).reduce(0, Integer::sum);
        System.out.println("sum = " + sum);

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        // Applying to reduce over Stream of Integer - get sum
        sum = numbers.stream().reduce(Integer::sum).orElse(0);
        System.out.println("sum = " + sum);

        // Applying to reduce over Stream of Integer - get max/min
        int max = numbers.stream().reduce(0, (a, b) -> a > b ? a : b);
        System.out.println("max = " + max);

        max = numbers.stream().reduce(Integer::min).orElse(0);
        System.out.println("min = " + max);
    }

    private static void stringWithMaxLengthUsingReduce() {
        List<String> languages = Arrays.asList("java", "python", "go", "perl", "ruby", "kafka");

        //reduce - the longest name
        String aLongName =
                languages.stream()
                        .reduce((name1, name2) -> name1.length() >= name2.length() ? name1 : name2)
                        .orElse(null);
        System.out.println("A longest name : " + aLongName);

        //reduce - with some initial value
        final String assemblyOrLonger =
                languages.stream()
                        .reduce("assembly", (n1, n2) -> n1.length() >= n2.length() ? n1 : n2);
        System.out.println("assemblyOrLonger = " + assemblyOrLonger);


        // Applying to reduce over Stream of String -  to concatenate
        String strConcat = Stream.of("one", "two", "three", "four", "five")
                .reduce("CountDown : ", (a, b) -> a + ", " + b);
        System.out.println(strConcat);

        // Applying to reduce over Stream of String -  to get char counts (sum of string length)
        int charCount = languages.stream()
                .map(String::length)
                .reduce(0, Integer::sum);
        System.out.println("charCount - " + charCount);
    }

    private static void reduceEx() {

        int totalCalories = Dish.getManu().stream().map(Dish::getCalories).mapToInt(i -> i).sum();
        System.out.println("totalCalories = " + totalCalories);
        totalCalories = Dish.getManu().stream().map(Dish::getCalories).reduce(0, Integer::sum);
        System.out.println("totalCalories = " + totalCalories);

        totalCalories = Dish.getManu()
                .stream()
                .collect(Collectors.reducing(0, Dish::getCalories, Integer::sum));
        System.out.println("totalCalories = " + totalCalories);


        Optional<Dish> mostCalorieDish = Dish.getManu()
                .stream()
                .max(Comparator.comparingInt(Dish::getCalories));
        System.out.println("mostCaloriesDish = " + mostCalorieDish.orElse(null));

        mostCalorieDish = Dish.getManu()
                .stream()
                .reduce((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2);

        System.out.println("mostCaloriesDish = " + mostCalorieDish.orElse(null));
    }
}
