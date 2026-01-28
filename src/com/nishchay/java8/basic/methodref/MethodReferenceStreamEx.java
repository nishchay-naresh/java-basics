package com.nishchay.java8.basic.methodref;

import java.util.Arrays;
import java.util.List;

public class MethodReferenceStreamEx {

    public static void main(String[] args) {
        basicEx();
        sortingEx();
    }

    /*
     * Method reference syntax is same for both - instance method and static method
     * Based on context compiler is good enough to identify the respective method invocation
     *
     * There is one caveat - method collision and resulting ambiguity
     *  If we have two methods with the same signature, static and instance,
     *  We will get compilation error, because of ambiguity
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
                .forEach(e -> System.out.print(e + ", "));
        System.out.println();
        /*
         * method reference to instance method
         *       public int length() {}
         * */
        stringList.stream()
                .map(String::length)
                .forEach(e -> System.out.print(e + ", "));
        System.out.println();
    }

    private static void sortingEx() {
        String[] languages = {"java", "python", "go", "perl", "ruby", "node"};

        System.out.println("Original array   = " + Arrays.toString(languages));
        Arrays.sort(languages, String::compareToIgnoreCase);
        System.out.println("Sorted array     = " + Arrays.toString(languages));
    }

}
