package com.nishchay.java8.fun;

import java.util.function.BiFunction;

/*
 *  BiFunction<T, U, R> f = t + u = r
 * R apply(T t, U u)
 *      – Applies this function to the given arguments and produces results.
 * default BiFunction andThen(Function after)
 *      – Returns a composed function that first applies this function to its input, and then applies the after function to the result.
 *
 *
 * */
public class BiFunctionEx {

    public static void main(String[] args) {

        biFunctionBasicEx();

//        hashMapComputeWithBiFunctionEx();
//        hashMapMergeReplaceAllEx();
//        hashMapPrintEx();

    }




    private static void biFunctionBasicEx() {

        // a basic apply() example
        BiFunction<Integer, Integer, Integer> funAdd = (a, b) -> a + b;
        System.out.println(funAdd.apply(10, 20)); // 30

        BiFunction<Integer, Integer, Integer> funMult = (a, b) -> a * b;
        System.out.println(funMult.apply(4, 9)); // 36

        BiFunction<String, String, Integer> funAdd1 = (s1, s2) -> s1.length() + s2.length();
        System.out.println(funAdd1.apply("java", "8")); // 5

    }

}
