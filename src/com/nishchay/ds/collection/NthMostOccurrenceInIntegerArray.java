package com.nishchay.ds.collection;

import java.util.*;

/*
 *	write down a function which returns the no with nth most occurrence in an array of integer
 *	arr[] = {7, 10, 11, 5, 2, 5, 5, 7, 11, 8, 9},
 *	k = 4
 *	Output: 5 11 7 10
 *	Explanation:
 *	    freq array : {2->1, 5->3, 7->2, 8->1, 9->1, 10->1, 11->2}
 *	    freq array sorted in descending order of frequency, if freq is same then  sorted in descending order of no
 *	    freq array : {5->3, 11->2, 7->2, 10->1, 9->1, 8->1, 2->1}
 *	    ans - get the first 4 no
 *
 *	  int[] nthMostOccurrence(int[]){
 *
 *	  }
 *	https://www.geeksforgeeks.org/find-k-numbers-occurrences-given-array/
 * */
public class NthMostOccurrenceInIntegerArray {


    public static void main(String[] args) {

        int[] arr = {7, 10, 11, 5, 2, 5, 5, 7, 11, 8, 9};

        int[] res = nthMostOccurrence(arr, 4);
        System.out.println("res = " + Arrays.toString(res)); //[5, 11, 7, 10]

    }

    private static int[] nthMostOccurrence(int[] intArray, int k) {

        Map<Integer, Integer> freqMap = HashMapSortOnValue.getFrequencyMap(intArray);

        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(freqMap.entrySet());
        System.out.println("Original List = " + entryList);

        Comparator<Map.Entry<Integer, Integer>> valueComp = Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder());
        Comparator<Map.Entry<Integer, Integer>> keyComp = Comparator.comparing(Map.Entry::getKey, Comparator.reverseOrder());
        Comparator<Map.Entry<Integer, Integer>> valueThenKeyComp = valueComp.thenComparing(keyComp);

        entryList.sort(valueThenKeyComp);

        System.out.println("Sorted List = " + entryList);

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = entryList.get(i).getKey();
        }
        return result;

    }
}
