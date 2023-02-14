package com.nishchay.java8.fun;

import java.util.HashMap;
import java.util.Map;
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

        hashMapComputeWithBiFunctionEx();
        hashMapMergeReplaceAllEx();
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


    // BiFunction with compute and computeIfPresent Example
    private static void hashMapComputeWithBiFunctionEx() {

        Map<Integer, String> hashMap = new HashMap<>();

        String defaultUser = "Anonymous";
        hashMap.put(7, "Peter");
        hashMap.put(5, "Philip");
        hashMap.put(2, "Martin");
        hashMap.put(4, null);
        System.out.println("Initial HashMap: " + hashMap);

        // Using compute(key, BiFunction)
        //hashMap.compute(4, (key, oldValue) -> oldValue.concat(msg));// throws NPE

        BiFunction<Integer, String, String> f1 = (key, oldValue) -> oldValue == null ? defaultUser : oldValue.toUpperCase();
        hashMap.compute(4, f1);

        hashMap.compute(2, f1);
        System.out.println("HashMap post compute() => " + hashMap);

        // Using computeIfPresent(key, BiFunction)
        String msg = "Hello ";
        BiFunction<Integer, String, String> f2 = (key, oldValue) -> msg + oldValue + "!";
        hashMap.computeIfPresent(7, f2);
        hashMap.computeIfPresent(3, f2);
        System.out.println("HashMap using computeIfPresent() => " + hashMap);

    }

    // BiFunction with merge and replaceAll Example
    private static void hashMapMergeReplaceAllEx() {

        Map<Integer, String> hashMap = new HashMap<>();
        String msg = " King";

        hashMap.put(7, "Peter");
        hashMap.put(5, "Philip");
        hashMap.put(2, "Martin");
        hashMap.put(4, null);
        System.out.println("Initial HashMap: " + hashMap);

        // Using merge(key, value, BiFunction)
        BiFunction<String, String, String> f = (old, given) -> given.concat(msg);
        hashMap.merge(7, "Arthur", f);
        hashMap.merge(2, "Martin", f);
        hashMap.merge(4, "Luther", f);
        hashMap.merge(6, "Robert", f);
        System.out.println("HashMap using merge() => " + hashMap);

        // using replaceAll(key, value, BiFunction)
        BiFunction<Integer, String, String> f2 = (key, value) -> value.replace(msg, "");
        hashMap.replaceAll(f2);
        System.out.println("HashMap using replaceAll() => " + hashMap);
    }

}
