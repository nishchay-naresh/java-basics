package com.nishchay.ds.string;

/*
 * Program to print all substrings of a given string
 *
 *	Given a string as an input. We need to write a program that will print all non-empty substrings of that given string.
 *
 *	Examples :
 *
 *	Input :  abcd
 *	Output :    1 -> a, b, c, d
 *              2 -> ab, bc, cd
 *              3 -> abc, bcd
 *              4 -> abcd
 *
 * =========Number of substrings of a string========
 *
 * Input : str = “abc”
 * Output : 6
 * Every substring of the given string : “a”, “b”, “c”, “ab”, “bc”, “abc”
 * Input : str = “abcd”
 * Output : 10
 * Every substring of the given string : “a”, “b”, “c”, “d”, “ab”, “bc”, “cd”, “abc”, “bcd” and “abcd”
 *
 * Count of non-empty substrings is n*(n+1)/2
 * */
public class SubstrOfAString {

    public static void main(String[] args) {

//        String str = "agbcba";
        String str = "abcd";

        printAllSubstring(str);

    }

    private static void printAllSubstring(String str) {

        StringBuilder sb = new StringBuilder();

        int length = str.length();
        for (int len = 1; len <= length; len++) {
            for (int j = 0; j <= length - len; j++) {

                /*
                String res = str.substring(j, j + len);
                System.out.println(res);
                */

                for (int k = j; k < j + len; k++) {
                    sb.append(str.charAt(k));
                }
                String res = sb.toString();
                // clear or empty a StringBuilder
                sb.setLength(0);
                System.out.println(res);

            }
        }
    }
}