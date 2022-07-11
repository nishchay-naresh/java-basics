package com.nishchay.ds.twopointers;

import java.util.Arrays;
/*
 *============== Remove duplicates from sorted array ====================
 *
 * Given a sorted array, remove all the duplicates from the array in-place such that each element appears only once, and return the new length.
 *
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 *
 *
 * Examples - 1
 *			Input : array[] = {2, 2, 2, 2, 2}
 *			Output : array[] = {2}, new size = 1
 *
 * Examples - 2
 *			Input : arr[] = {1, 2, 2, 3, 4, 4, 4, 5, 5}
 *			Output : array[] = {1, 2, 3, 4, 5}, new size = 5
 *
 * Examples - 3
 *			Input : arr[] = {1, 1, 1, 3, 5, 5, 7}
 *			Output : array[] = {1, 3, 5, 7}, new size = 4
 *
 * Examples - 4
 *			Input : arr[] = {}
 *			Output : array[] = {}, new size = 0
 *
 * https://www.geeksforgeeks.org/remove-duplicates-sorted-array/
 * https://www.callicoder.com/remove-duplicates-from-sorted-array/
 *
 * */
public class P2_04RemoveDupSortedArray {

    public static void main(String[] args) {

        extraSpaceWay();
        System.out.println("--------------------------------");
//        twoPointersWay();

    }

    /*
     * ========= Method 1 : Using extra space  =========
     *
     *	1. 	Create an auxiliary array temp[] to store unique elements.
     *	2. 	Traverse input array and one by one copy unique elements of arr[] to temp[].
     *           Also keep track of count of unique elements. Let this count be j.
     *	3. 	Copy back j elements from temp[] to arr[] and return j
     *
     * Time Complexity: O(n).
     * Auxiliary Space: O(n).
     *
     * */

    private static int removeDuplicates_copy(int[] arr) {
        int n = arr.length;

        if (n == 0 || n == 1)
            return n;

        int[] temp = new int[n];

        int j = 0; // unique element index
        for (int i = 0; i < n - 1; i++)
            if (arr[i] != arr[i + 1])
                temp[j++] = arr[i];

        // Store the last element as whether it is unique or repeated, it hasn't stored previously
        temp[j++] = arr[n - 1];

        // Modify original array
        for (int i = 0; i < j; i++)
            arr[i] = temp[i];

        return j;
    }

    private static void extraSpaceWay() {

        int[] arr;
        int uniqueCount;

        arr = new int[]{2, 2, 2, 2, 2};
        System.out.println("   with dups = " + Arrays.toString(arr));
        uniqueCount = removeDuplicates_copy(arr);
        System.out.println("without dups = " + Arrays.toString(Arrays.copyOfRange(arr,0, uniqueCount)));
        System.out.println(" uniqueCount = " + uniqueCount);

        arr = new int[]{1, 2, 2, 3, 4, 4, 4, 5, 5};
        System.out.println("   with dups = " + Arrays.toString(arr));
        uniqueCount = removeDuplicates_copy(arr);
        System.out.println("without dups = " + Arrays.toString(Arrays.copyOfRange(arr,0, uniqueCount)));
        System.out.println(" uniqueCount = " + uniqueCount);

        arr = new int[]{1, 1, 1, 3, 5, 5, 7};
        System.out.println("   with dups = " + Arrays.toString(arr));
        uniqueCount = removeDuplicates_copy(arr);
        System.out.println("without dups = " + Arrays.toString(Arrays.copyOfRange(arr,0, uniqueCount)));
        System.out.println(" uniqueCount = " + uniqueCount);

        arr = new int[]{};
        System.out.println("   with dups = " + Arrays.toString(arr));
        uniqueCount = removeDuplicates_copy(arr);
        System.out.println("without dups = " + Arrays.toString(Arrays.copyOfRange(arr,0, uniqueCount)));
        System.out.println(" uniqueCount = " + uniqueCount);
    }

}
