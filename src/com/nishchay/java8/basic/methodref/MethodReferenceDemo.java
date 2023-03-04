package com.nishchay.java8.basic.methodref;

import java.util.Arrays;
import java.util.List;

public class MethodReferenceDemo {

    public static void main(String[] args) {

        basicEx();
        soringEx();
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
         * method reference to instance method
         *       public String toString() {}
         * */
        stringList.stream()
                .map(String::valueOf)
                .forEach(System.out::println);

        /*
         * method reference to static method
         *      public static String valueOf(Object obj) {}
         * */
        stringList.stream()
                .map(String::toString)
                .forEach(System.out::println);

    }

    private static void soringEx() {
        String[] stringArray = {"Steve", "Rick", "Andy", "Nathan", "Lucy", "Simon", "Jon"};

        Arrays.sort(stringArray, String::compareToIgnoreCase);

        for (String str : stringArray) {
            System.out.println(str);
        }
    }

}
