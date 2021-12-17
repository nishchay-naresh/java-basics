package com.nishchay.ds.array.search;

import com.nishchay.ds.array.basic.ArrayUtils;

import java.util.Arrays;

/*
 *============== Search an element in a sorted and rotated array ====================
 *
 * Consider an array of distinct numbers sorted in increasing order. The array has been rotated (clockwise)
 * 		So for instance, 1 2 3 4 5 might become 3 4 5 1 2.
 * Devise a way to find an element in the rotated array in O(log n) time.
 *
 *
 *
 * Examples - 1
 *		Input  : arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
 *		         key = 3
 *		Output : Found at index 8
 *
 * Examples - 2
 *		Input  : arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
 *		         key = 30
 *		Output : Not found
 *
 * Examples - 3
 *		Input : arr[] = {30, 40, 50, 10, 20}
 *		        key = 10
 *		Output : Found at index 3
 *
 *
 * https://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/
 * 
 * */
public class BS7KeyInRotatedArray {

    public static void main(String[] args) {

        int key;
        int[] arr;

        arr = new int[] {5, 6, 7, 8, 9, 10, 1, 2, 3};
        key = 3;
        System.out.printf("Found At = %d%n", pivotedBinarySearch(arr, key)); // 8

        key = 7;
        System.out.printf("Found At = %d%n", pivotedBinarySearch(arr, key)); // 2

        key = 30;
        System.out.printf("Found At = %d%n", pivotedBinarySearch(arr, key)); // -1

        arr = new int[]{30, 40, 50, 10, 20};
        key = 10;
        System.out.printf("Found At = %d%n", pivotedBinarySearch(arr, key)); // 3

        arr = new int[]{15, 18, 21, 2, 3, 6, 12};
        key = 3;
        System.out.printf("Found At = %d%n", pivotedBinarySearch(arr, key)); // 4

        arr = new int[]{2, 4, 6, 8, 10, 12, 15, 18, 21};
        key = 18;
        System.out.printf("Found At = %d%n", pivotedBinarySearch(arr, key)); // 7
    }


    /*
     *  Although the entire array is not sorted from left to right,
     *  the sub-array on the left of the pivot and on the right of the pivot will still be sorted.
     *  We can use this fact and apply binary search to find the element in the array in O(log(n)) time complexity.
     *
     * ===== pivot Binary Search ======
     *
     *	Approach:
     *
     *	1. The idea is to find the pivot point, divide the array in two sub-arrays and perform binary search.
     *	2. We have the code to get the pivot point
     *	3. After the pivot is found, divide the array in two sub-arrays.
     *	4. Now the individual sub – arrays are sorted , we can apply binary search in both of the sub-arrays.
     *	5. If element is found in selected sub-array then return index Else return -1.
     *
     * */
    private static int pivotedBinarySearch(int[] arr, int key) {

        int pivot = BS6NumberOfRotations.findPivotIndex(arr);

        // pivot - 0, means array is not rotated at all
        if (pivot == 0)
            return ArrayUtils.binarySearchIterative(arr, key);

        // If we found a pivot, then first compare with pivot
        // and then search in two sub-arrays around pivot
        int[] left = Arrays.copyOf(arr,pivot); // copying 0 to pivot, excluding pivot
        int[] right = Arrays.copyOfRange(arr,pivot,arr.length); // copying pivot to length, excluding length

        int firstPartKey = ArrayUtils.binarySearchIterative(left, key);
        int secondPartKey = ArrayUtils.binarySearchIterative(right, key);
        if(-1 != firstPartKey){
            return firstPartKey;
        }else if(-1 != secondPartKey){
            return pivot+secondPartKey;
        }
        return -1;
    }


}
