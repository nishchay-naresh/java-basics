package com.nishchay.ds.array.basic;

import java.util.Scanner;

public class ArrayUtils {


    // The time complexity of this algorithm is O(n).
    public static int linearSearch(int[] arr, int key) {

        for (int i = 0; i < arr.length; i++) {
            // Return the index of the element if the element is found
            if (arr[i] == key)
                return i;
        }

        // return -1 if the element is not found
        return -1;
    }


    // The time complexity of this algorithm is O(log n)
    public static int binarySearchIterative(int[] sortedArray, int left, int right, int key) {

        int index = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (sortedArray[mid] < key) {
                left = mid + 1;
            } else if (sortedArray[mid] > key) {
                right = mid - 1;
            } else if (sortedArray[mid] == key) {
                index = mid;
                break;
            }
        }
        return index;
    }

    // The time complexity of this algorithm is O(2^n)
    public static int binarySearchRecursive(int[] sortedArray, int left, int right, int key) {

        int middle = (left + right) / 2;

        if (right < left) {
            return -1;
        }

        if (key == sortedArray[middle]) {
            return middle;
        } else if (key < sortedArray[middle]) {
            return binarySearchRecursive(
                    sortedArray, left, middle - 1, key);
        } else {
            return binarySearchRecursive(
                    sortedArray, middle + 1, right, key);
        }
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

        for (int i = 0,  j = arr.length - 1; i < j ; i++, j--) {
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
