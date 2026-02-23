package com.nishchay.ds.collection;

import com.nishchay.ds.string.freq.FrequencyUtility;

import java.util.*;
import java.util.stream.Collectors;


public class HashMapSortOnValue {

    public static void main(String[] args) {

        sortingAMap();
        sortIntArray();
    }

    private static void sortingAMap() {
        HashMap<String, Integer> marks = new HashMap<>();
        marks.put("java", 85);
        marks.put("perl", 75);
        marks.put("go", 65);
        marks.put("unix", 70);
        marks.put("c++", 90);
        marks.put("ruby", 60);
        System.out.println("originalMap = " + marks);
        sortMapByValueEx(marks);
        System.out.println("--------------------------------------");
        sortMapByKeyEx(marks);
    }


    private static void sortMapByValueEx(Map<String, Integer> marks) {
        Map<String, Integer> sortedMarks = sortMapByValue(marks);
        System.out.println("sortedMap = " + sortedMarks);
    }

    /*
     *  ---------- function to sort hashMap by values -------------
     *  Not doing any mutation in the source map, generating altogether a new map
     *
     *  You cannot directly sort a HashMap, but you can sort its entries based on value and collect into a new ordered map.
     *
     * 1. Populate hashMap with values
     * 2. Create a List<Map.Entry> from hashMap
     * 3. Sort this List<Map.Entry> based on Map.Entry.getValue()
     * 4. Iterate over this sorted List<Map.Entry> and copy its data to a new LinkedHashMap, so that it can preserve the new sorted order
     *
     *
     * CE - because Java generics inference fails in chained call without explicit type hints.
     * Map.Entry.comparingByValue().thenComparing(Map.Entry.comparingByKey(Comparator.reverseOrder())) - CE
     * */
    private static Map<String, Integer> sortMapByValue(Map<String, Integer> hashMap) {
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(hashMap.entrySet());

        // Sort the list - based on hashMap value then key
        Comparator<Map.Entry<String, Integer>> valueComparator = Map.Entry.comparingByValue();
        Comparator<Map.Entry<String, Integer>> keyComparator = Map.Entry.comparingByKey(Comparator.reverseOrder());
        Comparator<Map.Entry<String, Integer>> valueThenKeyComparator = valueComparator.thenComparing(keyComparator);
        entryList.sort(valueThenKeyComparator);

        // put data from a sorted list to linkedHashMap
        /*
        HashMap<String, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> currEntry : entryList) {
            sortedMap.put(currEntry.getKey(), currEntry.getValue());
        }
        */

        return hashMap.entrySet()
                .stream()
                .sorted(valueThenKeyComparator)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));

    }


    private static void sortMapByKeyEx(Map<String, Integer> marks) {
        System.out.println("originalMap = " + marks);
        Map<String, Integer> sortedMarks = sortMapByKey(marks);
        System.out.println("sortedMap = " + sortedMarks);

    }

    /*
     *  ---------- function to sort hashMap by key -------------
     *  Not doing any mutation in the source map, generating completely a new map
     *
     *  You cannot directly sort a HashMap, but you can sort its entries based on value and collect into a new ordered map.
     *
     * 1. Populate hashMap with values
     * 2. Create a List<Map.Entry> from hashMap
     * 3. Sort this List<Map.Entry> based on Map.Entry.getValue()
     * 4. Iterate over this sorted List<Map.Entry> and copy its data to a new LinkedHashMap, so that it can preserve the new sorted order
     *
     *
     * CE - because, Java generics inference fails in chained call without explicit type hints.
     * Map.Entry.comparingByValue().thenComparing(Map.Entry.comparingByKey(Comparator.reverseOrder())) - CE
     * */
    private static Map<String, Integer> sortMapByKey(Map<String, Integer> hashMap) {
        // Create a list from elements of HashMap
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(hashMap.entrySet());

        // Sort the list - based on hashMap key
        Comparator<Map.Entry<String, Integer>> keyComparator = Map.Entry.comparingByKey();
        entryList.sort(keyComparator);

        // put data from a sorted list to linkedHashMap
        return hashMap.entrySet()
                .stream()
                .sorted(keyComparator)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }

    /*
     * Sort an integer array based on its frequency, if frequency is same go for insertion order
     * Sort based on occurrence and if count same maintain insertion sequence
     * integer[] arr = {1,3,5,7,2,1,5,3,3};
     * o/p - 3,3,3,1,1,5,5,7,2
     * */
    private static void sortIntArray() {

        int[] arr = {1, 3, 5, 7, 2, 1, 5, 3, 3};
        // get ordered freq of each no in a LinkedHashMap
        Map<Integer, Long> freqMap = FrequencyUtility.getOrderedFrequencyMapStream(arr);

        // sort the map based on freq, which is value here
        List<Map.Entry<Integer, Long>> entryList = new ArrayList<>(freqMap.entrySet());

        Comparator<Map.Entry<Integer, Long>> valueComparatorReverse = Comparator.comparing(HashMap.Entry::getValue, Comparator.reverseOrder());
        entryList.sort(valueComparatorReverse);

        HashMap<Integer, Long> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<Integer, Long> currEntry : entryList) {
            sortedMap.put(currEntry.getKey(), currEntry.getValue());
        }

        System.out.println(" input    = " + Arrays.toString(arr));
        System.out.println("freqMap   = " + freqMap);
        System.out.println("sortedMap = " + sortedMap);
    }

    /*
     *  input - 1, 3, 5, 7, 2, 1, 5, 3, 3,
     * output - 3, 3, 3, 5, 5, 1, 1, 7, 2,
     * */
    static Map<Integer, Integer> getFrequencyMap(int[] intArray) {

        // get freq of each no in a hashMap
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int currNo : intArray) {
            Integer freq = freqMap.get(currNo);
            freq = freq == null ? 1 : ++freq;
            freqMap.put(currNo, freq);
        }
        return freqMap;
    }
}
