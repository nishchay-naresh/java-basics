package com.nishchay.ds.string;

import java.util.Arrays;

public class StrAnagram {

    public static void main(String[] args) {

        System.out.println("  isAnagramSort(\"cat\", \"act\") - " +  isAnagramSort("cat", "act"));
        System.out.println("  isAnagramSort(\"Keep\", \"Peek\") - " + isAnagramSort("Keep", "Peek"));
        System.out.println("  isAnagramSort(\"Mother In Law\", \"Hitler Woman\") - " +  isAnagramSort("Mother In Law", "Hitler Woman"));


        System.out.println("  isAnagramStream(\"cat\", \"act\") - " + isAnagramStream("cat", "act"));
        System.out.println("  isAnagramStream(\"Keep\", \"Peek\") - " + isAnagramStream("Keep", "Peek"));
        System.out.println("  isAnagramStream(\"Mother In Law\", \"Hitler Woman\") - " +  isAnagramStream("Mother In Law", "Hitler Woman"));

    }

    private static boolean isAnagramSort(String string1, String string2) {
        if (string1.length() != string2.length()) {
            return false;
        }
        char[] a1 = string1.toCharArray();
        char[] a2 = string2.toCharArray();
        Arrays.sort(a1);
        Arrays.sort(a2);
        return Arrays.equals(a1, a2);
    }

    private static boolean isAnagramStream(String str1, String str2) {
        int[] str1Chars = str1.toLowerCase().chars().sorted().toArray();
        int[] str2Chars = str2.toLowerCase().chars().sorted().toArray();
        return Arrays.equals(str1Chars, str2Chars);
    }
}
