package com.nishchay.ds.bit.appearonce;

import java.util.Arrays;


/*
 * Given an array in which all numbers except two are repeated once.
 * (i.e. we have 2n+2 numbers and n numbers are occurring twice and remaining two have occurred once)
 * Find those two numbers in the most efficient way.
 *
 *
 * Example :
 * 		Input:  arr[] = {36, 50, 24, 56, 36, 24, 42, 50}
 * 		Output: 42, 56
 *
 * https://www.geeksforgeeks.org/find-two-non-repeating-elements-in-an-array-of-repeating-elements/
 * https://www.youtube.com/watch?v=pnx5JA9LNM4
 *
 * */
public class TwoElementAppearsOnceInPairs {

    public static void main(String[] args) {

        int[] arr = new int[]{36, 50, 24, 56, 36, 24, 42, 50};
        findSingleElement(arr);

        arr = new int[] { 2, 3, 7, 9, 11, 2, 3, 11 };
        findSingleElement(arr);
    }

    /*
    * suppose the 2 element which are appears once are x, y
    *
    * 1. we do XOR for all the element
    *       36^ 50^ 24^ 56^ 36^ 24^ 42^ 50
    *       this will give us x XOR y
    *       x XOR y =   56 ^ 42 = 18
    * Now we need to find out 56 & 42 from this 18
    *
    *  take the rightSetBitMask for this x XOR y value (in binary representation)
    *  this bit will divide all the elements in 2 groups
    *  group 1 - all the element for which this bit is set (in binary representation)
    *  group 2 - all the element for which this bit is not set (in binary representation)
    *
    * 2. just XOR all the element for group 1 -  this will give you x
    * 3. just XOR all the element for group 2 -  this will give you y
    *
     * */
    private static void findSingleElement(int[] arr) {

        System.out.println("arr = " + Arrays.toString(arr));

        int xxory = 0;
        for (int val : arr) {
            xxory = xxory ^ val;
        }

        int rightSetBitMask = xxory & -xxory;
        int x = 0;
        int y = 0;

        for (int val : arr) {
            // all element whose rsbm is set
            if ((val & rightSetBitMask) == 0) {
                x = x ^ val;
            } else {
                y = y ^ val;
            }
        }

        if (x < y)
            System.out.println("Appears Once - " + x + ", " + y);
        else
            System.out.println("Appears Once - " + y + ", " + x);
    }
}
