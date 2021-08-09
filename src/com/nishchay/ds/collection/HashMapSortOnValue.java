package com.nishchay.ds.collection;

import java.util.*;


public class HashMapSortOnValue {

    public static void main(String[] args) {

        sortMapByValueEx();

        sortMapByKeyEx();

        sortIntArray();
        sortIntArray1();

    }

    /*
     * Sort an integer array based on its frequency, if frequency is same go for insertion order
     * Sort based on occurrence and if count same maintain insertion sequence
     * integer[] arr = {1,3,5,7,2,1,5,3,3};
     * o/p - 3,3,3,1,1,5,5,7,2
     * */
    private static void sortIntArray() {

        int[] arr = {1, 3, 5, 7, 2, 1, 5, 3, 3};

        // get freq of each no in a LinkedHashMap
        Map<Integer, Integer> freqMap = new LinkedHashMap<>();
        for (int currNo : arr) {
            Integer freq = freqMap.get(currNo);
            freq = freq == null ? 1 : ++freq;
            freqMap.put(currNo, freq);
        }

        // sort the map based on freq, which is value here
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(freqMap.entrySet());

        Comparator<Map.Entry<Integer, Integer>> valueComparatorReverse = Comparator.comparing(HashMap.Entry::getValue, Comparator.reverseOrder());
        entryList.sort(valueComparatorReverse);

        HashMap<Integer, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<Integer, Integer> currEntry : entryList) {
            sortedMap.put(currEntry.getKey(), currEntry.getValue());
        }

        System.out.println("sortedMap = " + sortedMap);

        System.out.print(" input - ");
        for (int x : arr) {
            System.out.print(x + ", ");
        }

        System.out.print("\n output - ");
        for (Map.Entry<Integer, Integer> e : sortedMap.entrySet()) {
            int freq = e.getValue();
            int num = e.getKey();
            for (int i = 1; i <= freq; i++) {
                System.out.print(num + ", ");
            }
        }
    }
    /*
     *	input - 1, 3, 5, 7, 2, 1, 5, 3, 3,
     *	output - 3, 3, 3, 1, 1, 5, 5, 7, 2,
     * */

    /*
     *  Sort an integer array based on its frequency descending order, if frequency is same go for no again in descending order
     *	integer[] arr = {1,3,5,7,2,1,5,3,3};
     *	o/p -  3,3,3,5,5,1,1,7,2
     *  N + N LogN + N= N LogN
     * */
    private static void sortIntArray1() {

        int[] arr = {1, 3, 5, 7, 2, 1, 5, 3, 3};

        Map<Integer, Integer> freqMap = getFrequencyMap(arr);

        // sort the map based on freq, which is value here
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(freqMap.entrySet());

        Comparator<Map.Entry<Integer, Integer>> valueComparatorReverse = Comparator.comparing(HashMap.Entry::getValue, Comparator.reverseOrder());
        Comparator<Map.Entry<Integer, Integer>> keyComparatorReverse = Comparator.comparing(HashMap.Entry::getKey, Comparator.reverseOrder());
        entryList.sort(valueComparatorReverse.thenComparing(keyComparatorReverse));

        HashMap<Integer, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<Integer, Integer> currEntry : entryList) {
            sortedMap.put(currEntry.getKey(), currEntry.getValue());
        }

        System.out.println("sortedMap = " + sortedMap);

        System.out.print(" input - ");
        for (int x : arr) {
            System.out.print(x + ", ");
        }

        System.out.print("\n output - ");
        for (Map.Entry<Integer, Integer> e : sortedMap.entrySet()) {
            int freq = e.getValue();
            int num = e.getKey();
            for (int i = 1; i <= freq; i++) {
                System.out.print(num + ", ");
            }
        }

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


    private static void sortMapByKeyEx() {

        HashMap<Integer, String> progLanguages = new HashMap<>();

        // populating hashMap
        progLanguages.put(85, "java");
        progLanguages.put(75, "perl");
        progLanguages.put(65, "go");
        progLanguages.put(70, "unix");
        progLanguages.put(90, "c++");
        progLanguages.put(60, "ruby");

        System.out.println("originalMap = " + progLanguages);

        Map<Integer, String> sortedMarks = sortMapByKey(progLanguages);

        System.out.println("sortedMap = " + sortedMarks);

    }

    // function to sort hashMap by key
    private static HashMap<Integer, String> sortMapByKey(HashMap<Integer, String> hashMap) {
        // Create a list from elements of HashMap
        List<Map.Entry<Integer, String>> entryList = new ArrayList<>(hashMap.entrySet());

        // Sort the list - based on hashMap key
        Comparator<Map.Entry<Integer, String>> keyComparator = Comparator.comparing(e -> e.getKey());
//        Comparator<Map.Entry<Integer, String>> keyComparator = Map.Entry.comparingByKey();
        entryList.sort(keyComparator);

        // put data from sorted list to linkedHashMap
        HashMap<Integer, String> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<Integer, String> currEntry : entryList) {
            sortedMap.put(currEntry.getKey(), currEntry.getValue());
        }
        return sortedMap;

    }

}
