package com.nishchay.ds.string.freq;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class StrAnagram {

    public static void main(String[] args) {

        System.out.println("  isAnagramSort(\"cat\", \"act\") - " +  isAnagramSort("cat", "act"));
        System.out.println("  isAnagramSort(\"Keep\", \"Peek\") - " + isAnagramSort("Keep", "Peek"));
        System.out.println("  isAnagramSort(\"Mother In Law\", \"Hitler Woman\") - " +  isAnagramSort("Mother In Law", "Hitler Woman"));

        System.out.println("  isAnagramStream(\"cat\", \"act\") - " + isAnagramStream("cat", "act"));
        System.out.println("  isAnagramStream(\"Keep\", \"Peek\") - " + isAnagramStream("Keep", "Peek"));
        System.out.println("  isAnagramStream(\"Mother In Law\", \"Hitler Woman\") - " +  isAnagramStream("Mother In Law", "Hitler Woman"));

        System.out.println("  isAnagramMap(\"cat\", \"act\") - " + isAnagramMap("cat", "act"));
        System.out.println("  isAnagramMap(\"Keep\", \"Peek\") - " + isAnagramMap("keep", "peek"));
        System.out.println("  isAnagramMap(\"mother in law\", \"hitler woman\") - " +  isAnagramMap("mother in law", "hitler woman"));
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

    private static boolean isAnagramMap(String string1, String string2) {
        if (string1.length() != string2.length()) {
            return false;
        }

        Map<Character, Integer> freqMap1 = getFrequencyMap(string1);
        Map<Character, Integer> freqMap2 = getFrequencyMap(string2);

        return freqMap1.equals(freqMap2);
    }

    private static Map<Character, Integer> getFrequencyMap(String word) {

        char[] charArray = word.toCharArray();
        Map<Character, Integer> freqMap = new HashMap<>();
        Integer freq;
        for (char currChar : charArray) {
            freq = freqMap.get(currChar);
            freq = freq == null ? 1 : ++freq;
            freqMap.put(currChar, freq);
        }
        return freqMap;
    }
}
