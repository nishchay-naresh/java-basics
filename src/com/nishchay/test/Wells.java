package com.nishchay.test;

import java.util.ArrayList;
import java.util.List;

/*
 *
 * ================ String substitution : ? - a/b ===================
 *
 *
 *	Write a Java8 program:
 *	There are N houses along the street . carbon filters are already installed in some of them.
 *	We would like to install some filters in the remaining houses (those that do not posssess them yet).
 *	Two types of filter , named 'a' and b' are being used .
 *	The filters works best if no three adjacent houses have the same type of filter.
 *	The house are represented as a string of characters 'a','b' and '?'
 *	('a' and 'b' denote a house with a filter of a given type installed ;'?'represents a with house is no filter yet).
 *	Your task is to make a plan of the filter types to be installed in the houses that do not yet have them.
 *
 *	Write a function :
 *	class Solution {
 *		public String[] solution (String s);
 *	}
 *	that, given a String s of length N,
 *	returns a string that is the result of replacing each '?' in the string s with an 'a' or a b' character
 *	and does not contain three identical consecutive letters (in other words, neither "aaa" nor "bbb" may occur in the processed string).
 *
 *	Examples:
 *	I. Given s="a?bb" your function should return "aabb"
 *	2. Given s="??abb" your function should return "ababb","bbabb: or "baabb"
 *	3. Given s="a?bba??aa" your function should return "aabbaabaa" or "aabbabbaa"
 *	4. Given s="aa??aa" your function should return "aabbaa"
 *	Write a efficient algorithm for the following
 *	assumptions:
 *	. String S is made only of the following characters : 'a'
 *	'b' and /or
 *	N is an integer within the range [I ..500,0001;
 *	It is always possible to create a plan so that there are no three identical consecutive filters.
 *
 * Case 5. When ur string have both the ? sequence('?','??') , and the distance between then is less than 3
 * Given s="a?b??aa" your function should return "aababaa" // aab??aa,abb??aa // aab??aa -aababaa //abb??aa-abbabaa,
 *
 * */
public class Wells {

    public static void main(String[] args) {

        String[] inputs = new String[]{"a?bb", "??abb", "aa??aa", "a?bba??aa"};

        for (String input : inputs) {
            List<String> possibleStrings = solution(input);
            System.out.println("input = " + input);
            System.out.println("possibleStrings = " + possibleStrings);
            System.out.println("------------------------------------");
        }
    }

    public static List<String> solution(String str) {
        if (str.contains("??") && str.contains("?")){
            List<String> inputStrings = substituteDoubleQ(str);
            List<String> possibleStrings = new ArrayList<>();
            for (String input : inputStrings) {
                possibleStrings.addAll(substituteSingleQ(input));
            }
            return possibleStrings;
        }
        return str.contains("??") ? substituteDoubleQ(str) : substituteSingleQ(str);
    }

    // substitute single ?, get possible strings
    public static List<String> substituteSingleQ(String input) {
        char[] singleQSubstitutions = new char[]{'a', 'b'};
        List<String> possibleStrList = new ArrayList<>();

        for (char c : singleQSubstitutions) {
            String possibleStr = input.replace('?', c);
            if (isNotHavingTriplets(possibleStr)) {
                possibleStrList.add(possibleStr);
            }
        }
        return possibleStrList;
    }

    // substitute double ??, get possible strings
    public static List<String> substituteDoubleQ(String input) {
        String[] doubleQSubstitutions = new String[]{"aa", "ab", "bb", "ba"};
        List<String> possibleStrList = new ArrayList<>();

        for (String s : doubleQSubstitutions) {
            String possibleStr = input.replace("??", s);
            if (isNotHavingTriplets(possibleStr)) {
                possibleStrList.add(possibleStr);
            }
        }
        return possibleStrList;
    }

    private static boolean isNotHavingTriplets(String possibleStr) {
        return !(possibleStr.contains("aaa") || possibleStr.contains("bbb"));
    }
}
