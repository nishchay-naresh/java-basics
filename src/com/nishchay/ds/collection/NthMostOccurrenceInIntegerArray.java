package com.nishchay.ds.collection;

import java.util.*;

/*
 *	write down a function which returns the no with nth most occurrence in an array of integer
 *
 * arr[] = {7, 10, 11, 5, 2, 5, 5, 7, 11, 8, 9},
 *	k = 4
 *	Output: 5 11 7 10
 *	--------
 * Explanation:
 *	    freq array : {2->1, 5->3, 7->2, 8->1, 9->1, 10->1, 11->2}
 *	    freq array sorted in descending order of frequency, if freq is same then  sorted in descending order of no
 *	    freq array : {5->3, 11->2, 7->2, 10->1, 9->1, 8->1, 2->1}
 *	    ans - get the first 4 no
 * ---------
 *	arr[] = {3, 1, 4, 4, 5, 2, 6, 1},
 *	k = 2
 *	Output: 4 1
 *
 * -------------------------------
 *	  int[] nthMostOccurrence(int[]){
 *
 *	  }
 *	https://www.geeksforgeeks.org/find-k-numbers-occurrences-given-array/
 * */
public class NthMostOccurrenceInIntegerArray {


    public static void main(String[] args) {

        int[] arr = {7, 10, 11, 5, 2, 5, 5, 7, 11, 8, 9};
        int k = 4;

        int[] res = nthMostOccurrence(arr, k);
        System.out.println(k + "thMostOccurrence = " + Arrays.toString(res)); //[5, 11, 7, 10]

        System.out.println("-----------------------------------------------------");

        arr = new int[]{3, 1, 4, 4, 5, 2, 6, 1};
        k = 2;
        res = nthMostOccurrence(arr, 2);
        System.out.println(k + "thMostOccurrence = " + Arrays.toString(res)); // [4, 1]

    }

    /*
     *	Time Complexity: O(d log d), where d is the count of distinct elements in the array. O(d log d) for sorting
     *	Auxiliary Space: O(d), where d is the count of distinct elements in the array.
     * */
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
/*
 * O/P =>
 *	Original List = [2=1, 5=3, 7=2, 8=1, 9=1, 10=1, 11=2]
 *	Sorted List = [5=3, 11=2, 7=2, 10=1, 9=1, 8=1, 2=1]
 *	4thMostOccurrence = [5, 11, 7, 10]
 *	-----------------------------------------------------
 *	Original List = [1=2, 2=1, 3=1, 4=2, 5=1, 6=1]
 *	Sorted List = [4=2, 1=2, 6=1, 5=1, 3=1, 2=1]
 *	2thMostOccurrence = [4, 1]
 * */