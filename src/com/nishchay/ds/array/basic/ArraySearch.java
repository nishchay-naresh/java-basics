package com.nishchay.ds.array.basic;

import java.util.Arrays;

public class ArraySearch {

    public static void main(String[] args) {

        System.out.println("------------ linearSearch-------------");
        linearSearchEx();
        System.out.println("------------ binarySearch-------------");
        binarySearchEx();

    }

    private static void linearSearchEx() {

        int[] arr = {3, 4, 1, 7, 5, 12, 8};

        System.out.println("arr - " + Arrays.toString(arr));

        System.out.println("linearSearch(arr, 12) - " + ArrayUtils.linearSearch(arr, 12));
        System.out.println("linearSearch(arr, 17) - " + ArrayUtils.linearSearch(arr, 17));
        System.out.println("linearSearch(arr, 1) - " + ArrayUtils.linearSearch(arr, 1));

    }

    private static void binarySearchEx() {
        int[] arr = {3, 4, 1, 7, 5, 12, 8};

        Arrays.sort(arr); // need to have sorted array for binary search
        System.out.println("arr - " + Arrays.toString(arr));

        int size = arr.length - 1;
        System.out.println("binarySearchIterative(arr, 0, size, 12) - " + ArrayUtils.binarySearchIterative(arr, 0, size, 12));
        System.out.println("binarySearchIterative(arr, 0, size, 17) - " + ArrayUtils.binarySearchIterative(arr, 0, size, 17));
        System.out.println("binarySearchIterative(arr, 0, size, 1) - " + ArrayUtils.binarySearchIterative(arr, 0, size, 1));

        System.out.println("binarySearchRecursive(arr, 0, size, 12) - " + ArrayUtils.binarySearchRecursive(arr, 0, size, 12));
        System.out.println("binarySearchRecursive(arr, 0, size, 17) - " + ArrayUtils.binarySearchRecursive(arr, 0, size, 17));
        System.out.println("binarySearchRecursive(arr, 0, size, 1) - " + ArrayUtils.binarySearchRecursive(arr, 0, size, 1));
    }

}
