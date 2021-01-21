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

    private static List<List<String>> groupAnagrams(String[] strArray) {

        Map<String, List<String>> anagramListMap = new HashMap<>();
        String sortedKey;
        char[] charArray;
        for (String currStr : strArray) {

            charArray = currStr.toCharArray();
            Arrays.sort(charArray);
            // char[] to String - String.valueOf(charArray)
            sortedKey = String.valueOf(charArray);

            List<String> anagramList = anagramListMap.get(sortedKey);
            if (anagramList == null) {
                anagramList = new ArrayList<>();
            }

            anagramListMap.put(sortedKey, anagramList);
            anagramList.add(currStr);
        }

        List<List<String>> resultList = new ArrayList<>(anagramListMap.values());
        return resultList;
    }

}


