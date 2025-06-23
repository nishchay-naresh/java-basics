package com.nishchay.java8.basic.methodref;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class MethodReferenceEx {

    public static void main(String[] args) {

        basicEx();
        soringEx();
        forEachEx();
    }


    /*
     * Method reference syntax is same for both - instance method & static method
     * based on context compiler is good enough to identify respective method invocation
     *
     * there is one caveat - method collision and resulting ambiguity
     *  if we have two method with same signature, static & instance, we will get compilation error, bcus of ambiguity
     *
     * */
    private static void basicEx() {

        List<String> stringList = Arrays.asList("java", "python", "go");

        /*
         * method reference to static method
         *      public static String valueOf(Object obj) {}
         *
         * */
        stringList.stream()
                .map(String::valueOf)
                .forEach(System.out::println);

        /*
         * method reference to instance method
         *       public int length() {}
         * */
        stringList.stream()
                .map(String::length)
                .forEach(System.out::println);
    }

    private static void soringEx() {
        String[] stringArray = {"Steve", "Rick", "Andy", "Nathan", "Lucy", "Simon", "Jon"};

        System.out.println("Original list   = " + Arrays.toString(stringArray));
        Arrays.sort(stringArray, String::compareToIgnoreCase);
        System.out.println("Sorted list     = " + Arrays.toString(stringArray));
    }

    private static void forEachEx() {
        List<String> stringList =  Arrays.asList("Rohit", "Shikhar", "Kohli", "Iyyar", "Rahul");

        Stream<String> strStream = stringList.stream();
        strStream.forEach(e -> System.out.print(e + ", "));

        // stringList.forEach(s -> System.out.println(s));
        stringList.forEach(System.out::println);
    }

}
