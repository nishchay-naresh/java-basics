package com.nishchay.ds.array.search;

/*
 *============== Minimum difference element in a sorted array ====================
 *
 *
 *  Given an array of integers sorted in ascending order, and a target value.
 *  find the element in the array that has minimum difference with the target value.
 *
 *	Example 1:
 *		Input: a[] = [2, 5, 10, 12, 15], target = 6
 *		Output: 5
 *		Explanation: The difference between the target value '6' and '5' is the minimum.
 *
 *	Example 2:
 *		Input: a[] = [2, 5, 10, 12, 15], target = 5
 *		Output: 5
 *
 *	Example 3:
 *		Input: a[] = [2, 5, 10, 12, 15], target = 8
 *		Output: 10
 *
 *	Example 4:
 *		Input: a[] = [2, 5, 10, 12, 15], target = 11
 *		Output: 10
 *
 *	Example 5:
 *		Input: a[] = [2, 5, 10, 12, 15], target = 20
 *		Output: 15
 *
 *
 * https://www.callicoder.com/minimum-difference-element-in-sorted-array/
 * */
public class BS13MinDiffElement {

    public static void main(String[] args) {

        int[] arr;
        int target;

        arr = new int[]{2, 5, 10, 12, 15};
        target = 6;

        System.out.printf("MinimumDifferenceElementWith(%d) = %d%n", target, getMinDifference(arr, target));

    }

    private static int getMinDifference(int[] arr, int target) {
        return -1;
    }

}
