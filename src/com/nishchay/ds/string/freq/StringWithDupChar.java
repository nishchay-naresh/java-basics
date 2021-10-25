package com.nishchay.ds.string.freq;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
/*
 * Problem - find the first recurring character in given String
 * Examples
 * if given String is "ABCDA" return "A"
 * if given String is "ABCDAB" return "A"
 * if given String is "ABBCDA" return "B"
 * if given String is "ABCD" return null
 */

public class StringWithDupChar {
    GoogleCode code;

    @Before
    public void init() {
        code = new GoogleCode();
    }

    @Test
    public void testBrutForceSolution() {
        assertEquals("A", code.bruteForce("ABCDA"));
        assertEquals("A", code.bruteForce("ABCDAB"));
        assertEquals("B", code.bruteForce("ABBCDA"));
        assertEquals(null, code.bruteForce("ABCD"));
    }

    @Test
    public void testUsingMapSolution() {
        assertEquals("A", code.usingMap("ABCDA"));
        assertEquals("A", code.usingMap("ABCDAB"));
        assertEquals("B", code.usingMap("ABBCDA"));
        assertEquals(null, code.usingMap("ABCD"));
    }

    @Test
    public void testUsingSetSolution() {
        assertEquals("A", code.usingSet("ABCDA"));
        assertEquals("A", code.usingSet("ABCDAB"));
        assertEquals("B", code.usingSet("ABBCDA"));
        assertEquals(null, code.usingSet("ABCD"));
    }
}


class GoogleCode {

    public String bruteForce(String input) {
        char[] characters = input.toCharArray();
        String firstRecurringCharacter = null;
        int firstRecurringIndex = input.length() - 1;

        for (int i = 0; i < characters.length; i++) {
            char ch = characters[i];

            for (int j = i + 1; j map = new HashMap<>();
            for (Character ch : chars) {
                Integer count = map.get(ch);
                if (count == null) {
                    map.put(ch, 1);
                } else {
                    return "" + ch;
                }

            }
            return null;
        }

        public String usingSet (String input){
            char[] chars = input.toCharArray();
            Set setOfCharacters = new HashSet<>();
            for (Character ch : chars) {

                // if character is already present then
                // this method will return false and that
                // would be our first recurring character
                if (!setOfCharacters.add(ch)) {
                    return "" + ch; // return String for simplicity
                }
            }
            return null;
        }
    }

