package com.nishchay.ds.array.sum;

/*
 *	=========== Find maximum Sum Contiguous Subarray ===========
 * Kadane’s Algorithm
 *
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *
 *	For Example
 *                      0    1  2   3   4  5  6   7  8
 *		Input: nums =  {-2, -3, 4, -1, -2, 1, 5, -3,-1}
 *		Output: 7
 *		Explanation: [4,-1,-2,1,5] has the largest sum = 7.
 *
 *		Input: nums = {5, 4, -1, 7, 8}
 *		Output: 23
 *
 *      Input: nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4}
 *      Output: 6
 *
 * https://www.youtube.com/watch?v=86CQq3pKSUw&ab_channel=CSDojo
 * https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
 * https://leetcode.com/problems/maximum-subarray/
 *
 * */


public class MaxSumSubArray {


    public static void main(String[] args) {

//        bruteForceEx();
        kadaneEx();

    }


    private static void bruteForceEx() {
        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3, -1};
        System.out.println("Maximum contiguous sum is " + maxSubArraySum_bruteForce(arr));

        arr = new int[]{5, 4, -1, 7, 8};
        System.out.println("Maximum contiguous sum is " + maxSubArraySum_bruteForce(arr));
    }

    private static void kadaneEx() {

        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3, -1};

//        System.out.println("Maximum contiguous sum is " + maxSubArraySum(arr));
        System.out.println("Maximum contiguous sum is " + maxSubArraySum_printIndex(arr));

        arr = new int[]{5, 4, -1, 7, 8};
        System.out.println("Maximum contiguous sum is " + maxSubArraySum(arr));
    }


    /*
     * Brute force approach
     * Generating all possible sub arrays
     *
     *      1,  -3,  2,  1,  -1
     *      +----|---|---|----|
     *          +----|---|----|
     *              +----|----|
     *
     *	Time Complexity: O(n^2)
     *	Auxiliary Space: O(1)
     * */
    private static int maxSubArraySum_bruteForce(int[] arr) {
        int n = arr.length;
        int curr_sum, max_sum;
        curr_sum = max_sum = 0;
        for (int i = 0; i < n - 1; i++) {
            curr_sum = arr[i];
            for (int j = i + 1; j < n; j++) {
                // get the sum for subset, i to j
                curr_sum = curr_sum + arr[j];
                max_sum = Math.max(max_sum, curr_sum);
            }
        }
        return max_sum;
    }

/*
    private static int maxSubArraySum_bruteForce(int[] arr) {
        int n = arr.length;
        int curr_sum, max_sum;
        max_sum = 0;
        for (int i = 0; i < n; i++) {
            curr_sum = 0;
            for (int j = i; j < n; j++) {
                // get the sum for subset, i to j
                curr_sum += arr[j];
                max_sum = Math.max(max_sum, curr_sum);
            }
        }
        return max_sum;
    }
*/

    /*
     *
     * Kadane’s Algorithm:
     *
     *	def maxSubArraySum(arr):
     *
     *		max_global = max_current  = arr[0]
     *
     *		for i from 1 to size-1:
     *			max_current  = max(arr[i], max_current + arr[i])
     *          max_global =  max(max_global, max_current);
     *
     *		return max_global
     *
     *	Time Complexity: O(n)
     *	Auxiliary Space: O(1)
     * */
    private static int maxSubArraySum(int[] arr) {
        int size = arr.length;
        int max_global, max_current;

        max_global = max_current = arr[0];

        for (int i = 1; i < size; i++) {
            max_current = Math.max(arr[i], max_current + arr[i]);
            max_global = Math.max(max_global, max_current);
        }

        return max_global;
    }

    private static int maxSubArraySum_printIndex(int[] arr) {
        int size = arr.length;
        int max_global, max_current;
        int start, end;
        start = end = 0;
        max_global = max_current = arr[0];

        for (int i = 1; i < size; i++) {
            if (arr[i] > max_current + arr[i]) {
                start = i;
            }
            max_current = Math.max(arr[i], max_current + arr[i]);

            if (max_current > max_global) {
                end = i;
            }
            max_global = Math.max(max_global, max_current);
        }
        System.out.printf("subArrays is from %d to %d \n", start, end);
        return max_global;
    }

}
