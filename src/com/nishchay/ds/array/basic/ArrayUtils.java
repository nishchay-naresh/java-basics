package com.nishchay.ds.array.basic;

import java.util.Scanner;

public class ArrayUtils {


    /*
     * Linear Search / Sequential search
     * just start either left/right side of the array, compare each element with the key, until you done with the entire collection
     * if found - return the index
     * else - return -1;
     *
     *  Time complexity - O(n)
     * */
    public static int linearSearch(int[] arr, int key) {

        for (int i = 0; i < arr.length; i++) {
            // Return the index of the element if the element is found
            if (arr[i] == key)
                return i;
        }

        return -1;
    }


    /*
     *	left = 0; right = endOfArray, calculate the mid
     *	Compare the key items with the mid element.
     *	If key == arr[mid],
     *		then return the mid index as result.
     *	Else If key > arr[mid],  key lies in the right half of the collection.
     *		Thus repeat steps 1 to 3 for right half of the collection.
     *	Else key < arr[mid], then the key is in the left half of the collection.
     *		Thus repeat steps 1 to 3 for left half of the collection.
     *
     *
     *  Time complexity - O(log n)
     * */
    public static int binarySearchIterative(int[] sortedArray, int key) {

        int left, right, mid;
        left = 0;
        right = sortedArray.length - 1;

        while (left <= right) {

            mid = (left + right) / 2;

            if (sortedArray[mid] == key) {
                return mid;
            } else if (sortedArray[mid] < key) { //  go right
                left = mid + 1;
            } else if (sortedArray[mid] > key) {//  go left
                right = mid - 1;
            }
        }
        return -1;
    }

    // The time complexity of this algorithm is O(2^n)
    public static int binarySearchRecursive(int[] array, int left, int right, int key) {

        if (right < left) {
            return -1;
        }

        int mid = (left + right) / 2;

        if (key == array[mid])
            return mid;
        else if (key < array[mid])
            return binarySearchRecursive(array, left, mid - 1, key);

        return binarySearchRecursive(array, mid + 1, right, key);

    }

    // The time complexity of this algorithm is O(n).
    public static int findMax(int[] arr) {
        int max = Integer.MIN_VALUE;

        for (int value : arr) {
            max = Math.max(max, value);
        }
        return max;
    }


    // reversing the content of an int array.
    public static void reverseArray(int[] arr) {

        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            // swap ith & jth element
            int t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
        }
    }


    private static int[] readArrayFromConsole() {

        Scanner s = new Scanner(System.in);

        // read the array size
        int length = s.nextInt();
        int[] intArr = new int[length];

        // read array element
        for (int i = 0; i < length; i++) {
            intArr[i] = s.nextInt();
        }
        return intArr;
    }

}
