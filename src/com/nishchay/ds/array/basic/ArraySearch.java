package com.nishchay.ds.array.basic;

import java.util.Arrays;

public class ArraySearch {


    public static void main(String[] args) {

//        linearSearchEx();
        binarySearchEx();

    }

    public static void linearSearchEx() {

        int[] arr = {3, 4, 1, 7, 5, 12, 8};

        System.out.println("arr - " + Arrays.toString(arr));

        System.out.println("linearSearch(arr, 12) - " + linearSearch(arr, 12));
        System.out.println("linearSearch(arr, 17) - " + linearSearch(arr, 17));
        System.out.println("linearSearch(arr, 1) - " + linearSearch(arr, 1));

    }


    private static void binarySearchEx() {
        int[] arr = {3, 4, 1, 7, 5, 12, 8};

        Arrays.sort(arr); // need to have sorted array for binary search
        System.out.println("arr - " + Arrays.toString(arr));

        int size = arr.length - 1;
        System.out.println("binarySearchIterative(arr, 0, size, 12) - " + binarySearchIterative(arr, 0, size, 12));
        System.out.println("binarySearchIterative(arr, 0, size, 17) - " + binarySearchIterative(arr, 0, size, 17));
        System.out.println("binarySearchIterative(arr, 0, size, 1) - " + binarySearchIterative(arr, 0, size, 1));

        System.out.println("binarySearchRecursive(arr, 0, size, 12) - " + binarySearchRecursive(arr, 0, size, 12));
        System.out.println("binarySearchRecursive(arr, 0, size, 17) - " + binarySearchRecursive(arr, 0, size, 17));
        System.out.println("binarySearchRecursive(arr, 0, size, 1) - " + binarySearchRecursive(arr, 0, size, 1));
    }


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

    // O(log n)


    // The time complexity of this algorithm is O(n).
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
}
