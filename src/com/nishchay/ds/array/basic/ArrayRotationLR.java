package com.nishchay.ds.array.basic;

import java.util.Arrays;

/*
 *   arr     = {10, 20, 30, 40, 50}
 *   Left    = {20, 30, 40, 50, 10}
 *   Right   = {50, 10, 20, 30, 40}
 * */
public class ArrayRotationLR {

    public static void main(String[] args) {

//        int[] arr = {3, 6, 1, 8, 4, 2};
        int[] arr = {10, 20, 30, 40, 50};

        System.out.println("           Original array  = " + Arrays.toString(arr));
        rotateArrayL(arr);
        System.out.println("Array after right rotation = " + Arrays.toString(arr));

    }

    /*
     *   arr     = {10, 20, 30, 40, 50}
     *   Left    = {20, 30, 40, 50, 10}
     * */
    private static void rotateArrayL(int[] arr) {
        int firstElement = arr[0];

        for (int i = 1; i < arr.length; i++) {
            arr[i - 1] = arr[i] ;
        }
        arr[arr.length - 1] = firstElement;
    }


}
