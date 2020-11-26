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
        marks.put("Operating System", 85);
        marks.put("Data Structure", 75);
        marks.put("Database", 65);
        marks.put("Java", 70);
        marks.put("C Programming", 90);
        marks.put("Networking", 60);

        System.out.println("marks = " + marks);

        Map<String, Integer> sortedMarks = sortByValue(marks);

        System.out.println("sortedMarks = " + sortedMarks);

    }

    // function to sort hashMap by values
    public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hashMap)
    {
        // Create a list from elements of HashMap
        List<Map.Entry<String, Integer> > entryList =  new ArrayList<>(hashMap.entrySet());

        // Sort the list - based on hashMap value
//        entryList.sort(Comparator.comparing(HashMap.Entry::getValue));
        entryList.sort(Map.Entry.comparingByValue());


        // put data from sorted list to hashmap
        HashMap<String, Integer> temp = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> currEntry : entryList) {
            temp.put(currEntry.getKey(), currEntry.getValue());
        }
        return temp;

    }
}
