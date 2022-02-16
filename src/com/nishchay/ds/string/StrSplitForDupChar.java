package com.nishchay.ds.string;

import java.util.ArrayList;
import java.util.List;

/*
 *	Write a simple “main” Java program that accepts a string as an argument and prints it out “split”
 *	any time there is a sequence of characters that repeat.
 *	For example - an argument “abbccdee” would print “ab bc cde e”
 *			Explanation - introduce a space for duplicate characters
 *
 * */
public class StrSplitForDupChar {

    public static void main(String[] args) {

        String input = "abbccdee";
        System.out.printf("%s -> %s%n", input, introduceSpace(input));
        System.out.printf("%s -> %s%n", input, strSplitForDup(input));

    }

    private static String introduceSpace(String input) {

        StringBuilder sb = new StringBuilder();
        int len = input.length();
        for (int i = 0; i < len; i++) {
            if (i < len - 1 && input.charAt(i) == input.charAt(i + 1)) {
                sb.append(input.charAt(i));
                sb.append(" ");
            } else {
                sb.append(input.charAt(i));
            }
        }
        return sb.toString();
    }

    private static List<String> strSplitForDup(String input) {

        StringBuilder builder = new StringBuilder();
        List<String> tuples = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            if ( i < input.length()-1 && input.charAt(i) == input.charAt(i+1)){
                builder.append(input.charAt(i)).append(" ");
                tuples.add(builder.toString());
                // flush builder previous content
                builder.setLength(0);
            }else{
                builder.append(input.charAt(i));
            }
        }
        tuples.add(builder.toString());
        return tuples;
    }

}
