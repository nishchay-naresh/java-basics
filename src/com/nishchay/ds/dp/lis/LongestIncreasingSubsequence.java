package com.nishchay.ds.dp.lis;

import com.nishchay.ds.array.basic.ArrayUtils;

import java.util.Arrays;

/*
 *	===========Longest increasing subsequence===========
 *
 * Given an integer array nums, return the length of the longest strictly increasing subsequence.
 * The Longest Increasing Subsequence (LIS) problem is to find the length of the longest subsequence of a given sequence
 * such that all elements of the subsequence are sorted in increasing order.
 * For example, the length of LIS for {10, 22, 9, 33, 21, 50, 41, 60, 80} is 6 and LIS is {10, 22, 33, 50, 60, 80}.
 *
 *
 * Examples :
 *			Input: nums = {10,9,2,5,3,7,101,18}
 *			Output: 4
 *			Explanation: The longest increasing subsequence is [2,3,7,101] / [2, 3, 7, 18], therefore the length is 4.
 *
 *			Input: arr[] = {11, 8, 5, 3, 2}
 *			Output: Length of LIS = 1
 *			The longest increasing subsequences are {3} and {2}
 *
 * 			Input: nums = {7,7,7,7,7,7,7}
 * 			Output: 1
 *
 * https://www.geeksforgeeks.org/longest-increasing-subsequence-dp-3/
 * https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/LongestIncreasingSubsequence.java
 * https://www.baeldung.com/cs/longest-increasing-subsequence-dynamic-programming
 *
 * */
public class LongestIncreasingSubsequence {

    public static void main(String[] args) {

        System.out.println("------------Basic-------------");
        lisBasicEx();
        System.out.println("------------Basic Print-------------");
        lisBasicPrintEx();
//        System.out.println("------------Improved-------------");
//        lisDBEx();

    }

    private static void lisBasicEx() {

        LongestIncreasingSubsequence ref = new LongestIncreasingSubsequence();

        int[] nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println("Length of lis is - " + ref.lisBasic(nums)); //4

        nums = new int[]{11, 8, 5, 3, 2};
        System.out.println("Length of lis is - " + ref.lisBasic(nums)); //1

        nums = new int[]{7, 7, 7, 7, 7, 7, 7};
        System.out.println("Length of lis is - " + ref.lisBasic(nums)); //1

        nums = new int[]{10, 22, 9, 33, 21, 50, 41, 60};
        System.out.println("Length of lis is - " + ref.lisBasic(nums)); //5
    }


    private static void lisBasicPrintEx() {

        LongestIncreasingSubsequence ref = new LongestIncreasingSubsequence();

        int[] nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        int[] res = ref.lisBasicPrint(nums);
        System.out.println("longest increasing subsequence found - " + Arrays.toString(res));//4 - [2, 3, 7, 18]

        nums = new int[]{50, 3, 10, 7, 40, 80};
        res = ref.lisBasicPrint(nums);
        System.out.println("longest increasing subsequence found - " + Arrays.toString(res));//4 - [3, 7, 40, 80]

        nums = new int[]{10, 22, 9, 33, 21, 50, 41, 60};
        res = ref.lisBasicPrint(nums);
        System.out.println("longest increasing subsequence found - " + Arrays.toString(res));//5 - [10, 22, 33, 41, 60]

        nums = new int[]{23, 10, 22, 5, 33, 8, 9, 21, 50, 41, 60, 80, 99, 22, 23, 24, 25, 26, 27};
        res = ref.lisBasicPrint(nums);
        System.out.println("longest increasing subsequence found - " + Arrays.toString(res));//10 - [5, 8, 9, 21, 22, 23, 24, 25, 26, 27]

    }

    /*
     * Using an auxiliary array to store the increasing sequence
     * Time Complexity: O(n^2).
     * Space Complexity: O(n).
     * */
    int lisBasic(int[] arr) {

        int len = arr.length;
        int[] incSeqCount = new int[len];

        for (int i = 0; i < len; i++) {
            incSeqCount[i] = 1; // bcus each element is increasing sequence by own, count is 1
        }

        // store each no increasing sequence in incSeqCount array
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++)
                if (arr[j] < arr[i] && incSeqCount[j] + 1 > incSeqCount[i])
                    incSeqCount[i] = incSeqCount[j] + 1;
        }

        // Return maximum value from incSeqCount[]
        return ArrayUtils.findMax(incSeqCount);
    }


    private int[] lisBasicPrint(int[] arr) {

        int len = arr.length;
        int[] incSeqCount = new int[len];

        for (int i = 0; i < len; i++) {
            incSeqCount[i] = 1; // bcus each element is increasing sequence by own, count is 1
        }

        // store each no increasing sequence in incSeqCount array
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++)
                if (arr[j] < arr[i] && incSeqCount[j] + 1 > incSeqCount[i])
                    incSeqCount[i] = incSeqCount[j] + 1;
        }

        // to print he lis seq, traverse the incSeqCount in reverse order from listCount, and continue till  listCount become 1
        // always look for listCount = listCount -1  value

        int listCount = ArrayUtils.findMax(incSeqCount);
        int[] lisArray = new int[listCount];

        for (int j = len - 1; j >= 0 && listCount != 0; j--) {
            if (listCount == incSeqCount[j]) {
                lisArray[listCount - 1] = arr[j];
                listCount = listCount - 1;
            }
        }

        return lisArray;
    }


}
