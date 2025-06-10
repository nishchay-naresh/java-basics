package com.nishchay.ds.array.nelement;


/*
 *  ================= Find the only repetitive element between 1 to n-1 ================
 *
 *  We are given an array arr[] of size n. Numbers are from 1 to (n-1) in random order.
 *  The array has only one repetitive element. We need to find the repetitive element.
 *
 *	Examples:
 *      	Input  : a[] = {1, 3, 2, 3, 4}
 *	        Output : 3
 *
 *	        Input  : a[] = {1, 5, 1, 2, 3, 4}
 *	        Output : 1
 *
 * This problem can be seen as 1-N numbers are there in array + one duplicate is there
 * bcus of this duplicate size of array N + 1;
 *
 *      	Input  : a[] = {1, 3, 2, 3, 4} = { 1, 2, 3, 4 } + { 2 }
 *	        Output : 3
 *
 * Solutions : this 1-N can be computed, for sum or XOR
 *
 *
 *
 * https://www.geeksforgeeks.org/find-repetitive-element-1-n-1/
 * https://leetcode.com/problems/find-the-duplicate-number/description/
 * */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class FindOnlyRepetitiveElementIn1_N {

    public static void main(String[] args) {

        int[][] input2D = {
                {1, 2, 3, 2, 4},                        // n-5, dup-2, missing-5
                {9, 8, 2, 6, 1, 8, 5, 3, 4, 7},         // n-10, dup-8, missing-10
                {1, 2, 3, 1, 5, 4},                     // n-6, dup-1, missing-6
                {1, 4, 3, 3, 2, 6},                     // n-6, dup-3, missing-5
                {9, 8, 2, 6, 1, 8, 5, 3, 4, 7},         // n-10, dup-8, missing-10
                {1, 2, 3, 1, 5, 4},                     // n-6, dup-1, missing-6
                {1, 5, 1, 2, 3, 4},                     // n-6, dup-1, missing-6
                {3, 3, 3, 3, 3},                        // n-5, dup-3, missing-1,2,4,5
        };

        int[] outputs = {2, 8, 1, 3, 8, 1, 1, 3};

        boolean result = true;
        for (int i = 0; i < input2D.length; i++) {
            result = result && findDuplicate_xor(input2D[i]) == (outputs[i]);
            if (!result)
                System.out.println("Test failed for: " + Arrays.toString(input2D[i]));
            else
                System.out.println("Test passed for: " + Arrays.toString(input2D[i]));
        }
    }

    /*
     * ============= Bruteforce Approach =====================
     *  Logic : Using 2 nested loop
     *
     *  The idea is to use two nested loops.
     *  The outer loop traverses through all elements and the inner loop check if the element picked by the outer loop appears anywhere else.
     *
     * Time Complexity : O(n^2)
     * Space Complexity: O(1)
     *
     * [Better Approach 1]
     * Logic Using sorting - O(n Log n) Time and O(1) Space
     *
     */
    private static int findDuplicate_2loop(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] == arr[j])
                    return arr[i];
            }
        }
        return -1;
    }

    /*
     * ============= Sorting Approach =====================
     *
     * Logic Using sorting - O(n Log n) Time and O(1) Space
     *
     * Time Complexity : O(n Log n) + O(n) = O(n Log n)
     * Space Complexity: O(1)
     *
     */
    private static int findDuplicate_sorting(int[] arr) {
        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 1; i++) {

            // If the adjacent elements are equal
            if (arr[i] == arr[i + 1]) {
                return arr[i];
            }
        }
        return -1;
    }

    /*
     * ============= Using a HashSet Approach =====================
     *
     * Logic  - Using HashSet
     * Use a HastSet to store elements visited. If an already visited element appears again, return it.
     *
     *
     * Time Complexity : O(n)
     * Space Complexity: O(n)
     *
     */
    private static int findDuplicate_hasSet(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int x : arr) {
            // If the element is already in the set
            if (set.contains(x))
                return x;
            set.add(x);
        }
        return -1;
    }

    /*
     * ============= Using bit-wise XOR operator Approach =====================
     *
     * Logic - Using bit-wise XOR operator
     * Logic : (XOR of first n-1 natural numbers)   XOR     (XOR of all element in arr)
     *          1 ^ 2 ^ 3 .. ^ (n-1)    ^       arr[0] ^ arr[1] ^ .... arr[n-1] -  ans
     *
     *
     *	Example:
     *	N=5
     *	arr[5]={1,2,3,2,4}
     *	XOR PROPERTY : 2 XOR 2 =0 i.e XOR of same no. is 0.
     *	now what is happening in algo 2?
     *	XOR of 1st N-1 natural no. X1=1^2^3^4
     *  N-1, bcus N no are there in array, +1 is the no which is repeated
     *	XOR of array elements X2=1^2^3^2^4
     *	X1 XOR X2 = 1^2^3^4^1^2^3^2^4= 1^1^2^2^2^3^3^4^4=2
     *
     * Time Complexity : O(n)
     * Space Complexity: O(1)
     *
     * */
    private static int findDuplicate_xor(int[] arr) {

        int n = arr.length;
        int res = 0;
        for (int i = 0; i < n - 1; i++)
            res = res ^ (i + 1) ^ arr[i];
        res = res ^ arr[n - 1];

        return res;
    }

    /*
     * ============= Using Sum Formula =====================
     *
     * As we know - sum of first n natural numbers is = (n * (n + 1)) / 2, we will use this
     *
     * Logic :
     *          sumOfN = (n * (n + 1)) / 2;
     *          sumOfNPlusDup = sum of all element in arr
     *
     * We compute sum of array elements and
     * then subtract natural number sum from it
     * to find the only missing element.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * */
    private static int findDuplicate_sumFormula(int[] arr) {

        int n = arr.length - 1;
        int expectedSum = (n * (n + 1)) / 2;

        int arraySum = 0;
        for (int num : arr)
            arraySum += num;

        return (arraySum - expectedSum);
    }

    /*
     * ============= Using Elements as Indexes =====================
     *
     * Logic : As there are only positive numbers,
     *  so visit the index equal to the current element and make it negative.
     *  If an index value is already negative,
     *  then it means that current element is repeated.
     *
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * */
    private static int findDuplicate_elementsAsIndexes(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[Math.abs(arr[i])] < 0) {
                return Math.abs(arr[i]);
            }
            arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
        }
        return -1;
    }

}