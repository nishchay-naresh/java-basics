package com.nishchay.ds.array.sort;

import java.util.Arrays;

/*
 *	=========== Segregate 0s and 1s in an array ===========
 *
 * Picks up a random song from the playlist and plays it.
 *
 * You are given an array of 0s and 1s in random order.
 * Segregate 0s on left side and 1s on right side of the array [Basically you have to sort the array]. Traverse array only once.
 *
 *
 *Input array   =  [0, 1, 0, 1, 0, 0, 1, 1, 1, 0]
 * Output array =  [0, 0, 0, 0, 0, 1, 1, 1, 1, 1]
 *
 *
 *
 * https://www.geeksforgeeks.org/segregate-0s-and-1s-in-an-array-by-traversing-array-once/
 *
 *
 * */
public class SortArrayOf01 {

    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 0, 1, 1, 0, 1};

        System.out.println("Original array - " + Arrays.toString(arr));
        segregate0and1(arr);
//        segregate0and1TwoPointers(arr);
        System.out.println("Sorted array - " + Arrays.toString(arr));
    }


    /*
     *
     * Method 1 :  Count 0s or 1s
     * Count the number of 0s, Once we get the Number Of Zeros
     * number of Ones in the array will be = Array Length – Number Of Zeros
     *
     * Once we have counted, we can fill the array first we will put the zeros and then ones.
     * Time Complexity : O(n)
     * No fo array scan  - 2
     *
     * */
    private static void segregate0and1(int[] arr) {
        int length = arr.length;
        int countZeros = 0; // counts the no of zeros in arr

        for (int i = 0; i < length; i++) {
            if (arr[i] == 0)
                countZeros++;
        }

        // loop fills the arr with 0 until countZeros
        for (int i = 0; i < countZeros; i++)
            arr[i] = 0;

        // loop fills remaining arr space with 1
        for (int i = countZeros; i < length; i++)
            arr[i] = 1;

    }

    /*
     *
     * Method 2 :  Use two indexes to traverse
     *Maintain two indexes. Initialize the first index left as 0 and second index right as n-1.
     *	Do following while left < right
     *	a) Keep incrementing index left while there are 0s at it
     *	b) Keep decrementing index right while there are 1s at it
     *	c) If left < right then exchange arr[left] and arr[right]
     *
     * Time Complexity : O(n)
     * No fo array scan  - 1
     *
     * */

    private static void segregate0and1TwoPointers(int[] arr) {

        int left = 0, right = arr.length - 1;

        int t;
        while (left < right)
        {
            /* Increment left index while we see 0 at left */
            while (arr[left] == 0 && left < right)
                left++;

            /* Decrement right index while we see 1 at right */
            while (arr[right] == 1 && left < right)
                right--;

            /* If left is smaller than right then there is a 1 at left
               and a 0 at right.  Exchange arr[left] and arr[right]*/
            if (left < right)
            {
                t = arr[left];
                arr[left] = arr[right];
                arr[right] = t;
                left++;
                right--;
            }
        }
    }

}
