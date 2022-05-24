package com.nishchay.ds.array.sort;

import java.util.Arrays;

/*
 *	=========== Move Zeros to the Start/End ===========
 *
 * Given an array of random numbers, move all the zero’s of a given array to the start/end of the array.
 * maintaining the order of other elements in the array.
 *
 * For example,
 *		if the given array is {1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0}
 *		moving all zeros to end   - {1, 9, 8, 4, 2, 7, 6, 0, 0, 0, 0}
 *		moving all zeros to start - {0, 0, 0, 0, 1, 9, 8, 4, 2, 7, 6}
 *
 *	Example 1:
 *		Input :  arr[] = {1, 2, 0, 4, 3, 0, 5, 0};
 *		Output : moving all zeros to end   -  {1, 2, 4, 3, 5, 0, 0, 0};
 *				moving all zeros to start  -  {0, 0, 0, 1, 2, 4, 3, 5};
 *
 *	Example 2:
 *		Input : arr[]  = {1, 2, 0, 0, 0, 3, 6};
 *		Output : moving all zeros to end   -  {1, 2, 3, 6, 0, 0, 0};
 *				moving all zeros to start  -  {0, 0, 0, 1, 2, 3, 6};
 *
 *
 * https://www.educative.io/m/move-zeros-left
 * https://www.geeksforgeeks.org/move-zeroes-end-array/
 * */
public class MoveZeros {

    public static void main(String[] args) {

        int[] arr;

        System.out.println("=========== Move Zeros to the Start ===========");
        arr = new int[]{1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0};
        pushEndEx(arr);
        arr = new int[]{1, 2, 0, 4, 3, 0, 5, 0};
        pushEndEx(arr);
        arr = new int[]{10, 2, 13, 4, 3, 7, 5, 1};
        pushEndEx(arr);
        arr = new int[]{1};
        pushEndEx(arr);

        System.out.println("=========== Move Zeros to the End ===========");
        arr = new int[]{1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0};
        pushStartEx(arr);
        arr = new int[]{1, 2, 0, 4, 3, 0, 5, 0};
        pushStartEx(arr);
        arr = new int[]{10, 2, 13, 4, 3, 7, 5, 1};
        pushStartEx(arr);
        arr = new int[]{1};
        pushStartEx(arr);

    }


    private static void pushEndEx(int[] arr) {
        System.out.println("                 Original Array : " + Arrays.toString(arr));
        pushZerosToEnd(arr);
        System.out.println("Array after pushing zeros to end: " + Arrays.toString(arr));
        System.out.println("----------------------------------------------------------");

    }

    /*
     *	=========== Move Zeros to the end ===========
     * initialize writeIndex = 0
     * Traverse the given array ‘arr’ from left to right.
     * 	    if current element is non-zero, write it to writeIndex , then do writeIndex++
     * Now n - writeIndex = noOfZeros
     * So iterate noOfZeros times and copy all zeros at writeIndex
     *
     * Time Complexity: O(n) where n is number of elements in input array.
     * Auxiliary Space: O(1)
     * */
    private static void pushZerosToEnd(int[] arr) {

        if (arr.length < 1) {
            return;
        }
        int n = arr.length;
        int writerIndex = 0;

        for (int i = 0; i < n; i++)
            if (arr[i] != 0)
                arr[writerIndex++] = arr[i];

        while (writerIndex < n)
            arr[writerIndex++] = 0;

    }

    private static void pushStartEx(int[] arr) {
        System.out.println("                 Original Array : " + Arrays.toString(arr));
        pushZerosToStart(arr);
        System.out.println("Array after pushing zeros to end: " + Arrays.toString(arr));
        System.out.println("---------------------------------------------------------");
    }

    /*
     *	=========== Move Zeros to the start ===========
     * initialize writeIndex = n-1
     * Traverse the given array ‘arr’ from right to left.
     * 	    if current element is non-zero, write it to writeIndex , then do writeIndex++
     * Now n - writeIndex = noOfZeros
     * So iterate noOfZeros times and copy all zeros at writeIndex
     *
     * Time Complexity: O(n) where n is number of elements in input array.
     * Auxiliary Space: O(1)
     * */
    private static void pushZerosToStart(int[] arr) {

        if (arr.length < 1) {
            return;
        }

        int n = arr.length;
        int writerIndex = n - 1;

        for (int i = n - 1; i >= 0; i--)
            if (arr[i] != 0)
                arr[writerIndex--] = arr[i];

        while (writerIndex >= 0)
            arr[writerIndex--] = 0;

    }


}

