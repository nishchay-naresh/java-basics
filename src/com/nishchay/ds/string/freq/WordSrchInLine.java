package com.nishchay.ds.string.freq;

/*
implement a word search in over multiple lines of text and return the matching line

Str1 = "this is a test20"
Str2 = "testing for content indexing"
Str3 = "testing for search text in test"
Strn N = "……"

Search key = "test" (whole word search) returns str1
* */

import java.util.*;

public class WordSrchInLine {

    public static void main(String[] args) {

        List<String> lines = new ArrayList<>();
        lines.add("this is a test20");
        lines.add("testing for content indexing");
        lines.add("testing for search text in test");

        String key = "test";
        System.out.printf("%s -> %s%n", key, returnContainingLine(lines, key));
        searchInLineHM(lines, key);
    }

    private static String returnContainingLine(List<String> lines, String key) {

        for (String curr : lines) {
            if (Arrays.asList(curr.split(" ")).contains(key))
                return curr;
        }
        return null;
    }

    private static void searchInLineHM(List<String> lines, String key) {

        Map<String, Integer> dictionary = new HashMap<>();

        Integer freq = 0;
        for (String line : lines) {
            for (String words : line.split(" ")) {
                freq = dictionary.get(words);
                freq = freq == null ? 0 : ++freq;
                dictionary.put(words, freq);
            }
        }

        if (dictionary.containsKey(key)) {
            System.out.println("found");
        }
    }
}
