package com.nishchay.ds.stdalgo;

/*
 *	=========== Majority Element ===========
 *
 *	Write a function which takes an array and prints the majority element (if it exists), otherwise prints “No Majority Element”.
 *  A majority element in an array A[] of size n is an element that appears more than n/2 times
 * (and hence there is at most one such element).
 *
 *
 *	Example 1:
 *		Input : {3, 3, 4, 2, 4, 4, 2, 4, 4}
 *		Output : 4
 *		Explanation: The frequency of 4 is 5 which is greater than the half of the size of the array size.
 *
 *	Example 2:
 *		Input : {3, 3, 4, 2, 4, 4, 2, 4}
 *		Output : No Majority Element
 *		Explanation: There is no element whose frequency is greater than the half of the size of the array size.
 *
 *
 * https://www.geeksforgeeks.org/majority-element/
 * https://www.youtube.com/watch?v=zOyOwDEF1Rc&ab_channel=IDeserve
 *
 * */

import java.util.Arrays;

public class BoyerMooreVoteAlgorithm {

    public static void main(String[] args) {

        int[] array = {2, 6, 2, 2, 6, 2, 2, 8, 2, 1};
        System.out.println(Arrays.toString(array) + " \nMajority Element: " + getMajorityElementNaive(array));
        System.out.println(Arrays.toString(array) + " \nMajority Element: " + getMajorityElement(array));

        array = new int[]{3, 3, 4, 2, 4, 4, 2, 4, 4};
        System.out.println(Arrays.toString(array) + " \nMajority Element: " + getMajorityElement(array));

        array = new int[]{3, 3, 4, 2, 4, 4, 2, 4};
        System.out.println(Arrays.toString(array) + " \nMajority Element: " + getMajorityElement(array));
    }
    /*
     * =============Solutions==============
     *	Algorithm 1: Use 2 loops
     *		In inner loop calculate the count of every element
     *		In outer loop check, if count is greater than n/2, return the element.
     *		If out of the loops, return null.
     *		Time Complexity: O(n^2)
     *
     *	Algorithm 2: Sort the array
     *		Again iterate over the array once and count occurrence of each element.
     *		If an element is found with count is greater than n/2, return the element.
     *		If no such element found, return null.
     *		Time Complexity: O(nlogn) sorting + O(n) Counting = O(nlogn)
     *
     *	Algorithm 3: Boyer-Moore Vote Algorithm
     *		Step 1: Find a candidate for majority element.
     *		Step 2: Check if this candidate is a majority element.
     *
     *		Step1:
     *		Find the candidate for majority element
     *		1: Initialize count of current candidate as 0, count = 0
     *		2: Iterate over the array and do following steps:
     *		   (a) If count == 0, set candidate = array[i], count = 1
     *		   (b) Else
     *		       (i) If candidate == array[i], set count = count + 1
     *		       (ii) else set count = count - 1
     *
     *		Step 2:
     *		Check if candidate is Majority Element
     *		1: If count == 0, there is no majority element.
     *		2: Else, iterate over array to get count of candidate.
     *		    (a) If count is greater than n/2, return candidate
     *		    (b) Else return null;
     * */

    private static Integer getMajorityElementNaive(int[] array) {

        if (array == null || array.length == 0) {
            return null;
        }

        for (int i = 0; i < array.length; i++) {
            int count = 0;
            for (int j = 0; j < array.length; j++) {
                if (array[i] == array[j]) {
                    count++;
                }
            }
            if (count > array.length / 2) {
                return array[i];
            }
        }
        return null;
    }


    private static Integer getMajorityElement(int[] array) {

        if (array == null || array.length == 0) {
            return null;
        }

        // find the candidate for Majority
        Integer candidate = null;
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (count == 0) {
                candidate = array[i];
                count = 1;
            } else {
                if (candidate == array[i]) {
                    count++;
                } else {
                    count--;
                }
            }
        }

        if (count == 0) {
            return null;
        }

        // check if the candidate occurs more than n/2 times
        count = 0;
        for (int i = 0; i < array.length; i++) {
            if (candidate == array[i]) {
                count++;
            }
        }
        return (count > array.length / 2) ? candidate : null;
    }


}
