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
        int[] arr = new int[]{ 0, 1, 0, 1, 1, 1 };

        System.out.println("Original array - " + Arrays.toString(arr));
        segregate0and1(arr);
        System.out.println("Sorted array - " + Arrays.toString(arr));
    }

    static void segregate0and1(int[] arr){

    }

}
