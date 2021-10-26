package com.nishchay.ds.string.freq;

import java.util.HashSet;
import java.util.Set;

/*
 * Problem - test a string , whether it contains only unique chars
 *
 * Examples
 *		if given String is "java" return false
 * 		if given String is "perl" return true
 * 		if given String is "apple" return false
 * 		if given String is "orange" return false
 * */
public class StringWithUniqueChars {


    public static void main(String[] args) {

        System.out.println("isUniqueCharsOnlyHashSet(\"java\") - " + isUniqueCharsOnlyHashSet("java"));
        System.out.println("isUniqueCharsOnlyHashSet(\"perl\") - " + isUniqueCharsOnlyHashSet("perl"));

        System.out.println("isUniqueCharsOnlyHashSet(\"apple\") - " + isUniqueCharsOnlyHashSet("apple"));
        System.out.println("isUniqueCharsOnlyHashSet(\"orange\") - " + isUniqueCharsOnlyHashSet("orange"));

        System.out.println("isUniqueCharsOnlyStream(\"apple\") - " + isUniqueCharsOnlyStream("apple"));
        System.out.println("isUniqueCharsOnlyStream(\"orange\") - " + isUniqueCharsOnlyStream("orange"));

    }

    private static boolean isUniqueCharsOnlyHashSet(String str) {

        Set<Character> hashSet = new HashSet<>();

        for (char c : str.toCharArray()) { //iterate through character array
            if (!hashSet.add(c))//try to add each char to hashSet
                return false; //return false if could not add
        }
        return true;
    }


    private static boolean isUniqueCharsOnlyStream(String str) {
        return str.length() == str.chars().distinct().count();
    }
}
