package com.nishchay.core.collection;

import java.util.*;

/*
*
* 1. populate hashMap with values
* 2. Create a List<Map.Entry> from hashMap
* 3. sort this List<Map.Entry> based on Map.Entry.getValue()
* 4. iterate over this sorted List<Map.Entry> and copy its data to a new LinkedHashMap, so that it can preserve the new sorted order
*
* */
public class HashMapSortOnValue {

    public static void main(String[] args) {

        HashMap<String, Integer> marks = new HashMap<>();

        // populating hashMap
        marks.put("java", 85);
        marks.put("perl", 75);
        marks.put("go", 65);
        marks.put("unix", 70);
        marks.put("c++", 90);
        marks.put("ruby", 60);

        System.out.println("originalMap = " + marks);

        Map<String, Integer> sortedMarks = sortByValue(marks);

        System.out.println("sortedMap = " + sortedMarks);

    }

    // function to sort hashMap by values
    public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hashMap)
    {
        // Create a list from elements of HashMap
        List<Map.Entry<String, Integer> > entryList =  new ArrayList<>(hashMap.entrySet());

        // Sort the list - based on hashMap value
//        entryList.sort(Comparator.comparing(HashMap.Entry::getValue));
        entryList.sort(Map.Entry.comparingByValue());

        // Sort the list - based on hashMap key
//        entryList.sort(Comparator.comparing(HashMap.Entry::getKey));
//        entryList.sort(Map.Entry.comparingByKey());


        // put data from sorted list to hashMap
        HashMap<String, Integer> temp = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> currEntry : entryList) {
            temp.put(currEntry.getKey(), currEntry.getValue());
        }
        return temp;

    }
}
