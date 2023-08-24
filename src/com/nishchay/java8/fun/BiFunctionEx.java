package com.nishchay.java8.fun;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

/*
 *
 *  BiFunction<inputType1,inputType2, outputType>
 *  java.util.function.BiFunction<T, U, R>  :    T,U -> R      :	R apply(T t, U u);
 *
 * 1. R apply(T t, U u)
 *      – Applies this function to the given arguments and produces results.
 * 2. default BiFunction andThen(Function after)
 *      – Returns a composed function that first applies this function to its input, and then applies the after function to the result.
 *
 * */
public class BiFunctionEx {
    public static void main(String[] args) {

        biFunctionBasicEx();

        computeWithBiFunctionEx();
        computeIfAbsentWithBiFunctionEx();
        hashMapMergeReplaceAllEx();
        hashMapPrintEx();
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
    private static void computeWithBiFunctionEx() {

        Map<Integer, String> hashMap = new HashMap<>();
        hashMap.put(7, "Peter");
        hashMap.put(5, "Philip");
        hashMap.put(2, "Martin");
        hashMap.put(4, null);
        System.out.println("Initial HashMap: " + hashMap);

        // Using compute(key, BiFunction)
        // hashMap.compute(4, (key, oldValue) -> oldValue.concat(msg));// throws NPE

        // String defaultUser = "Anonymous";
        // BiFunction<Integer, String, String> f1 = (key, oldValue) -> oldValue == null ? defaultUser : oldValue.toUpperCase();

        hashMap.compute(4, (key1, oldValue) -> {
            if(oldValue == null){
                return "Anonymous";
            }else{
                return oldValue.toUpperCase();
            }
        });

        hashMap.compute(2, (key, oldValue) -> {
            if(oldValue == null){
                return "Anonymous";
            }else{
                return oldValue.toUpperCase();
            }
        });

        hashMap.compute(10, (key, oldValue) -> {
            if(oldValue == null){
                return "Anonymous";
            }else{
                return oldValue.toUpperCase();
            }
        });

        System.out.println("HashMap post compute() => " + hashMap);
    }

    private static void computeIfAbsentWithBiFunctionEx() {

        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("One", 1);
        hashMap.put("Two", 2);

        // Using computeIfPresent(key, BiFunction)
        hashMap.computeIfPresent("Two", (key, oldValue) -> oldValue + 100);
        hashMap.computeIfPresent("foo", (key, oldValue) -> oldValue + 1000);
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

    // BiFunction to print map key and values, print number of occurrences of value with suffix
    private static void hashMapPrintEx() {
        Map<Integer, String> m = new HashMap<>();
        m.put(1, "Peter");
        m.put(2, "Mike");
        m.put(3, "John");
        m.put(4, "Mike");
        m.put(5, "Peter");
        m.put(6, "Anand");
        m.put(7, "Peter");

        // Collections.frequency to get number of occurrences
        BiFunction<Integer, String, String> f =
                (key, value) -> "[Key="+key+", "+value+"("+ Collections.frequency(m.values(), value)+")]";

        m.forEach((k,v)-> System.out.println(f.apply(k, v)));
    }
}
