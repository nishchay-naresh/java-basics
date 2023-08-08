package com.nishchay.test.blueyonder;

/*
 *============== Maximum difference between two elements such that larger element appears after the smaller number ====================
 *
 * Given an array arr[] of integers, find out the maximum difference between any two elements such that larger element appears after the smaller number.
 *
 *
 * Examples - 1
 * 			Input : arr = {2, 3, 10, 6, 4, 8, 1}
 * 			Output : 8
 * 			Explanation : The maximum difference is between 10 and 2.
 *
 * Examples - 2
 * 			Input : arr = {7, 9, 5, 6, 3, 2}
 * 			Output : 2
 * 			Explanation : The maximum difference is between 9 and 7.
 *
 *
 * https://www.geeksforgeeks.org/maximum-difference-between-two-elements/
 *
 * */

public class MaxDiff2ElementFromRightSide {

    public static void main(String[] args) {

        int[] arr;

        arr = new int[]{1, 2, 90, 10, 110};
        System.out.println("Maximum difference is = " +  findMaxDiff_bruteforce(arr)); // 109

        System.out.println("--------------------------------------");

        arr = new int[]{1, 2, 90, 10, 110};
        System.out.println("Maximum difference is = " +  maxDiff(arr)); // 109

        arr = new int[]{2, 3, 10, 6, 4, 8, 1};
        System.out.println("Maximum difference is = " +  maxDiff(arr)); // 8

        arr = new int[]{7, 9, 5, 6, 3, 2};
        System.out.println("Maximum difference is = " +  maxDiff(arr)); // 2
    }

    /*
     * ============= bruteforce approach - 2 nested loop =====================
     * A simple solution is to use two nexted loops.
     *
     * Time Complexity : O(n^2)
     * Auxiliary Space : O(1)
     *
     */
    private static int findMaxDiff_bruteforce(int[] arr){
        int maxDiff = arr[1] - arr[0];
        int i, j;
        for (i = 0; i < arr.length; i++)
            for (j = i + 1; j < arr.length; j++)
                if (arr[j] - arr[i] > maxDiff)
                    maxDiff = arr[j] - arr[i];

        return maxDiff;
    }

    /*
     * ============= Tricky and Efficient approach - single loop =====================
     *
     * In this method, instead of taking difference of the picked element with every other element,
     *  we take the difference with the minimum element found so far. So we need to keep track of 2 things:
     *      1) Maximum difference found so far (max_diff).
     *      2) Minimum number visited so far (min_element).
     *
     * Time Complexity : O(n)
     * Auxiliary Space : O(1)
     *
     *   The function assumes that there are at least two elements in array.
     *   The function returns a negative value if the array is sorted in decreasing order.
     *   Returns 0 if elements are equal
     */

    private static int maxDiff(int[] arr) {
        int maxDiff = arr[1] - arr[0];
        int minElement = arr[0];
        int i;
        for (i = 1; i < arr.length; i++)
        {
            if (arr[i] - minElement > maxDiff)
                maxDiff = arr[i] - minElement;
            if (arr[i] < minElement)
                minElement = arr[i];
        }
        return maxDiff;
    }
}
