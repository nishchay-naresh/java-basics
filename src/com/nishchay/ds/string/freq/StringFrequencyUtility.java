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

    // Count the frequency of each no in integer array
    /*
    *
    * return - ordered frequency map
    * */
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
    public static Map<String, Long> getFrequencyMapStream(String[] strArray) {
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


    /*
     *   grouping function to return Map<String, Integer> instead of Map<String,Long>
     *   all 3 ways will give you an ordered frequency map in the form of linkedHashMap
     *
     * https://stackoverflow.com/questions/55353829/java-8-grouping-function-to-return-mapstring-integer-instead-of-mapstring-lo
     * */
    static Map<String, Integer> getFrequencyMapStream_intCount(String[] strArray) {

        Map<String, Integer> freqMap;

        // can perform a conversion of Long to Integer after the counting like
        freqMap = Arrays.stream(strArray)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new,
                        Collectors.collectingAndThen(Collectors.counting(), Long::intValue)));

        // you may also count using an int value type in the first place
        freqMap = Arrays.stream(strArray)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new,
                        Collectors.summingInt(word -> 1)));

        // This is summing a one for each word. You can use the same approach with the toMap collector
        Map<String, Integer> map = Arrays.stream(strArray)
                .collect(Collectors.toMap(Function.identity(), word -> 1, Integer::sum));

        return freqMap;
    }

}
