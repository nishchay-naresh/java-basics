package com.nishchay.ds.string.freq;

import java.util.HashSet;


/*
 *	=========== Find the first repeated character in a string ===========
 *
 *	Given a string, Write a code to find the first repeated character in it.
 *
 *	Write an efficient program to print all the duplicates and their counts in the input string
 *
 *	Example 1:
 *		Input: ch = “geeksforgeeks”
 *		Output: e
 *		e is the first element that repeats
 *
 *	Example 1:
 *		Input: str = “hello geeks”
 *		Output: l
 *		l is the first element that repeats
 *
 *
 * https://www.geeksforgeeks.org/find-the-first-repeated-character-in-a-string/
 * https://javarevisited.blogspot.com/2021/10/how-to-find-first-recurring-character.html?m=1
 *
 * */
public class FirstRepeatingCharacter {

    public static void main(String[] args) {

        System.out.println("firstRepeating(\"racecars\") - " +  firstRepeating("racecars")); // c
        System.out.println("firstRepeating(\"ZEBRA\") - " +  firstRepeating("ZEBRA")); // '\0'

        doTestsPass();

    }

    /**
     * boolean doTestsPass()
     * Returns true if all tests pass. Otherwise returns false.
     */
    private static void doTestsPass() {

        // feel free to make testing more elegant
        String[] inputs = {"apple", "pen" ,"racecars", "ababdc", "simplest", "ABCDA", "KBCDYB", "ZONDO", "ZEBRA"};
        char[] outputs = {'p','\0', 'c', 'a', 's', 'A', 'B', 'O', '\0'};

        boolean result = true;
        for (int i = 0; i < inputs.length; i++) {
            result = result && firstRepeating(inputs[i]) == outputs[i];
            if (!result)
                System.out.println("Test failed for: " + inputs[i]);
            else
                System.out.println("Test passed for: " + inputs[i]);
        }
    }


    private static char firstRepeating(String str) {

        HashSet<Character> h = new HashSet<>();
        char c;
        for (int i = 0; i < str.length(); i++) {
            c = str.charAt(i);
            if (h.contains(c))
                return c;
            else
                h.add(c);
        }
        return '\0';
    }

}

