package com.nishchay.java8.basic;

import java.util.List;
import java.util.Arrays;

public class StringJoin {

    /*
    *
    * String join(CharSequence delimiter, CharSequence... elements)
    * Returns a new String composed of copies of the CharSequence elements joined together with a copy of the specified delimiter.
    *
    * NullPointerException – If delimiter is null,  if an element is null, then "null" is added.
    * */
    public static void main(String[] args) {

        String counting = String.join(" >> ", "Four", "Five", "Six", "Seven");
        System.out.println(counting);

        String statement = String.join("  ", "Java", "is", "a", "programming", "language");
        System.out.println(statement);

        String sequence = String.join(" -> ", "Wake up", "Eat", "Work", "Sleep");
        System.out.println(sequence);

        sequence = String.join(" -> ", "Wake up", "Eat", null, "Work", "Sleep", null);
        System.out.println(sequence);

//        String str = String.join(null, "Four", "Five", "Six");
//        System.out.println(str); // Exception in thread "main" java.lang.NullPointerException

        List<String> list = Arrays.asList("java", "python", "go", "perl", "ruby", "node");
        String names = String.join(" | ", list);
        System.out.println(names);

    }
}
