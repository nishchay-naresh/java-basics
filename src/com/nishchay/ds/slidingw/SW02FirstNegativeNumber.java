package com.nishchay.ds.slidingw;

import java.util.Arrays;

/*
 *============== First negative integer in every window of size k ====================
 *
 *
 * Given an array and a positive integer k, find the first negative integer for each window(contiguous subarray) of size k.
 * If a window does not contain a negative integer, then print 0 for that window.
 *
 *	Example 1
 *		Input : arr[] = {-8, 2, 3, -6, 10}, k = 2
 *		Output : {-8, 0, -6, -6}
 *		First negative integer for each window of size k
 *		{-8, 2} = -8
 *		{2, 3} = 0 (does not contain a negative integer)
 *		{3, -6} = -6
 *		{-6, 10} = -6
 *
 *	Example 2
 *		Input : arr[] = {12, -1, -7, 8, -15, 30, 16, 28} , k = 3
 *		Output : {-1, -1, -7, -15, -15, 0}
 *
 *	Example 3
 *		Input : arr[] = {12, -1, -7, 8, -15, 30, 16, 28} , k = 4
 *		Output : {-1, -1, -7, -15, -15}
 *
 * https://www.callicoder.com/first-negative-number-in-every-window-of-size-k/
 * https://www.geeksforgeeks.org/first-negative-integer-every-window-size-k/
 * */
public class SW02FirstNegativeNumber {

    public static void main(String[] args) {

        int[] arr, result;
        int k;

        arr = new int[]{-8, 2, 3, -6, 10};
        k = 2;
        result = getFirstNegativeNumbersBruteForce(arr, k);
        System.out.println("Negative Numbers - " +  Arrays.toString(result));

        arr = new int[]{12, -1, -7, 8, -15, 30, 16, 28};
        k = 3;
        result = getFirstNegativeNumbersBruteForce(arr, k);
        System.out.println("Negative Numbers - " +  Arrays.toString(result));

        arr = new int[]{12, -1, -7, 8, -15, 30, 16, 28};
        k = 4;
        result = getFirstNegativeNumbersBruteForce(arr, k);
        System.out.println("Negative Numbers - " +  Arrays.toString(result));


        arr = new int[]{101, 101};
        k = 3;
        result = getFirstNegativeNumbersBruteForce(arr, k);
        System.out.println("Negative Numbers - " +  Arrays.toString(result));

    }

    private static int[] getFirstNegativeNumbersBruteForce(int[] a, int k) {

        int size = a.length;
        if (k == 0 || size == 0 || size < k) {
            return new int[]{0};
        }

        int[] firstNegativeNumbers = new int[size - k + 1];
        int idx = 0;

        for (int i = 0; i <= size - k; i++) {
            int firstNegativeNum = 0;
            for (int j = i; j < i + k; j++) {
                if (a[j] < 0) {
                    firstNegativeNum = a[j];
                    break;
                }
            }
            firstNegativeNumbers[idx++] = firstNegativeNum;
        }

        return firstNegativeNumbers;
    }


}
