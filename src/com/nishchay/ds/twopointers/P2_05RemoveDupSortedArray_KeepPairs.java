package com.nishchay.ds.twopointers;

import java.util.Arrays;

/*
 *==================== Remove duplicates from sorted array Keep Pairs ========================
 *
 * Given a sorted array, remove the duplicates from the array in-place such that each element appears at most twice, and return the new length.
 *
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 *
 *
 * Examples - 1
 *			Input : array[] = {2, 2, 2, 2, 2}
 *			Output : array[] = {2,2}, new size = 2
 *
 * Examples - 2
 *			Input : arr[] = {1, 2, 2, 3, 4, 4, 4, 5, 5}
 *			Output : array[] = {1, 2, 2, 3, 4, 4, 5, 5}, new size = 8
 *
 * Examples - 3
 *			Input : arr[] = {1, 1, 1, 3, 5, 5, 7}
 *			Output : array[] = {1, 1, 3, 5, 5, 7}, new size = 6
 *
 * Examples - 4
 *			Input : arr[] = {}
 *			Output : array[] = {}, new size = 0
 *
 * https://www.callicoder.com/remove-duplicates-from-sorted-array-ii/
 *
 * */
public class P2_05RemoveDupSortedArray_KeepPairs {

    public static void main(String[] args) {

        twoPointersWay();

    }

    /*
     * ========= Approach : Two pointer approach  =========
     *
     *	Just maintain a separate index for same array as maintained for different array in Method 1
     *
     * Time Complexity: O(n).
     * Auxiliary Space: O(1).
     *
     * */
    private static int keepingPairs_twoPointers(int[] arr) {

        int n = arr.length;

        if (n == 0 || n == 1 || n == 2)
            return n;

        // unique element index
        int j = 0;

        // Doing same as done in Method 1, using the same index i.e. j for same array
        for (int i = 0; i < n; i++){

            // If arr[i] == arr[i+2] then skip the arr[i] because it is repeated more than twice.
            if (i < n - 2 && arr[i] == arr[i + 2]) {
                continue;
            }
            arr[j++] = arr[i];
        }

        return j;
    }

    private static void twoPointersWay() {

        int[] arr;
        int uniqueCount;

        arr = new int[]{2, 2, 2, 2, 2};
        System.out.println("   with dups = " + Arrays.toString(arr));
        uniqueCount = keepingPairs_twoPointers(arr);
        System.out.println("without dups = " + Arrays.toString(Arrays.copyOfRange(arr,0, uniqueCount)));
        System.out.println(" uniqueCount = " + uniqueCount);

        arr = new int[]{1, 2, 2, 3, 4, 4, 4, 5, 5};
        System.out.println("   with dups = " + Arrays.toString(arr));
        uniqueCount = keepingPairs_twoPointers(arr);
        System.out.println("without dups = " + Arrays.toString(Arrays.copyOfRange(arr,0, uniqueCount)));
        System.out.println(" uniqueCount = " + uniqueCount);

        arr = new int[]{1, 1, 1, 3, 5, 5, 7};
        System.out.println("   with dups = " + Arrays.toString(arr));
        uniqueCount = keepingPairs_twoPointers(arr);
        System.out.println("without dups = " + Arrays.toString(Arrays.copyOfRange(arr,0, uniqueCount)));
        System.out.println(" uniqueCount = " + uniqueCount);

        arr = new int[]{};
        System.out.println("   with dups = " + Arrays.toString(arr));
        uniqueCount = keepingPairs_twoPointers(arr);
        System.out.println("without dups = " + Arrays.toString(Arrays.copyOfRange(arr,0, uniqueCount)));
        System.out.println(" uniqueCount = " + uniqueCount);

    }

}
