package com.nishchay.ds.array.search;

/*
 *============== Maximum Element in a Bitonic Array ====================
 *============== Find bitonic point in given bitonic sequence ====================
 *
 *
 * Given an array of integers which is initially increasing and then decreasing, find the maximum value in the array.
 *
 *
 * Examples - 1
 *		Input: array[]= {4, 10, 15, 20, 45, 35, 29, 17, 10} //increasing then decreasing
 *		Output: 45
 *
 * Examples - 2
 *		Input: array[] = {4, 10, 15, 20, 45} // only increasing
 *		Output: 45
 *
 * Examples - 3
 *		Input: array[]= {100, 85, 60, 45, 10, 5, 3}; // only decreasing
 *		Output: 100
 *
 * Examples - 4
 *		Input: array[]= {50, 100}; // only increasing
 *		Output: 100
 *
 * Examples - 5
 *		Input: array[]= {100, 50}; // only decreasing
 *		Output: 100
 *
 * Examples - 6
 *		Input: array[]= {100}; // only increasing
 *		Output: 100
 *
 *
 * https://www.geeksforgeeks.org/find-the-maximum-element-in-an-array-which-is-first-increasing-and-then-decreasing/
 * https://www.geeksforgeeks.org/find-bitonic-point-given-bitonic-sequence/?ref=rp
 * https://www.callicoder.com/maximum-element-in-bitonic-array/
 *
 *
 * */
public class BS16BitonicArrayMax {

    public static void main(String[] args) {

        findMaxEx();
        System.out.printf("----------------------------------------------%n");
        findMaxUsingPeakEx();

    }

    private static void findMaxEx() {

        int[] arr;

        arr = new int[]{4, 10, 15, 20, 45, 35, 29, 17, 10}; //increasing then decreasing
        System.out.printf("max = %d%n", findMax(arr)); // 45

        arr = new int[]{4, 10, 15, 20, 45}; // only increasing
        System.out.printf("max = %d%n", findMax(arr)); // 45

        arr = new int[]{100, 85, 60, 45, 10, 5, 3}; // only decreasing
        System.out.printf("max = %d%n", findMax(arr)); // 100

        arr = new int[]{50, 100}; // only increasing
        System.out.printf("max = %d%n", findMax(arr)); // 100

        arr = new int[]{100, 50}; // only decreasing
        System.out.printf("max = %d%n", findMax(arr)); // 100

        arr = new int[]{100}; // only increasing
        System.out.printf("max = %d%n", findMax(arr)); // 100

    }

    private static void findMaxUsingPeakEx() {
        int[] arr;

        arr = new int[]{4, 10, 15, 20, 45, 35, 29, 17, 10}; //increasing then decreasing
        System.out.printf("max = %d%n", findMaxIndex(arr)); // 45

        arr = new int[]{4, 10, 15, 20, 45}; // only increasing
        System.out.printf("max = %d%n", findMaxIndex(arr)); // 45

        arr = new int[]{100, 85, 60, 45, 10, 5, 3}; // only decreasing
        System.out.printf("max = %d%n", findMaxIndex(arr)); // 100

        arr = new int[]{50, 100}; // only increasing
        System.out.printf("max = %d%n", findMaxIndex(arr)); // 100

        arr = new int[]{100, 50}; // only decreasing
        System.out.printf("max = %d%n", findMaxIndex(arr)); // 100

        arr = new int[]{100}; // only increasing
        System.out.printf("max = %d%n", findMaxIndex(arr)); // 100
    }

    private static int findMaxIndex(int[] arr) {
        return arr[findMax(arr)];
    }

    static int findMax(int[] arr) {

        if (arr.length == 1) {
            return 0;
        }

        int left, right, mid, size;
        left = 0;
        right = arr.length - 1;
        size = arr.length;
        while (left <= right) {

            mid = (left + right) / 2;

            if (0 < mid && mid < size - 1) {
                if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                    return mid;
                } else if (arr[mid] < arr[mid + 1]) { // go right
                    left = mid + 1;
                } else { // go left
                    right = mid - 1;
                }
                // edge case
            } else if (mid == 0) {
                return arr[0] > arr[1] ? 0 : 1;
            } else if (mid == size - 1) {
                return arr[size - 1] > arr[size - 2] ? size - 1 : size - 2;
            }
        }
        return -1;
    }

}
