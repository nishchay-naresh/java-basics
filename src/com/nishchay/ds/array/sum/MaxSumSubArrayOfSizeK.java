package com.nishchay.ds.array.sum;

/*
 *	=========== Find maximum (or minimum) sum of a sub array of size k ===========
 *
 * Given an array of integers and a number k, find the maximum sum of a subarray of size k.
 *
 *	For Example
 *
 *		Input  : arr[] = {1, 4, 2, 10, 23, 3, 1, 0, 20}
 *		         k = 4
 *		Output : 39
 *		We get maximum sum by adding subarray {4, 2, 10, 23}
 *		of size 4.
 *
 *      Input  : arr[] = {100, 200, 300, 400}
 *		         k = 2
 *		Output : 700
 *
 *		Input  : arr[] = {2, 3}
 *		         k = 3
 *		Output : Invalid
 *		There is no subarray of size 3 as size of whole
 *		array is 2.
 *
 *
 *
 * https://www.geeksforgeeks.org/find-maximum-minimum-sum-subarray-size-k/
 *
 * */
public class MaxSumSubArrayOfSizeK {

    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 10, 23, 3, 1, 0, 20};
        int k = 4;
        int n = arr.length;
        System.out.println("MaxSumSubArrayOfSizeK - " + maxSum(arr, n, k));
        System.out.println("MaxSumSubArrayOfSizeK - " + maxSum(new int[]{2,3}, 2, 4));
    }

    /*
    * Returns maximum sum in a subarray of size k.
	*	Time Complexity: O(n)
	*	Auxiliary Space: O(1)
    * */
    private static int maxSum(int[] arr, int n, int k) {

        if (n < k) {
            System.out.println("Invalid");
            return -1;
        }

        // Compute sum of first window of size k
        int res = 0;
        for (int i = 0; i < k; i++)
            res += arr[i];

        // Compute sums of remaining windows by removing first element of previous window
        // and adding last element of current window.
        int currSum = res;
        for (int i = k; i < n; i++) {
            currSum = currSum + arr[i] - arr[i - k];
            res = Math.max(res, currSum);
        }

        return res;
    }
}
