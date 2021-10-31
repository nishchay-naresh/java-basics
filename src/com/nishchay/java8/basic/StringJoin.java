package com.nishchay.java8.basic;

import java.util.List;
import java.util.Arrays;

public class StringJoin {

    public static void main(String[] args) {

        String counting = String.join(" >> ", "Four", "Five", "Six", "Seven");
        System.out.println(counting);

        String statement = String.join("  ", "Java", "is", "a", "programming", "language");
        System.out.println(statement);

        String sequence = String.join(" -> ", "Wake up", "Eat", "Work", "Sleep");
        System.out.println(sequence);

        sequence = String.join(" -> ", "Wake up", "Eat", null, "Work", "Sleep", null);
        System.out.println(sequence);

//        String str = String.join(null, "abc", "bcd", "apple");
//        System.out.println(str); // Exception in thread "main" java.lang.NullPointerException

        //Converting an array of String to the list
        List<String> list = Arrays.asList("Steve", "Rick", "Peter", "Abbey");
        String names = String.join(" | ", list);
        System.out.println(names);


    }
}
