package com.nishchay.ds.array.basic;

import java.util.Arrays;


/*
 *   arr     = {10, 20, 30, 40, 50}   <-----
 *   Left    = {20, 30, 40, 50, 10}
 *   arr     = {10, 20, 30, 40, 50}   ----->
 *   Right   = {50, 10, 20, 30, 40}
 *
 * -------------------------------
 * Given an array, rotate the array to the right by k steps.
 * arr : [1, 2, 3, 4, 5, 6, 7, 8], k=3
 * ans:  [6, 7, 8, 1, 2, 3, 4, 5]
 *
 * */
public class ArrayRotationLR {

    public static void main(String[] args) {

//        arrayLRotateEx();
//        System.out.println("----------------------------------------------------------");
//        arrayRRotateEx();
//        System.out.println("----------------------------------------------------------");
        arrayRotateRKTimesEx();
    }


    private static void arrayLRotateEx() {

        int[] arr;

        arr = new int[]{10, 20, 30, 40, 50};

        System.out.println("          Original array   = " + Arrays.toString(arr));
        rotateLeft(arr);
        System.out.println("Array after left rotation  = " + Arrays.toString(arr));

        arr = new int[]{3, 6, 1, 8, 4, 2};
        System.out.println("           Original array  = " + Arrays.toString(arr));
        rotateLeft(arr);
        System.out.println("Array after left rotation  = " + Arrays.toString(arr));
    }

    private static void arrayRRotateEx() {
        int[] arr;

        arr = new int[]{10, 20, 30, 40, 50};
        System.out.println("          Original array   = " + Arrays.toString(arr));
        rotateRight(arr);
        System.out.println("Array after right rotation = " + Arrays.toString(arr));

        arr = new int[]{3, 6, 1, 8, 4, 2};
        System.out.println("           Original array  = " + Arrays.toString(arr));
        rotateRight(arr);
        System.out.println("Array after right rotation = " + Arrays.toString(arr));
    }

    /*
     *   arr     = {10, 20, 30, 40, 50}
     *   Left    = {20, 30, 40, 50, 10}
     * */
    private static void rotateLeft(int[] arr) {
        int firstElement = arr[0];

        // move forward ward - left to right
        for (int i = 0; i < arr.length-1; i++) {
            arr[i] = arr[i+1];
        }
        arr[arr.length - 1] = firstElement;
    }

    /*
     *    arr     = {10, 20, 30, 40, 50}
     *   Right   = {50, 10, 20, 30, 40}
     * */
    private static void rotateRight(int[] arr) {

        int lastElement = arr[arr.length - 1];

        // move back ward - right to left
        for (int i = arr.length-1 ; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = lastElement;
    }

    /*
     * arr : [1, 2, 3, 4, 5, 6, 7, 8], k=3
     * ans:  [6, 7, 8, 1, 2, 3, 4, 5]
     *
     *  A = [3, 8, 9, 7, 6] and K = 3,
     * the function should return [9, 7, 6, 3, 8].
     * */
    private static void arrayRotateRKTimesEx() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        int k = 3;
        System.out.printf("       Original array  = %s%n", Arrays.toString(arr));
        for (int i = 1; i <= k; i++) {
            rotateRight(arr);
        }
        System.out.printf("Array %d right rotation = %s%n", k, Arrays.toString(arr)); //[6, 7, 8, 1, 2, 3, 4, 5]

        arr = new int[]{3, 8, 9, 7, 6};
        k = 3;
        System.out.printf("       Original array  = %s%n", Arrays.toString(arr));
        for (int i = 1; i <= k; i++) {
            rotateRight(arr);
        }
        System.out.printf("Array %d right rotation = %s", k, Arrays.toString(arr)); //[9, 7, 6, 3, 8]
    }

}
