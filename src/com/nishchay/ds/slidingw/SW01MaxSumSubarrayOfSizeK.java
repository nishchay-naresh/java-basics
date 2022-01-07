package com.nishchay.ds.slidingw;

/*
 *============== Find maximum (or minimum) sum of a subarray of size k ====================
 *
 *
 * Given an array of positive integers, and a positive number k, find the maximum sum of any contiguous subarray of size k.
 *
 *	Example 1
 *		Input: [3, 5, 2, 1, 7], k=2
 *		Output: 8
 *		Explanation: Subarray with maximum sum is [1, 7].
 *
 *	Example 2
 *		Input: a[] = {4, 2, 3, 5, 1, 2}, k = 3
 *		Output: 10
 *		Explanation: Subarray with maximum sum is [2, 3, 5]
 *
 *	Example 3
 *		Input  : arr[] = {1, 4, 2, 10, 23, 3, 1, 0, 20}, k = 4
 *		Output : 39
 *		We get maximum sum by adding subarray {4, 2, 10, 23}
 *		of size 4.
 *
 *	Example 4
 *		Input  : arr[] = {2, 3}, k = 3
 *		Output : 0
 *		There is no subarray of size 3 as size of whole
 *		array is 2.
 *
 * https://www.callicoder.com/maximum-sum-subarray-of-size-k/
 *
 * */
public class SW01MaxSumSubarrayOfSizeK {

    public static void main(String[] args) {

        int[] arr;
        int k;

        arr = new int[]{3, 5, 2, 1, 7};
        k = 2;
        System.out.printf("Max sum subarray of size %d = %d%n", k, findSumMaxSubarrayOfSizeKBruteForce(arr, k));

        System.out.printf("Max sum subarray of size %d = %d%n", k, findSumMaxSubarrayOfSizeK(arr, k));

        arr = new int[]{4, 2, 3, 5, 1, 2};
        k = 3;
        System.out.printf("Max sum subarray of size %d = %d%n", k, findSumMaxSubarrayOfSizeK(arr, k));

        arr = new int[]{1, 4, 2, 10, 23, 3, 1, 0, 20};
        k = 4;
        System.out.printf("Max sum subarray of size %d = %d%n", k, findSumMaxSubarrayOfSizeK(arr, k));


        arr = new int[]{101, 101};
        k = 3;
        System.out.printf("Max sum subarray of size %d = %d%n", k, findSumMaxSubarrayOfSizeK(arr, k));

    }

    private static int findSumMaxSubarrayOfSizeKBruteForce(int[] a, int k) {
        int maxSum = 0, currWindowSum;
        for (int i = 0; i <= a.length-k; i++) {
            currWindowSum = 0;
            for (int j = i; j < i+k; j++) {
                currWindowSum += a[j];
            }
            maxSum = Math.max(maxSum, currWindowSum);
        }
        return maxSum;
    }

    /*
     * Brute force - with 2 loops, it can easily be doable in O(n^2)
     * Sliding Window - try to achieve same using single loop
     *
     *	for (int end = 0; end < size; end++) {
     *		windowSum = windowSum + a[end]; // Add the next element to the window
     *
     *		if (end - start + 1 == k) { // When we hit the window size. Update maximum sum, and slide the window
     *			maxSum = Math.max(maxSum, windowSum);
     *			windowSum = windowSum - a[start]; // Subtract the element going out of the window
     *			start++; // Slide the window
     *		}
     *	}
     *
     * */
    private static int findSumMaxSubarrayOfSizeK(int[] a, int k) {
        int size = a.length;
        if (k == 0 || size == 0 || size < k) {
            return 0;
        }

        int maxSum = Integer.MIN_VALUE;
        int start = 0;
        int windowSum = 0;

        for (int end = 0; end < size; end++) {
            windowSum = windowSum + a[end]; // Add the next element to the window

            if (end - start + 1 == k) { // When we hit the window size. Update maximum sum, and slide the window
                maxSum = Math.max(maxSum, windowSum);
                windowSum = windowSum - a[start]; // Subtract the element going out of the window
                start++; // Slide the window
            }
        }
        return maxSum;
    }


}
