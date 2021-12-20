package com.nishchay.ds.array.search;
/*
 *================= Floor & Ceiling in a Sorted Array ====================
 *
 *
 *============== Floor in a Sorted Array ====================
 * Given a sorted array and a value key, the floor of key is the largest element in array smaller than or equal to key.
 * Write efficient functions to find floor of key.
 *
 *
 * Examples - 1
 *		Input : arr[] = {1, 2, 8, 10, 10, 12, 19}, key = 5
 *		Output : 2
 *		2 is the largest element in
 *		arr[] smaller than 5.
 *
 * Examples - 2
 *		Input : arr[] = {1, 2, 8, 10, 10, 12, 19}, key = 20
 *		Output : 19
 *		19 is the largest element in
 *		arr[] smaller than 20.
 *
 * Examples - 3
 *		Input : arr[] = {1, 2, 8, 10, 10, 12, 19}, key = 0
 *		Output : -1
 *		Since floor doesn't exist,
 *		output is -1.
 *
 *
 *============== Ceiling in a Sorted Array ====================
 *
 * Given a sorted array and a value key, the ceiling of key is the smallest element in array greater than or equal to key.
 * Write efficient functions to find floor and ceiling of key.
 *
 * 	Example 1
 * 		Input : a[] = {1, 3, 9, 15, 15, 18, 21}, key = 0
 * 		Output : 1
 *      1 is the smallest element in the array greater than or equal to 5.
 *
 * 	Example 2
 * 		Input : a[] = {1, 3, 9, 15, 15, 18, 21}, key = 1
 * 		Output : 1
 *      1 is the smallest element in the array greater than or equal to 1.
 *
 * 	Example 3:
 * 		Input : a[] = {1, 3, 9, 15, 15, 18, 21}, key = 5
 * 		Output : 9
 *      9 is the smallest element in the array greater than or equal to 5.
 *
 * 	Example 4:
 * 		Input : a[] = {1, 3, 9, 15, 15, 18, 21}, key = 25
 * 		Output : -1
 *      Ceiling doesn't exist
 *
 *
 * https://www.geeksforgeeks.org/floor-in-a-sorted-array/
 * https://www.geeksforgeeks.org/ceiling-in-a-sorted-array/
 * https://www.techiedelight.com/find-floor-ceil-number-sorted-array/
 * */
public class BS9FloorAndCeiling {

    public static void main(String[] args) {

        floorEx();
        ceilingEx();
    }


    private static void floorEx() {

        int key;
        int[] arr;

        arr = new int[] {1, 2, 8, 10, 10, 12, 19};
        key = 5;
        System.out.printf("Found At = %d%n", getFloor(arr, key)); // 2

        key = 20;
        System.out.printf("Found At = %d%n", getFloor(arr, key)); // 19

        key = 0;
        System.out.printf("Found At = %d%n", getFloor(arr, key)); // -1

        arr = new int[]{1, 3, 9, 15, 15, 18, 21};
        key = 5;
        System.out.printf("Found At = %d%n", getFloor(arr, key)); // 3

        key = 25;
        System.out.printf("Found At = %d%n", getFloor(arr, key)); // 21

        key = 0;
        System.out.printf("Found At = %d%n", getFloor(arr, key)); // -1
    }

    private static void ceilingEx() {

        int key;
        int[] arr;

        arr = new int[] {1, 3, 9, 15, 15, 18, 21};

        key = 0;
        System.out.printf("Found At = %d%n", getceil(arr, key)); // 1

        key = 1;
        System.out.printf("Found At = %d%n", getceil(arr, key)); // 1

        key = 5;
        System.out.printf("Found At = %d%n", getceil(arr, key)); // 9

        key = 25;
        System.out.printf("Found At = %d%n", getceil(arr, key)); // -1

    }

    private static int getFloor(int[] arr, int key) {
        return -1;
    }


    private static int getceil(int[] arr, int key) {
        return -1;
    }


}
