package com.nishchay.java8.dp;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class DP02LightWeightStrategy {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("     sum total - " + sumTotal(numbers, e -> true));
        System.out.println("sum total even - " + sumTotal(numbers, e -> e % 2 == 0));
        System.out.println(" sum total odd - " + sumTotal(numbers, e -> e % 2 != 0));
    }

    /*
    * The underlying algorithm is passed through - Predicate<Integer> selector
    * So we can pass the strategy/algorithm through the lambda
    * */
    private static int sumTotal(List<Integer> values, Predicate<Integer> selector) {
        return values.stream()
                .filter(selector)
                .mapToInt(e -> e)
                .sum();
    }

}
