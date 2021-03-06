package com.nishchay.ds.string.freq;

import java.util.Map;

public class MostFrequentWord {

    public static void main(String[] args) {

        String strArray[] = {"geeks", "for", "geeks", "a",
                "portal", "to", "learn", "can", "be",
                "computer", "science", "zoom", "yup",
                "fire", "in", "be", "data", "geeks"};

        Map<String, Integer> feqMap = StringFrequency.getFrequencyMap(strArray);
        System.out.println(feqMap);

        String result = "";
        int value = 0;
        for (Map.Entry<String, Integer> currEntry : feqMap.entrySet()) {
            // Check for word having highest frequency
            if (currEntry.getValue() > value) {
                value = currEntry.getValue();
                result = currEntry.getKey();
            }
        }

        System.out.println("Most frequent word is - " + result);
    }



}
