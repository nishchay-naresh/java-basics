package com.nishchay.ds.array.search;

import com.nishchay.ds.array.basic.ArrayUtils;

import java.util.Arrays;



/*
 *============== Binary Search ====================
 *
 * Given a sorted array arr[] of n elements, write a function to search a given element key in arr[].
 *
 *
 *
 * Examples - 1
 *		Input  : arr[] = {5, 7, 8, 10, 12, 18, 23, 25, 29};
 *		         key = 23
 *		Output : Found at index 6
 *
 *
 * https://www.geeksforgeeks.org/binary-search/
 * */
public class BS1ArraySearch {

    public static void main(String[] args) {

        System.out.println("------------ linearSearch-------------");
        linearSearchEx();
        System.out.println("------------ binarySearch-------------");
        binarySearchEx();

    }
    /*
    *
    * 	Binary Search: Search a sorted array by repeatedly dividing the search interval in half.
    *   Begin with an interval covering the whole array.
    *   If the value of the search key is less than the item in the middle of the interval, narrow the interval to the lower half.
    *   Otherwise, narrow it to the upper half. Repeatedly check until the value is found or the interval is empty.
    *
    * ===== Binary Search ======
	*
	*	Approach:
	*
	*	1.	Compare key with the middle element.
	*	2.	If key matches with the middle element, we return the mid index.
	*	3.	Else If key is greater than the mid element,
	*			then key can only lie in the right half subarray after the mid element. So we recur for the right half.
	*	4.	Else (key is smaller) recur for the left half.
    *
    * */
    private static void linearSearchEx() {

        int[] arr = {3, 4, 1, 7, 5, 12, 8};

        System.out.println("arr : " + Arrays.toString(arr));

        System.out.println("linearSearch(arr, 12) : " + ArrayUtils.linearSearch(arr, 12));
        System.out.println("linearSearch(arr, 17) : " + ArrayUtils.linearSearch(arr, 17));
        System.out.println("linearSearch(arr, 1) : " + ArrayUtils.linearSearch(arr, 1));

    }

    private static void binarySearchEx() {
        int[] arr = {3, 4, 1, 7, 5, 12, 8};

        Arrays.sort(arr); // need to have sorted array for binary search
        System.out.println("arr : " + Arrays.toString(arr));

        int size = arr.length - 1;
        System.out.println("binarySearchIterative(arr, 12) : " + ArrayUtils.binarySearchIterative(arr, 12));
        System.out.println("binarySearchIterative(arr, 17) : " + ArrayUtils.binarySearchIterative(arr, 17));
        System.out.println("binarySearchIterative(arr, 1) : " + ArrayUtils.binarySearchIterative(arr, 1));

        System.out.println("binarySearchRecursive(arr, 0, size, 12) : " + ArrayUtils.binarySearchRecursive(arr, 0, size, 12));
        System.out.println("binarySearchRecursive(arr, 0, size, 17) : " + ArrayUtils.binarySearchRecursive(arr, 0, size, 17));
        System.out.println("binarySearchRecursive(arr, 0, size, 1) : " + ArrayUtils.binarySearchRecursive(arr, 0, size, 1));
    }

}
