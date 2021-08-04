package com.nishchay.ds.array.sort;


import java.util.Arrays;

/*
 *	Count minimum number of subsets (or subsequences) with consecutive numbers
 *
 *	 Given an array of distinct positive numbers,
 *	 the task is to calculate the number of subsets (or subsequences) from the array
 *	 such that each subset contains consecutive numbers.
 *
 *	Examples:
 *
 *	Input :  arr[] = {100, 56, 5, 6, 102, 58, 101, 57, 7, 103, 59}
 *	Output : 3
 *	{5, 6, 7}, { 56, 57, 58, 59}, {100, 101, 102, 103}
 *	are 3 subset in which numbers are consecutive.
 *
 *	Input :  arr[] = {10, 100, 105}
 *	Output : 3
 *	{10}, {100} and {105} are 3 subset in which numbers are consecutive.
 *
 * https://www.geeksforgeeks.org/count-minimum-number-subsets-subsequences-consecutive-numbers/
 * */
public class MinimumSubsetWithConsecutiveNumbers {

    public static void main(String[] args) {
        int[] arr = { 100, 56, 5, 6, 102, 58, 101, 57, 7, 103, 59 };
        System.out.println(numofsubset(arr)); // 3

        arr = new int[]{10, 100, 105};
        System.out.println(numofsubset(arr)); // 3
    }

    /*
     *  Returns count of subsets with consecutive numbers
     *
     *	1. Sort the array arr[ ] and count = 1.
     *	2. Traverse the sorted array and for each element arr[i].
     *	   If arr[i] + 1 != arr[i+1],
     *	       then increment the count by one.
     *	3. Return the count.
     * */
    static int numofsubset(int[] arr){

        // Sort the array so that elements
        // which are consecutive in nature
        // became consecutive in the array.
        Arrays.sort(arr);

        // Initialize result
        int count = 1;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] + 1 != arr[i + 1])
                count++;
        }

        return count;
    }

}
