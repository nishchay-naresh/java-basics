package com.nishchay.ds.string.freq;

import java.util.*;


/*
 * Given an array of strings strArray, group the anagrams together. You can return the answer in any order.
 * Input: strArray = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * mine :  [[eat, tea, ate], [bat], [tan, nat]]
 * */
public class GroupAnagrams {

    public static void main(String[] args) {

        String[] strArray = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};

        List<List<String>> resultList = groupAnagrams(strArray);
        System.out.println("resultList = " + resultList);

    }

    private static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String word : strs) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);               // Sort word
            String key = new String(chars);   // Sorted string as key

            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(word);
        }

        return new ArrayList<>(map.values());
    }
}


