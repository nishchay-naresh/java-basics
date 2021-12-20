package com.nishchay.ds.array.search;

/*
 *============== Search in an almost sorted array ====================
 *
 * Given an array which is sorted, but after sorting some elements are moved to either of the adjacent positions,
 *  i.e., arr[i] may be present at arr[i+1] or arr[i-1].
 *
 * Write an efficient function to search an element in this array.
 * Basically the element arr[i] can only be swapped with either arr[i+1] or arr[i-1].
 *
 * For example consider the array {2, 3, 10, 4, 40}, 4 is moved to next position and 10 is moved to previous position.
 *
 * Examples - 1
 *		Input: arr[] =  {10, 3, 40, 20, 50, 80, 70}, key = 40
 *		Output: 2
 *		Output is index of 40 in given array
 *
 * Examples - 2
 *		Input: arr[] =  {10, 3, 40, 20, 50, 80, 70}, key = 90
 *		Output: -1
 *		-1 is returned to indicate element is not present
 *
 * https://www.geeksforgeeks.org/search-almost-sorted-array/
 * https://www.educative.io/edpresso/how-to-search-in-a-nearly-sorted-array
 * */
public class BS8NearlySortedArray {

    public static void main(String[] args) {

        int key;
        int[] arr;

        arr = new int[] {10, 3, 40, 20, 50, 80, 70};
        key = 40;
        System.out.printf("Found At = %d%n", searchAlmostSorted(arr, key)); // 2

        key = 3;
        System.out.printf("Found At = %d%n", searchAlmostSorted(arr, key)); // 1

        arr = new int[]{10, 3, 40, 20, 50, 80, 70};
        key = -1;
        System.out.printf("Found At = %d%n", searchAlmostSorted(arr, key)); // -1

        arr = new int[]{15, 20, 30, 25, 35};
        key = 25;
        System.out.printf("Found At = %d%n", searchAlmostSorted(arr, key)); // 3

        key = 100;
        System.out.printf("Found At = %d%n", searchAlmostSorted(arr, key)); // -1
    }

    /*
     * ===== Modified Binary Search ======
     *
     *	Approach:
     *
     *	if(target == a[mid]) {
     *		return mid;
     *	}
     *
     *	if(mid > 0 && target == a[mid-1]) {
     *		return mid-1;
     *	}
     *
     *	if(mid < n-1 && target == a[mid+1]) {
     *		return mid+1;
     *	}
     *
     *	if (target < a[mid]) {
     *		end = mid-2;
     *	} else {
     *		start = mid+2;
     *	}
     *
     *  Time complexity - O(log n)
     *
     * */
    private static int searchAlmostSorted(int[] arr, int key) {

        return -1;
    }

}
