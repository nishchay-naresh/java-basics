package com.nishchay.ds.array.sort;

import java.util.Arrays;

/*
 * Rearrange Odd & Even numbers of an integer array
 * Given an array a[] consisting of odd & even nos O,E
 * Write a method to separate even and odd numbers of given array of integer.
 * Put all even first and then odd numbers
 *
 * i/p - {12, 34, 45, 9, 8, 90, 3}
 * o/p - {12, 34, 8, 90, 45, 9, 3}
 *
 * https://www.geeksforgeeks.org/segregate-even-and-odd-numbers/
 * */
public class SortArrayOfOE {

    public static void main(String[] args) {

        int[] arr = {12, 34, 45, 9, 8, 90, 3};
        System.out.println("Original array = " + Arrays.toString(arr));

        segregateEvenOdd(arr);
        System.out.println("  Sorted array = " + Arrays.toString(arr));
    }

    /*
     *	Complexity Analysis:
     *	Time Complexity: O(n).
     *	Space Complexity: O(1).
     *	As no extra space is required.
     * */
    private static void segregateEvenOdd(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            while (arr[left] % 2 == 0 && left < right) // even
                left++;
            while (arr[right] % 2 == 1 && left < right) // odd
                right--;
            if (left < right) {
                // swipe left & right
                int t = arr[left];
                arr[left] = arr[right];
                arr[right] = t;
            }
        }

    }

}

/*
 * Original array = [12, 34, 45, 9, 8, 90, 3]
 *   Sorted array = [12, 34, 90, 8, 9, 45, 3]
 * */
