package com.nishchay.ds.string.freq;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringFrequencyUtility {

    // Count the frequency of each character in a String
    static Map<Character, Integer> getFrequencyMap(String word) {

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

    // java 8 feature to get the frequency map - HashMap
    static Map<Character, Long> getFrequencyMapStream(String word) {
        Map<Character, Long> freqMap = word.chars()
                .mapToObj(i -> Character.toLowerCase(Character.valueOf((char) i))) //convert to lowercase & then to Character object
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return freqMap;
    }

    // java 8 feature to get the frequency map - LinkedHashMap
    static Map<Character, Long> getOrderedFrequencyMapStream(String word) {
        Map<Character, Long> freqLinkedHashMap = word.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
        return freqLinkedHashMap;
    }

    // Count the frequency of each words in a String array
    static Map<String, Integer> getFrequencyMap(String[] strArray) {

        Map<String, Integer> feqMap = new HashMap<>();
        Integer freq;
        for (String currStr : strArray) {
            freq = feqMap.get(currStr);
            freq = freq == null ? 1 : ++freq;
            feqMap.put(currStr, freq);
        }
        return feqMap;
    }


    // Count the frequency of each no in a integer array
    public static Map<Integer, Integer> getFrequencyMap(int[] intArray) {

        Map<Integer, Integer> feqMap = new HashMap<>();
        Integer freq;
        for(int currNo : intArray){
            freq = feqMap.get(currNo);
            freq = freq == null ? 1 : ++freq;
            feqMap.put(currNo, freq);
        }
        return feqMap;
    }

    // java 8 feature to get the frequency map - HashMap
    static Map<String, Long> getFrequencyMapStream(String[] strArray) {
        Map<String, Long> freqMap = Arrays.stream(strArray)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return freqMap;
    }

    // java 8 feature to get the frequency map - LinkedHashMap
    static Map<String, Long> getOrderedFrequencyMapStream(String[] strArray) {
        Map<String, Long> freqLinkedHashMap = Arrays.stream(strArray)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
        return freqLinkedHashMap;
    }


}
