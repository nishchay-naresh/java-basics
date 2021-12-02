package com.nishchay.ds.array.basic;

import java.util.Arrays;

/*
 *==============1920. Build Array from Permutationo====================
 *
 * Build an array from its element(which in turns are index)
 *
 * Given a zero-based permutation nums (0-indexed),
 * build an array ans of the same length where ans[i] = nums[nums[i]] for each 0 <= i < nums.length and return it.
 *
 * A zero-based permutation nums is an array of distinct integers from 0 to nums.length - 1 (inclusive).
 *
 *	Example 1:
 *
 * 		Input: nums = [0,2,1,5,3,4]
 * 		Output: [0,1,2,4,5,3]
 * 		Explanation: The array ans is built as follows:
 * 		ans = [nums[nums[0]], nums[nums[1]], nums[nums[2]], nums[nums[3]], nums[nums[4]], nums[nums[5]]]
 * 		    = [nums[0], nums[2], nums[1], nums[5], nums[3], nums[4]]
 * 		    = [0,1,2,4,5,3]
 *
 *	Example 2:
 *
 *		Input: nums = [5,0,1,2,3,4]
 *		Output: [4,5,0,1,2,3]
 *		Explanation: The array ans is built as follows:
 *		ans = [nums[nums[0]], nums[nums[1]], nums[nums[2]], nums[nums[3]], nums[nums[4]], nums[nums[5]]]
 *		    = [nums[5], nums[0], nums[1], nums[2], nums[3], nums[4]]
 *		    = [4,5,0,1,2,3]
 *
 * https://leetcode.com/problems/build-array-from-permutation/
 * */
public class BuildArrayFromElements {

    public static void main(String[] args) {
        int[] arr = {5,0,1,2,3,4};
        int[] res = buildArray(arr);

        System.out.println("res = " + Arrays.toString(res));//{4,5,0,1,2,3}

        arr = new int[]{0,2,1,5,3,4};
        res = buildArray(arr);
        System.out.println("res = " + Arrays.toString(res));//{0,1,2,4,5,3}
    }

    private static int[] buildArray(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            res[i] = nums[nums[i]];
        }
        return res;
    }
}
