package com.nishchay.java8.fun;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 *	java.util.function.Function<T, R>	:	R apply(T t);
 *
 *	T – Type of the input to the function.
 *	R – Type of the result of the function.
 *
 * */
public class FunctionEx {

    public static void main(String[] args) {

//        funAsConcept();
//        funAsParameter();
        System.out.println("------------");
        funIdentityEx();
        identityEx_toMap();
    }




    /*
    *
    * https://mkyong.com/java8/java-8-function-examples/
    * */
    private static void funAsConcept() {

        Function<Integer, Integer> f1 = i -> i*4;
        System.out.println(f1.apply(3));    //12

        Function<Integer, Integer> f2 = i -> i+4;
        System.out.println(f2.apply(3));    //7

        // Function which takes in a number and returns half of it
        Function<Integer, Double> funHalf = a -> a / 2.0;
        System.out.println(funHalf.apply(10));  //5.0


        // Function which takes in a String and returns its length
        Function<String, Integer> funStrLength = x -> x.length();
        System.out.println(funStrLength.apply("java")); // 4

    }

    /*
     * Pass a function as a parameter to another method.
     *
     * If you observe here you will find that - first parameter type, Function parameter type both are same
     * First parameter type = Function parameter
     *
     * https://techndeck.com/how-to-pass-function-as-a-parameter-in-a-method-in-java-8/
     * */
    private static void funAsParameter() {
        Function<Integer, Integer> inc = e -> e + 1;
        doSum(5, inc);

        Function<String, Integer> funStrLength = x -> x.length();
        nameLengthPrint("java", funStrLength);

    }

    public static void doSum(Integer value, Function <Integer, Integer> func) {
        System.out.println(func.apply(value));  //6
    }

    public static void nameLengthPrint(String name, Function <String, Integer> func) {
        System.out.println(func.apply(name));  //4
    }


    /*
    * identity() – Returns a Function that always returns its input argument.
    *
    * https://javabydeveloper.com/java-8-function-and-examples/
    * */
    private static void funIdentityEx() {

        Function<String, String> f1 = x -> x;
        System.out.println(f1.apply("java"));
        Function<Integer, Integer> f2 = x -> x;
        System.out.println(f2.apply(25));

        f1 = Function.identity();
        System.out.println(f1.apply("java"));
        f2 = Function.identity();
        System.out.println(f2.apply(25));

        System.out.println(Function.identity().apply("java"));  //java
        System.out.println(Function.identity().apply(25));  //25

    }

    private static void identityEx_toMap() {

        Map<String, Integer> map =
                Stream.of("java", "python", "go")
                        .collect(Collectors.toMap(Function.identity(), String::length));
                        // .collect(Collectors.toMap(e -> e, e -> e.length()));

        System.out.println("map = " + map);
    }

}
