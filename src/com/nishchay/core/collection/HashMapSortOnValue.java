package com.nishchay.core.collection;

import java.util.*;


public class HashMapSortOnValue {

    public static void main(String[] args) {

        sortMapByValueEx();
//        sortIntArray();

    }



    /*
    *  input - 1, 3, 5, 7, 2, 1, 5, 3, 3,
    * output - 3, 3, 3, 5, 5, 1, 1, 7, 2,
    *
    * */

    /*
     * 1. populate hashMap with values
     * 2. Create a List<Map.Entry> from hashMap
     * 3. sort this List<Map.Entry> based on Map.Entry.getValue()
     * 4. iterate over this sorted List<Map.Entry> and copy its data to a new LinkedHashMap, so that it can preserve the new sorted order
     * */
    private static void sortMapByValueEx() {

        HashMap<String, Integer> marks = new HashMap<>();

        // populating hashMap
        marks.put("java", 85);
        marks.put("perl", 75);
        marks.put("go", 65);
        marks.put("unix", 70);
        marks.put("c++", 90);
        marks.put("ruby", 60);

        System.out.println("originalMap = " + marks);

        Map<String, Integer> sortedMarks = sortMapByValue(marks);

        System.out.println("sortedMap = " + sortedMarks);

    }


    // function to sort hashMap by values
    private static HashMap<String, Integer> sortMapByValue(HashMap<String, Integer> hashMap) {
        // Create a list from elements of HashMap
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(hashMap.entrySet());

        // Sort the list - based on hashMap value
//        Comparator<Map.Entry<String, Integer>> valueComparator =  Comparator.comparing(HashMap.Entry::getValue);
        Comparator<Map.Entry<String, Integer>> valueComparator = Map.Entry.comparingByValue();
        entryList.sort(valueComparator);

        // Sort the list - based on hashMap key
//        entryList.sort(Comparator.comparing(HashMap.Entry::getKey));
//        entryList.sort(Map.Entry.comparingByKey());


        // put data from sorted list to linkedHashMap
        HashMap<String, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> currEntry : entryList) {
            sortedMap.put(currEntry.getKey(), currEntry.getValue());
        }
        return sortedMap;

    }


}
