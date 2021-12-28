package com.nishchay.ds.array.search;

import com.nishchay.ds.array.basic.ArrayUtils;

import java.util.Arrays;

/*
 *============== Find an element in Bitonic array ====================
 *
 * Given a bitonic sequence of n distinct elements, write a program to find a given element x in the bitonic sequence in O(log n) time.
 *
 * Examples - 1
 *		Input :  arr[] = {-3, 9, 18, 20, 17, 5, 1};
 *		         key = 20
 *		Output : Found at index 3
 *
 * Examples - 2
 *		Input :  arr[] = {5, 6, 7, 8, 9, 10, 3, 2, 1};
 *		         key = 30
 *		Output : Not Found
 *
 *
 * https://www.geeksforgeeks.org/find-element-bitonic-array/
 * https://www.callicoder.com/search-in-bitonic-array/
 *
 * */
public class BS12BitonicArraySearch {


    public static void main(String[] args) {


        int[] arr;
        int key;

        arr = new int[]{4, 10, 15, 20, 45, 35, 29, 17, 10};
        key = 20;
        System.out.printf("found at = %d%n", search(arr, key)); // 3

        arr = new int[]{4, 10, 15, 20, 45}; // only increasing
        key = 30;
        System.out.printf("found at = %d%n", search(arr, key)); // -1

    }

    /*
     * This problem is a variation of some of the existing problems we have already solved in this series:
     * 	1.  Find Maximum Element in a Bitonic Array
     * 	2.  Order-agnostic Binary Search
     *
     * This problem can be easily solve in below way :
     *	    1.  Find bitonic point in given bitonic sequence - maxIndex
     *	    2.  Apply binary search from
     *		    -   0 to maxIndex and  ( descending order)
     *		    -   maxIndex+1 to array_length-1 ( descending order)
     * */
    // Bitonic Search
    private static int search(int[] arr, int key) {
        int maxIndex = BS11BitonicArrayMax.findMax(arr);

        int[] left = Arrays.copyOf(arr,maxIndex); // copying 0 to maxIndex, excluding pivot
        int[] right = Arrays.copyOfRange(arr, maxIndex,arr.length); // copying maxIndex to length, excluding length

        int targetIndex = ArrayUtils.binarySearchIterative(left, key);
        if (targetIndex != -1) {
            return targetIndex;
        }
        return BS2ReverseSortedArray.binarySearchReverse(right, key);
    }

}
