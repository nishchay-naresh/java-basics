package com.nishchay.ds.array.sort;

import java.util.Arrays;

/*
 * Rearrange Positive & Negative Values
 * Given an array a[] consisting of +ve, -ve nos P,N
 * Write a method to rearrange all negative integers to the left of the middle element and all positive integers to the right
 *
 * */
public class SortArrayOfPN {

    public static void main(String[] args) {

        int[] arr = {2, 4, -6, 8, -5, -10, 6, -11, 3, 9};
        int len = arr.length;
        System.out.println("Original array = " + Arrays.toString(arr));

        sortPN(arr);
        System.out.println("  Sorted array = " + Arrays.toString(arr));
    }

    /*
     *	Complexity Analysis:
     *	Time Complexity: O(n).
     *	Only two traversals of the array is needed.
     *	Space Complexity: O(1).
     *	As no extra space is required.
     * */
    private static void sortPN(int[] arr) {
        int left = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {   // if negative number found
                if (i != left) {
                    int temp = arr[i];
                    arr[i] = arr[left]; // swapping with leftmost positive
                    arr[left] = temp;
                }
                left++;
            }
        }
    }



    private static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

}

/*
 * Original array = [2, 4, -6, 8, -5, -10, 6, -11, 3, 9]
 *   Sorted array = [-6, -5, -10, -11, 4, 2, 6, 8, 3, 9]
 *
 * */
