package com.nishchay.ds.array.search;

/*
 *============== Find a peak element an Array ====================
 *
 *
 * Given an array of integers. Find a peak element in it.
 * An array element is a peak if it is NOT smaller than its neighbours.
 * For corner elements, we need to consider only one neighbour.
 *
 *
 * Examples - 1
 *		Input: array[]= {5, 7, 10, 20, 15, 13}
 *		Output: 20
 *		The element 20 has neighbours 10 and 15,
 *		both of them are less than 20.
 *
 * Examples - 2
 *		Input: array[] = {10, 20, 15, 2, 23, 90, 67}
 *		Output: 20 or 90
 *		The element 20 has neighbours 10 and 15,
 *		both of them are less than 20, similarly 90 has neighbours 23 and 67.
 *
 * Examples - 3
 *		Input: array[]= {1, 2, 3, 4, 5}
 *		Output: 5
 *		The element 5 has only neighbours 4 which is less than 5.
 *
 * Examples - 4
 *		Input: array[]= {10, 8, 6, 5, 3, 2}
 *		Output: 10
 *		The element 10 has only neighbours 8 which is less than 10.
 *
 *
 * https://www.geeksforgeeks.org/find-a-peak-in-a-given-array/
 * https://www.techiedelight.com/find-peak-element-array/
 * https://www.ideserve.co.in/learn/find-a-peak-element-in-an-array
 * */
public class BS14PeakElement {

    public static void main(String[] args) {

        findPeakEx();
        System.out.printf("----------------------------------------------%n");
        findPeakSimpleEx();
    }

    private static void findPeakEx() {
        int[] arr;

        arr = new int[]{5, 7, 9, 10, 18, 15, 13};
        System.out.printf("peak of the array = %d%n", findPeak(arr)); // 18

        arr = new int[]{10, 20, 15, 2, 23, 90, 67};
        System.out.printf("peak of the array = %d%n", findPeak(arr)); // 20/90

        arr = new int[]{1, 2, 3, 4, 5};
        System.out.printf("peak of the array = %d%n", findPeak(arr)); // 5

        arr = new int[]{10, 8, 6, 5, 3, 2};
        System.out.printf("peak of the array = %d%n", findPeak(arr)); // 10

        arr = new int[]{5, 19, 24, 14, 8, 4, 26, 12};
        System.out.printf("peak of the array = %d%n", findPeak(arr)); // 24

        arr = new int[]{2, 4, 6, 8, 10, 12, 15, 18, 21};
        System.out.printf("peak of the array = %d%n", findPeak(arr)); // 21
    }

    /*
     * =====Find the Peak Element from an Array=====
     *
     * Applying binary search for non-sorted array
     * Need to have two things :
     * 	1	logic - key matching
     * 		if (array[mid] is the peak element)
     *
     * 		An element A[i] of an array A is a peak element if it’s not smaller than its neighbour(s).
     *
     *      A[i-1] <= A[i] >= A[i+1] for 0 < i < n-1 // middle
     *      A[i-1] <= A[i] if i = n – 1 // right edge
     *      A[i] >= A[i+1] if i = 0 // left edge
     *
     *
     * 	2	logic - for left & right movement
     * 		since array[mid - 1] < array[mid], so chances of getting peak is on right side is high
     * 		if (array[mid - 1] < array[mid]) {// go right
     * 			left = mid + 1;
     * 	 	} else {// go left
     * 			right = mid - 1;
     * 		}
     *
     * */
    static int findPeak_simple(int[] array) {

        int size = array.length;

        int left = 0;
        int right = size - 1;
        int mid;

        while (left <= right) {
            mid = (left + right) / 2;

            if (mid > 0 && mid < size - 1) {
                if (array[mid - 1] <= array[mid] && array[mid] >= array[mid + 1]) {
                    return array[mid];
                } else if (array[mid - 1] < array[mid]) {// go right
                    left = mid + 1;
                } else {// go left
                    right = mid - 1;
                }
            // edge case
            } else if (mid == 0) {
                return Math.max(array[0], array[1]);
            } else if (mid == size - 1) {
                return Math.max(array[size - 1], array[size - 2]);
            }
        }
        return -1;
    }

    private static int findPeak(int[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }

        int n = array.length;

        int left = 0;
        int right = n - 1;
        int mid;

        while (left <= right) {
            mid = (left + right) / 2;

            if ((mid == 0 || array[mid - 1] <= array[mid]) && (mid == n - 1 || array[mid] >= array[mid + 1])) {
                return array[mid];
            } else if (mid > 0 && array[mid - 1] < array[mid]) {// go right
                left = mid + 1;
            } else {// go left
                right = mid - 1;
            }
        }
        return -1;
    }

    private static void findPeakSimpleEx() {
        int[] arr;

        arr = new int[]{5, 7, 9, 10, 18, 15, 13};
        System.out.printf("peak of the array = %d%n", findPeak_simple(arr)); // 18

        arr = new int[]{10, 20, 15, 2, 23, 90, 67};
        System.out.printf("peak of the array = %d%n", findPeak_simple(arr)); // 20/90

        arr = new int[]{1, 2, 3, 4, 5};
        System.out.printf("peak of the array = %d%n", findPeak_simple(arr)); // 5

        arr = new int[]{10, 8, 6, 5, 3, 2};
        System.out.printf("peak of the array = %d%n", findPeak_simple(arr)); // 10

        arr = new int[]{5, 19, 24, 14, 8, 4, 26, 12};
        System.out.printf("peak of the array = %d%n", findPeak_simple(arr)); // 24

        arr = new int[]{2, 4, 6, 8, 10, 12, 15, 18, 21};
        System.out.printf("peak of the array = %d%n", findPeak_simple(arr)); // 21
    }

}
